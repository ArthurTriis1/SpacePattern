package models;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author arthur
 */
public class GameArea extends JPanel implements ActionListener{
    
    private Nav nav;
    private Timer timer;
    
    public GameArea(){
        setFocusable(true);
        
        nav = new Nav();
        
        addKeyListener(new KeyboardAdapter());
        
        timer = new Timer(1, this);
        timer.start();
        
    }
    
    @Override
    public void paint(Graphics g){
        Graphics2D graphs = (Graphics2D) g;
        graphs.setColor(new Color(25, 25, 112));
        graphs.fillRect(0, 0, 500, 500);    
        
        nav.render(graphs);
        
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        nav.update();    
        repaint();
    }
    
    private class KeyboardAdapter extends KeyAdapter {
        
        @Override
        public void keyPressed(KeyEvent e){
            nav.keyPressed((e));
        }
        
        @Override
        public void keyReleased(KeyEvent e){

            nav.keyRelease(e);
        }
    }

}
