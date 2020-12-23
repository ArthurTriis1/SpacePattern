/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.enemy;

import java.util.ArrayList;
import java.util.Random;

/**
 *  Classe responsavel por criar diferentes tipos de inimigos randomicamente
 * "IMPLEMENTA O PADRÃO FACTORY
 */
public class EnemyFactory {

    public static AbstractEnemy create(){
        Random randomGenerate = new Random();
        ArrayList<AbstractEnemy> enemys = new ArrayList<AbstractEnemy>();
        enemys.add(new EnemyRight());
        enemys.add(new EnemyLeft());
        enemys.add(new EnemyTop());
        enemys.add(new EnemyBottom());
        return enemys.get(randomGenerate.nextInt(4));
    }
}
