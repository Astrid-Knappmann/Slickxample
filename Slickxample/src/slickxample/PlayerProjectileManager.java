/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slickxample;

import java.util.ArrayList;
import java.util.Iterator;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Patrick
 */
public class PlayerProjectileManager {

    private final ArrayList<PlayerProjectile> projectiles;
    private final ArrayList<IceParticle> iceParticles;
    private final Image iceBall;
    private Iterator<PlayerProjectile> playeriterator;
    private Iterator<IceParticle> iceParticleiterator;
    public static int iceParticleCreationCount;
    public static float ICEBALL_MIDDLE;

    public PlayerProjectileManager() throws SlickException {
        projectiles = new ArrayList<>();
        iceParticles = new ArrayList<>();
        iceBall = new Image("res/wannabeIce.png");
        ICEBALL_MIDDLE = iceBall.getWidth()/2;
    }

    public void SpawnProjectile(float xPos, float yPos, float angle, int id) {
        switch (id) {
            case 0:
                projectiles.add(new IceBall(xPos, yPos, angle, iceBall, iceParticles));
                break;

        }
    }

    public void render(GameContainer container, StateBasedGame game, Graphics g) {
        playeriterator = projectiles.iterator();
        while (playeriterator.hasNext()) {
            PlayerProjectile p = playeriterator.next();
            p.render(container, game, g);
        }

        iceParticleiterator = iceParticles.iterator();
        while (iceParticleiterator.hasNext()) {
            IceParticle p = iceParticleiterator.next();
            p.render(container, game, g);
        }
    }

    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        playeriterator = projectiles.iterator();
        iceParticleCreationCount += 1 * delta;
        while (playeriterator.hasNext()) {
            PlayerProjectile p = playeriterator.next();
            p.update(container, game, delta);
            if (p.getYPos() < -100 || p.getYPos() > container.getHeight() || p.getXPos() < -100 || p.getXPos() > container.getWidth()) {
                playeriterator.remove();
            }
        }

        if (iceParticleCreationCount > 15) {
            iceParticleCreationCount = 0;
        }
        iceParticleiterator = iceParticles.iterator();
        while (iceParticleiterator.hasNext()) {
            IceParticle p = iceParticleiterator.next();
            p.update(container, game, delta);
            if (p.getLifeTime() <= 0) {
                iceParticleiterator.remove();
                MainMenu.count--;
            }
        }
    }

    public void addIceParticle(IceParticle i) {
        iceParticles.add(i);
    }
}
