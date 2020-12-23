/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.keyevent;

import models.keyevent.KeyEventType;
import interfaces.Observable;
import interfaces.Subject;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


/**
 * Classe responsavel por gerenciar os eventos de teclado e e disparados para os 
 * Subjects adicionados
 * IMPLEMENTA O PADRÃO OBSERVABLE
 */    
public class KeyboardAdapter extends KeyAdapter implements Observable<KeyEventType>{

    final private ArrayList<Subject<KeyEventType>> subjects = new ArrayList<Subject<KeyEventType>>();


    @Override
    public void keyPressed(KeyEvent e){
       this.next(new KeyEventType(e, KeyEventTypeEnum.keyPressed));
    }

    @Override
    public void keyReleased(KeyEvent e){
        this.next(new KeyEventType(e, KeyEventTypeEnum.keyReleased));
    }

    @Override
    public void add(Subject<KeyEventType> subject) {
        this.subjects.add(subject);
    }

    @Override
    public void next(KeyEventType event) {
        this.subjects.forEach(sub -> sub.execute(event));
    }

    


}
