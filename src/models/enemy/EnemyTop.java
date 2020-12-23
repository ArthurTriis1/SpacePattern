/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.enemy;

import java.util.Random;

/**
 *
 * @author arthu
 */
public class EnemyTop extends AbstractEnemy{
    Random randomGenerator = new Random();
    int xRandom = randomGenerator.nextInt(440);

    public EnemyTop() {
        super(0, 0);
        this.setX(xRandom);
    }
    
    @Override
    void move() {
        this.setY(this.getY() + this.getSpeed());
    }
    
    
    
}
