package ca.bcit.comp2526.a2a;

import javax.swing.*;

/**
 * Pawn.
 *
 * @author Kevin Dohyung Kim
 * @version 2018
 */
public class Pawn extends Piece implements java.io.Serializable {

    /**
     * Declares a static final serialVersionUID field of type long.
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Constructs an object of type Pawn.
     * @param player1 images of pawn.
     */
    public Pawn(int red) {
        super(red);
        if (red == 1) 
            icon = new ImageIcon("src/ca/bcit/comp2526/a2a/images/wP.png");
        else 
            icon = new ImageIcon("src/ca/bcit/comp2526/a2a/images/bP.png");
    }
    
    /**
     * Checks if the movement of Pawn is valid or not.
     * @see ca.bcit.comp2526.a2a.Piece#isValidMove(int, int, int, int, ca.bcit.comp2526.a2a.Tile[][])
     * @param x initial x position of the piece.
     * @param y initial y position of the piece.
     * @param getX the x position of the piece after movement.
     * @param getY the y position of the piece after movement.
     * @param tiles tiles where pieces are moved to.
     * @return true if the movement is valid for the piece.
     */
    public boolean isValidMove(int x, int y, int getX, int getY, final Tile[][] tiles) {
        if (player1 == 1) {
            if (y == 6) {
                if ((getX == x + 1 || getY == x - 1) && (getY == y - 2 || getY == y - 1)
                        && !tiles[getX][getY].isEmpty()) {
                    return true;
                }
                if (getX == x && getY == y - 2) {
                    return (tiles[getY][getX].isEmpty() && tiles[getY + 1][getX].isEmpty());
                }
                return (getX == x && getY == y - 1 && tiles[getY][getX].isEmpty());
            }

            if ((getX == x + 1 || getX == x - 1) && getY == y - 1 && !tiles[getY][getX].isEmpty()) {
                return true;
            }
            return (getX == x && getY == y - 1 && tiles[getY][getX].isEmpty());
        } else {
            if (y == 1) {
                if ((getX == x + 1 || getX == x - 1) && (getY == y + 2 || getY == y + 1)
                        && !tiles[getX][getY].isEmpty()) {
                    return true;
                }
                if (getX == x && getY == y + 2) {
                    return (tiles[getY][getX].isEmpty() && tiles[getY - 1][getX].isEmpty());
                }
                return (getX == x && getY == y + 1 && tiles[getY][getX].isEmpty());
            }
            if ((getX == x + 1 || getX == x - 1) && (getY == y + 1) && !tiles[getY][getX].isEmpty()) {
                return true;
            }
            return (getX == x && getY == y + 1 && tiles[getY][getX].isEmpty());
        }
    }
}
