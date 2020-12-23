/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.counter;

/**
 * Classe Singleton responsavel por manter a contagem dos pontos no game
 * iguais e todas as classes
 * IMPLEMENTA O PADRÃO SINGLETON
 */
public class CounterSingleton {
    private static CounterSingleton instance;
    private int counterValue;
    
    private CounterSingleton(){
        this.counterValue = 0;
    }
    
    public static CounterSingleton getInstance() {
        if (instance == null) {
            instance = new CounterSingleton();
        }
        return instance;
    }

    public int getCounterValue() {
        return counterValue;
    }

    public void resetCounterValue(int counterValue) {
        this.counterValue = 0;
    }
    
    public void add1CounterValue() {
        this.counterValue += 1;
    }
    
    
    
}
