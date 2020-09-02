package com.YoelSiegel;

import java.awt.*;

public class Knight extends Piece{
    public Knight(PieceColor ecolor, int x, int y) {
        super(ecolor, x, y, PieceType.KNIGHT);
    }

    public void getLegalMoves(ChessBoard temp){
        if(!temp.getChessboard()[getX()][getY()].isPieceOn()){
            return;
        }
        if (betweenExclusive(getX() + 1, 0, 8)&& betweenExclusive(this.getY() + 2, 0, 8)) {
            if(temp.gettile(getX()+1, getY()+2).isPieceOn()){
                if(temp.gettile(getX()+1, getY()+2).getPiece().getPieceColor()!=temp.gettile(getX(), getY()).getPiece().getPieceColor()){
                    setincaseofattack(getX()+1,getY()+2,temp);
                }
            }
            else{
                setincaseofmove(getX()+1,getY()+2,temp);

            }

        }
        if (betweenExclusive(getX() + 2, 0, 8)&& betweenExclusive(this.getY() + 1, 0, 8)) {
            if(temp.gettile(getX()+2, getY()+1).isPieceOn()){
                if(temp.gettile(getX()+2, getY()+1).getPiece().getPieceColor()!=temp.gettile(getX(), getY()).getPiece().getPieceColor()){
                    setincaseofattack(getX()+2,getY()+1,temp);
                }
            }
            else{
                setincaseofmove(getX()+2,getY()+1,temp);
            }
        }
        if (betweenExclusive(getX() -1, 0, 8)&& betweenExclusive(this.getY() -2, 0, 8)) {
            if(temp.gettile(getX()-1, getY()-2).isPieceOn()){
                if(temp.gettile(getX()-1, getY()-2).getPiece().getPieceColor()!=temp.gettile(getX(), getY()).getPiece().getPieceColor()){
                    setincaseofattack(getX()-1,getY()-2,temp);
                }
            }
            else{
                setincaseofmove(getX()-1,getY()-2,temp);
            }
        }
        if (betweenExclusive(getX() - 2, 0, 8)&& betweenExclusive(this.getY() - 1, 0, 8)) {
            if(temp.gettile(getX()-2, getY()-1).isPieceOn()){
                if(temp.gettile(getX()-2, getY()-1).getPiece().getPieceColor()!=temp.gettile(getX(), getY()).getPiece().getPieceColor()){
                    setincaseofattack(getX()-2,getY()-1,temp);
                }
            }
            else{
                setincaseofmove(getX()-2,getY()-1,temp);
            }
        }
        if (betweenExclusive(getX() + 1, 0, 8)&& betweenExclusive(this.getY() -2, 0, 8)) {
            if(temp.gettile(getX()+1, getY()-2).isPieceOn()){
                if(temp.gettile(getX()+1, getY()-2).getPiece().getPieceColor()!=temp.gettile(getX(), getY()).getPiece().getPieceColor()){
                    setincaseofattack(getX()+1,getY()-2,temp);
                }
            }
            else{
                setincaseofmove(getX()+1,getY()-2,temp);
            }
        }
        if (betweenExclusive(getX() + 2, 0, 8)&& betweenExclusive(this.getY() - 1, 0, 8)) {
            if(temp.gettile(getX()+2, getY()-1).isPieceOn()){
                if(temp.gettile(getX()+2, getY()-1).getPiece().getPieceColor()!=temp.gettile(getX(), getY()).getPiece().getPieceColor()){
                    setincaseofattack(getX()+2,getY()-1,temp);
                }
            }
            else{
                setincaseofmove(getX()+2,getY()-1,temp);
            }
        }
        if (betweenExclusive(getX() - 1, 0, 8)&& betweenExclusive(this.getY() + 2, 0, 8)) {
            if(temp.gettile(getX()-1, getY()+2).isPieceOn()){
                if(temp.gettile(getX()-1, getY()+2).getPiece().getPieceColor()!=temp.gettile(getX(), getY()).getPiece().getPieceColor()){
                    setincaseofattack(getX()-1,getY()+2,temp);
                }
            }
            else{
                setincaseofmove(getX()-1,getY()+2,temp);
            }
        }
        if (betweenExclusive(getX() - 2, 0, 8)&& betweenExclusive(this.getY() + 1, 0, 8)) {
            if(temp.gettile(getX()-2, getY()+1).isPieceOn()){
                if(temp.gettile(getX()-2, getY()+1).getPiece().getPieceColor()!=temp.gettile(getX(), getY()).getPiece().getPieceColor()){
                    setincaseofattack(getX()-2,getY()+1,temp);
                }
            }
            else{
                setincaseofmove(getX()-2,getY()+1,temp);
            }
        }
    }
    public static boolean betweenExclusive(int x, int min, int max) {
        return x>=min && x<max;
    }
}


