package ca.bcit.comp2526.a2a;

import javax.swing.Icon;
import ca.bcit.comp2526.a2a.Tile;

/**
 * Piece.
 *
 * @author Kevin Dohyung Kim
 * @version 2018
 */
public abstract class Piece implements java.io.Serializable {

    /**
     * Declares a static final serialVersionUID field of type long.
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Sets Icon as icon.
     */
    protected Icon icon = null;
    
    /**
     * Sets player1 as one of two players of the piece.
     */
    protected final int player1;
    
    /**
     * Returns the icon image for different pieces.
     * @return the image of icon.
     */
    public Icon getIcon() {
        return icon;   
    }
    
    /**
     * 
     * Constructs an object of type Piece.
     * @param red player 1 as red.
     */
    public Piece (int red) {
        player1 = red;
    }
   
    /**
     * Returns the player of the piece.
     * @return player1 of the game.
     */
    public int getPlayer() {
        return player1;
    }

    /**
     * Checks if the movement of piece is valid or not.
     * @param x initial x position of the piece.
     * @param y initial y position of the piece.
     * @param getX the x position of the piece after movement.
     * @param getY the y position of the piece after movement.
     * @param tiles tiles where pieces are moved to.
     * @return true if the movement is valid for the piece.
     */
    public boolean isValidMove(int x, int y, int getX, int getY, final Tile[][] tiles) {
     // TODO Auto-generated method stub
        return false;
    }

    /**
     * Checks if the movement of piece is valid or not.
     * @param x initial x position of the piece.
     * @param y initial y position of the piece.
     * @param getX the x position of the piece after movement.
     * @param getY the y position of the piece after movement.
     * @return true if the movement is valid for the piece.
     */
    public boolean isValidMove(int x, int y, int getX, int getY) {
        // TODO Auto-generated method stub
        return false;
    }
}
