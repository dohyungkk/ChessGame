package ca.bcit.comp2526.a2a;

import javax.swing.*;

/**
 * Queen.
 *
 * @author Kevin Dohyung Kim
 * @version 2018
 */
public class Queen extends Piece implements java.io.Serializable {
    
    /**
     * Declares a static final serialVersionUID field of type long.
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Constructs an object of type Queen.
     * @param player1 image of queen.
     */
    public Queen(int red) {
        super(red);
        if (red == 1) 
            icon = new ImageIcon("src/ca/bcit/comp2526/a2a/images/wQ.png");
        else 
            icon = new ImageIcon("src/ca/bcit/comp2526/a2a/images/bQ.png");
    }

    /**
     * Checks if the movement of Queen is valid or not.
     * @see ca.bcit.comp2526.a2a.Piece#isValidMove(int, int, int, int, ca.bcit.comp2526.a2a.Tile[][])
     * @param x initial x position of the piece.
     * @param y initial y position of the piece.
     * @param getX the x position of the piece after movement.
     * @param getY the y position of the piece after movement.
     * @param tiles tiles where pieces are moved to.
     * @return true if the movement is valid for the piece.
     */
    public boolean isValidMove(int x, int y, int getX, int getY, final Tile[][] tiles) {
        return (diagonal(x, y, getX, getY, tiles) || straight(x, y, getX, getY, tiles));
    }

    /**
     * Checks if diagonal movement is valid for Queen.
     * @param x initial x position of the piece.
     * @param y initial y position of the piece.
     * @param getX the x position of the piece after movement.
     * @param getY the y position of the piece after movement.
     * @param tiles tiles where pieces are moved to.
     * @return true if the movement is valid for the piece.
     */
    private boolean diagonal(int x, int y, int getX, int getY, final Tile[][] tiles) {
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

    /**
     * Checks if straight movement is valid for Queen.
     * @param x initial x position of the piece.
     * @param y initial y position of the piece.
     * @param getX the x position of the piece after movement.
     * @param getY the y position of the piece after movement.
     * @param tiles tiles where pieces are moved to.
     * @return true if the movement is valid for the piece.
     */
    private boolean straight(int x, int y, int getX, int getY, final Tile[][] tiles) {
        if (!(getX != x && getY != y)) {
            if (getY < y) {
                for (int i = x, j = y - 1; j > getY; j--) {
                    // System.out.println(i + "," + j);
                    if (!tiles[j][i].isEmpty())
                        return false;
                }
            }
            if (getX > x) {
                for (int i = x + 1, j = y; i < getX; i++) {
                    if (!tiles[j][i].isEmpty())
                        return false;
                }
            }
            if (getY > y) {
                for (int i = x, j = y + 1; j < getY; j++) {
                    if (!tiles[j][i].isEmpty())
                        return false;
                }
            }
            if (getX < x) {
                for (int i = x - 1, j = y; i > getX; i--) {
                    if (!tiles[j][i].isEmpty())
                        return false;
                }
            }
            return true;
        }
        return false;
    }
}
