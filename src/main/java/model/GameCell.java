package model;

import static model.Game.isDebug;

public class GameCell {

    private boolean hit = false;
    private Ship parentShip = null;

    public ViewState getViewState() {
        if (hit && parentShip != null && parentShip.isDestroyed()) return ViewState.DESTROYED;
        else if (hit && parentShip != null) return ViewState.HIT;
        else if (hit) return ViewState.WATER;
        else if (isDebug && parentShip != null) return ViewState.SHIP_DEBUG;
        return ViewState.UNKNOWN;
    }

    public boolean hasShip() {
        return parentShip != null;
    }

    public void hit() {
        if (!hit) {
            hit = true;
            if (parentShip != null) parentShip.hit();
        }
    }

    public Ship getParentShip() {
        if (this.hasShip()) {
            return parentShip;
        }
        return null;
    }

    public void setParentShip(Ship parentShip) {
        this.parentShip = parentShip;
    }

    public enum ViewState {

        UNKNOWN('-'),
        WATER('O'),
        HIT('X'),
        DESTROYED('D'),
        SHIP_DEBUG('S');

        char symbol;

        ViewState(char symbol) {
            this.symbol = symbol;
        }
    }

}
