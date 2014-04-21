/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slickxample;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Patrick
 */
public class TileManager {
    
    private final int groundId = 0;
    private final int ground2Id = 1;
    private final int ground3Id = 2;
    public static final int tileSize = 32;
    public static float scrollspeed = 0.04f;
    private Image ground;
    private Image ground2;
    private Image ground3;
    public static final int tileMover = -64;

    
    

    public TileManager() {
    }
    
    public void init(GameContainer container, StateBasedGame game) throws SlickException{
        ground = new Image("res/Ground.png");
        ground2 = new Image("res/Ground2.png");
        ground3 = new Image("res/Ground3.png");
    }

    public static float getScrollspeed() {
        return scrollspeed;
    }

    public Image getGround() {
        return ground;
    }

    public Image getGround2() {
        return ground2;
    }

    public int getGroundId() {
        return groundId;
    }

    public int getGround2Id() {
        return ground2Id;
    }

    public int getGround3Id() {
        return ground3Id;
    }

    public Image getGround3() {
        return ground3;
    }
    
    

    public int getTileSize() {
        return tileSize;
    }

    public static void setScrollspeed(float scrollspeed) {
        TileManager.scrollspeed = scrollspeed;
    }
    
    public static int getTileMover() {
        return tileMover;
    }
    
    
    
    
}
