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
    private Image ground;
    private int groundId;
    private Image ground2;
    private int ground2Id;
    private Image ground3;
    private int ground3Id;
    private int tileSize;
    private float scrollspeed;
    private float mapPos = 0;
    private LinkedList<int[]> map;
    private int tileMover;
    private LevelCreator lvlCreator;
    private int extraRows;
    private EnemyManager enemyManager;
    private int currentLvl;
    private float difficulty = 1;

    public LevelRenderer(TileManager t, LevelCreator lvlCreator, EnemyManager enemyManager) {
        this.lvlCreator = lvlCreator;
        this.enemyManager = enemyManager;
        this.t = t;
    }

    public void init(GameContainer container, StateBasedGame game) {
        ground2 = t.getGround2();
        ground = t.getGround();
        groundId = t.getGroundId();
        ground2Id = t.getGround2Id();
        ground3 = t.getGround3();
        ground3Id = t.getGround3Id();
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
                    if (map.get(y)[x] == groundId) {
                        ground.draw(x * tileSize, y * tileSize + scroll + tileMover - extraRows * tileSize);
                    } else {
                        if (map.get(y)[x] == ground2Id) {
                            ground2.draw(x * tileSize, y * tileSize + scroll + tileMover - extraRows * tileSize);
                        } else {
                            if (map.get(y)[x] == ground3Id) {
                                ground3.draw(x * tileSize, y * tileSize + scroll + tileMover - extraRows * tileSize);
                            }
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
            difficulty += 0.1f;
            enemyManager.spawnEnemies(currentLvl, difficulty);
        }

        if (scroll <= tileSize * -1) {
//            int[] i = map.pollFirst();
//            map.addLast(i);
//            scroll = 0;
        }

    }

    public void reset() {
        map = new LinkedList<>();
        for (int[] i : defaultMap) {
            map.add(i);
        }
        extraRows = 0;
        mapPos = 0;
        scroll = 0;
        difficulty = 1;
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
