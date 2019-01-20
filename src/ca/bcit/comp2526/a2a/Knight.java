package ca.bcit.comp2526.a2a;

import javax.swing.*;

/**
 * Knight.
 *
 * @author Kevin Dohyung Kim
 * @version 2018
 */
public class Knight extends Piece implements java.io.Serializable {

    /**
     * Declares a static final serialVersionUID field of type long.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructs an object of type Knight.
     * @param player1 icon of knight.
     */
    public Knight(int red) {
        super(red);
        if (red == 1)
            icon = new ImageIcon("src/ca/bcit/comp2526/a2a/images/wH.png");
        else
            icon = new ImageIcon("src/ca/bcit/comp2526/a2a/images/bH.png");
    }

    /**
     * Checks if the movement of Knight is valid or not.
     * @see ca.bcit.comp2526.a2a.Piece#isValidMove(int, int, int, int, ca.bcit.comp2526.a2a.Tile[][])
     * @param x initial x position of the piece.
     * @param y initial y position of the piece.
     * @param getX the x position of the piece after movement.
     * @param getY the y position of the piece after movement.
     * @param tiles tiles where pieces are moved to.
     * @return true if the movement is valid for the piece.
     */
    public boolean isValidMove(int x, int y, int getX, int getY, final Tile[][] tiles) {
        if ((getX == x + 2 && getY == y + 1) || (getX == x + 2 && getY == y - 1) || (getX == x - 2 && getY == y + 1)
                || (getX == x - 2 && getY == y - 1) || (getX == x + 1 && getY == y + 2)
                || (getX == x + 1 && getY == y - 2) || (getX == x - 1 && getY == y + 2)
                || (getX == x - 1 && getY == y - 2)) {
            return true;
        } else {
            return false;
        }
    }
}
