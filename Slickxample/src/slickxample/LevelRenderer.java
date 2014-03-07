/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slickxample;

import java.util.Iterator;
import java.util.LinkedList;
import org.newdawn.slick.Color;
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
    private int[][] defaultMap;
    private float scroll;
    private Image water;
    private int waterId;
    private Image island;
    private int islandId;
    private int tileSize;
    private float scrollspeed;
    private float mapPos = 0;
    private LinkedList<int[]> map;
    private int tileMover;
    private LevelCreator lvlCreator;
    private int extraRows;
    private EnemyManager enemyManager;
    private int currentLvl;

    public LevelRenderer(TileManager t, LevelCreator lvlCreator, EnemyManager enemyManager) {
        this.lvlCreator = lvlCreator;
        this.enemyManager = enemyManager;
        this.t = t;
    }

    public void init(GameContainer container, StateBasedGame game) {
        island = t.getIsland();
        water = t.getWater();
        waterId = t.getWaterTileId();
        islandId = t.getIslandTileId();
        tileSize = t.getTileSize();
        tileMover = t.getTileMover();
        scrollspeed = t.getScrollspeed();
        defaultMap = lvlCreator.getDefaultMap();
        currentLvl = 1;
        map = new LinkedList<>();
        for (int[] i : defaultMap) {
            map.add(i);
        }

    }

    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        for (int y = 0; y < map.size(); y++) {
            if (y * tileSize + scroll - extraRows * tileSize < container.getHeight() - tileMover && y * tileSize + scroll - extraRows * tileSize > 0 + tileMover) {
                for (int x = 0; x < map.get(y).length; x++) {
                    if (map.get(y)[x] == waterId) {
                        water.draw(x * tileSize, y * tileSize + scroll + tileMover - extraRows * tileSize);
                    } else {
                        if (map.get(y)[x] == islandId) {
                            island.draw(x * tileSize, y * tileSize + scroll + tileMover - extraRows * tileSize);
                        }
                    }
                }
            }
        }
    }

    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {

        scrollspeed = t.getScrollspeed();
        scroll += scrollspeed * delta;

        if (scroll >= tileSize) {
            if (extraRows == 0) {
                for (int[] i : lvlCreator.createLevel()) {
                    map.addFirst(i);
                    mapPos += 32;
                    extraRows++;
                }
            }
            scroll = 0;
            extraRows--;
            enemyManager.spawnEnemies(currentLvl);
        }

        if (scroll <= tileSize * -1) {
//            int[] i = map.pollFirst();
//            map.addLast(i);
//            scroll = 0;
        }

    }

//    private void changeMap() {
//        if (mapDelta > 0) {
//            if (nextMapArrayPosUp == nextMap.length - 1) {
//                loadNextMap = false;
//                map.addFirst(nextMap[nextMapArrayPosUp]);
//                nextMapArrayPosUp = 0;
//            } else {
//                if (nextMapArrayPosUp >= oldMapSize) {
//                    map.addFirst(nextMap[nextMapArrayPosUp]);
//                    nextMapArrayPosUp++;
//                } else {
//                    map.pollLast();
//                    map.addFirst(nextMap[nextMapArrayPosUp]);
//                    nextMapArrayPosUp++;
//                }
//            }
//        } else {
//            if (mapDelta == 0) {
//                if (nextMapArrayPosUp == nextMap.length - 1) {
//                    loadNextMap = false;
//                    map.pollLast();
//                    map.addFirst(nextMap[nextMapArrayPosUp]);
//                    nextMapArrayPosUp = 0;
//                } else {
//                    map.pollLast();
//                    map.addFirst(nextMap[nextMapArrayPosUp]);
//                    nextMapArrayPosUp++;
//                }
//            }
//            if (mapDelta < 0) {
//                if (nextMapArrayPosUp == nextMap.length - 1) {
//                    loadNextMap = false;
//                    map.pollLast();
//                    map.addFirst(nextMap[nextMapArrayPosUp]);
//                    nextMapArrayPosUp = 0;
//                    for (int y = 0; y > mapDelta; y--) {
//                        map.pollLast();
//                    }
//                } else {
//                    map.pollLast();
//                    map.addFirst(nextMap[nextMapArrayPosUp]);
//                    nextMapArrayPosUp++;
//                }
//            }
//        }
//    }
//    public void loadNextMap(int[][] nextMap) {
//        this.nextMap = nextMap;
//        loadNextMap = true;
//        nextMapArrayPosUp = 0;
//        nextMapArrayPosDown = nextMap.length - 1;
//        mapDelta = nextMap.length - map.size();
//        oldMapSize = map.size();
//    }
}
