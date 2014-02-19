/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slickxample;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Patrick
 */
public class IceBall implements PlayerProjectile {

    private float xPos;
    private float yPos;
    private Image texture;
    private ArrayList<IceParticle> particleEffects;
    private float speed = 0.2f;
    private float angle;

    public IceBall(float xPos, float yPos, float angle, Image texture, ArrayList<IceParticle> particleEffects) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.angle = angle;
        this.texture = texture;
        this.particleEffects = particleEffects;
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) {
        texture.draw(xPos, yPos);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        yPos += speed * (float) Math.cos(angle) * delta;
        xPos += speed * (float) Math.sin(angle) * delta;

//        yPos -= 0.2f * delta;
        texture.rotate(1 * delta);
        try {
            if (PlayerProjectileManager.iceParticleCreationCount > 15) {
                particleEffects.add(new IceParticle(xPos, yPos, new Image("res/wannabeIce.png"), RandomTool.getRandom().nextInt(360), RandomTool.getRandom().nextFloat() / 2 - 0.25f));
                MainMenu.count++;
            }
        } catch (SlickException ex) {
        }

    }

    @Override
    public void setXPos(float xPos) {
        this.xPos = xPos;
    }

    @Override
    public float getXPos() {
        return xPos;
    }

    @Override
    public void setYPos(float YPos) {
        this.yPos = yPos;
    }

    @Override
    public float getYPos() {
        return yPos;
    }
}
