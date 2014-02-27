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
    private final ArrayList<Entity> enemies;
    private final Image iceBall;
    private Iterator<PlayerProjectile> playeriterator;
    private Iterator<IceParticle> iceParticleiterator;
    private Iterator<Entity> enemyiterator;
    private final Image lavaSpray;
    public static int iceParticleCreationCount;
    public static final int ICEBALL_ID = 0;
    public static float ICEBALL_MIDDLEX;
    public static float ICEBALL_MIDDLEY;
    public static final float ICEBALL_RELOAD = 400;
    public static final int LAVASPRAY_ID = 1;
    public static final float LAVASPRAY_RELOAD = 7;
    public static float LAVASPRAY_MIDDLEX;
    public static float LAVASPRAY_MIDDLEY;

    public PlayerProjectileManager(ArrayList<Entity> enemies) throws SlickException {
        this.enemies = enemies;
        projectiles = new ArrayList<>();
        iceParticles = new ArrayList<>();
        iceBall = new Image("res/wannabeIce.png");
        lavaSpray = new Image("res/LavaSpray.png");
        ICEBALL_MIDDLEX = iceBall.getWidth() / 2;
        LAVASPRAY_MIDDLEX = lavaSpray.getWidth() / 2 + 7;
        ICEBALL_MIDDLEY = iceBall.getHeight() / 2;
    }

    public void SpawnProjectile(float xPos, float yPos, float angle, int id) {
        switch (id) {
            case 0:
                projectiles.add(new IceBall(xPos, yPos, angle, iceBall, iceParticles));
                break;
            case 1:
                projectiles.add(new LavaSpray(xPos + ICEBALL_MIDDLEX, yPos + ICEBALL_MIDDLEY, angle, lavaSpray));
                break;
        }
        MainMenu.count++;
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
            p.setYPos((p.getYPos() + TileManager.getScrollspeed() * delta));
            p.update(container, game, delta);
            checkCollision(p);
            if (p.getYPos() < -100 || p.getYPos() > container.getHeight() + 100 || p.getXPos() < -100 || p.getXPos() > container.getWidth() + 100 || p.getLifeTime() <= 0) {
                playeriterator.remove();
                MainMenu.count--;
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
    
    public void checkCollision(PlayerProjectile p){
        enemyiterator = enemies.iterator();
        while (enemyiterator.hasNext()){
            Entity e = enemyiterator.next();
            if(p.checkCollision(e.getBounds())){
                p.collision(e);
            }
        }
    }
}
