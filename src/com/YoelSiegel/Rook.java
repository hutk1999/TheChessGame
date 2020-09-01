package com.YoelSiegel;

import java.awt.*;

public class Rook extends Piece {
    public Rook(PieceColor pieceColor, int x, int y) {

        super(pieceColor, x, y, PieceType.ROOK);
    }

    public void getLegalMoves(ChessBoard temp) {
        for (int i = 1; i < 8; i++) {
            if(betweenExclusive(getX()+i, 0, 8)&&betweenExclusive(getY(), 0, 8)) {
                if (temp.getChessboard()[getX()+i][getY()].isPieceOn()) {
                    if (temp.getChessboard()[getX()+i][getY()].getPiece().getPieceColor() != getPieceColor()) {
                        temp.getChessboard()[getX()+i][getY()].setTheBackground(Color.green);
                        break;
                    } else {
                        break;
                    }
                } else {

                    temp.getChessboard()[getX()+i][getY()].setTheBackground(Color.green);
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if (betweenExclusive(getX() - i, 0, 8) && betweenExclusive(getY(), 0, 8)) {
                if (temp.getChessboard()[getX()-i][getY()].isPieceOn()) {
                    if (temp.getChessboard()[getX()-i][getY()].getPiece().getPieceColor() != getPieceColor()) {
                        temp.getChessboard()[getX()-i][getY()].setTheBackground(Color.green);
                        break;
                    } else {
                        break;
                    }
                } else {
                    temp.getChessboard()[getX()-i][getY()].setTheBackground(Color.green);
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if (betweenExclusive(getX(), 0, 8) && betweenExclusive(getY() - i, 0, 8)) {
                if (temp.getChessboard()[getX()][getY()-i].isPieceOn()) {
                    if (temp.getChessboard()[getX()][getY()-i].getPiece().getPieceColor() != getPieceColor()) {
                        temp.getChessboard()[getX()][getY()-i].setTheBackground(Color.green);
                        break;
                    } else {
                        break;
                    }
                } else {
                    temp.getChessboard()[getX()][getY()-i].setTheBackground(Color.green);
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if (betweenExclusive(getX() - i, 0, 8) && betweenExclusive(getY(), 0, 8)) {
                if (temp.getChessboard()[getX()-i][getY()].isPieceOn()) {
                    if (temp.getChessboard()[getX()-i][getY()].getPiece().getPieceColor() != getPieceColor()) {
                        temp.getChessboard()[getX()-i][getY()].setTheBackground(Color.green);
                        break;
                    } else {
                        break;
                    }
                } else {
                    temp.getChessboard()[getX()-i][getY()].setTheBackground(Color.green);
                }
            }
        }
    }
    public static boolean betweenExclusive(int x, int min, int max) {
        return x>=min && x<max;
    }
}









