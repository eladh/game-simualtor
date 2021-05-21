package com.company.game;

import com.company.pons.*;

import java.util.Optional;

public class Board {

// todo - Better data structure use a bitboard
    private Spot[][] boxes = new Spot[8][8];

    public Board(Spot[][] boxes) {
        this.boxes = boxes;
    }

    public Board() {
        this.resetBoard();
    }

    public Optional<Spot> getBox(int x, int y) {
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            return Optional.empty();
        }

        return Optional.of(boxes[x][y]);
    }

    public Spot[][] getBoxes() {
        return boxes.clone();
    }

    public void resetBoard() {
        for (int row = 0; row < boxes.length; row++) {
            for (int col = 0; col < boxes[row].length; col++) {
                if (row == 0) {
                    switch (col) {
                        case 0:
                        case 7:
                            boxes[row][col] = new Spot(row, col, new Rook(false));
                            break;
                        case 1:
                        case 6:
                            boxes[row][col] = new Spot(row, col, new Knight(false));
                            break;
                        case 2:
                        case 5:
                            boxes[row][col] = new Spot(row, col, new Bishop(false));
                            break;
                        case 3:
                            boxes[row][col] = new Spot(row, col, new Queen(false));
                            break;
                        case 4:
                            boxes[row][col] = new Spot(row, col, new King(false));
                            break;
                    }
                } else if (row == 1) {
                    boxes[row][col] = new Spot(row, col, new Pawn(false));
                } else if (row == 6) {
                    boxes[row][col] = new Spot(row, col, new Pawn(true));
                } else if (row == 7) {
                    switch (col) {
                        case 0:
                        case 7:
                            boxes[row][col] = new Spot(row, col, new Rook(true));
                            break;
                        case 1:
                        case 6:
                            boxes[row][col] = new Spot(row, col, new Knight(true));
                            break;
                        case 2:
                        case 5:
                            boxes[row][col] = new Spot(row, col, new Bishop(true));
                            break;
                        case 3:
                            boxes[row][col] = new Spot(row, col, new Queen(true));
                            break;
                        case 4:
                            boxes[row][col] = new Spot(row, col, new King(true));
                            break;
                    }
                } else {
                    boxes[row][col] = new Spot(row ,col ,null);
                }
            }
        }
    }
}
