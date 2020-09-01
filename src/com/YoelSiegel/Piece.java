package com.YoelSiegel;

import java.awt.image.BufferedImage;

public class Piece {
    private int x;
    private int y;
    private PieceColor piececolor;
    private PieceType type;
    public BufferedImage image;

    public Piece(PieceColor pieceColor, int x, int y,PieceType type){
        this.type = type;
        this.piececolor = pieceColor;
        this.x = x;
        this.y = y;
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

    public PieceColor getPiececolor() {
        return piececolor;
    }

    public void setPiececolor(PieceColor piececolor) {
        this.piececolor = piececolor;
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
