/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slickxample;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Patrick
 */
public class Player extends Entity {

    private PlayerProjectileManager projectiles;
    private Input input;
    private Image slowedTint;
    private float reloadTime;
    private final float doubleDirectionMultiplier = 0.707114f;
    private float originalSpeed;
    private boolean slowed = false;
    private float slowDuration;
    private float slowAmount = 0;

    public Player(float xPos, float yPos, Image texture, PlayerProjectileManager projectiles) {
        super(xPos, yPos);
        try {
            super.texture = new Image("res/Player.png");
            slowedTint = new Image("res/PlayerSlowed.png");
        } catch (SlickException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
        super.bounds = new Rectangle(xPos + 3, yPos + 3, texture.getWidth() - 6, texture.getHeight() - 6);
        this.projectiles = projectiles;
        slowedTint.setAlpha(0.5f);
        super.speed = 0.1f;
        super.pathingX = 2;
        super.pathingY = 10;
        super.pathing = new Rectangle(xPos + pathingX, yPos + pathingY, 8, 10);
        originalSpeed = speed;
        setMaxLife(500);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) {
        super.render(container, game, g);
        if (slowed) {
            slowedTint.draw(xPos, yPos);
        }
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        if (slowed) {
            slowDuration -= 0.5f* delta;
            if (slowDuration <= 0) {
                slowAmount = 0;
                slowed = false;
            }
        }
        if(reloadTime >=-9){
        reloadTime -= 0.5f * delta;
        }
        TileManager.setScrollspeed(0);
        reactToInput(container, delta);
        super.update(container, game, delta);
    }

    private void reactToInput(GameContainer container, int delta) {
        input = container.getInput();
        if ((input.isKeyDown(Input.KEY_S) && input.isKeyDown(Input.KEY_D) || input.isKeyDown(Input.KEY_S) && input.isKeyDown(Input.KEY_A) || input.isKeyDown(Input.KEY_W) && input.isKeyDown(Input.KEY_D) || input.isKeyDown(Input.KEY_W) && input.isKeyDown(Input.KEY_A)) && (!(input.isKeyDown(Input.KEY_S) && input.isKeyDown(Input.KEY_W)) && (!(input.isKeyDown(Input.KEY_A) && input.isKeyDown(Input.KEY_D))))) {
            speed = doubleDirectionMultiplier * originalSpeed * (1 - slowAmount);
        } else {
            speed = originalSpeed * (1 - slowAmount);

        }
        if (input.isKeyDown(Input.KEY_S)) {
//            yPos += speed * delta;
            TileManager.setScrollspeed(speed * -1);
        }
        if (input.isKeyDown(Input.KEY_W)) {
//            yPos -= speed * delta;
            TileManager.setScrollspeed(speed);
        }
        if (input.isKeyDown(Input.KEY_D)) {
            xPos += speed * delta;
        }
        if (input.isKeyDown(Input.KEY_A)) {
            xPos -= speed * delta;
        }
        if (input.isKeyDown(Input.KEY_SPACE)) {
            if (reloadTime <= 0) {
                projectiles.SpawnProjectile(xPos, yPos, MathTool.getAngle(input, PlayerProjectileManager.ICEBALL_MIDDLEX), 0);
                reloadTime = PlayerProjectileManager.ICEBALL_RELOAD;
            }
        } else {
            if (input.isMouseButtonDown(Input.MOUSE_RIGHT_BUTTON)) {
                if (reloadTime <= 0) {
                    projectiles.SpawnProjectile(xPos, yPos, MathTool.getAngle(input, PlayerProjectileManager.LIGHTNING_MIDDLEX), 2);
                    reloadTime = PlayerProjectileManager.LIGHTNING_RELOAD;
                }
            } else {
                if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
                    System.out.println(reloadTime);
                    while (reloadTime <= 0) {
                        
                        projectiles.SpawnProjectile(xPos, yPos, MathTool.getAngle(input, PlayerProjectileManager.LAVASPRAY_MIDDLEX), 1);
                        reloadTime += PlayerProjectileManager.LAVASPRAY_RELOAD;
                    }
                }
            }

        }
    }

    @Override
    public void updateBounds() {
        bounds.setLocation(xPos + 3, yPos + 3);
    }

    public void slow(float amount, float duration) {
        slowed = true;
        slowAmount = amount;
        slowDuration = duration;
    }

    public void reset() {
        setxPos(400);
        setyPos(300);
        setLife(500);
        reloadTime = 400;
        slowAmount = 0;
        slowed = false;
        slowDuration = 0;
    }

}
