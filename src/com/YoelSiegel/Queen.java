package com.YoelSiegel;

import java.awt.*;

public class Queen extends Piece{
    public Queen(PieceColor pieceColor, int x, int y) {
        super(pieceColor, x, y, PieceType.QUEEN);
    }
    public void getLegalMoves(ChessBoard temp){
        if(!temp.getChessboard()[getX()][getY()].isPieceOn()){
            return;
        }
        for (int i = 1; i < 8; i++) {
            if (betweenExclusive(getX() + i, 0, 8) && betweenExclusive(getY(), 0, 8)) {
                if (temp.getChessboard()[getX() + i][getY()].isPieceOn()) {
                    if (temp.getChessboard()[getX() + i][getY()].getPiece().getPieceColor() != getPieceColor()) {
                        setincaseofattack(getX()+i,getY(),temp);
                        break;
                    } else {
                        break;
                    }
                } else {

                    setincaseofmove(getX()+i,getY(),temp);

                }
            }
        }

        for (int i = 1; i < 8; i++) {
            if (betweenExclusive(getX() - i, 0, 8) && betweenExclusive(getY(), 0, 8)) {
                if (temp.getChessboard()[getX() - i][getY()].isPieceOn()) {
                    if (temp.getChessboard()[getX() - i][getY()].getPiece().getPieceColor() != getPieceColor()) {
                        setincaseofattack(getX()-i,getY(),temp);
                        break;
                    } else {
                        break;
                    }
                } else {
                    setincaseofmove(getX()-i,getY(),temp);
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if (betweenExclusive(getX(), 0, 8) && betweenExclusive(getY() - i, 0, 8)) {
                if (temp.getChessboard()[getX()][getY() - i].isPieceOn()) {
                    if (temp.getChessboard()[getX()][getY() - i].getPiece().getPieceColor() != getPieceColor()) {
                        setincaseofattack(getX(),getY()-i,temp);
                        break;
                    } else {
                        break;
                    }
                } else {
                    setincaseofmove(getX(),getY()-i,temp);
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if (betweenExclusive(getX(), 0, 8) && betweenExclusive(getY()+i, 0, 8)) {
                if (temp.getChessboard()[getX() ][getY()+i].isPieceOn()) {
                    if (temp.getChessboard()[getX() ][getY()+i].getPiece().getPieceColor() != getPieceColor()) {
                        setincaseofattack(getX(),getY()+i,temp);
                        break;
                    } else {
                        break;
                    }
                } else {
                    setincaseofmove(getX(),getY()+i,temp);
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if(!temp.getChessboard()[getX()][getY()].isPieceOn()){
                return;
            }
            if(betweenExclusive(getX()+i, 0, 8)&&betweenExclusive(getY()+i, 0, 8)){
                if (temp.gettile(getX() + i, getY() + i).isPieceOn()) {
                    if(temp.gettile(getX() + i, getY() + i).getPiece().getPieceColor()!=temp.gettile(getX(), getY()).getPiece().getPieceColor()){
                        setincaseofattack(getX()+i,getY()+i,temp);
                        break;
                    }
                    else{
                        break;
                    }
                }
                setincaseofmove(getX()+i,getY()+i,temp);
            }
        }
        for (int i = 1; i < 8; i++) {
            if(betweenExclusive(getX()-i, 0, 8)&&betweenExclusive(getY()-i, 0, 8)){
                if (temp.gettile(getX() - i, getY() - i).isPieceOn()) {
                    if(temp.gettile(getX() - i, getY() - i).getPiece().getPieceColor()!=temp.gettile(getX(), getY()).getPiece().getPieceColor()){
                        setincaseofattack(getX()-i,getY()-i,temp);
                        break;
                    }
                    else{
                        break;
                    }
                }
                setincaseofmove(getX()-i,getY()-i,temp);
            }
        }
        for (int i = 1; i < 8; i++) {
            if(betweenExclusive(getX()+i, 0, 8)&&betweenExclusive(getY()-i, 0, 8)){
                if (temp.gettile(getX() + i, getY() - i).isPieceOn()) {
                    if(temp.gettile(getX() + i, getY() - i).getPiece().getPieceColor()!=temp.gettile(getX(), getY()).getPiece().getPieceColor()){
                        setincaseofattack(getX()+i,getY()-i,temp);
                        break;
                    }
                    else{
                        break;
                    }
                }
                setincaseofmove(getX()+i,getY()-i,temp);
            }
        }
        for (int i = 1; i < 8; i++) {
            if(betweenExclusive(getX()-i, 0, 8)&&betweenExclusive(getY()+i, 0, 8)){
                if (temp.gettile(getX() - i, getY() + i).isPieceOn()) {
                    if(temp.gettile(getX() - i, getY() + i).getPiece().getPieceColor()!=temp.gettile(getX(), getY()).getPiece().getPieceColor()){
                        setincaseofattack(getX()-i,getY()+i,temp);
                        break;
                    }
                    else{
                        break;
                    }
                }
                setincaseofmove(getX()-i,getY()+i,temp);
            }
        }

    }

    public static boolean betweenExclusive(int x, int min, int max) {
        return x>=min && x<max;
    }

}



