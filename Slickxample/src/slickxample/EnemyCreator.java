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
    private int rngLessener;

    public EnemyCreator() {
    }

    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        screenWidth = container.getWidth();
    }

    public ArrayList<Entity> spawnEnemies(int lvl, float difficulty){
        
        switch(lvl){
            case 1:
                return spawnEnemieslvl1(difficulty);
            default: return null;
        }
    }
    
    public ArrayList<Entity> spawnEnemieslvl1(float difficulty) {
        int random = RandomTool.getRandom().nextInt(40 - rngLessener) + rngLessener;
        if (random >= 0 && random <= 32) {
            rngLessener += 5;
            return null;
        }
        if (random >= 33 && random <= 33) {
            rngLessener = 0;
            return lvl1_1(difficulty);
        }
        if (random >= 34 && random <= 34) {
            rngLessener = 0;
            return lvl1_4(difficulty);           
        }
        if (random >= 35 && random <= 35) {
            rngLessener = 0;
            return lvl1_5(difficulty);
        }
        if (random >= 36 && random <= 38) {
            rngLessener = 0;
            return lvl1_3(difficulty);
        }
        if(random >= 39 && random <= 39){
            rngLessener = 0;
            return lvl1_2(difficulty);
        }
        return null;
    }

    private ArrayList<Entity> lvl1_1(float difficulty) {
        ArrayList<Entity> list = new ArrayList<>();
        int xPosMover = RandomTool.getRandom().nextInt(screenWidth - 100);
        for (int y = 0; y < 3; y++) {
            list.add(new Zombie(xPosMover + getXPos(y*3), getYPos(), difficulty));
        }
        return list;
    }

    private ArrayList<Entity> lvl1_2(float difficulty) {
        ArrayList<Entity> list = new ArrayList<>();
        int xPosMover = RandomTool.getRandom().nextInt(screenWidth - 100);
        for (int y = 0; y < 8; y++) {
            list.add(new Zombie(xPosMover + getXPos(y), getYPos(), difficulty));
        }
        return list;
    }
    
    private ArrayList<Entity> lvl1_3(float difficulty) {
        ArrayList<Entity> list = new ArrayList<>();
        int xPosMover = RandomTool.getRandom().nextInt(screenWidth - 100);
        for (int y = 0; y < 3; y++) {
            list.add(new SkeletonMage(xPosMover + getXPos(y * 3), getYPos(), difficulty));
        }
        return list;
    }
    
    private ArrayList<Entity> lvl1_4(float difficulty) {
        ArrayList<Entity> list = new ArrayList<>();
        for (int y = 0; y < 3; y++) {
            list.add(new Zombie(-40, 200 + getYPos(y*3), difficulty));
        }
        return list;
    }
    
    private ArrayList<Entity> lvl1_5(float difficulty) {
        ArrayList<Entity> list = new ArrayList<>();
        for (int y = 0; y < 3; y++) {
            list.add(new Zombie(815, 200 + getYPos(y*3), difficulty));
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
    
    private int getYPos(int number) {
        int result = -15 * number - RandomTool.getRandom().nextInt(16);
        return result;
    }

}
