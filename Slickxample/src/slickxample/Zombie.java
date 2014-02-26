/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slickxample;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author PK
 */
public class Zombie extends Entity {

    private float angle;

    public Zombie(float xPos, float yPos, Image texture) {
        super(xPos, yPos, texture);
        life = 50;
        super.speed = 0.08f;
        super.pathingX = 4;
        super.pathingY = 25;
        super.pathing = new Rectangle(xPos + pathingX, yPos + pathingY, 16, 11);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        angle = AngleCalculator.getAngleToPlayer(xPos, yPos);
        yPos += speed * (float) Math.cos(angle) * delta;
        xPos += speed * (float) Math.sin(angle) * delta;
        super.update(container, game, delta);

    }

}
