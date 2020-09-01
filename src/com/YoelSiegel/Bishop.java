package com.YoelSiegel;

import java.awt.*;

public class Bishop extends Piece{
    public Bishop(PieceColor ecolor, int x, int y) {
        super(ecolor, x, y, PieceType.BISHOP);
    }

    public void getLegalMoves(ChessBoard temp){
        for (int i = 1; i < 8; i++) {
            if(betweenExclusive(getX()+i, 0, 8)&&betweenExclusive(getY()+i, 0, 8)){
                if (temp.gettile(getX() + i, getY() + i).isPieceOn()) {
                    if(temp.gettile(getX() + i, getY() + i).getPiece().getPieceColor()!=temp.gettile(getX(), getY()).getPiece().getPieceColor()){
                        temp.getChessboard()[getX()+i][getY()+i].setTheBackground(Color.GREEN);
                        break;
                    }
                    else{
                        break;
                    }
                }
                temp.getChessboard()[getX()+i][getY()+i].setTheBackground(Color.GREEN);
            }
        }
        for (int i = 1; i < 8; i++) {
            if(betweenExclusive(getX()-i, 0, 8)&&betweenExclusive(getY()-i, 0, 8)){
                if (temp.gettile(getX() - i, getY() - i).isPieceOn()) {
                    if(temp.gettile(getX() - i, getY() - i).getPiece().getPieceColor()!=temp.gettile(getX(), getY()).getPiece().getPieceColor()){
                        temp.getChessboard()[getX()-i][getY()-i].setTheBackground(Color.GREEN);
                        break;
                    }
                    else{
                        break;
                    }
                }
                temp.getChessboard()[getX()-i][getY()-i].setTheBackground(Color.GREEN);
            }
        }
        for (int i = 1; i < 8; i++) {
            if(betweenExclusive(getX()+i, 0, 8)&&betweenExclusive(getY()-i, 0, 8)){
                if (temp.gettile(getX() + i, getY() - i).isPieceOn()) {
                    if(temp.gettile(getX() + i, getY() - i).getPiece().getPieceColor()!=temp.gettile(getX(), getY()).getPiece().getPieceColor()){
                        temp.getChessboard()[getX()+i][getY()-i].setTheBackground(Color.GREEN);
                        break;
                    }
                    else{
                        break;
                    }
                }
                temp.getChessboard()[getX()+i][getY()-i].setTheBackground(Color.GREEN);
            }
        }
        for (int i = 1; i < 8; i++) {
            if(betweenExclusive(getX()-i, 0, 8)&&betweenExclusive(getY()+i, 0, 8)){
                if (temp.gettile(getX() - i, getY() + i).isPieceOn()) {
                    if(temp.gettile(getX() - i, getY() + i).getPiece().getPieceColor()!=temp.gettile(getX(), getY()).getPiece().getPieceColor()){
                        temp.getChessboard()[getX()-i][getY()+i].setTheBackground(Color.GREEN);
                        break;
                    }
                    else{
                        break;
                    }
                }
                temp.getChessboard()[getX()-i][getY()+i].setTheBackground(Color.GREEN);
            }
        }

    }

    public static boolean betweenExclusive(int x, int min, int max) {
        return x>=min && x<max;
    }
}
