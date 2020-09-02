package com.YoelSiegel;

import java.awt.*;

public class Pawn extends Piece{

    public Pawn(PieceColor pieceColor, int x, int y){
       super(pieceColor, x, y, PieceType.PAWN);

    }
    public void getLegalMoves(ChessBoard temp){
        if(!temp.getChessboard()[getX()][getY()].isPieceOn()){
            return;
        }
        int z=0;
        //makes z=-1 is piece is white
        if(!temp.getChessboard()[getX()][getY()].isPieceOn()){
            return;
        }
        if(temp.getChessboard()[getX()][getY()].getPiece().getPieceColor()==PieceColor.WHITE){
            z=(-1);
        }
        //makes it 1 if its black
        else {
            z=1;
        }
        //if the one in front of it is empty make it green
        if(temp.getChessboard()[getX()+z][getY()].isPieceOn()!=true){
            setincaseofmove(getX()+z,getY(),temp);
        }
        //if the one diagonal left is empty then check if 2 diagonal is empty
        if(z==1) {
            if (getX() == 7) {
            } else {
                if (getY() == 7) {
                } else {
                    if (temp.getChessboard()[getX() + 1][getY() + 1].getPiece() != null) {
                        if (temp.getChessboard()[getX() + 1][getY() + 1].getPiece().getPieceColor() != getPieceColor()) {
                            setincaseofattack(getX()+1,getY()+1,temp);

                        }
                    }
                }
                if (getY() == 0) {
                } else {
                    //if one diaganol right is empty then check if 2 diagonal is empty
                    if (temp.getChessboard()[getX() + 1][getY() - 1].getPiece() != null) {
                        if (temp.getChessboard()[getX() + 1][getY() - 1].getPiece().getPieceColor() != getPieceColor()) {
                         setincaseofattack(getX()+1,getY()-1,temp);
                        }
                    }
                }
            }
        }
        else {
            if (getX() == 0) {
            } else {
                if (getY() == 7) {
                } else {
                    if (temp.getChessboard()[getX() - 1][getY() + 1].getPiece() != null) {
                        setincaseofattack(getX()-1,getY()+1,temp);
                }
                if (getY() ==0) {
                } else {
                    //if one diaganol right is empty then check if 2 diagonal is empty
                    if (temp.getChessboard()[getX() - 1][getY() - 1].getPiece() != null) {
                        if (temp.getChessboard()[getX() - 1][getY() - 1].getPiece().getPieceColor() != getPieceColor()) {
                          setincaseofattack(getX()-1,getY()-1,temp);
                        }
                    }
                }
            }
        }}

        if(z==1) {

            if (getX() == 1) {
                if (temp.getChessboard()[getX() + 1][getY()].isPieceOn() == false) {
                    if (temp.getChessboard()[getX() + 2][getY()].isPieceOn() == false) {
                        System.out.println("heyo we in here");
                     setincaseofmove(getX()+2,getY(),temp);
                    }
                }
            }
        }
        else{
            if(getX()==6){
                if(temp.getChessboard()[getX()-1][getY()].isPieceOn()==false){
                    if(temp.getChessboard()[getX()-2][getY()].isPieceOn()==false){
                        setincaseofmove(getX()-2,getY(),temp);
                    }
                }
            }
        }
    }
}


