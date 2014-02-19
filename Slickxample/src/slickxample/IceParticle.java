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
public class IceParticle implements PlayerProjectile{

    private float xPos;
    private float yPos;
    private Image texture;
    private int lifeTime = 750;
    private float alpha= 0.5f;
    private float rotation;

    public IceParticle(float xPos, float yPos, Image texture, int initRotation, float rotation) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.texture = texture;
        texture.setRotation(initRotation);
        this.rotation = rotation;
        texture.setAlpha(alpha);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) {
        texture.draw(xPos, yPos, 0.5f);

    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        texture.rotate(rotation*delta);
        lifeTime -= 1*delta;
        if(lifeTime <= 520){
        texture.setAlpha(alpha -= 0.001*delta);
        }
    }

    public int getLifeTime() {
        return lifeTime;
    }

    @Override
    public void setXPos(float xPos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float getXPos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setYPos(float YPos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float getYPos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
