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
public class IceBall extends Projectile {

    private final ArrayList<IceParticle> particleEffects;

    public IceBall(float xPos, float yPos, float angle, Image texture, ArrayList<IceParticle> particleEffects) {
        super(xPos, yPos, angle, texture);
        this.particleEffects = particleEffects;
        super.speed = 0.2f;
        super.damage = 50;
    }

//    @Override
//    public void render(GameContainer container, StateBasedGame game, Graphics g) {
//        super.render(container, game, g);
//    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        super.update(container, game, delta);
        texture.rotate(1 * delta);
        try {
            if (PlayerProjectileManager.iceParticleCreationCount > 15) {
                particleEffects.add(new IceParticle(xPos, yPos, new Image("res/ice.png"), RandomTool.getRandom().nextInt(360), RandomTool.getRandom().nextFloat() / 2 - 0.25f));
                MainMenu.count++;
            }
        } catch (SlickException ex) {
        }

    }
}
