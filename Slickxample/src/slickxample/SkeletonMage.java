/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package slickxample;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author Patrick
 */
public class SkeletonMage extends Entity {

    public SkeletonMage(float xPos, float yPos) {
        super(xPos, yPos);
        try {
            super.texture = new Image("res/SkeletonMage.png");
        } catch (SlickException ex) {
            Logger.getLogger(SkeletonMage.class.getName()).log(Level.SEVERE, null, ex);
        }
        setMaxLife(50);
        super.speed = 0.08f;
        super.pathingX = 4;
        super.pathingY = 25;
        super.pathing = new Rectangle(xPos + pathingX, yPos + pathingY, 16, 11);
    }
    
}
