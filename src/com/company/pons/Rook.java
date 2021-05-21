package com.company.pons;

import com.company.game.Board;
import com.company.game.Spot;

public class Rook extends Piece {
    public Rook(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        if (super.canMove(board, start, end)) {
            return true;
        }
        if (end.getX() == start.getX()) {
            return false;
        }
        return end.getY() != start.getY();
    }
}
