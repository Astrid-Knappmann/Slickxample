/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slickxample;

import java.util.Random;

/**
 *
 * @author Patrick
 */
public class RandomTool {
    
    private static Random random;
    
    public static Random getRandom(){
        if(random == null){
            random = new Random();
        }
        return random;
    }
    
}
