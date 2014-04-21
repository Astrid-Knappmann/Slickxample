/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package slickxample;

/**
 *
 * @author PK
 */
public class MoveFleeLava implements MoveStrategy{
    
    private float xMultiplier = 0;
    private float yMultiplier = 0;
    
    
    
    @Override
    public void move(Entity e, int delta) {
        float xPos = e.getxPos();
        float yPos = e.getyPos();
        float speed = e.getSpeed();
        if(xMultiplier == 0 && yMultiplier == 0){
            xMultiplier = (float) Math.sin(0 + (RandomTool.getRandom().nextFloat()-0.5f));
            yMultiplier = (float) Math.cos(0 + (RandomTool.getRandom().nextFloat()-0.5f));
        }
        
        e.setyPos(yPos += (speed * yMultiplier * delta) * -1);
        e.setxPos(xPos += (speed * xMultiplier * delta) * -1);
    }
}
