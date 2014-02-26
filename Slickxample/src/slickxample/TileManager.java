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
    
    private final int waterTileId = 0;
    private final int islandTileId = 1;
    private final int tileSize = 20;
    private static float scrollspeed = 0.04f;
    private Image water;
    private Image island;

    public TileManager() {
    }
    
    public void init(GameContainer container, StateBasedGame game) throws SlickException{
        water = new Image("res/water.png");
        island = new Image("res/island.png");
    }

    public static float getScrollspeed() {
        return scrollspeed;
    }

    public Image getWater() {
        return water;
    }

    public Image getIsland() {
        return island;
    }

    public int getWaterTileId() {
        return waterTileId;
    }

    public int getIslandTileId() {
        return islandTileId;
    }

    public int getTileSize() {
        return tileSize;
    }

    public static void setScrollspeed(float scrollspeed) {
        TileManager.scrollspeed = scrollspeed;
    }
    
    
    
    
}
