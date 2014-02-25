/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slickxample;

import java.util.LinkedList;
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
    private int[][] defaultMap = {
        {RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2)},
        {RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2)},
        {RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2)},
        {RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2)},
        {RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2)},
        {RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2)},
        {RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2)},
        {RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2)},
        {RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2)},
        {RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2)},
        {RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2)},
        {RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2)},
        {RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2)},
        {RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2)},
        {RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2)},
        {RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2)},
        {RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2)},
        {RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2)},
        {RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2)},
        {RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2)},
        {RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2)},
        {RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2), RandomTool.getRandom().nextInt(2)}};
    private float scroll;
    private Image water;
    private int waterId;
    private Image island;
    private int islandId;
    private int tileSize;
    private float scrollspeed;
    private LinkedList<int[]> map;
    private int[][] nextMap;
    private boolean loadNextMap = false;
    private int nextMapArrayPos = 0;
    private int mapDelta = 0;
    private int oldMapSize = 1;
    private int tileMover = 150;

    public LevelRenderer(TileManager t) {
        this.t = t;
    }

    public void init(GameContainer container, StateBasedGame game) {
        island = t.getIsland();
        water = t.getWater();
        waterId = t.getWaterTileId();
        islandId = t.getIslandTileId();
        tileSize = t.getTileSize();
        scrollspeed = t.getScrollspeed();
        map = new LinkedList<>();
        for (int[] i : defaultMap) {
            map.add(i);
        }

    }

    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        for (int y = 0; y < map.size(); y++) {
            for (int x = 0; x < map.get(y).length; x++) {
                if (map.get(y)[x] == waterId) {
                    water.draw(x * tileSize, y * tileSize + scroll + tileMover);
                } else {
                    if (map.get(y)[x] == islandId) {
                        island.draw(x * tileSize, y * tileSize + scroll + tileMover);
                    }
                }
            }
        }
    }

    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {

        scroll += scrollspeed * delta;


        if (scroll >= tileSize) {
            if (loadNextMap) {
                changeMap();
            } else {

                int[] i = map.pollLast();
                map.addFirst(i);
            }
            scroll = 0;
        }

    }

    private void changeMap() {
        if (mapDelta > 0) {
            if (nextMapArrayPos == nextMap.length - 1) {
                loadNextMap = false;
                map.addFirst(nextMap[nextMapArrayPos]);
                nextMapArrayPos = 0;
            } else {
                if (nextMapArrayPos >= oldMapSize) {
                    map.addFirst(nextMap[nextMapArrayPos]);
                    nextMapArrayPos++;
                } else {
                    map.pollLast();
                    map.addFirst(nextMap[nextMapArrayPos]);
                    nextMapArrayPos++;
                }
            }
        } else {
            if (mapDelta == 0) {
                if (nextMapArrayPos == nextMap.length - 1) {
                    loadNextMap = false;
                    map.pollLast();
                    map.addFirst(nextMap[nextMapArrayPos]);
                    nextMapArrayPos = 0;
                } else {
                    map.pollLast();
                    map.addFirst(nextMap[nextMapArrayPos]);
                    nextMapArrayPos++;
                }
            }
            if (mapDelta < 0) {
                if (nextMapArrayPos == nextMap.length - 1) {
                    loadNextMap = false;
                    map.pollLast();
                    map.addFirst(nextMap[nextMapArrayPos]);
                    nextMapArrayPos = 0;
                    for(int y = 0; y > mapDelta; y--){
                        map.pollLast();
                    }
                } else {
                    map.pollLast();
                    map.addFirst(nextMap[nextMapArrayPos]);
                    nextMapArrayPos++;
                }
            }
        }
    }

    public void loadNextMap(int[][] nextMap) {
        this.nextMap = nextMap;
        loadNextMap = true;
        nextMapArrayPos = 0;
        mapDelta = nextMap.length - map.size();
        oldMapSize = map.size();
    }
}
