package com.YoelSiegel;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Iterator;


public class Tiles extends JPanel {
    private boolean isPieceOn;
    private Piece piece;
    private ChessBoard ourTempBoard;
    private PieceColor tileColor;
    private int locationx;
    private int locationy;
    private int attackingx;
    private int attackingy;
    private boolean inattack;
    private BufferedImage image;
    private Color color;
    private String fileName;
    Border blackline = BorderFactory.createLineBorder(Color.black, 5);

    public Tiles(PieceColor tileColor, Color mycolor, ChessBoard temp, int locationx, int locationy) {
        this.locationx=locationx;
        this.locationy=locationy;
        ourTempBoard = temp;
        this.isPieceOn = false;
        this.piece = null;
        this.tileColor = tileColor;
        this.color = mycolor;
        setBackground(color);
        setBorder(blackline);
        addMouseListener(new mousy());
    }

    public void setAttackingx(int x) {
        attackingx = x;

    }

    public void setAttackingy(int y) {
        attackingy = y;
    }

    public boolean isInattack() {
        return inattack;
    }

    public void setInattack(boolean inattack) {
        this.inattack = inattack;
    }

    public void setPiece(Piece piece, PieceType pieceType, PieceColor pieceColor, String theString) throws IOException {
        this.piece = piece;
        fileName=theString;
        setPieceOn(true);
        this.piece.setType(pieceType);
        this.piece.setPieceColor(pieceColor);
        setBackground(color);
        try {
            BufferedImage tempimage = ImageIO.read(new File(theString));
            BufferedImage tempImage2 = resize(tempimage, 50, 50);
            image = tempImage2;
            piece.image = image;
        } catch (IOException ex) {
        }
        repaint();
    }

    public void setTheBackground(Color temp) {
        setBackground(temp);
        repaint();
    }

    public static BufferedImage resize(BufferedImage img, int newW, int newH) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return dimg;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 50, 35, null); // see javadoc for more info on the parameters
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


        public void setPiece(Piece piece) {
            this.piece = piece;
        }

        public PieceColor getTileColor() {
            return tileColor;
        }

        public void setTileColor(PieceColor tileColor) {
            this.tileColor = tileColor;
        }
/*
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
    class mousy extends MouseAdapter {
        private Color background;
        private Color backbound;


        @Override
        public void mousePressed(MouseEvent e) {
            background = getBackground();
            if (background == Color.green) {
                //we are gonna move the piece
                if (inattack) {
                    attack(ourTempBoard);
                } else {
                    movepiece(ourTempBoard);
                }
                //then we check if there is a check
                //if there is we move it back and send a alert that there is a check
                // after every turn we check to see if the other guy is in check and make a alert that there is a check
                //we also need a turn function number
            } else {
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        if (ourTempBoard.getChessboard()[i][j].getBackground() == Color.green) {
                            ourTempBoard.getChessboard()[i][j].setBackground(ourTempBoard.getChessboard()[i][j].color);
                        }
                    }
                }
            }

            if (piece == null) {
                System.out.println("mis");
                System.out.println("mis"+getX()+""+getY());
            } else {
                System.out.println("hit"+getPiece().getX()+""+getPiece().getY());
                System.out.println("hit"+getX()+""+getY());
                getPiece().getLegalMoves(ourTempBoard);
            }
            repaint();

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            setBackground(background);
            repaint();

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            backbound = getBackground();
            setBackground(backbound);
            repaint();
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setBackground(backbound);
            repaint();
        }
    }

    public void movepiece(ChessBoard temp)  {
        Tiles attacker=temp.getChessboard()[attackingx][attackingy];
        piece=attacker.piece;
        image=attacker.image;
        inattack=false;
        isPieceOn=true;
        tileColor=attacker.tileColor;
        fileName=attacker.fileName;
        ourTempBoard=attacker.ourTempBoard;
        getPiece().setX(getLocationx());
        getPiece().setY(getLocationy());
        attacker.setPiece(null);
        attacker.fileName=null;
        attacker.image=null;
        attacker.isPieceOn=false;
        attacker.setTheBackground(attacker.color);
        repaint();
        attacker.repaint();
        System.out.println(""+getX()+""+getY());
    }

    public void attack(ChessBoard temp) {

    }

    public int getLocationx() {
        return locationx;
    }

    public void setLocationx(int locationx) {
        this.locationx = locationx;
    }

    public int getLocationy() {
        return locationy;
    }

    public void setLocationy(int locationy) {
        this.locationy = locationy;
    }
}






