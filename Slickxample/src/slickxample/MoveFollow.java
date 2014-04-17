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
public class MoveFollow implements MoveStrategy {

    @Override
    public void move(Entity e, int delta) {
        float angle = MathTool.getAngleToPlayer(e.getxPos(), e.getyPos());
        e.setyPos(e.getyPos() + e.getSpeed() * (float) Math.cos(angle) * delta);
        e.setxPos(e.getxPos() + e.getSpeed() * (float) Math.sin(angle) * delta);
    }

}
