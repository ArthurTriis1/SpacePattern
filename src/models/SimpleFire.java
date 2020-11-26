/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import interfaces.FireInterface;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author arthu
 */
public class SimpleFire implements FireInterface{

    @Override
    public void renderAndUpdate(Fire fire, Graphics2D graphcs2D) {
                fire.setY(fire.getY() - fire.getSPEED());
        if(fire.getY() < 0){
            fire.setVisible(false);
        }
        
        if(fire.isVisible()){
            graphcs2D.setColor(new Color(25, 125, 25));
            graphcs2D.fillRect(fire.getX() , fire.getY(), fire.getWidth(), fire.getHeight());
        }
    }
    
}
