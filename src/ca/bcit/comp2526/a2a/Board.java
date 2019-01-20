package ca.bcit.comp2526.a2a;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.JPanel;
import java.awt.Point;

/**
 * Board that extends JPanel to create tiles and controls pieces.
 *
 * @author Kevin Dohyung Kim
 * @version 2018
 */
public class Board extends JPanel implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    public Tile[][] tiles = new Tile[8][8];
    private Piece[][] piece;
    private int turn;
    private tileHandler tileListener;
    private Point point;
    private Point clickPoint;
    
    /**
     * Constructs an object of type Board.
     */
    public Board() {
        setLayout(new GridLayout(8,8));
        clickPoint = new Point(-1, -1);
        tileListener = new tileHandler();
        
        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                tiles[i][j] = new Tile(j, i); 
                tiles[i][j].addActionListener(tileListener);
                if((i+j)%2 !=0)
                    tiles[i][j].setBackground(Color.white);
                else
                    tiles[i][j].setBackground(Color.black);
                this.add(tiles[i][j]);
            }
        }
    }
    
    /**
     * Sets start position of pieces.
     */
    public final void startPosition() {
        piece = new Piece[2][6];
        piece[0][0] = new King(1);
        piece[0][1] = new Queen(1);
        piece[0][2] = new Bishop(1);
        piece[0][3] = new Knight(1);
        piece[0][4] = new Rook(1);
        piece[0][5] = new Pawn(1);
        
        piece[1][0] = new King(2);
        piece[1][1] = new Queen(2);
        piece[1][2] = new Bishop(2);
        piece[1][3] = new Knight(2);
        piece[1][4] = new Rook(2);
        piece[1][5] = new Pawn(2);
    }
    
    /**
     * Sets where each piece goes in each tile.
     */
    public final void startPiece() {
        
        turn = 1;
        
        //Red pieces
        tiles[0][0].setPiece(piece[1][4]);
        tiles[0][1].setPiece(piece[1][3]);
        tiles[0][2].setPiece(piece[1][2]);
        tiles[0][3].setPiece(piece[1][1]);
        tiles[0][4].setPiece(piece[1][0]);
        tiles[0][5].setPiece(piece[1][2]);
        tiles[0][6].setPiece(piece[1][3]);
        tiles[0][7].setPiece(piece[1][4]);
        for (int i = 0; i < 8; i++) {
            tiles[1][i].setPiece(piece[1][5]);
        }
        
        //Gold pieces
        tiles[7][0].setPiece(piece[0][4]);
        tiles[7][1].setPiece(piece[0][3]);
        tiles[7][2].setPiece(piece[0][2]);
        tiles[7][3].setPiece(piece[0][1]);
        tiles[7][4].setPiece(piece[0][0]);
        tiles[7][5].setPiece(piece[0][2]);
        tiles[7][6].setPiece(piece[0][3]);
        tiles[7][7].setPiece(piece[0][4]);
        for (int i = 0; i < 8; i++) {
            tiles[6][i].setPiece(piece[0][5]);
        }
    }
    
    /**
     * Sets turn as 1 and piece as red.
     * @param red player1.
     * @param i x-coord of board.
     * @param j y-coord of board.
     */
    public void setPiece(Piece red, int i, int j) {
        turn = 1;
        tiles[j][i].setPiece(red);
    }
    
    /**
     * Clears tiles if there is a piece.
     */
    public final void clearBoard() {
        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 8; i++) {
                tiles[j][i].clearPiece();
            }
        }
    }
    
    /**
     * Gets tiles.
     * @return tiles.
     */
    public Tile[][] getTiles() {
        return tiles;
    }
    
    /**
     * Checks if a tile is clicked.
     * @param clickTile Tile is clicked.
     * @return position of pointed object.
     */
    private Point validClick(Object clickTile) {
        Point point = null;
        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 8; i++) {
                if (clickTile == tiles[j][i]) {
                    point = new Point(i, j);
                }
            }
        }
        return point;
    }
    
    /**
     * Checks if a tile is invalid.
     * @return true if invalid.
     */
    private final boolean isInvalid() {
        return ((clickPoint.x == -1 || clickPoint.y == -1));
    }
    
    /**
     * Checks if a tile is empty or not.
     * @return true is tile is not empty.
     */
    private final boolean hasPiece() {
        return (!(tiles[point.y][point.x].isEmpty()));
    }
    
    /**
     * Checks if piece is moving to a tile with same colour of piece on it.
     * @return true if piece is moving to a tile with same colour of piece.
     */
    private final boolean isSame() {
        return (tiles[point.y][point.x].getPiece().getPlayer() == 
                tiles[clickPoint.y][clickPoint.x].getPiece().getPlayer());
    }
    
    public Piece getP(int row, int col) {
        return tiles[row][col].getPiece();
    }
    
    /**
     * Checks whose turn it is.
     * @param yes If turn is correct.
     * @return true If it's right turn.
     */
    private final boolean Turn(boolean yes) {
        if (yes) {
            return (tiles[point.y][point.x].piece.getPlayer() == turn);
        }
        return true;
    }
    
    /**
     * Switches the turn between two players.
     * @param yes Change turn when one player makes a move.
     */
    private final void switchTurn(boolean yes) {
        if (yes && turn == 1) {
            turn = 2;
        } else {
            turn = 1;
        }
    }
    
    /**
     * Clicks a tile.
     */
    private final void clicked() {
        clickPoint = point;
        tiles[point.y][point.x].setEnabled(false);
    }
    
    /**
     * Moves the piece to different tile.
     */
    private final void move() {
        tiles[point.y][point.x].setPiece(tiles[clickPoint.y][clickPoint.x].getPiece());
        tiles[clickPoint.y][clickPoint.x].clearPiece();
    }
    
    /**
     * Unclicks the clicked tile.
     */
    private final void unclicked() {
        tiles[clickPoint.y][clickPoint.x].setEnabled(true);
        clickPoint.x = -1;
        clickPoint.y = -1;
    }
    
    /**
     * Checks if tile has piece and whose piece it is on a tile, and if move is valid.
     * @return true if move is valid.
     */
    private boolean ValidMove() {
        if (hasPiece() && isSame()) {
            return false;
        } else {
            
            return tiles[clickPoint.y][clickPoint.x].piece.isValidMove(clickPoint.x, clickPoint.y, point.x, point.y, tiles);
        }
    }

    /**
     * tileHandler that responds to the actions on the board.
     *
     * @author Kevin Dohyung Kim
     * @version 2018
     */
    public class tileHandler implements ActionListener, Serializable {
       
        /**
         * Declares a static final serialVersionUID field of type long.
         */
        private static final long serialVersionUID = 1L;

        /**
         * Performs actions.
         * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
         * @param e movents of pieces.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            point = validClick(e.getSource());
            if (isInvalid()) {
                if (hasPiece()) {
                    if (Turn(true)) {
                        clicked();
                    }
                }
            } else {
                if (ValidMove()) {
                    if (!hasPiece() || !isSame()) {
                        move();
                        switchTurn(true);
                    }
                }
                unclicked();
            }
        }
    }
}
