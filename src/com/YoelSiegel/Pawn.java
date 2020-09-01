package com.YoelSiegel;

import java.awt.*;

public class Pawn extends Piece{

    public Pawn(PieceColor pieceColor, int x, int y){
       super(pieceColor, x, y, PieceType.PAWN);

    }
    public void getLegalMoves(ChessBoard temp){
        int z=0;
        //makes z=-1 is piece is white
        if(temp.getChessboard()[getX()][getY()].getPiece().getPieceColor()==PieceColor.WHITE){
            z=(-1);
        }
        //makes it 1 if its black
        else {
            z=1;
        }
        //if the one in front of it is empty make it green
        if(temp.getChessboard()[getX()+z][getY()].isPieceOn()!=true){
            temp.getChessboard()[getX()+z][getY()].setTheBackground(Color.green);
        //    temp.getChessboard()[getX()+z][getY()].
        }
        //if the one diagonal left is empty then check if 2 diagonal is empty
        if(getY()>=6){}
        else{
            if(temp.getChessboard()[getX()+z][getY()+1].getPiece()!=null){
        if(temp.getChessboard()[getX()+z][getY()+1].getPiece().getPieceColor()!=getPieceColor()){
            if(temp.getChessboard()[getX()+(2*z)][getY()+(2)].isPieceOn()==false){
                temp.getChessboard()[getX()+(2*z)][getY()+2].setTheBackground(Color.green);
            }
        }}}
        if(getY()<=1){}
        else{
        //if one diaganol right is empty then check if 2 diagonal is empty
            if(temp.getChessboard()[getX()+z][getY()-1].getPiece()!=null){
        if(temp.getChessboard()[getX()+z][getY()-1].getPiece().getPieceColor()!=getPieceColor()){
            if(temp.getChessboard()[getX()+(2*z)][getY()-(2)].isPieceOn()==false){
                temp.getChessboard()[getX()+(2*z)][getY()-2].setTheBackground(Color.green);
            }
        } }}
        if(z==1){
        if(getX()==1){
            if(temp.getChessboard()[getX()+1][getY()].isPieceOn()==false){
                if(temp.getChessboard()[getX()+2][getY()].isPieceOn()==false){
                    temp.getChessboard()[getX()+2][getY()].setTheBackground(Color.green);
                }
            }
        }}
        else{
            if(getX()==6){
                if(temp.getChessboard()[getX()-1][getY()].isPieceOn()==false){
                    if(temp.getChessboard()[getX()-2][getY()].isPieceOn()==false){
                        temp.getChessboard()[getX()-2][getY()].setTheBackground(Color.green);
                    }
                }
            }
        }
    }
}


