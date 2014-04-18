/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package slickxample;

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
public class LavaFlow extends Projectile{
    

    

    public LavaFlow(float xPos, float yPos, float angle, Image texture) {
        super(xPos, yPos, angle, texture);
        super.damage = 0.04f;
        super.lifeTime = 1;
    }
    
    public void init(GameContainer container, StateBasedGame game) throws SlickException{        
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) {
        if(yPos <650){
        texture.draw(xPos, yPos);
        }
    }
    
    
    @Override
    public void update(GameContainer container, StateBasedGame game, int delta){
        yPos -= (0.01f - TileManager.getScrollspeed()) * delta;
        bounds.setLocation(xPos, yPos);
        
    }

    @Override
    public void collision(Entity e) {
        e.setLife(e.getLife() - damage);
    }
        
}
