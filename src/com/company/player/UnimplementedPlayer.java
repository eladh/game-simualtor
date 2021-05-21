package com.company.player;

import com.company.game.Move;
import com.company.game.Spot;

import java.util.List;

public class UnimplementedPlayer implements IPlayerMove {

    @Override
    public Move getMove(List<Move> moves, Spot[][] board, boolean isWhite) {
        return null;
    }

    @Override
    public boolean isDrawAcceptable(List<Move> moves, Spot[][] board, boolean isWhite) {
        return false;
    }
}
