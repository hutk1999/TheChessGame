package com.YoelSiegel;

import java.awt.*;

public class King extends Piece{
    public King(PieceColor ecolor, int x, int y) {

        super(ecolor, x, y, PieceType.KING);
    }
    public void getLegalMoves(ChessBoard temp){
        System.out.println("in here");
        if(getX()==7){}
        else {
            if (temp.getChessboard()[getX() + 1][getY()].isPieceOn() == true) {
                if (temp.getChessboard()[getX() + 1][getY()].getPiece().getPieceColor() != getPieceColor()) {
                    temp.getChessboard()[getX() + 1][getY()].setTheBackground(Color.GREEN);
                    temp.getChessboard()[getX() + 1][getY()].setAttackingx(getX());
                    temp.getChessboard()[getX() + 1][getY()].setAttackingy(getY());
                    temp.getChessboard()[getX() + 1][getY()].setInattack(true);
                }

            }
            else{
                temp.getChessboard()[getX()+1][getY()].setTheBackground(Color.GREEN);
                temp.getChessboard()[getX() + 1][getY()].setAttackingx(getX());
                temp.getChessboard()[getX() + 1][getY()].setAttackingy(getY());
                temp.getChessboard()[getX() + 1][getY()].setInattack(false);
            }
            if(getY()==7){}
            else{
        if(temp.getChessboard()[getX()+1][getY()+1].isPieceOn()==true){
            if(temp.getChessboard()[getX()+1][getY()+1].getPiece().getPieceColor()!=getPieceColor()){
                temp.getChessboard()[getX()+1][getY()+1].setTheBackground(Color.GREEN);
                temp.getChessboard()[getX() + 1][getY() + 1].setAttackingx(getX());
                temp.getChessboard()[getX() + 1][getY() + 1].setAttackingy(getY());
                temp.getChessboard()[getX() + 1][getY() + 1].setInattack(true);
            }

        }
        else{
            temp.getChessboard()[getX()+1][getY()+1].setTheBackground(Color.GREEN);
            temp.getChessboard()[getX() + 1][getY() + 1].setAttackingx(getX());
            temp.getChessboard()[getX() + 1][getY() + 1].setAttackingy(getY());
            temp.getChessboard()[getX() + 1][getY() + 1].setInattack(false);
        }}
            if(getY()==0){}
            else {
        if(temp.getChessboard()[getX()+1][getY()-1].isPieceOn()==true){
            if(temp.getChessboard()[getX()+1][getY()-1].getPiece().getPieceColor()!=getPieceColor()){
                temp.getChessboard()[getX()+1][getY()-1].setTheBackground(Color.GREEN);
                temp.getChessboard()[getX() + 1][getY() - 1].setAttackingx(getX());
                temp.getChessboard()[getX() + 1][getY() - 1].setAttackingy(getY());
                temp.getChessboard()[getX() + 1][getY() - 1].setInattack(true);
            }

        }
        else{
            temp.getChessboard()[getX()+1][getY()-1].setTheBackground(Color.GREEN);
            temp.getChessboard()[getX() + 1][getY() -1].setAttackingx(getX());
            temp.getChessboard()[getX() + 1][getY() - 1].setAttackingy(getY());
            temp.getChessboard()[getX() + 1][getY() - 1].setInattack(false);
        }}
        }
        if(getY()==0){}
        else{
        if(temp.getChessboard()[getX()][getY()-1].isPieceOn()==true){
            if(temp.getChessboard()[getX()][getY()-1].getPiece().getPieceColor()!=getPieceColor()){
                temp.getChessboard()[getX()][getY()-1].setTheBackground(Color.GREEN);
                temp.getChessboard()[getX()][getY() - 1].setAttackingx(getX());
                temp.getChessboard()[getX()][getY() - 1].setAttackingy(getY());
                temp.getChessboard()[getX()][getY() - 1].setInattack(true);
            }

        }
        else {
            temp.getChessboard()[getX()][getY()-1].setTheBackground(Color.GREEN);
            temp.getChessboard()[getX()][getY() - 1].setAttackingx(getX());
            temp.getChessboard()[getX()][getY() - 1].setAttackingy(getY());
            temp.getChessboard()[getX()][getY() - 1].setInattack(false);
        }
        }
        if(getY()==7){}
        else{
        if(temp.getChessboard()[getX()][getY()+1].isPieceOn()==true){
            if(temp.getChessboard()[getX()][getY()+1].getPiece().getPieceColor()!=getPieceColor()){
                temp.getChessboard()[getX()][getY()+1].setTheBackground(Color.GREEN);
                temp.getChessboard()[getX()][getY() + 1].setAttackingx(getX());
                temp.getChessboard()[getX()][getY() + 1].setAttackingy(getY());
                temp.getChessboard()[getX()][getY() + 1].setInattack(true);
            }

        }  else {
            temp.getChessboard()[getX()][getY()+1].setTheBackground(Color.GREEN);
            temp.getChessboard()[getX()][getY() + 1].setAttackingx(getX());
            temp.getChessboard()[getX()][getY() + 1].setAttackingy(getY());
            temp.getChessboard()[getX()][getY() + 1].setInattack(false);
        }
        }
        if(getX()==0){}
        else {
            if (temp.getChessboard()[getX() - 1][getY()].isPieceOn() == true) {
                if (temp.getChessboard()[getX() - 1][getY()].getPiece().getPieceColor() != getPieceColor()) {
                    temp.getChessboard()[getX() - 1][getY()].setTheBackground(Color.GREEN);
                    temp.getChessboard()[getX() - 1][getY()].setAttackingx(getX());
                    temp.getChessboard()[getX() - 1][getY()].setAttackingy(getY());
                    temp.getChessboard()[getX() - 1][getY()].setInattack(true);
                }

            }
            else {
                temp.getChessboard()[getX() - 1][getY()].setTheBackground(Color.GREEN);
                temp.getChessboard()[getX() - 1][getY()].setAttackingx(getX());
                temp.getChessboard()[getX() - 1][getY()].setAttackingy(getY());
                temp.getChessboard()[getX() - 1][getY()].setInattack(false);
            }
            if(getY()==7){}
            else {
            if (temp.getChessboard()[getX() - 1][getY() + 1].isPieceOn() == true) {
                if (temp.getChessboard()[getX() - 1][getY() + 1].getPiece().getPieceColor() != getPieceColor()) {
                    temp.getChessboard()[getX() - 1][getY() + 1].setTheBackground(Color.GREEN);
                    temp.getChessboard()[getX() - 1][getY() + 1].setAttackingx(getX());
                    temp.getChessboard()[getX() - 1][getY() + 1].setAttackingy(getY());
                    temp.getChessboard()[getX() - 1][getY() + 1].setInattack(true);
                }

            }
            else {
                temp.getChessboard()[getX() - 1][getY() + 1].setTheBackground(Color.GREEN);
                temp.getChessboard()[getX() - 1][getY() + 1].setAttackingx(getX());
                temp.getChessboard()[getX() - 1][getY() + 1].setAttackingy(getY());
                temp.getChessboard()[getX() - 1][getY() + 1].setInattack(false);
            }
            }
            if(getY()==0){}
            else {
                if (temp.getChessboard()[getX() - 1][getY() - 1].isPieceOn() == true) {
                    if (temp.getChessboard()[getX() - 1][getY() - 1].getPiece().getPieceColor() != getPieceColor()) {
                        temp.getChessboard()[getX() - 1][getY() - 1].setTheBackground(Color.GREEN);
                        temp.getChessboard()[getX() - 1][getY() - 1].setAttackingx(getX());
                        temp.getChessboard()[getX() - 1][getY() - 1].setAttackingy(getY());
                        temp.getChessboard()[getX() - 1][getY() - 1].setInattack(true);
                    }

                }
                else {
                    temp.getChessboard()[getX() - 1][getY() - 1].setTheBackground(Color.GREEN);
                    temp.getChessboard()[getX() - 1][getY() - 1].setAttackingx(getX());
                    temp.getChessboard()[getX() - 1][getY() - 1].setAttackingy(getY());
                    temp.getChessboard()[getX() - 1][getY() - 1].setInattack(false);
                }
            }

        }

    }
}
