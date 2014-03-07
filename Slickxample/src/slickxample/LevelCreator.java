/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package slickxample;

import java.util.LinkedList;

/**
 *
 * @author Patrick
 */
public class LevelCreator {

    private final int[][] defaultMap = {
        {randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile()},
        {randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile()},
        {randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile()},
        {randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile()},
        {randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile()},
        {randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile()},
        {randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile()},
        {randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile()},
        {randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile()},
        {randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile()},
        {randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile()},
        {randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile()},
        {randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile()},
        {randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile()},
        {randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile()},
        {randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile()},
        {randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile()},
        {randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile()},
        {randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile()},
        {randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile()},
        {randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile()},
        {randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile()},
        {randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile()},
        {randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile()},
        {randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile()},
        {randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile()}};
    
    
    public LevelCreator() {
    }
    
    
    
    public int[][] createLevel(){
        int random = RandomTool.getRandom().nextInt(10);
        if(random == 0){
            int[][] i = {
        {1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
            return i;
        }
        if(random > 0 && random < 10){
            int[][] i ={{randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile(), randomTile()}};
            return i;
        }
        return null;
    }
    
    public int randomTile(){
        int random = RandomTool.getRandom().nextInt(5);
        if(random == 0){
            return 0;
        }
        if(random >0 && random < 5){
            return 1;
        }
        return 0;
    }
    
    public int[][] getDefaultMap(){
        return defaultMap;
    }
    
}
