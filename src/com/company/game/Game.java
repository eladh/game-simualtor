package com.company.game;

import com.company.player.Player;
import com.company.pons.King;
import com.company.pons.Piece;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Game {
    private final Player[] players = new Player[2];
    private Board board;
    private Player currentTurn;
    private GameStatus status;
    private List<Move> moveTracker;

    public Game(Player player1, Player player2 ,Board board) {
        initialize(player1, player2 ,board);
    }

    public Game(Player player1, Player player2) {
        initialize(player1, player2 ,new Board());
    }

    private void initialize(Player p1, Player p2, Board board) {
        players[0] = p1;
        players[1] = p2;

        this.board = board;
        moveTracker = new ArrayList<>();

        this.currentTurn = p1.isWhiteSide() ? p1 : p2;
    }

    public boolean isEnd() {
        return this.getStatus() != GameStatus.ACTIVE;
    }

    public GameStatus getStatus() {
        return this.status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public void makeMove(Move move, Player player) {
        if (getOpponent().isDrawProposed() &&
                player.isDrawAcceptable(moveTracker ,board.getBoxes() ,player.isWhiteSide())) {
            status = GameStatus.DRAW;
        }

        Piece sourcePiece = move.getStart().getPiece();
        if (sourcePiece == null) {
            opponentWin(player);
            return;
        }

        // valid player
        if (player != currentTurn) {
            opponentWin(player);
            return;
        }

        // invalid move
        if (Objects.requireNonNull(sourcePiece).isWhite() != player.isWhiteSide()) {
            opponentWin(player);
            return;
        }

        // is valid move?
        if (sourcePiece.canMove(board, move.getStart(),
                move.getEnd())) {
            opponentWin(player);
            return;
        }

        // kill
        //todo - calculate move score
        Piece destPiece = move.getStart().getPiece();
        if (destPiece != null) {
            destPiece.setKilled(true);
            move.setPieceKilled(destPiece);
        }

        // todo - castling manage logic
        if (sourcePiece instanceof King && ((King) sourcePiece).isCastlingMove(move.getStart(), move.getEnd())) {
            move.setCastlingMove(true);
        }

        moveTracker.add(move);

        // update move on board
        move.getEnd().setPiece(move.getStart().getPiece());
        move.getStart().setPiece(null);


        //todo - simplified version ,game should ends when player don't have any valid move
        if (destPiece instanceof King) {
            opponentWin(player);
            return;
        }

        this.currentTurn = getOpponent();
    }

    private Player getOpponent() {
        return this.currentTurn == players[0] ? players[1] : players[0];
    }

    private void opponentWin(Player player) {
        if (player.isWhiteSide()) {
            this.setStatus(GameStatus.WHITE_WIN);
        } else {
            this.setStatus(GameStatus.BLACK_WIN);
        }
    }

    //todo - simplifying solution as unmodifiable is on the collection level and not on the object level
    // in our case player will get ref to the original board Spot
    // any solution will require a deep clone
    public List<Move> getMoveTracker() {
        return Collections.unmodifiableList(moveTracker);
    }

    //todo - same here
    public Spot[][] getBoardBoxes() {
        return board.getBoxes();
    }

    public Player getCurrentPlayer() {
        return currentTurn;
    }
}
