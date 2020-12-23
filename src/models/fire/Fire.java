package models.fire;

import interfaces.FireInterface;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import models.Nav;

/**
 * Clase base para implementação do STRATEGY no Fire,
 * ela é composta por diferentes tipos de tiros que são por Classes
 * que implementam a FireInterface
 */
public class Fire {
    private int x, y, height = 15, width = 6;
    
    private boolean isVisible;
    private Nav nav;
    private static int SPEED = 10;
    private FireInterface fireInterface;
   
    public Fire(Nav nav, FireInterface fireInterface){
        this.nav = nav;
        this.x = nav.getX() + width + 5;
        this.y = nav.getY();
        
        this.isVisible = true;
        this.fireInterface = fireInterface;
    }
    
    public void renderAndUpdate(Graphics2D graphs){
        this.fireInterface.renderAndUpdate(this, graphs);
    }

    public void setX(int x) {
        this.x = x;
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x,y,width,height);   
    }
    

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public static int getSPEED() {
        return SPEED;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    public Nav getNav() {
        return nav;
    }



    
    
}
