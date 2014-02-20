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
    private float space = PlayerProjectileManager.ICEBALL_MIDDLEX;

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
                projectiles.SpawnProjectile(xPos, yPos, getAngle(space), 0);
                reloadTime = PlayerProjectileManager.ICEBALL_RELOAD;
            }
        } else {
            if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
                if (reloadTime <= 0) {
                    projectiles.SpawnProjectile(xPos, yPos, getAngle(PlayerProjectileManager.LAVASPRAY_MIDDLEX) + RandomTool.getRandom().nextFloat() / 3 - 0.1666f, 1);
                    reloadTime = PlayerProjectileManager.LAVASPRAY_RELOAD;
                }
            }
        }

    }

    public float getAngle(float projectileid) {
        float deltax = input.getMouseX() - projectileid - xPos;
        float deltay = input.getMouseY() - projectileid - yPos;
        float angle = (float) Math.atan2(deltax, deltay);
        return angle;
    }
}
