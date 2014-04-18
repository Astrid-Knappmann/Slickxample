/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package slickxample;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author PK
 */
public class ScoreManager {
    
    private float currentScore = 0;
    
    public void render(GameContainer container, StateBasedGame game, Graphics g){
        g.setColor(Color.white);
        g.drawString("Score: " + (int)currentScore, 25, 50);
    }
    
    public void update(GameContainer container, StateBasedGame game, int delta){
        
    }
    
    public void addPoints(float points){
        currentScore += points;
    }
    
}
