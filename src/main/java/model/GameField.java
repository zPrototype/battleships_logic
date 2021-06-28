package model;

public class GameField {

    private final int size;
    GameCell[][] field;

    public GameField(int size) {
        this.field = new GameCell[size][size];
        this.size = size;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.field[i][j] = new GameCell();
            }
        }
    }

    public void placeShip(int x, int y, Ship.Direction direction, int length) {
        System.out.printf("Try to place ship at %d %d with length %d in direction %s%n", x, y, length, direction);
        if (length < 1) return; // If player is stupid
        System.out.println("Length is Ok");
        if (!isInBounds(x, y, direction, length)) return;
        System.out.println("Bounds are Ok");
        if (!isAreaFree(x, y, direction, length)) return;
        System.out.println("Area is free");

        System.out.println("Placing ship");
        Ship ship = new Ship(x, y, length, direction);
        for (int i = 0; i < length; i++) {
            field[y][x].setParentShip(ship);
            if (direction == Ship.Direction.HORIZONTAL) {
                x++;
            } else {
                y++;
            }
        }
        System.out.println("Ship placed");
    }

    public void removeShip(int x, int y) {
        System.out.printf("Trying to remove ship from %d %d%n", x, y);
        if (!isPosInBounds(x, y)) return;

        Ship ship = field[y][x].getParentShip();
        if (ship == null) return;


        int traverseX = ship.getOriginX();
        int traverseY = ship.getOriginY();

        System.out.printf(
                "Found Ship with origin %d %d and length %d in direction %s%n",
                traverseX, traverseY, ship.getLength(), ship.getDirection()
        );

        for (int i = 0; i < ship.getLength(); i++) {
            field[traverseY][traverseX].setParentShip(null);
            if (ship.getDirection() == Ship.Direction.HORIZONTAL) {
                traverseX++;
            } else {
                traverseY++;
            }
        }

        System.out.println("Ship was removed");
    }

    private boolean isPosInBounds(int x, int y) {
        return x >= 0 && y >= 0 && x <= size - 1 && y <= size - 1;
    }

    private boolean isInBounds(int x, int y, Ship.Direction direction, int length) {
        if (!isPosInBounds(x, y)) {
            return false;
        }

        System.out.println("Pos exists in field");

        if (direction == Ship.Direction.HORIZONTAL) {
            return x + length <= size;
        } else {
            return y + length <= size;
        }
    }

    private boolean isAreaFree(int x, int y, Ship.Direction direction, int length) {
        for (int i = 0; i < length; i++) {
            if (field[y][x].hasShip()) {
                return false;
            }
            if (direction == Ship.Direction.HORIZONTAL) {
                x++;
            } else {
                y++;
            }
        }
        return true;
    }

    public void shootAt(int x, int y) {
        if (!isPosInBounds(x, y)) {
            return;
        }
        field[y][x].hit();
    }

    public void print() {
        System.out.print("  ");
        for (int i = 0; i < size; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < size; j++) {
                System.out.print(field[i][j].getViewState().symbol + " ");
            }
            System.out.println();
        }
    }
}
