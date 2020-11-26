package spacepattern;

import javax.swing.JFrame;
import models.GameArea;

/**
 *
 * @author arthur
 */
public class SpacePattern extends JFrame{
    
    public SpacePattern(){
        add(new GameArea());
        setTitle("SpacePatters !!!");
        setSize(500, 500);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new SpacePattern();
    }
}
