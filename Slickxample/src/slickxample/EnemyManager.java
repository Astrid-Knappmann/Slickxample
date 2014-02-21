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
import static slickxample.PlayerProjectileManager.ICEBALL_MIDDLEX;
import static slickxample.PlayerProjectileManager.ICEBALL_MIDDLEY;

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
                enemies.add(new TestBox(xPos, yPos, testBox));
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
            e.update(container, game, delta);
            if (e.getLife() <= 0) {
                enemyiterator.remove();
            }
        }
        enemyiterator = enemies.iterator();
        while (enemyiterator.hasNext()) {
            Entity e = enemyiterator.next();
            Rectangle p = e.getPathing();
            boolean hasMoved = false;
            for (Entity i : enemies) {
                Rectangle r = i.getPathing();
//consider && !hasMoved
                if (p.intersects(r) && !p.equals(r)) {
                    if (p.getMaxY() - r.getMinY() < 4) {
                        e.setyPos(e.getyPos() - (p.getMaxY() - r.getMinY()));
                        hasMoved = true;
                    }
                    if (p.getMaxY() - r.getMinY() > 18) {
                        e.setyPos(e.getyPos() + (r.getMaxY() - p.getMinY()));
                        hasMoved = true;
                    }

                    if (p.getMaxX() - r.getMinX() < 4) {
                        e.setxPos(e.getxPos() - (p.getMaxX() - r.getMinX()));
                        hasMoved = true;
                    }
                    if (p.getMaxX() - r.getMinX() > 28) {
                        e.setxPos(e.getxPos() + (r.getMaxX() - p.getMinX()));
                        hasMoved = true;

                    }

                }
            }
        }
    }

}
