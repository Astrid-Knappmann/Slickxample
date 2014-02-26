/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slickxample;

import java.util.ArrayList;
import java.util.Iterator;
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
public class EnemyManager {

    private ArrayList<Entity> enemies;
    private Image testBox;
    private Iterator<Entity> enemyiterator;

    public EnemyManager(ArrayList<Entity> enemies) throws SlickException {
        this.enemies = enemies;
        testBox = new Image("res/Zombie.png");
    }

    public void SpawnProjectile(float xPos, float yPos, int id) {
        switch (id) {
            case 0:
                enemies.add(new Zombie(xPos, yPos, testBox));
                break;
        }
    }

    public void render(GameContainer container, StateBasedGame game, Graphics g) {
        enemyiterator = enemies.iterator();
        while (enemyiterator.hasNext()) {
            Entity e = enemyiterator.next();
            e.render(container, game, g);
//            g.draw(e.getPathing());
        }
    }

    public void update(GameContainer container, StateBasedGame game, int delta) {
        enemyiterator = enemies.iterator();
        while (enemyiterator.hasNext()) {
            Entity e = enemyiterator.next();
            e.setyPos(e.getyPos() + TileManager.getScrollspeed() * delta);
            e.update(container, game, delta);
            if (e.getLife() <= 0) {
                enemyiterator.remove();
            }
        }
        enemyiterator = enemies.iterator();
        while (enemyiterator.hasNext()) {
            Entity e = enemyiterator.next();
            for (Entity i : enemies) {
                e.pathing(i.getPathing());
            }
        }
    }
}
