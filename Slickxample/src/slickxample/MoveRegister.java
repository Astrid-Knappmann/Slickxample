/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slickxample;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Patrick
 */
public class MoveRegister {

    public static final String CASTER1_ID = "caster1";
    public static final String CASTERTOWARDS_ID = "casterTowards";
    public static final String FLEE_ID = "flee";
    public static final String IDLE_ID = "idle";
    public static final String FOLLOW_ID = "follow";
    public static final String FLEELAVA_ID = "fleeLava";

    public void init(GameContainer container, StateBasedGame game) throws SlickException {

    }

    public static MoveStrategy getCaster1(Entity e) {
        e.setCurrentMoveStrat(CASTER1_ID);
        return new MoveCaster1();
    }

    public static MoveStrategy getFlee(Entity e) {
        e.setCurrentMoveStrat(FLEE_ID);
        return new MoveFlee();
    }

    public static MoveStrategy getIdle(Entity e) {
        e.setCurrentMoveStrat(IDLE_ID);
        return new MoveIdle();
    }

    public static MoveStrategy getCasterTowards(Entity e) {
        e.setCurrentMoveStrat(CASTERTOWARDS_ID);
        return new MoveCasterTowards();
    }

    public static MoveStrategy getFollow(Entity e) {
        e.setCurrentMoveStrat(FOLLOW_ID);
        return new MoveFollow();
    }
    
     public static MoveStrategy getFleeLava(Entity e) {
        e.setCurrentMoveStrat(FLEELAVA_ID);
        return new MoveFleeLava();
    }
}
