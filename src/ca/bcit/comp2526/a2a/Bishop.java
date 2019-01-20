package ca.bcit.comp2526.a2a;

import javax.swing.*;

/**
 * Bishop.
 *
 * @author Kevin Dohyung Kim
 * @version 2018
 */
public class Bishop extends Piece implements java.io.Serializable {

    /**
     * Declares a static final serialVersionUID field of type long.
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Constructs an object of type Bishop.
     * @param player1 image of bishop.
     */
    public Bishop(int red) {
        super(red);
        if (red == 1)
            icon = new ImageIcon("src/ca/bcit/comp2526/a2a/images/wB.png");
        else
            icon = new ImageIcon("src/ca/bcit/comp2526/a2a/images/bB.png");
    }
    
    /**
     * Checks if the movement of Bishop is valid or not.
     * @see ca.bcit.comp2526.a2a.Piece#isValidMove(int, int, int, int, ca.bcit.comp2526.a2a.Tile[][])
     * @param x initial x position of the piece.
     * @param y initial y position of the piece.
     * @param getX the x position of the piece after movement.
     * @param getY the y position of the piece after movement.
     * @param tiles tiles where pieces are moved to.
     * @return true if the movement is valid for the piece.
     */
    public boolean isValidMove(int x, int y, int getX, int getY, final Tile[][] tiles) {
        if (Math.abs(getX - x) == Math.abs(getY - y)) {
            if (getX > x && getY < y) {
                for (int i = x + 1, j = y - 1; i < getX; i++, j--) {
                    if (!tiles[i][j].isEmpty()) {
                        return false;
                    }
                }
            }
            if (getX < x && getY < y) {
                for (int i = x - 1, j = y - 1; i > getX; i--, j--) {
                    if (!tiles[j][i].isEmpty()) {
                        return false;
                    }
                }
            }
            if (getX > x && getY > y) {
                for (int i = x + 1, j = y + 1; i < getX; i++, j++) {
                    if (!tiles[j][i].isEmpty()) {
                        return false;
                    }
                }
            }
            if (getX < x && getY > y) {
                for (int i = x - 1, j = y + 1; i >= getX; i--, j++) {
                    if (!tiles[j][i].isEmpty()) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
}
