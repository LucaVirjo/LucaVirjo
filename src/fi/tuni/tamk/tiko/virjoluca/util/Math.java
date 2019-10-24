package fi.tuni.tamk.tiko.virjoluca.util;
/**
 * The Math class containts methods to complete basic mathematic tasks
 * 
 * @author Luca Virjo
 */
public class Math {
    /**
     * The getRandom class returns a random value between a given minimum and maximum
     * 
     * @param min the lowest value that the method can return
     * @param max the largest value that the method
     * @return a random integer between the min and max values
     */
    public static int getRandom(int min, int max) {
        return min + (int) (java.lang.Math.random() * ((max - min) + 1));
    }
}
