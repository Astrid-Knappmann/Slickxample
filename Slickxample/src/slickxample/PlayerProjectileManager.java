/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slickxample;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Patrick
 */
public class PlayerProjectileManager {

    private final ArrayList<Projectile> projectiles;
    private final ArrayList<IceParticle> iceParticles;
    private final ArrayList<Entity> enemies;
    private final Image iceBall;
    private Iterator<Projectile> playeriterator;
    private Iterator<IceParticle> iceParticleiterator;
    private Iterator<Entity> enemyiterator;
    private LavaFlow lavaFlow;
    private final Image lavaSpray;
    private final Image lightning;
    private Input input;
    public static int iceParticleCreationCount;
    public static final int ICEBALL_ID = 0;
    public static float ICEBALL_MIDDLEX;
    public static float ICEBALL_MIDDLEY;
    public static final float ICEBALL_RELOAD = 200;
    public static final int LAVASPRAY_ID = 1;
    public static final float LAVASPRAY_RELOAD = 3;
    public static float LAVASPRAY_MIDDLEX;
    public static float LAVASPRAY_MIDDLEY;
    public static float LIGHTNING_MIDDLEX;
    public static final float LIGHTNING_RELOAD = 150;

    public PlayerProjectileManager(ArrayList<Entity> enemies, LavaFlow lavaFlow) throws SlickException {
        this.enemies = enemies;
        projectiles = new ArrayList<>();
        iceParticles = new ArrayList<>();
        iceBall = new Image("res/ice.png");
        lavaSpray = new Image("res/LavaSpray.png");
        lightning = new Image("res/lightning.png");
        ICEBALL_MIDDLEX = iceBall.getWidth() / 2;
        LAVASPRAY_MIDDLEX = lavaSpray.getWidth() / 2 + 7;
        ICEBALL_MIDDLEY = iceBall.getHeight() / 2;
        LIGHTNING_MIDDLEX = lightning.getWidth() / 2;
        this.lavaFlow = lavaFlow;
    }

    public void SpawnProjectile(float xPos, float yPos, float angle, int id)  {
        try {
            switch (id) {
                case 0:
                    projectiles.add(new IceBall(xPos, yPos, angle, iceBall, iceParticles));
                    break;
                case 1:
                    projectiles.add(new LavaSpray(xPos + ICEBALL_MIDDLEX, yPos + ICEBALL_MIDDLEY, angle, lavaSpray));
                    break;
                case 2: projectiles.add(new Lightning(xPos, yPos, angle, MathTool.getAngleInvX(input, LIGHTNING_MIDDLEX), new Image("res/lightning.png")));
                break;
            }
            MainMenu.count++;
        } catch (SlickException ex) {
            Logger.getLogger(PlayerProjectileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void render(GameContainer container, StateBasedGame game, Graphics g) {
        playeriterator = projectiles.iterator();
        while (playeriterator.hasNext()) {
            Projectile p = playeriterator.next();
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
            Projectile p = playeriterator.next();
            p.setYPos((p.getYPos() + TileManager.getScrollspeed() * delta));
            p.update(container, game, delta);
            checkCollision(p);
            if (p.getYPos() < -100 || p.getYPos() > container.getHeight() + 100 || p.getXPos() < -100 || p.getXPos() > container.getWidth() + 100 || p.getLifeTime() <= 0) {
                playeriterator.remove();
                MainMenu.count--;
            }
        }
        lavaCollision();
        
        

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
        input = container.getInput();
    }

    public void addIceParticle(IceParticle i) {
        iceParticles.add(i);
    }
    
    public void lavaCollision(){
        checkCollision(lavaFlow);
    }
    
    public void checkCollision(Projectile p){
        enemyiterator = enemies.iterator();
        while (enemyiterator.hasNext()){
            Entity e = enemyiterator.next();
            if(p.checkCollision(e.getBounds())){
                p.collision(e);
            }
        }
    }
}
