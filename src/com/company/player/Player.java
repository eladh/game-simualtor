package com.company.player;

import com.company.game.Move;
import com.company.game.Spot;

import java.util.List;

//todo develop minimax player

public class Player implements IPlayerMove {

    protected String name;
    protected boolean white;
    protected IPlayerMove playerMove;
    protected boolean proposedDraw;
    protected int score;

    public Player(IPlayerMove playerMove, String name, boolean white) {
        this.playerMove = playerMove;
        this.name = name;
        this.white = white;
    }

    public boolean isWhiteSide() {
        return white;
    }

    public Move getMove(List<Move> moves, Spot[][] board, boolean isWhite) {
        return playerMove.getMove(moves, board, isWhite);
    }

    public boolean isDrawAcceptable(List<Move> moves, Spot[][] board, boolean isWhite) {
        return proposedDraw = playerMove.isDrawAcceptable(moves, board, isWhite);
    }

    public boolean isDrawProposed() {
        return proposedDraw;
    }

    public int getScore() {
        return score;
    }

    public void updateScore(int score) {
        this.score += score;
    }
}
