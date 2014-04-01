/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slickxample;

import java.util.ArrayList;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author PK
 */
public class EnemyCreator {

    private int screenWidth;
    private Image zombieImg;

    public EnemyCreator() {
    }

    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        screenWidth = container.getWidth();
    }

    public ArrayList<Entity> spawnEnemies(int lvl){
        switch(lvl){
            case 1:
                return spawnEnemieslvl1();
            default: return null;
        }
    }
    
    public ArrayList<Entity> spawnEnemieslvl1() {
        int random = RandomTool.getRandom().nextInt(20);
        if (random >= 0 && random <= 9) {
            return null;
        }
        if (random >= 16 && random <= 18) {
            return lvl1_1();
        }
        if(random >= 19 && random <= 19){
            return lvl1_2();
        }
        return null;
    }

    private ArrayList<Entity> lvl1_1() {
        ArrayList<Entity> list = new ArrayList<>();
        int xPosMover = RandomTool.getRandom().nextInt(screenWidth - 100) + TileManager.tileSize;
        for (int y = 0; y < 3; y++) {
            list.add(new Zombie(xPosMover + getXPos(y), getYPos()));
        }
        return list;
    }

    private ArrayList<Entity> lvl1_2() {
        ArrayList<Entity> list = new ArrayList<>();
        int xPosMover = RandomTool.getRandom().nextInt(screenWidth - 100) + TileManager.tileSize;
        for (int y = 0; y < 8; y++) {
            list.add(new Zombie(xPosMover + getXPos(y), getYPos()));
        }
        return list;
    }
    
    private int getXPos(int number) {
        int result = 15 * number + RandomTool.getRandom().nextInt(16);
        return result;
    }
    
    private int getYPos(){
        return TileManager.tileMover - RandomTool.getRandom().nextInt(32);
    }

}
