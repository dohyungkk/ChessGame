package ca.bcit.comp2526.a2a;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Movement.
 *
 * @author Kevin Dohyung Kim
 * @version 2018
 */
public class Movement implements ActionListener {

    /**
     * Moves pieces.
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     * @param e movement of pieces.
     */
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        Tile action = (Tile) e.getSource();   
        if (action.getPiece() != null) {
            Tile.data = (Tile) action;
        } else {
            if (Tile.data != null) {
                Tile.data.setIcon(null);
                action.setIcon(Tile.data.getPiece().getIcon());
                action.move(Tile.data.getPiece());
                Tile.data.remove();
                Tile.data = null;
            }
        } 
    }
}
