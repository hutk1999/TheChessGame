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

    public String getFileName() {
        return fileName;
    }

    public Border getBlackline() {
        return blackline;
    }

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
        this.piece.setTheFilename(theString);
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
            if(piece!=null) {
            }

            background = getBackground();
            if (background == Color.green) {
                if(piece!=null) {
                    if(piece.isNevermoved()&&ourTempBoard.getChessboard()[attackingx][attackingy].getPiece().isNevermoved()) {
                        if (piece.getType() == PieceType.KING) {
                            if (ourTempBoard.getChessboard()[attackingx][attackingy].getPiece().getType() == PieceType.ROOK) {
                                if(isthereacheck()){
                                    return;
                                }
                                if (attackingy == 7) {
                                    if ( ourTempBoard.getChessboard()[attackingx][attackingy].getPiece() != null) {
                                        ourTempBoard.getChessboard()[attackingx][attackingy].getPiece().setNevermoved(false);
                                    }
                                    Tiles attacker = ourTempBoard.getChessboard()[attackingx][attackingy];
                                    Tiles tempTiles = ourTempBoard.getChessboard()[attackingx][attackingy - 2];
                                    tempTiles.setPiece(attacker.piece);
                                    tempTiles.image = attacker.image;
                                    tempTiles.inattack = false;
                                    tempTiles.isPieceOn = true;
                                    tempTiles.fileName = attacker.fileName;
                                    tempTiles.getPiece().setX(attackingx);
                                    tempTiles.getPiece().setY(attackingy - 2);
                                    attacker.setPiece(null);
                                    attacker.fileName = null;
                                    attacker.image = null;
                                    attacker.isPieceOn = false;
                                    attacker.setTheBackground(attacker.color);
                                    ourTempBoard.getChessboard()[attackingx][attackingy - 2] = tempTiles;
                                    Tiles tempTileKing = ourTempBoard.getChessboard()[attackingx][attackingy - 3];
                                    Tiles kingsLocation = ourTempBoard.getChessboard()[attackingx][attackingy - 1];
                                    kingsLocation.setPiece(tempTileKing.piece);
                                    kingsLocation.image = tempTileKing.image;
                                    kingsLocation.inattack = false;
                                    kingsLocation.isPieceOn = true;
                                    kingsLocation.fileName = tempTileKing.fileName;
                                    kingsLocation.getPiece().setX(attackingx);
                                    kingsLocation.getPiece().setY(attackingy - 1);
                                    tempTileKing.setPiece(null);
                                    tempTileKing.fileName = null;
                                    tempTileKing.image = null;
                                    tempTileKing.isPieceOn = false;
                                    tempTileKing.setTheBackground(attacker.color);
                                    updateboard();
                                    repaint();
                                    attacker.repaint();
                                    ourTempBoard.turn = !ourTempBoard.turn;
                                    ourTempBoard.change=false;
                                    return;
                                } else {
                                    if ( ourTempBoard.getChessboard()[attackingx][attackingy].getPiece() != null) {
                                        ourTempBoard.getChessboard()[attackingx][attackingy].getPiece().setNevermoved(false);
                                    }
                                    Tiles attacker = ourTempBoard.getChessboard()[attackingx][attackingy];
                                    Tiles tempTiles = ourTempBoard.getChessboard()[attackingx][attackingy + 2];
                                    tempTiles.setPiece(attacker.piece);
                                    tempTiles.image = attacker.image;
                                    tempTiles.inattack = false;
                                    tempTiles.isPieceOn = true;
                                    tempTiles.fileName = attacker.fileName;
                                    tempTiles.getPiece().setX(attackingx);
                                    tempTiles.getPiece().setY(attackingy + 2);
                                    attacker.setPiece(null);
                                    attacker.fileName = null;
                                    attacker.image = null;
                                    attacker.isPieceOn = false;
                                    attacker.setTheBackground(attacker.color);
                                    ourTempBoard.getChessboard()[attackingx][attackingy + 2] = tempTiles;
                                    Tiles tempTileKing = ourTempBoard.getChessboard()[attackingx][attackingy + 4];
                                    Tiles kingsLocation = ourTempBoard.getChessboard()[attackingx][attackingy + 1];
                                    kingsLocation.setPiece(tempTileKing.piece);
                                    kingsLocation.image = tempTileKing.image;
                                    kingsLocation.inattack = false;
                                    kingsLocation.isPieceOn = true;
                                    kingsLocation.fileName = tempTileKing.fileName;
                                    kingsLocation.getPiece().setX(attackingx);
                                    kingsLocation.getPiece().setY(attackingy + 1);
                                    tempTileKing.setPiece(null);
                                    tempTileKing.fileName = null;
                                    tempTileKing.image = null;
                                    tempTileKing.isPieceOn = false;
                                    tempTileKing.setTheBackground(attacker.color);
                                    updateboard();
                                    repaint();
                                    attacker.repaint();
                                    ourTempBoard.turn = !ourTempBoard.turn;
                                    ourTempBoard.change=false;
                                    return;
                                }
                            }
                        }
                    }
                }

                //we are gonna move the piece
                int tempx=attackingx;
                int tempy=attackingy;
                Tiles tempattackingtile=ourTempBoard.getChessboard()[attackingx][attackingy];
                Piece tempattackingpiece=tempattackingtile.getPiece();
                Tiles ourtile=ourTempBoard.gettile(getLocationx(),getLocationy());
                Piece ourpiece=getPiece();

                if (inattack) {
                    if( ourTempBoard.getChessboard()[attackingx][attackingy].getPiece()!=null) {
                        ourTempBoard.getChessboard()[attackingx][attackingy].getPiece().setNevermoved(false);                    }
                    attack(ourTempBoard);
                    setTheBackground(color);
                    if(ourTempBoard.change){
                        ourTempBoard.turn=!ourTempBoard.turn;
                        ourTempBoard.change=false;
                    }

                } else {
                    if( ourTempBoard.getChessboard()[attackingx][attackingy].getPiece()!=null) {
                        ourTempBoard.getChessboard()[attackingx][attackingy].getPiece().setNevermoved(false);                    }
                    movepiece(ourTempBoard);
                    setTheBackground(color);
                    if(ourTempBoard.change){
                        ourTempBoard.turn=!ourTempBoard.turn;
                        ourTempBoard.change=false;
                    }
                }
                updateboard();

                if(isthereacheck()) {
                ourTempBoard.turn=!ourTempBoard.turn;

                    if(getPiece()!=null) {
                        getPiece().setX(getLocationx());
                        getPiece().setY(getLocationy());

                        ourTempBoard.getChessboard()[tempx][tempy].attackingx = getLocationx();
                        ourTempBoard.getChessboard()[tempx][tempy].attackingy = getLocationy();
                        ourTempBoard.getChessboard()[tempx][tempy].movepiece(ourTempBoard);
                        ourTempBoard.getChessboard()[tempx][tempy].repaint();
                    }
                    if(ourpiece!=null) {
                        try {
                            System.out.println(ourpiece.getTheFilename());
                            ourTempBoard.getChessboard()[getLocationx()][getLocationy()].setPiece(ourpiece,ourpiece.getType(),ourpiece.getPieceColor(),ourpiece.getTheFilename());
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                    updateboard();
                    repaint();
                    if(ourpiece!=null) {
                        if (ourpiece.getPieceColor() == PieceColor.BLACK) {
                            ourTempBoard.blackList.add(ourpiece);
                        } else {
                            ourTempBoard.whiteList.add(ourpiece);
                        }
                    }

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
            for (int i = 0; i < ourTempBoard.blackList.size(); i++) {
                ourTempBoard.blackList.get(i).getLegalMoves(ourTempBoard);
                if (kingtile.getBackground() == Color.GREEN) {
                    updateboard();
                    repaint();
                    return true;
                }
                updateboard();
                repaint();
            }


        }


        else {
            Tiles kingtile = ourTempBoard.getChessboard()[ourTempBoard.arrofKings[0].getX()][ourTempBoard.arrofKings[0].getY()];

            for (int i = 0; i < ourTempBoard.whiteList.size(); i++) {
                ourTempBoard.whiteList.get(i).getLegalMoves(ourTempBoard);
                if (kingtile.getBackground() == Color.GREEN) {
                    updateboard();
                    repaint();
                    return true;
                }
                updateboard();
                repaint();
            }
        }
    return false ;
    }
}






