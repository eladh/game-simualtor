package com.company.player;

import com.company.game.Move;
import com.company.game.Spot;

import java.util.*;

public class RandomPlayer implements IPlayerMove {

    private final static Random RANDOM = new Random();

    @Override
    public Move getMove(List<Move> moves, Spot[][] board, boolean isWhite) {
        //todo - simulate random move, get all possible moves for player
        ArrayList<Move> allMoves = getAllPossibleMoves(board ,isWhite);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return allMoves.get(RANDOM.nextInt(allMoves.size()));
    }

    private ArrayList<Move> getAllPossibleMoves(Spot[][] board, boolean isWhite) {
        return new ArrayList<>();
    }

    @Override
    public boolean isDrawAcceptable(List<Move> moves, Spot[][] board, boolean isWhite) {
        return RANDOM.nextBoolean();
    }

}
