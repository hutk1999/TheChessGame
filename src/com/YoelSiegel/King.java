package com.YoelSiegel;

import java.awt.*;

public class King extends Piece{
    public King(PieceColor ecolor, int x, int y) {

        super(ecolor, x, y, PieceType.KING);
    }
    boolean hasevermoved=false;
    public void getLegalMoves(ChessBoard temp){
        if(!temp.getChessboard()[getX()][getY()].isPieceOn()){
            return;
        }
        System.out.println("in here");
        if(getX()==7){}
        else {
            if (temp.getChessboard()[getX() + 1][getY()].isPieceOn() == true) {
                if (temp.getChessboard()[getX() + 1][getY()].getPiece().getPieceColor() != getPieceColor()) {
                    setincaseofattack(getX()+1,getY(),temp);
                }

            }
            else{
                setincaseofmove(getX()+1,getY(),temp);
            }
            if(getY()==7){}
            else{
        if(temp.getChessboard()[getX()+1][getY()+1].isPieceOn()==true){
            if(temp.getChessboard()[getX()+1][getY()+1].getPiece().getPieceColor()!=getPieceColor()){
                setincaseofattack(getX()+1,getY()+1,temp);
            }

        }
        else{
            setincaseofmove(getX()+1,getY()+1,temp);
        }}
            if(getY()==0){}
            else {
        if(temp.getChessboard()[getX()+1][getY()-1].isPieceOn()==true){
            if(temp.getChessboard()[getX()+1][getY()-1].getPiece().getPieceColor()!=getPieceColor()){
                setincaseofattack(getX()+1,getY()-1,temp);
            }

        }
        else{
            setincaseofmove(getX()+1,getY()-1,temp);
        }}
        }
        if(getY()==0){}
        else{
        if(temp.getChessboard()[getX()][getY()-1].isPieceOn()==true){
            if(temp.getChessboard()[getX()][getY()-1].getPiece().getPieceColor()!=getPieceColor()){
                setincaseofattack(getX(),getY()-1,temp);
            }

        }
        else {
            setincaseofmove(getX(),getY()-1,temp);
        }
        }
        if(getY()==7){}
        else{
        if(temp.getChessboard()[getX()][getY()+1].isPieceOn()==true){
            if(temp.getChessboard()[getX()][getY()+1].getPiece().getPieceColor()!=getPieceColor()){
                setincaseofattack(getX(),getY()+1,temp);
            }

        }  else {
            setincaseofmove(getX(),getY()+1,temp);
        }
        }
        if(getX()==0){}
        else {
            if (temp.getChessboard()[getX() - 1][getY()].isPieceOn() == true) {
                if (temp.getChessboard()[getX() - 1][getY()].getPiece().getPieceColor() != getPieceColor()) {
                    setincaseofattack(getX()-1,getY(),temp);
                }

            }
            else {
                setincaseofmove(getX()-1,getY(),temp);
            }
            if(getY()==7){}
            else {
            if (temp.getChessboard()[getX() - 1][getY() + 1].isPieceOn() == true) {
                if (temp.getChessboard()[getX() - 1][getY() + 1].getPiece().getPieceColor() != getPieceColor()) {
                    setincaseofattack(getX()-1,getY()+1,temp);
                }

            }
            else {
                setincaseofmove(getX()-1,getY()+1,temp);
            }
            }
            if(getY()==0){}
            else {
                if (temp.getChessboard()[getX() - 1][getY() - 1].isPieceOn() == true) {
                    if (temp.getChessboard()[getX() - 1][getY() - 1].getPiece().getPieceColor() != getPieceColor()) {
                        setincaseofmove(getX()-1,getY()-1,temp);
                    }

                }
                else {
                    setincaseofmove(getX()-1,getY()-1,temp);
                }
            }

        }

    }
}
