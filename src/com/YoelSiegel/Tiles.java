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
    private boolean justmoved;
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
            if(isPieceOn()&&backbound!=Color.GREEN) {
                if (ourTempBoard.turn) {
                    if (getPiece().getPieceColor() == PieceColor.WHITE) {
                        ourTempBoard.change=true;
                    } else {
                        return;
                    }
                }
                else if (!ourTempBoard.turn) {
                    if (getPiece().getPieceColor() == PieceColor.BLACK) {
                        ourTempBoard.change=true;
                    } else {
                        return;
                    }
                }
            }

            background = getBackground();
            System.out.println(justmoved);
            if (background == Color.green) {
                //we are gonna move the piece
                int tempx=attackingx;
                int tempy=attackingy;
                Tiles tempattackingtile=ourTempBoard.getChessboard()[attackingx][attackingy];
                Piece tempattackingpiece=tempattackingtile.getPiece();
                Tiles ourtile=ourTempBoard.gettile(getLocationx(),getLocationy());
                Piece ourpiece=getPiece();
                if (inattack) {
                    attack(ourTempBoard);
                    setTheBackground(color);
                    if(ourTempBoard.change){
                        ourTempBoard.turn=!ourTempBoard.turn;
                        ourTempBoard.change=false;
                    }
                } else {
                    movepiece(ourTempBoard);
                    setTheBackground(color);
                    if(ourTempBoard.change){
                        ourTempBoard.turn=!ourTempBoard.turn;
                        ourTempBoard.change=false;
                    }
                }
                updateboard();

                if(isthereacheck()) {
/*                    System.out.println("in here");
                    ourTempBoard.getChessboard()[getLocationx()][getLocationy()].attackingx=ourtile.getX();
                    Tiles attacker=ourtile;
                    piece=attacker.piece;
                    image=attacker.image;
                    inattack=false;
                    isPieceOn=true;
                    tileColor=attacker.tileColor;
                    fileName=attacker.fileName;
                    setLocationx(attacker.getLocationx());
                    setLocationy(attacker.getLocationy());
                    ourTempBoard=attacker.ourTempBoard;
                    if(getPiece()!=null) {
                        getPiece().setX(getLocationx());
                        getPiece().setY(getLocationy());
                    }
*/                    ourTempBoard.getChessboard()[tempx][tempy].attackingx=getLocationx();
                    ourTempBoard.getChessboard()[tempx][tempy].attackingy=getLocationy();
                    ourTempBoard.getChessboard()[tempx][tempy].movepiece(ourTempBoard);
                    ourTempBoard.getChessboard()[tempx][tempy].repaint();



                    if (ourTempBoard.getChessboard()[tempx][tempy].getPiece().getPieceColor() == PieceColor.BLACK) {
                        ourTempBoard.blackList.add(ourpiece);
                    } else {
                        ourTempBoard.whiteList.add(ourpiece);
                    }
                    repaint();

                    updateboard();
                }}
                //if there is we move it back and send a alert that there is a check
                // after every turn we check to see if the other guy is in check and make a alert that there is a check
                //we also need a turn function number



         else {
                updateboard();
                if (piece == null) {
                } else {
                    getPiece().getLegalMoves(ourTempBoard);
                }
            }

            repaint();

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            setBackground(color);
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
            if(((getPiece()!=null)&&(!inattack))){
            setBackground(color);
            repaint();}
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
        updateboard();
        repaint();
        attacker.repaint();
        System.out.println(""+getX()+""+getY());
    }

    public void attack(ChessBoard temp) {
        Tiles attacker=temp.getChessboard()[attackingx][attackingy];
        if(getPiece().getPieceColor()==PieceColor.WHITE)
        {
            temp.blackList.remove(getPiece());
        }
        else{
            temp.whiteList.remove(getPiece());
        }
        image=null;
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
        updateboard();
        repaint();
        attacker.repaint();
        System.out.println(""+getX()+""+getY());
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
    public void updateboard(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (ourTempBoard.getChessboard()[i][j].getBackground() == Color.green) {
                    ourTempBoard.getChessboard()[i][j].setBackground(ourTempBoard.getChessboard()[i][j].color);

                }
            }
        }
    }
    public boolean isthereacheck(){
        //1 is white 0 is black
        if(getPiece().getPieceColor()==PieceColor.WHITE) {
            Tiles kingtile = ourTempBoard.getChessboard()[ourTempBoard.arrofKings[1].getX()][ourTempBoard.arrofKings[1].getY()];


            for (int i = 0; i <ourTempBoard.blackList.size();i++){
                //make code that checks if we are attacked
            }
        }


    else{
            Tiles kingtile=ourTempBoard.getChessboard()[ourTempBoard.arrofKings[1].getX()][ourTempBoard.arrofKings[1].getY()];
            for (int i = 0; i <ourTempBoard.blackList.size();i++){
                //make code that checks if we are attacked
            }
        }
        System.out.println("got here");
    return true;
    }
}






