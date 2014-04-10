/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slickxample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.newdawn.slick.Color;
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
    private EnemyCreator creator;
    private ComparatorY comparatorY;

    public EnemyManager(ArrayList<Entity> enemies, EnemyCreator creator) throws SlickException {
        this.enemies = enemies;
        this.creator = creator;
        testBox = new Image("res/Zombie.png");
        comparatorY = new ComparatorY();
    }

    public void spawnEnemies(int lvl) {
        ArrayList<Entity> list = creator.spawnEnemies(lvl);
        if (!(list == null)) {
            for (Entity e : list) {
                enemies.add(e);
            }
        }
    }

    public void SpawnProjectile(float xPos, float yPos, int id) {
        switch (id) {
            case 0:
                enemies.add(new Zombie(xPos, yPos));
                break;
        }
    }

    public void render(GameContainer container, StateBasedGame game, Graphics g) {
        Collections.sort(enemies, comparatorY);
        enemyiterator = enemies.iterator();
        while (enemyiterator.hasNext()) {
            Entity e = enemyiterator.next();
            e.render(container, game, g);
            drawHealthBars(e, g);
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

    public void drawHealthBars(Entity e, Graphics g) {
        g.setColor(Color.black);
        g.fillRect(e.getxPos() + 2, e.getyPos() - 10, e.getTexture().getWidth() - 2, 5);
        g.setColor(Color.red);
        g.fillRect(e.getxPos() + 3, e.getyPos() - 9, (e.getTexture().getWidth() - 2) * (e.getLife() / e.getMaxLife()), 3);
    }
}
