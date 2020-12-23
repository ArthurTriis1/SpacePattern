/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.keyevent;

import java.awt.event.KeyEvent;

/**
 * Classe que envelopa os eventos de teclado
 */
public class KeyEventType {
    KeyEvent event;
    KeyEventTypeEnum type;

    public KeyEventType(KeyEvent event, KeyEventTypeEnum type) {
        this.event = event;
        this.type = type;
    }

    public KeyEvent getEvent() {
        return event;
    }

    public void setEvent(KeyEvent event) {
        this.event = event;
    }

    public KeyEventTypeEnum getType() {
        return type;
    }

    public void setType(KeyEventTypeEnum type) {
        this.type = type;
    }
        
    
}

