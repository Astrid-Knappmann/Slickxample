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
public class IceParticle extends Projectile {

    private float alpha = 0.5f;
    private float rotation;

    public IceParticle(float xPos, float yPos, Image texture, int initRotation, float rotation) {
        super(xPos, yPos, 0, texture);
        texture.setRotation(initRotation);
        this.rotation = rotation;
        texture.setAlpha(alpha);
        super.lifeTime = 750;
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) {
        texture.draw(xPos, yPos, 0.5f);

    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        texture.rotate(rotation * delta);
        lifeTime -= 1 * delta;
        yPos+= TileManager.getScrollspeed() * delta;
        if (lifeTime <= 520) {
            texture.setAlpha(alpha -= 0.001 * delta);
        }
    }

}
