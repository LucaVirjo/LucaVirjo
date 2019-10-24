package fi.tuni.tamk.tiko.virjoluca.util;

/**
 * This class has methods that have to do with processing integers
 * 
 * @author Luca Virjo
 */
public class Integers {
    /**
     * This method formats an integer to a string that has spaces between groups of numbers
     * 
     * @param integer the integer to be formatted
     * @param groupSize the size of a group of numbers
     * @return a string that contains the original integer formatted to have spaces between groups of numbers
     */
    public static String formatIntToString (int integer, int groupSize) {
        String number = Integer.toString(integer);
        String formatted = "";
        int spacing = 0;
        for(int i = number.length() - 1; i >= 0; i--) {
            formatted = number.charAt(i) + formatted;
            spacing++;
            if(spacing == groupSize && i != 0) {
                formatted = " " + formatted;
                spacing = 0;
            }
        }
        return formatted;
    }
    /**
     * This method formats integers to a given length by adding a given character to it's beginning
     * 
     * @param integer the integer to format
     * @param size the amount of characters that the integer will be after formatting
     * @param fill the character to be added to the integer
     * @return the original integer in the given length in string
     */
    public static String formatIntToWEqualLength(int integer, int size, char fill) {
        String number = Integer.toString(integer);
        for(int i = 0; i < size - number.length(); i++) {
            number = fill + number;
        }
        return number;
    }
}
