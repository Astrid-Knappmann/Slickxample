/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slickxample;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author PK
 */
public class Zombie extends Entity {

    private float angle;

    public Zombie(float xPos, float yPos) {
        super(xPos, yPos);
        try {
            super.texture = new Image("res/Zombie.png");
        } catch (SlickException ex) {
            Logger.getLogger(Zombie.class.getName()).log(Level.SEVERE, null, ex);
        }
        super.bounds = new Rectangle(xPos, yPos, texture.getWidth(), texture.getHeight());
        setMaxLife(100);
        super.speed = 0.08f;
        super.pathingX = 4;
        super.pathingY = 25;
        super.pathing = new Rectangle(xPos + pathingX, yPos + pathingY, 16, 11);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        angle = MathTool.getAngleToPlayer(xPos, yPos);
        yPos += speed * (float) Math.cos(angle) * delta;
        xPos += speed * (float) Math.sin(angle) * delta;
        super.update(container, game, delta);

    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) {
        super.render(container, game, g);
        
        
    }
    
    

}
