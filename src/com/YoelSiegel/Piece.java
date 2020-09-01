package com.YoelSiegel;

import java.awt.image.BufferedImage;

public class Piece {
    private int x;
    private int y;
    private PieceColor pieceColor;
    private PieceType type;
    public BufferedImage image;

    public Piece(PieceColor pieceColor, int x, int y,PieceType type){
        this.type = type;
        this.pieceColor = pieceColor;
        this.x = x;
        this.y = y;
    }
    public void getLegalMoves(ChessBoard temp){}
    public boolean isMoveLegal(ChessBoard temp, int x, int y, boolean realmove){ return false;}

    public void evalMove(ChessBoard temp, int x, int y, boolean realmove){
        if (realmove) {
            if (temp.getChessboard()[x][y].isPieceOn()) {
                attackPiece(temp, x, y);
            } else {
                movePiece(temp, x, y);
            }
        }
    }

    public void movePiece(ChessBoard temp, int x, int y) {
        temp.getChessboard()[x][y] = temp.getChessboard()[getX()][getY()];
        //temp.getChessboard()[getX()][getY()] = new Tiles(false, null, temp.getChessboard()[getX()][getY()].getTileColor());
        temp.getChessboard()[x][y].setPieceOn(true);
        setX(x);
        setY(y);
    }



    public void attackPiece(ChessBoard temp, int x, int y) {
        if(temp.gettile(x,y).getPiece().getPieceColor()==PieceColor.WHITE){
            temp.whiteList.remove(temp.gettile(x,y).getPiece());
        }
        else
        {
            temp.blackList.remove(temp.gettile(x,y).getPiece());
        }
        //temp.getChessboard()[x][y].setPiece(this, this.type,this.piececolor);
        //temp.getChessboard()[getX()][getY()] = new Tiles(false, null, temp.getChessboard()[getX()][getY()].getTileColor());
        // temp.getChessboard()[x][y].setPieceOn(true);
        setX(x);
        setY(y);


    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public PieceColor getPieceColor() {
        return pieceColor;
    }

    public void setPieceColor(PieceColor piececolor) {
        this.pieceColor = piececolor;
    }

    public PieceType getType() {
        return type;
    }

    public void setType(PieceType type) {
        this.type = type;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
