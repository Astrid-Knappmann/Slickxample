/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slickxample;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Patrick
 */
public interface PlayerProjectile {
    
    float xPos = 0;
    float yPos = 0;
    Image texture = null;
    
    public void render(GameContainer container, StateBasedGame game, Graphics g);
    public void update(GameContainer container, StateBasedGame game, int delta);
    public void setXPos(float xPos);
    public float getXPos();
    public void setYPos(float YPos);
    public float getYPos();
}
