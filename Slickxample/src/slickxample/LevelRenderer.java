/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slickxample;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Patrick
 */
public class LevelRenderer {

    private TileManager t;
    int[] i = null;
    private int[][] map = {
        {RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10)},
        {RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10)},
        {RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10)},
        {RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10)},
        {RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10)},
        {RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10)},
        {RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10)},
        {RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10)},
        {RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10)},
        {RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10)},
        {RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10)},
        {RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10)},
        {RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10)},
        {RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10)},
        {RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10)},
        {RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10)},
        {RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10)},
        {RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10)},
        {RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10)},
        {RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10)},
        {RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10)},
        {RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10), RandomTool.getRandom().nextInt(10)}};
    private float scroll;
    private Image water;
    private int waterId;
    private Image island;
    private int islandId;
    private int tileSize;

    public LevelRenderer(TileManager t) {
        this.t = t;
    }
    
    
    public void init(GameContainer container, StateBasedGame game){
        island = t.getIsland();
        water = t.getWater();
        waterId = t.getWaterTileId();
        islandId = t.getIslandTileId();
        tileSize = t.getTileSize();
    }

    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                if (map[y][x] >= waterId) {
                    water.draw(x * tileSize, y * tileSize + scroll - 50);
                }
                if (map[y][x] == islandId) {
                    island.draw(x * tileSize, y * tileSize + scroll - 50);
                }

            }
        }
    }

    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {

        scroll += 0.1f * delta;
        if (scroll >= tileSize) {
            for (int y = map.length - 1; y > -1; y--) {

                if (y == map.length - 1) {
                    i = map[0];
                    map[0] = map[y];
                } else {
                    if (y == 0) {
                        map[y + 1] = i;
                    } else {
                        map[y + 1] = map[y];
                    }
                }
            }
            scroll = 0;

        }
    }
}
