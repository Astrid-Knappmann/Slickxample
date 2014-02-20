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
public abstract class PlayerProjectile {

    float xPos;
    float yPos;
    Image texture;
    float speed;
    float angle;

    public void render(GameContainer container, StateBasedGame game, Graphics g) {
        texture.draw(xPos, yPos);
    }

    public void update(GameContainer container, StateBasedGame game, int delta) {
        yPos += speed * (float) Math.cos(angle) * delta;
        xPos += speed * (float) Math.sin(angle) * delta;
    }

    public void setXPos(float xPos) {
        this.xPos = xPos;
    }

    public float getXPos() {
        return xPos;
    }

    public void setYPos(float YPos) {
        this.yPos = yPos;
    }

    public float getYPos() {
        return yPos;
    }

}
