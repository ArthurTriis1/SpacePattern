/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.enemy;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * Classe base para implementação de um inimigo 
 * IMPLEMENTA O PADRÃO TEMPLATE METHOD
 */
public abstract class AbstractEnemy {
    private int initialX, initialY, speed = 2;
    private int x , y, dx, dy;
    private int fireTypeValue = 0;
    private int height = 30 , width = 30;

    public AbstractEnemy(int initialX, int initialY) {
        this.x = initialX;
        this.y = initialY;
    }

    /**
     * Função principal do template method, a renderização do inimigo vai ser 
     * igual para todos, mas sua movimentação vai mudar de acordo com seu tipo
     * @param graphs 
     */
    public void renderAndUpdate(Graphics2D graphs){
          this.move();
          this.renderLine(1, 0, 1, graphs);
          this.renderLine(5, 0, 1, graphs);
          this.renderLine(2, 1, 3, graphs);
          this.renderLine(2, 2, 3, graphs);
          this.renderLine(2, 3, 3, graphs);
          this.renderLine(1, 4, 1, graphs);
          this.renderLine(5, 4, 1, graphs);
    }
    
    
    private void renderLine(int x, int y, int width, Graphics2D graphs){
        int yUnit = this.height/5; //6
        int xUnit = this.width/5; //5
        graphs.setColor(Color.black);
        graphs.fillRect(this.x + x * xUnit ,this.y +  yUnit * y , width * xUnit, yUnit);
    }
    
    /**
     * Matodo a ser sobrescrito pelos diferentes tipos de inimigos
     */
    abstract void move();
    
    public Rectangle getBounds(){
        return new Rectangle(x,y,width,height);   
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    
    
    
}
