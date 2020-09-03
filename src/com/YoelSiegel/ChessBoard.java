package com.YoelSiegel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChessBoard extends JFrame {
    public static JPanel gamePanel=new JPanel();
    private Tiles[][] chessboard=new Tiles[8][8];
    //makes array of our kings
    public Piece[] arrofKings=new Piece[2];
    public boolean turn=true;
    public boolean change=false;
    //makes array of all our pieces
    public java.util.List<Piece> blackList=new ArrayList<>();
    public List<Piece> whiteList=new ArrayList<>();
    public ChessBoard() {
        this.setLayout(new BorderLayout());
        this.setSize(1200, 1000);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gamePanel.setPreferredSize(new Dimension(800, 1000));
        gamePanel.setLayout(new GridLayout(8, 8));
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(((i+j)%2)==0){
                    chessboard[i][j]=new Tiles(PieceColor.WHITE ,Color.lightGray, this, i, j);
                }
                else{
                    chessboard[i][j]=new Tiles(PieceColor.BLACK ,Color.DARK_GRAY, this, i, j);
                }
                gamePanel.add(chessboard[i][j]);

            }
        }

        this.add(gamePanel);
        this.setVisible(true);
    }

    /*public static JPanel getGamePanel() {
        return gamePanel;
    }

    public static void setGamePanel(JPanel gamePanel) {
        ChessBoard.gamePanel = gamePanel;
    }
*/
    public Tiles[][] getChessboard() {
        return chessboard;
    }
    public Tiles gettile(int i, int j) {
        return getChessboard()[i][j];
    }

    public void makeBoard() throws IOException {
      /*  Pawn bptemp0 = new Pawn(PieceColor.BLACK, 1, 0);
        getChessboard()[1][0].setPiece(bptemp0, PieceType.PAWN, PieceColor.BLACK, "src/com/YoelSiegel/Images/black_pawn.png");
        Pawn bptemp1 = new Pawn(PieceColor.BLACK, 1, 1);
        getChessboard()[1][1].setPiece(bptemp1, PieceType.PAWN, PieceColor.BLACK, "src/com/YoelSiegel/Images/black_pawn.png");
        Pawn bptemp2 = new Pawn(PieceColor.BLACK, 1, 2);
        getChessboard()[1][2].setPiece(bptemp2, PieceType.PAWN, PieceColor.BLACK, "src/com/YoelSiegel/Images/black_pawn.png");
        Pawn bptemp3 = new Pawn(PieceColor.BLACK, 1, 3);
        getChessboard()[1][3].setPiece(bptemp3, PieceType.PAWN, PieceColor.BLACK, "src/com/YoelSiegel/Images/black_pawn.png");
        Pawn bptemp4 = new Pawn(PieceColor.BLACK, 1, 4);
        getChessboard()[1][4].setPiece(bptemp4, PieceType.PAWN, PieceColor.BLACK, "src/com/YoelSiegel/Images/black_pawn.png");
        Pawn bptemp5 = new Pawn(PieceColor.BLACK, 1, 5);
        getChessboard()[1][5].setPiece(bptemp5, PieceType.PAWN, PieceColor.BLACK, "src/com/YoelSiegel/Images/black_pawn.png");
        Pawn bptemp6 = new Pawn(PieceColor.BLACK, 1, 6);
        getChessboard()[1][6].setPiece(bptemp6, PieceType.PAWN, PieceColor.BLACK, "src/com/YoelSiegel/Images/black_pawn.png");
        Pawn bptemp7 = new Pawn(PieceColor.BLACK, 1, 7);
        getChessboard()[1][7].setPiece(bptemp7, PieceType.PAWN, PieceColor.BLACK, "src/com/YoelSiegel/Images/black_pawn.png");
        Pawn wptemp0 = new Pawn(PieceColor.WHITE, 6, 0);
        getChessboard()[6][0].setPiece(wptemp0, PieceType.PAWN, PieceColor.WHITE, "src/com/YoelSiegel/Images/white_pawn.png");
        Pawn wptemp1 = new Pawn(PieceColor.WHITE, 6, 1);
        getChessboard()[6][1].setPiece(wptemp1, PieceType.PAWN, PieceColor.WHITE, "src/com/YoelSiegel/Images/white_pawn.png");
        Pawn wptemp2 = new Pawn(PieceColor.WHITE, 6, 2);
        getChessboard()[6][2].setPiece(wptemp2, PieceType.PAWN, PieceColor.WHITE, "src/com/YoelSiegel/Images/white_pawn.png");
        Pawn wptemp3 = new Pawn(PieceColor.WHITE, 6, 3);
        getChessboard()[6][3].setPiece(wptemp3, PieceType.PAWN, PieceColor.WHITE, "src/com/YoelSiegel/Images/white_pawn.png");
        Pawn wptemp4 = new Pawn(PieceColor.WHITE, 6, 4);
        getChessboard()[6][4].setPiece(wptemp4, PieceType.PAWN, PieceColor.WHITE, "src/com/YoelSiegel/Images/white_pawn.png");
        Pawn wptemp5 = new Pawn(PieceColor.WHITE, 6, 5);
        getChessboard()[6][5].setPiece(wptemp5, PieceType.PAWN, PieceColor.WHITE, "src/com/YoelSiegel/Images/white_pawn.png");
        Pawn wptemp6 = new Pawn(PieceColor.WHITE, 6, 6);
        getChessboard()[6][6].setPiece(wptemp6, PieceType.PAWN, PieceColor.WHITE, "src/com/YoelSiegel/Images/white_pawn.png");
       */ Pawn wptemp7 = new Pawn(PieceColor.WHITE, 6, 7);
        getChessboard()[6][7].setPiece(wptemp7, PieceType.PAWN, PieceColor.WHITE, "src/com/YoelSiegel/Images/white_pawn.png");
        Bishop bbtemp0 = new Bishop(PieceColor.BLACK, 0, 2);
        getChessboard()[0][2].setPiece(bbtemp0, PieceType.BISHOP, PieceColor.BLACK,"src/com/YoelSiegel/Images/black_bishop.png");
        Bishop bbtemp1 = new Bishop(PieceColor.BLACK, 0, 5);
        getChessboard()[0][5].setPiece(bbtemp1, PieceType.BISHOP, PieceColor.BLACK, "src/com/YoelSiegel/Images/black_bishop.png");
        Bishop wbtemp0 = new Bishop(PieceColor.WHITE, 7, 2);
        getChessboard()[7][2].setPiece(wbtemp0, PieceType.BISHOP, PieceColor.WHITE, "src/com/YoelSiegel/Images/white_bishop.png");
        Bishop wbtemp1 = new Bishop(PieceColor.WHITE, 7, 5);
        getChessboard()[7][5].setPiece(wbtemp1, PieceType.BISHOP, PieceColor.WHITE,"src/com/YoelSiegel/Images/white_bishop.png");
        Rook bctemp0 = new Rook(PieceColor.BLACK, 0, 0);
        getChessboard()[0][0].setPiece(bctemp0, PieceType.ROOK, PieceColor.BLACK, "src/com/YoelSiegel/Images/black_rook.png");
        Rook bctemp1 = new Rook(PieceColor.BLACK, 0, 7);
        getChessboard()[0][7].setPiece(bctemp1, PieceType.ROOK, PieceColor.BLACK, "src/com/YoelSiegel/Images/black_rook.png");
        Rook wctemp0 = new Rook(PieceColor.WHITE, 7, 0);
        getChessboard()[7][0].setPiece(wctemp0, PieceType.ROOK, PieceColor.WHITE, "src/com/YoelSiegel/Images/white_rook.png");
        Rook wctemp1 = new Rook(PieceColor.WHITE, 7, 7);
        getChessboard()[7][7].setPiece(wctemp1, PieceType.ROOK, PieceColor.WHITE, "src/com/YoelSiegel/Images/white_rook.png");
        Knight bktemp0 = new Knight(PieceColor.BLACK, 0, 1);
        getChessboard()[0][1].setPiece(bktemp0, PieceType.KNIGHT, PieceColor.BLACK, "src/com/YoelSiegel/Images/black_knight.png");
        Knight bktemp1 = new Knight(PieceColor.BLACK, 0, 6);
        getChessboard()[0][6].setPiece(bktemp1, PieceType.KNIGHT, PieceColor.BLACK, "src/com/YoelSiegel/Images/black_knight.png");
        Knight wktemp0 = new Knight(PieceColor.WHITE, 7, 1);
        getChessboard()[7][1].setPiece(wktemp0, PieceType.KNIGHT, PieceColor.WHITE, "src/com/YoelSiegel/Images/white_knight.png");
        Knight wktemp1 = new Knight(PieceColor.WHITE, 7, 6);
        getChessboard()[7][6].setPiece(wktemp1, PieceType.KNIGHT, PieceColor.WHITE, "src/com/YoelSiegel/Images/white_knight.png");
        Queen bqtemp = new Queen(PieceColor.BLACK, 0, 3);
        getChessboard()[0][3].setPiece(bqtemp, PieceType.QUEEN, PieceColor.BLACK, "src/com/YoelSiegel/Images/black_queen.png");
        Queen wqtemp = new Queen(PieceColor.WHITE, 7, 3);
        getChessboard()[7][3].setPiece(wqtemp, PieceType.QUEEN, PieceColor.WHITE, "src/com/YoelSiegel/Images/white_queen.png");
        King bKtemp = new King(PieceColor.BLACK, 0, 4);
        getChessboard()[0][4].setPiece(bKtemp, PieceType.KING, PieceColor.BLACK, "src/com/YoelSiegel/Images/black_king.png");
        arrofKings[0]=getChessboard()[0][4].getPiece();
        King wKtemp = new King(PieceColor.WHITE, 7, 4);
        getChessboard()[7][4].setPiece(wKtemp, PieceType.KING, PieceColor.WHITE, "src/com/YoelSiegel/Images/white_king.png");
        arrofKings[1]=getChessboard()[7][4].getPiece();
        whiteList.add(wKtemp);
        whiteList.add(wqtemp);
        whiteList.add(wbtemp0);
        whiteList.add(wbtemp1);
        whiteList.add(wctemp0);
        whiteList.add(wctemp1);
        whiteList.add(wktemp0);
        whiteList.add(wktemp1);
      /*  whiteList.add(wptemp0);
        whiteList.add(wptemp1);
        whiteList.add(wptemp2);
        whiteList.add(wptemp3);
        whiteList.add(wptemp4);
        whiteList.add(wptemp5);
        whiteList.add(wptemp6);
        whiteList.add(wptemp7);
*/
        blackList.add(bKtemp);
        blackList.add(bqtemp);
        blackList.add(bbtemp0);
        blackList.add(bbtemp1);
        blackList.add(bctemp0);
        blackList.add(bctemp1);
        blackList.add(bktemp0);
        blackList.add(bktemp1);/*
        blackList.add(bptemp0);
        blackList.add(bptemp1);
        blackList.add(bptemp2);
        blackList.add(bptemp3);
        blackList.add(bptemp4);
        blackList.add(bptemp5);
        blackList.add(bptemp6);
        blackList.add(bptemp7);*/
    }
}
