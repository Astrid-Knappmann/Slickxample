/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slickxample;

import java.util.ArrayList;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Patrick
 */
public class Player {

    private float xPos;
    private float yPos;
    private Image texture;
    private PlayerProjectileManager projectiles;
    private Input input;
    private float reloadTime;

    public Player(float xPos, float yPos, Image texture, PlayerProjectileManager projectiles) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.texture = texture;
        this.projectiles = projectiles;
    }

    public void render(GameContainer container, StateBasedGame game, Graphics g) {
        texture.draw(xPos, yPos);
    }

    public void update(GameContainer container, StateBasedGame game, int delta) {
        input = container.getInput();
        reloadTime -= 1 * delta;
        if (input.isKeyDown(Input.KEY_S)) {
            yPos += 0.1f * delta;
        }
        if (input.isKeyDown(Input.KEY_W)) {
            yPos -= 0.1f * delta;
        }
        if (input.isKeyDown(Input.KEY_D)) {
            xPos += 0.1f * delta;
        }
        if (input.isKeyDown(Input.KEY_A)) {
            xPos -= 0.1f * delta;
        }
        if (input.isKeyDown(Input.KEY_SPACE)) {
            if (reloadTime <= 0) {
                projectiles.SpawnProjectile(xPos, yPos, getAngle(), 0);
                reloadTime = 400;
            }
        }
    }
    
    public float getAngle(){
        float deltax =  input.getMouseX() - xPos;
        float deltay = input.getMouseY() - yPos;
        float angle = (float) Math.atan2(deltax, deltay);
        return angle;
    }
}
