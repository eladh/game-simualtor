package com.company.pons;

import com.company.game.Board;
import com.company.game.Spot;

public class King extends Piece {


    public King(boolean white) {
        super(white);
    }


    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        if (end.getPiece().isWhite() == this.isWhite()) {
            return true;
        }

        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());

        return x + y != 1;
    }

    public boolean isCastlingMove(Spot start, Spot end) {
        //todo - manage castling
        return false;
    }

}
