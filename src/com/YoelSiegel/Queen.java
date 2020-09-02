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
            if(betweenExclusive(getX()+i, 0, 8)&&betweenExclusive(getY()+i, 0, 8)){
                if (temp.gettile(getX() + i, getY() + i).isPieceOn()) {
                    if(temp.gettile(getX() + i, getY() + i).getPiece().getPieceColor()!=temp.gettile(getX(), getY()).getPiece().getPieceColor()){
                        temp.getChessboard()[getX()+i][getY()+i].setTheBackground(Color.GREEN);
                        temp.getChessboard()[getX() + i][getY() + i].setAttackingx(getX());
                        temp.getChessboard()[getX() + i][getY() + i].setAttackingy(getY());
                        temp.getChessboard()[getX() + i][getY() + i].setInattack(true);
                        break;
                    }
                    else{
                        break;
                    }
                }
                temp.getChessboard()[getX()+i][getY()+i].setTheBackground(Color.GREEN);
                temp.getChessboard()[getX() + i][getY() + i].setAttackingx(getX());
                temp.getChessboard()[getX() + i][getY() + i].setAttackingy(getY());
                temp.getChessboard()[getX() + i][getY() + i].setInattack(false);
            }
        }
        for (int i = 1; i < 8; i++) {
            if(betweenExclusive(getX()-i, 0, 8)&&betweenExclusive(getY()-i, 0, 8)){
                if (temp.gettile(getX() - i, getY() - i).isPieceOn()) {
                    if(temp.gettile(getX() - i, getY() - i).getPiece().getPieceColor()!=temp.gettile(getX(), getY()).getPiece().getPieceColor()){
                        temp.getChessboard()[getX()-i][getY()-i].setTheBackground(Color.GREEN);
                        temp.getChessboard()[getX() - i][getY() - i].setAttackingx(getX());
                        temp.getChessboard()[getX() - i][getY() - i].setAttackingy(getY());
                        temp.getChessboard()[getX() - i][getY() - i].setInattack(true);
                        break;
                    }
                    else{
                        break;
                    }
                }
                temp.getChessboard()[getX()-i][getY()-i].setTheBackground(Color.GREEN);
                temp.getChessboard()[getX() - i][getY() - i].setAttackingx(getX());
                temp.getChessboard()[getX() - i][getY() - i].setAttackingy(getY());
                temp.getChessboard()[getX() - i][getY() - i].setInattack(false);
            }
        }
        for (int i = 1; i < 8; i++) {
            if(betweenExclusive(getX()+i, 0, 8)&&betweenExclusive(getY()-i, 0, 8)){
                if (temp.gettile(getX() + i, getY() - i).isPieceOn()) {
                    if(temp.gettile(getX() + i, getY() - i).getPiece().getPieceColor()!=temp.gettile(getX(), getY()).getPiece().getPieceColor()){
                        temp.getChessboard()[getX()+i][getY()-i].setTheBackground(Color.GREEN);
                        temp.getChessboard()[getX() + i][getY() - i].setAttackingx(getX());
                        temp.getChessboard()[getX() + i][getY() - i].setAttackingy(getY());
                        temp.getChessboard()[getX() + i][getY() - i].setInattack(true);
                        break;
                    }
                    else{
                        break;
                    }
                }
                temp.getChessboard()[getX()+i][getY()-i].setTheBackground(Color.GREEN);
                temp.getChessboard()[getX() + i][getY() - i].setAttackingx(getX());
                temp.getChessboard()[getX() + i][getY() - i].setAttackingy(getY());
                temp.getChessboard()[getX() + i][getY() - i].setInattack(false);
            }
        }
        for (int i = 1; i < 8; i++) {
            if(betweenExclusive(getX()-i, 0, 8)&&betweenExclusive(getY()+i, 0, 8)){
                if (temp.gettile(getX() - i, getY() + i).isPieceOn()) {
                    if(temp.gettile(getX() - i, getY() + i).getPiece().getPieceColor()!=temp.gettile(getX(), getY()).getPiece().getPieceColor()){
                        temp.getChessboard()[getX()-i][getY()+i].setTheBackground(Color.GREEN);
                        temp.getChessboard()[getX() - i][getY() + i].setAttackingx(getX());
                        temp.getChessboard()[getX() - i][getY() + i].setAttackingy(getY());
                        temp.getChessboard()[getX() - i][getY() + i].setInattack(true);
                        break;
                    }
                    else{
                        break;
                    }
                }
                temp.getChessboard()[getX()-i][getY()+i].setTheBackground(Color.GREEN);
                temp.getChessboard()[getX() - i][getY() + i].setAttackingx(getX());
                temp.getChessboard()[getX() - i][getY() + i].setAttackingy(getY());
                temp.getChessboard()[getX() - i][getY() + i].setInattack(false);
            }
        }
        for (int i = 1; i < 8; i++) {
            if (betweenExclusive(getX() + i, 0, 8) && betweenExclusive(getY(), 0, 8)) {
                if (temp.getChessboard()[getX() + i][getY()].isPieceOn()) {
                    if (temp.getChessboard()[getX() + i][getY()].getPiece().getPieceColor() != getPieceColor()) {
                        temp.getChessboard()[getX() + i][getY()].setTheBackground(Color.green);
                        temp.getChessboard()[getX() + i][getY()].setInattack(true);
                        temp.getChessboard()[getX() + i][getY()].setAttackingx(getX());
                        temp.getChessboard()[getX() + i][getY()].setAttackingy(getY());
                        break;
                    } else {
                        break;
                    }
                } else {

                    temp.getChessboard()[getX() + i][getY()].setTheBackground(Color.green);
                    temp.getChessboard()[getX() + i][getY()].setInattack(false);
                    temp.getChessboard()[getX() + i][getY()].setAttackingx(getX());
                    temp.getChessboard()[getX() + i][getY()].setAttackingy(getY());

                }
            }
        }

        for (int i = 1; i < 8; i++) {
            if (betweenExclusive(getX() - i, 0, 8) && betweenExclusive(getY(), 0, 8)) {
                if (temp.getChessboard()[getX() - i][getY()].isPieceOn()) {
                    if (temp.getChessboard()[getX() - i][getY()].getPiece().getPieceColor() != getPieceColor()) {
                        temp.getChessboard()[getX() - i][getY()].setTheBackground(Color.green);
                        temp.getChessboard()[getX() - i][getY()].setInattack(true);
                        temp.getChessboard()[getX() - i][getY()].setAttackingx(getX());
                        temp.getChessboard()[getX() - i][getY()].setAttackingy(getY());
                        break;
                    } else {
                        break;
                    }
                } else {
                    temp.getChessboard()[getX() - i][getY()].setTheBackground(Color.green);
                    temp.getChessboard()[getX() - i][getY()].setInattack(false);
                    temp.getChessboard()[getX() - i][getY()].setAttackingx(getX());
                    temp.getChessboard()[getX() - i][getY()].setAttackingy(getY());
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if (betweenExclusive(getX(), 0, 8) && betweenExclusive(getY() - i, 0, 8)) {
                if (temp.getChessboard()[getX()][getY() - i].isPieceOn()) {
                    if (temp.getChessboard()[getX()][getY() - i].getPiece().getPieceColor() != getPieceColor()) {
                        temp.getChessboard()[getX()][getY() - i].setTheBackground(Color.green);
                        temp.getChessboard()[getX()][getY() - i].setInattack(true);
                        temp.getChessboard()[getX()][getY() - i].setAttackingx(getX());
                        temp.getChessboard()[getX()][getY() - i].setAttackingy(getY());
                        break;
                    } else {
                        break;
                    }
                } else {
                    temp.getChessboard()[getX()][getY() - i].setTheBackground(Color.green);
                    temp.getChessboard()[getX()][getY() - i].setInattack(false);
                    temp.getChessboard()[getX()][getY() - i].setAttackingx(getX());
                    temp.getChessboard()[getX()][getY() - i].setAttackingy(getY());
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if (betweenExclusive(getX() - i, 0, 8) && betweenExclusive(getY(), 0, 8)) {
                if (temp.getChessboard()[getX() - i][getY()].isPieceOn()) {
                    if (temp.getChessboard()[getX() - i][getY()].getPiece().getPieceColor() != getPieceColor()) {
                        temp.getChessboard()[getX() - i][getY()].setTheBackground(Color.green);
                        temp.getChessboard()[getX() - i][getY()].setInattack(true);
                        temp.getChessboard()[getX() - i][getY()].setAttackingx(getX());
                        temp.getChessboard()[getX() - i][getY()].setAttackingy(getY());
                        break;
                    } else {
                        break;
                    }
                } else {
                    temp.getChessboard()[getX() - i][getY()].setTheBackground(Color.green);
                    temp.getChessboard()[getX() - i][getY()].setInattack(false);
                    temp.getChessboard()[getX() - i][getY()].setAttackingx(getX());
                    temp.getChessboard()[getX() - i][getY()].setAttackingy(getY());
                }
            }
        }

    }

    public static boolean betweenExclusive(int x, int min, int max) {
        return x>=min && x<max;
    }

}



