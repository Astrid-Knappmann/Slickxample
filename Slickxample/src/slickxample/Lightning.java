/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slickxample;

import java.util.ArrayList;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author PK
 */
public class Lightning extends Projectile {

    private ArrayList<Entity> hitList;

    public Lightning(float xPos, float yPos, float angle, float angleInvX, Image texture) {
        super(xPos, yPos, angle, texture);
        super.bounds.setLocation(super.xPos + 76 * (float) Math.sin(angle), super.yPos + 76 * (float) Math.cos(angle));
        super.bounds.setSize(super.texture.getWidth(), super.texture.getWidth());
        super.damage = 25;
        super.texture.setCenterOfRotation(9.5f, 0);
        super.speed = 0.8f;
        super.texture.setRotation((float) Math.toDegrees(angleInvX));
        hitList = new ArrayList<>();
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        yPos += speed * (float) Math.cos(angle) * delta;
        xPos += speed * (float) Math.sin(angle) * delta;
        bounds.setLocation(bounds.getX() + speed * (float) Math.sin(angle) * delta, bounds.getY() + speed * (float) Math.cos(angle) * delta);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) {
        super.render(container, game, g);
//        g.draw(bounds);
    }

    @Override
    public void setYPos(float yPos) {
        this.yPos = yPos;
        bounds.setY(yPos + 76 * (float) Math.cos(angle));
    }

    @Override
    public void collision(Entity e) {
        boolean isHit = false;
        for (Entity e2 : hitList) {

            if (e.equals(e2)) {
                isHit = true;
            }
        }
        if (!isHit) {
            e.setLife(e.getLife() - damage);
            hitList.add(e);

        }
    }

}
