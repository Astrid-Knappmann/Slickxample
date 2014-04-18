/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author PK
 */
public class EnemyProjectileManager {

    private Player player;
    private static ArrayList<Projectile> projectiles;
    private Iterator<Projectile> projectileIterator;
    private LavaFlow lavaFlow;

    public EnemyProjectileManager(Player player, LavaFlow lavaFlow) {
        this.player = player;
        projectiles = new ArrayList<>();
        this.lavaFlow = lavaFlow;
    }

    public static void SpawnProjectile(float xPos, float yPos, float angle, float angle2, int id) {
        try {
            switch (id) {
                case 0:
                    projectiles.add(new WeakFireball(xPos, yPos, angle, angle2, new Image("res/WeakFireball.png")));
                break;

            }
            MainMenu.count++;
        } catch (SlickException ex) {
            Logger.getLogger(PlayerProjectileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void render(GameContainer container, StateBasedGame game, Graphics g) {
        projectileIterator = projectiles.iterator();
        while (projectileIterator.hasNext()) {
            Projectile p = projectileIterator.next();
            p.render(container, game, g);
        }
    }

    public void update(GameContainer container, StateBasedGame game, int delta) {
        projectileIterator = projectiles.iterator();
        while (projectileIterator.hasNext()) {
            Projectile p = projectileIterator.next();
            p.setYPos((p.getYPos() + TileManager.getScrollspeed() * delta));
            p.update(container, game, delta);
            checkCollision(p);
            if (p.getYPos() < -100 || p.getYPos() > container.getHeight() + 100 || p.getXPos() < -100 || p.getXPos() > container.getWidth() + 100 || p.getLifeTime() <= 0) {
                projectileIterator.remove();
                MainMenu.count--;
            }
        }
        lavaCollision();
    }

    public void checkCollision(Projectile p) {
        if (p.checkCollision(player.getBounds())) {
            p.collision(player);
        }
    }
    
    public void lavaCollision(){
        checkCollision(lavaFlow);
    }
}
