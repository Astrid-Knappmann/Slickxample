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


    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        
    }

    public static MoveStrategy getCaster1() {
        return new MoveCaster1();
    }

    public static MoveStrategy getFlee() {
        return new MoveFlee();
    }
    
    public static MoveStrategy getIdle() {
        return new MoveIdle();
    }
     public static MoveStrategy getCasterTowards() {
        return new MoveCasterTowards();
    }

}
