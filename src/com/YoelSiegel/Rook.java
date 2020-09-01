package com.YoelSiegel;

import java.awt.*;

public class Rook extends Piece{
    public Rook(PieceColor pieceColor, int x, int y) {

        super(pieceColor, x, y, PieceType.ROOK);
    }
    /*public void getLegalMoves(ChessBoard temp){
        for (int i = this.getY() + 1; i<8; i++) {
            if (temp.getChessboard()[getX()][i].isPieceOn()) {
                if(temp.getChessboard()[getX()][i].getPiece().getPieceColor()!=getPieceColor()){
                    temp.getChessboard()[getX()][i].setTheBackground(Color.green);
            }
        }
        evalMove(temp, x, y, realMove);
        return true;
    } else if ((x == this.getX()) && (y < this.getY())) {
        for (int i = y + 1; i < getY(); i++) {
            if (temp.getChessboard()[x][i].isPieceOn()) {
                System.out.print("this move is illegal");
                return false;
            }
        }
        evalMove(temp, x, y, realMove);
        return true;
    } else if ((y == this.getY()) && (x > this.getX())) {
        for (int i = this.getX() + 1; i < x; i++) {
            if (temp.getChessboard()[i][y].isPieceOn()) {
                System.out.print("this move is illegal");
                return false;
            }
        }
        evalMove(temp, x, y, realMove);
        return true;
    } else if ((y == this.getY()) && (x < this.getX())) {
        for (int i = x + 1; i < getX(); i++) {
            if (temp.getChessboard()[i][y].isPieceOn()) {
                System.out.print("this move is illegal");
                return false;
            }
        }
        evalMove(temp, x, y, realMove);
        return true;
    }

}

*/









}
