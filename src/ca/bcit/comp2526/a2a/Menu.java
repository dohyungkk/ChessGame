package ca.bcit.comp2526.a2a;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Game.
 *
 * @author Kevin Dohyung Kim
 * @version 2018
 */
public class Menu extends JFrame implements Serializable{
   
    /**
     * Declares a static final serialVersionUID field of type long.
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Calls board from Board.
     */
    private Board board;
    
    /**
     * Declares menu of JMenuBar.
     */
    private JMenuBar menu;
    
    /**
     * Declares newMenu from JMenuItem.
     */
    private JMenuItem newMenu;
    
    /**
     * Declares saveMenu from JMenuItem.
     */
    private JMenuItem saveMenu;
    
    /**
     * Declares loadMenu from JMenuItem.
     */
    private JMenuItem loadMenu;
    
    /**
     * Declares menuHandler from MenuHandler.
     */
    private MenuHandler menuHandler;

    /**
     * Constructs an object of type Menu.
     * @param chess Window frame.
     */
    public Menu(String chess) {
        super(chess);

        menuHandler = new MenuHandler();

        openMenu();

        this.pack();
        this.setSize(800, 850);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        board = new Board();
        this.add(board);
        board.startPosition();
        board.startPiece();
    }

    /**
     * Creates the menu.
     */
    private final void openMenu() {
        menu = new JMenuBar();
        menu.setSize(new Dimension(800, 50));

        JMenu menuBar = new JMenu("File");
        menuBar.setMnemonic(KeyEvent.VK_F);
        menu.add(menuBar);

        newMenu = new JMenuItem("New", KeyEvent.VK_N);
        newMenu.addActionListener(menuHandler);
        menuBar.add(newMenu);

        saveMenu = new JMenuItem("Save", KeyEvent.VK_S);
        saveMenu.addActionListener(menuHandler);
        menuBar.add(saveMenu);

        loadMenu = new JMenuItem("Load", KeyEvent.VK_L);
        loadMenu.addActionListener(menuHandler);
        menuBar.add(loadMenu);

        this.setJMenuBar(menu);
    }
    
    /**
     * Creates the save function.
     */
    public final void save() {
        try {
            FileOutputStream fileOut = new FileOutputStream("save/save.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(board);
            out.close();
            fileOut.close();
            System.out.printf("The game is saved in save/save.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    /**
     * Creates the load function.
     */
    public final void load() {
        this.remove(board);
        board = null;
        try {
            FileInputStream fileIn = new FileInputStream("save/save.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            board = (Board) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("The game is not found.");
            c.printStackTrace();
            return;
        }
        
        this.add(board);
        this.repaint();
    }

    /**
     * Creates MenuHandler.
     *
     * @author Kevin Dohyung Kim
     * @version 2018
     */
    public class MenuHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if ("New".equals(e.getActionCommand())) {
                board.clearBoard();
                board.startPosition();
                board.startPiece();
            }

            if ("Save".equals(e.getActionCommand())) {
                save();
            }

            if ("Load".equals(e.getActionCommand())) {
                load();
            }
        }
    }

    /**
     * Drives the program.
     * 
     * @param args unused
     */
    public static void main(String[] args) {
        JFrame frame = new Menu("Kevin Kim's Chess");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
