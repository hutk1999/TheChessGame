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
                }

            }
            else{
                temp.getChessboard()[getX()+1][getY()].setTheBackground(Color.GREEN);
            }
            if(getY()==7){}
            else{
        if(temp.getChessboard()[getX()+1][getY()+1].isPieceOn()==true){
            if(temp.getChessboard()[getX()+1][getY()+1].getPiece().getPieceColor()!=getPieceColor()){
                temp.getChessboard()[getX()+1][getY()+1].setTheBackground(Color.GREEN);
            }

        }
        else{
            temp.getChessboard()[getX()+1][getY()+1].setTheBackground(Color.GREEN);
        }}
            if(getY()==0){}
            else {
        if(temp.getChessboard()[getX()+1][getY()-1].isPieceOn()==true){
            if(temp.getChessboard()[getX()+1][getY()-1].getPiece().getPieceColor()!=getPieceColor()){
                temp.getChessboard()[getX()+1][getY()-1].setTheBackground(Color.GREEN);
            }

        }
        else{
            temp.getChessboard()[getX()+1][getY()-1].setTheBackground(Color.GREEN);
        }}
        }
        if(getY()==0){}
        else{
        if(temp.getChessboard()[getX()][getY()-1].isPieceOn()==true){
            if(temp.getChessboard()[getX()][getY()].getPiece().getPieceColor()!=getPieceColor()){
                temp.getChessboard()[getX()][getY()].setTheBackground(Color.GREEN);
            }

        }
        else {
            temp.getChessboard()[getX()][getY()].setTheBackground(Color.GREEN);
        }
        }
        if(getY()==7){}
        else{
        if(temp.getChessboard()[getX()][getY()+1].isPieceOn()==true){
            if(temp.getChessboard()[getX()][getY()+1].getPiece().getPieceColor()!=getPieceColor()){
                temp.getChessboard()[getX()][getY()+1].setTheBackground(Color.GREEN);
            }

        }  else {
            temp.getChessboard()[getX()][getY()+1].setTheBackground(Color.GREEN);
        }
        }
        if(getX()==0){}
        else {
            if (temp.getChessboard()[getX() - 1][getY()].isPieceOn() == true) {
                if (temp.getChessboard()[getX() - 1][getY()].getPiece().getPieceColor() != getPieceColor()) {
                    temp.getChessboard()[getX() - 1][getY()].setTheBackground(Color.GREEN);
                }

            }
            else {
                temp.getChessboard()[getX() - 1][getY()].setTheBackground(Color.GREEN);
            }
            if(getY()==7){}
            else {
            if (temp.getChessboard()[getX() - 1][getY() + 1].isPieceOn() == true) {
                if (temp.getChessboard()[getX() - 1][getY() + 1].getPiece().getPieceColor() != getPieceColor()) {
                    temp.getChessboard()[getX() - 1][getY() + 1].setTheBackground(Color.GREEN);
                }

            }
            else {
                temp.getChessboard()[getX() - 1][getY() + 1].setTheBackground(Color.GREEN);
            }
            }
            if(getY()==0){}
            else {
                if (temp.getChessboard()[getX() - 1][getY() - 1].isPieceOn() == true) {
                    if (temp.getChessboard()[getX() - 1][getY() - 1].getPiece().getPieceColor() != getPieceColor()) {
                        temp.getChessboard()[getX() - 1][getY() - 1].setTheBackground(Color.GREEN);
                    }

                }
                else {
                    temp.getChessboard()[getX() - 1][getY() - 1].setTheBackground(Color.GREEN);
                }
            }

        }

    }
}
