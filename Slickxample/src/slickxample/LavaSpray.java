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
public class LavaSpray extends PlayerProjectile{

    
    public LavaSpray(float xPos, float yPos, float angle, Image texture) {
        super.xPos = xPos;
        super.yPos = yPos;
        super.angle = angle;
        super.texture = texture;
        super.speed = 0.2f;
        super.lifeTime = 800 + RandomTool.getRandom().nextInt(150);
        
        
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) {
        super.update(container, game, delta);
        lifeTime -= 1*delta;
    }

}
