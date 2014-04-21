/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slickxample;

import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Zombie extends Entity {

    private float angle;
    private float damage;
    private Player player;
    private float attackReload = 0;
    private float difficulty;
    private float slowAmount;
    private float slowDuration = 750;

    public Zombie(float xPos, float yPos, float difficulty) {
        super(xPos, yPos);
        try {
            super.texture = new Image("res/Zombie.png");
        } catch (SlickException ex) {
            Logger.getLogger(Zombie.class.getName()).log(Level.SEVERE, null, ex);
        }
        super.bounds = new Rectangle(xPos, yPos, texture.getWidth(), texture.getHeight());
        this.difficulty = difficulty;
        super.speed = 0.08f;
        super.pathingX = 4;
        super.pathingY = 25;
        super.pathing = new Rectangle(xPos + pathingX, yPos + pathingY, 16, 11);
        player = PlayerHandler.getPlayer();
        super.baseScore = 10 * difficulty;
        damage = 1.5f * (difficulty/10 + 1);
        setMaxLife(100 + RandomTool.getRandom().nextInt(76) + (difficulty * (5 + RandomTool.getRandom().nextInt(6))));
        slowAmount = 0.25f + (difficulty/100) ;
        moveStrat = MoveRegister.getFollow(this);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        act(delta);
        super.update(container, game, delta);

    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) {
        super.render(container, game, g);                
    }

    @Override
    public void act(int delta) {
        attackReload -= 0.5f * delta;
        moveStrat.move(this, delta);        
        if(MathTool.getDistanceToPlayer(xPos + texture.getWidth()/2, yPos + texture.getHeight()/2) < 30 && attackReload <= 0){
            attack();
        }
    }
    
    public void attack(){        
        player.setLife(player.getLife() - damage);
        player.slow(slowAmount, slowDuration);
        attackReload = 100;
    }

    @Override
    public void enforceBorders(GameContainer container) {
        
    }
    
    
    
    

}
