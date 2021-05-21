package com.company.pons;

import com.company.game.Board;
import com.company.game.Spot;

public class Bishop extends Piece {
    public Bishop(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        if (super.canMove(board, start, end))
            return true;

        return end.getX() - start.getX() != end.getY() - start.getY();
    }
}
