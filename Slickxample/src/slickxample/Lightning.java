/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slickxample;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author PK
 */
public class Lightning extends PlayerProjectile {

    private float distance;

    public Lightning(float xPos, float yPos, float angle, float angleInvX, float distance, Image texture) {
        super(xPos, yPos, angle, texture);
//        super.yPos += 76 * (float) Math.cos(angle);
//        super.xPos += 76 * (float) Math.sin(angle);
        super.damage = 50;
        super.bounds.setLocation(super.xPos, super.yPos);
        this.distance = distance;
        super.texture.setCenterOfRotation(9*(distance/76), 0);
        super.texture.setRotation((float) Math.toDegrees(angleInvX));

    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {

    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) {
//        super.render(container, game, g);
        texture.draw(xPos, yPos, distance / 76);
        g.draw(bounds);
    }

}
