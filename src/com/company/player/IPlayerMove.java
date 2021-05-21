package com.company.player;

import com.company.game.Move;
import com.company.game.Spot;

import java.util.List;

public interface IPlayerMove {

    Move getMove(List<Move> moves, Spot[][] board, boolean isWhite);

    boolean isDrawAcceptable(List<Move> moves, Spot[][] board, boolean isWhite);
}
