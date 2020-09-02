package com.YoelSiegel;

import java.awt.*;
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

    public void setincaseofmove(int x,int y,ChessBoard temp){
            temp.getChessboard()[x][y].setTheBackground(Color.GREEN);
            temp.getChessboard()[x][y].setAttackingx(getX());
            temp.getChessboard()[x][y].setAttackingy(getY());
            temp.getChessboard()[x][y].setInattack(false);
    }
    public void setincaseofattack(int x,int y ,ChessBoard temp){
        temp.getChessboard()[x][y].setTheBackground(Color.GREEN);
        temp.getChessboard()[x][y].setAttackingx(getX());
        temp.getChessboard()[x][y].setAttackingy(getY());
        temp.getChessboard()[x][y].setInattack(true);

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
