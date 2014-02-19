/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slickxample;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Patrick
 */
public class Slickxample extends StateBasedGame{
    
    public static final int MAINMENUSTATE = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SlickException {
        // TODO code application logic here
        AppGameContainer app = new AppGameContainer(new Slickxample("Namae"));
        app.setDisplayMode(800, 600, false);
        app.start();
    }
    
    public Slickxample (String name){
        super(name);
    }

    @Override
    public void initStatesList(GameContainer container) throws SlickException {
        addState(new MainMenu(MAINMENUSTATE));
        getState(MAINMENUSTATE).init(container, this);
        enterState(MAINMENUSTATE);
    }
}
