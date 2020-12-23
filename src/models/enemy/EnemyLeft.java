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
public class EnemyLeft extends AbstractEnemy{
    Random randomGenerator = new Random();
    int yRandom = randomGenerator.nextInt(440);

    public EnemyLeft() {
        super(0, 30);
        this.setY(yRandom);
    }
    
    @Override
    void move() {
        this.setX(this.getX() + this.getSpeed());
    }
    
    
    
}
