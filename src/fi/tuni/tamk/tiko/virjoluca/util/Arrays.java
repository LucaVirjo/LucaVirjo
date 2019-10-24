package fi.tuni.tamk.tiko.virjoluca.util;

import fi.tuni.tamk.tiko.virjoluca.util.Math;
/**
 * This class includes utilities for processing arrays
 * 
 * @author Luca Virjo
 */
public class Arrays {
    /**
     * This method turns a String array into an int array
     * 
     * @param array the original String array that will be converted to int
     * @return the converted int array
     */
    public static int [] toIntArray(String [] array) {
        int[] intArray = new int[array.length];
        int index = 0;
        try {
            for(int i = 0; i < array.length; i++) {
                intArray[i] = Integer.parseInt(array[i]);
            }
        } catch(NumberFormatException e) {
            System.out.println("Array[" + index + "] cannot be converted to int");
        }
        return intArray;
    }
    /**
     * This method checks if an integer is found within an int array
     * 
     * @param value the integer that the array is being searched for
     * @param array the array that is searched
     * @return the boolean value true if the integer was found in the array, else it will return false
     */
    public static boolean contains(int value, int[] array) {
        for(int i = 0; i < array.length; i++) {
            if(value == array[i]) {
                return true;
            }
        }
        return false;
    }
    /**
     * This method checks how many values in two int arrays are the same
     * 
     * @param array1 the first array that is compared
     * @param array2 the second array that is compared
     * @return the amount of values that were found in both arrays
     */
    public static int containsSameValues(int [] array1, int [] array2) {
        int amount = 0; 
        for(int i = 0; i < array1.length; i++) {
            for(int j = 0; j < array2.length; j++) {
                if(array1[i] == array2[j]) {
                    amount++;
                }
            }
        }
        return amount;
    }
    /**
     * This method prints an int array on the command prompt
     * 
     * @param array the array to be printed
     */
    public static void print(int [] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    /**
     * This method removes an index from an array
     * 
     * @param array the array to be modified
     * @param index the index that is removed
     * @return an array that is a copy of the original, but has had one index removed
     */
    public static int[] removeIndex(int[] array, int index) {
        int[] temp = new int [array.length - 1];
        int tempIndex = 0;
        for(int j = 0; j < array.length; j++) {
            if(j != index) {
                temp[tempIndex] = array[j];
                tempIndex++;
            }
        }
        return temp;
    }
    /**
     * This method sorts an int array from the lowest value to the biggest value
     * 
     * @param array the array to be sorted
     * @return the sorted array
     */
    public static int[] sort(int[] array) {
        int smallest = array[0];
        int index = 0;
        for(int i = 0; i < array.length - 1; i++) {
            smallest = array[i];
            index = i;
            for(int j = i + 1; j < array.length; j++) {
                if(array[j] < array[index]) {
                    smallest = array[j];
                    index = j;
                }
            }
            array[index] = array[i];
            array[i] = smallest;
        }
        return array;
    }
    /**
     * This method prints an array with all the contents being the same size
     * 
     * @param array the array to be printed
     * @param size the total amount of character's that all of the contents will have, 
     * please note that the total amount of character's can't be smaller than the amount of 
     * characters in the largest integer in the array in order to have the method function properly
     * @param fill the character to be added to the contents to make them all the same size
     */
    public static void printFilled(int [] array, int size, char fill) {
        for(int i = 0; i < array.length; i++) {
            System.out.print(Integers.formatIntToWEqualLength(array[i], size, fill) + " ");
        }
        System.out.println();
    }
}
