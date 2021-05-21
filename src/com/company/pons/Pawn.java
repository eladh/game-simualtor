package com.company.pons;

import com.company.game.Board;
import com.company.game.Spot;

public class Pawn extends Piece {

    public Pawn(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        return super.canMove(board, start, end);
    }
}
