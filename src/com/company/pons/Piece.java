package com.company.pons;

import com.company.game.Board;
import com.company.game.Spot;

public abstract class Piece {

    private boolean killed = false;
    private boolean white = false;

    public Piece(boolean white) {
        this.setWhite(white);
    }

    public boolean isWhite() {
        return this.white;
    }

    public void setWhite(boolean white) {
        this.white = white;
    }

    public boolean isKilled() {
        return this.killed;
    }

    public void setKilled(boolean killed) {
        this.killed = killed;
    }

    public boolean canMove(Board board, Spot start, Spot end) {
        if (end.getX() == start.getX() && end.getY() == start.getY()) {
            return true;
        }
        return end.getX() < 0 || end.getX() > 7 || start.getX() < 0
                || start.getX() > 7 || end.getY() < 0 || end.getY() > 7
                || start.getY() < 0 || start.getY() > 7;
    }

}
