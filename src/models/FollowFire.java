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
public class FollowFire implements FireInterface{

    @Override
    public void renderAndUpdate(Fire fire, Graphics2D graphcs2D) {
                fire.setY(fire.getY() - fire.getSPEED());
        if(fire.getY() < 0){
            fire.setVisible(false);
        }
        fire.setX(fire.getNav().getX() + fire.getWidth() + 5);
        if(fire.isVisible()){
            graphcs2D.setColor(new Color(250, 25, 0));
            graphcs2D.fillRect(fire.getX() , fire.getY(), fire.getWidth(), fire.getHeight());
        }
    }
    
}
