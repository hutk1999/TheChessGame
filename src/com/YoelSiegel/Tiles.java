package com.YoelSiegel;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Iterator;
import org.apache.commons.io.IOUtils;

public class Tiles extends JPanel {
    private boolean isPieceOn;
    private Piece piece;
    private PieceColor tileColor;
    private int x;
    private int y;
    private BufferedImage image;
    private Color color;
    public Tiles(PieceColor tileColor, Color mycolor){
        this.isPieceOn=false;
        this.piece=null;
        this.tileColor=tileColor;
        this.color=mycolor;
        setBackground(color);
    }


    public void setPiece(Piece piece,PieceType pieceType, PieceColor pieceColor, String theString) throws IOException {
        this.piece = piece;
        setPieceOn(true);
        this.piece.setType(pieceType);
        this.piece.setPieceColor(pieceColor);
        setBackground(color);
        try {
            BufferedImage tempimage=ImageIO.read(new File(theString));
            BufferedImage tempImage2=resize(tempimage, 50,50);
            image=tempImage2;
            piece.image=image;
        } catch (IOException ex) {
        }
        repaint();
    }

    public static BufferedImage resize(BufferedImage img, int newW, int newH) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0 ,null);
        g2d.dispose();
        return dimg;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 50, 35, null ); // see javadoc for more info on the parameters
    }
    public boolean isPieceOn() {
        return isPieceOn;
    }

    public void setPieceOn(boolean pieceOn) {
        isPieceOn = pieceOn;
    }

    public Piece getPiece() {
        return piece;
    }
/*
    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public PieceColor getTileColor() {
        return tileColor;
    }

    public void setTileColor(PieceColor tileColor) {
        this.tileColor = tileColor;
    }

    @Override
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    /*public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }*/
}




