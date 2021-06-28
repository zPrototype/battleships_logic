package model;

public class Game {

    public static boolean isDebug = true;

    public static void main(String[] args) {
        showRandomGame();
    }

    public static void showCloseCall() {
        GameField f = new GameField(8);
        f.placeShip(0,0, Ship.Direction.VERTICAL, 3);
        f.placeShip(1,0, Ship.Direction.VERTICAL, 4);
        f.placeShip(2,0, Ship.Direction.HORIZONTAL, 4);
        f.print();
        f.shootAt(1, 1);
        f.shootAt(0, 1);
        f.shootAt(0, 0);
        f.shootAt(0, 2);
        f.print();
    }

    public static void showEdgeGame() {
        GameField f = new GameField(8);
        f.placeShip(0, 0, Ship.Direction.VERTICAL, 1);
        f.placeShip(7, 0, Ship.Direction.VERTICAL, 1);
        f.placeShip(0, 7, Ship.Direction.VERTICAL, 1);
        f.placeShip(7, 7, Ship.Direction.VERTICAL, 1);
        f.print();
    }

    public static void showRandomGame() {
        GameField f = new GameField(10);
        f.placeShip(0, 0, Ship.Direction.HORIZONTAL, 1);
        f.placeShip(5, 0, Ship.Direction.HORIZONTAL, 3);
        f.placeShip(0, 5, Ship.Direction.VERTICAL, 3);
        f.placeShip(1, 1, Ship.Direction.VERTICAL, 3);
        f.print();
        f.removeShip(6, 0);
        f.print();
        f.placeShip(6, 0, Ship.Direction.VERTICAL, 5);
        f.print();
        f.shootAt(0, 0);
        f.shootAt(5, 0);
        f.shootAt(4, 0);
        f.shootAt(5, 1);
        f.shootAt(4, 0);
        f.print();
        f.shootAt(6, 0);
        f.shootAt(6, 1);
        f.shootAt(6, 2);
        f.shootAt(6, 3);
        f.shootAt(6, 4);
        f.print();
    }
}
