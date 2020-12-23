/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.enemy;

import java.util.Random;

/**
 * Tipo de Inimigo
 */
public class EnemyBottom extends AbstractEnemy{
    Random randomGenerator = new Random();
    int xRandom = randomGenerator.nextInt(440);

    public EnemyBottom() {
        super(0, 440);
        this.setX(xRandom);
    }
    
    /**
     * Implementação do metodo move, integrante do 'renderizar' presente em
     * AbstractEnemy
     */
    @Override
    void move() {
        this.setY(this.getY() - this.getSpeed());
    }
    
    
    
}
