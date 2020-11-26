package models;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author arthur
 */
public class Nav {
    private int x , y, dx;
    private int height = 30 , width = 30;
    private List<Fire> fires;
    private boolean followFire = false;
    
    
    public Nav(){
     this.x = 10;
     this.y = 420;
     fires = new ArrayList<Fire>();
    }
    
    public void update(){
        if(x + dx > 10 && x + dx < 440) x = x + dx; 
    }
    
    public void simpleFire(){
        if(this.followFire){
            this.fires.add(new Fire(this, new FollowFire()));
        }else{
            this.fires.add(new Fire(this, new SimpleFire()));
        }
        
    }
    
    public void keyPressed(KeyEvent event){
        int code = event.getKeyCode();
        if(code == KeyEvent.VK_F3){
                this.followFire = !this.followFire;
        }
        if(code == KeyEvent.VK_SPACE){
                this.simpleFire();
        }
        if(code == KeyEvent.VK_LEFT){
                dx = -3;
        }
        if(code == KeyEvent.VK_RIGHT){
                dx = 3;
        } 
    }
    
    public void keyRelease(KeyEvent event){
                    
        int code = event.getKeyCode();
        if(code == KeyEvent.VK_LEFT){           
            dx = 0;
        }
        if(code == KeyEvent.VK_RIGHT){                        
            dx =  0;
        } 
    }
    
    public void render(Graphics2D graphs){
        this.fires.stream().forEach(fire ->{
            if(fire.isVisible()){
                fire.renderAndUpdate(graphs);
            }
        });
        
        graphs.setColor(new Color(125, 25, 25));
        this.renderLine(2, 0, 2, graphs);
        this.renderLine(0, 1, 6, graphs);
        this.renderLine(1, 2, 4, graphs);
        this.renderLine(1, 3, 4, graphs);
        this.renderLine(0, 4, 6, graphs);
    }
    
    private void renderLine(int x, int y, int width, Graphics2D graphs){
        int yUnit = this.getHeight()/5; //6
        int xUnit = this.getWidth()/6; //5
        graphs.fillRect(this.getX() + x * xUnit ,this.getY() +  yUnit * y , width * xUnit, yUnit);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public List<Fire> getFires() {
        return fires;
    }
       
}
