package ca.bcit.comp2526.a2a;

import javax.swing.JButton;


/**
 * Tile.
 *
 * @author Kevin Dohyung Kim
 * @version 2018
 */
public class Tile extends JButton implements java.io.Serializable {

    /**
     * Declares a static final serialVersionUID field of type long.
     */
    private static final long serialVersionUID = 1L;
   
    /**
     * Defines X coordinate.
     */
    private final int XCoord;
    
    /**
     * Defines Y coordinate.
     */
    private final int YCoord;
    
    /**
     * Calls piece from Piece.
     */
    protected Piece piece;
    
//    public static Tile data;
    
    /**
     * Constructs an object of type Tile.
     * @param x x-coordinates.
     * @param y y-coordinates.
     */
    public Tile(int x, int y) {
        piece = null;
        this.XCoord = x;
        this.YCoord = y;
    }
    
    /**
     * Sets the piece as color red to start with.
     * @param red red icon.
     */
    public void setPiece (Piece red) {
        piece = red;
        this.setIcon(red.getIcon());
    }
    
    /**
     * Empty the piece in the tile by making it as null.
     */
    public void clearPiece() {
        piece = null;
        this.setIcon(null);
    }
    
    /**
     * Gets pieces that is currently on the tile.
     * @return pieces piece the tile has; null if it's empty.
     */
    public Piece getPiece() {
        return piece;
    }
    
    /**
     * Checks if the tile is empty or not.
     * @return true if the tile is empty.
     */
    public boolean isEmpty() {
        if (this.getPiece() == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Moves pieces.
     * @param piece move pieces.
     */
    public void move(Piece piece) {
        this.piece = piece;
    }
    
    /**
     * Removes pieces.
     */
    public void remove() {
        this.piece = null;
    }

    public int getXCoord() {
        return XCoord;
    }

    public int getYCoord() {
        return YCoord;
    }
}
