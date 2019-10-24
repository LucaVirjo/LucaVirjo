package fi.tuni.tamk.tiko.virjoluca;

import fi.tuni.tamk.tiko.virjoluca.util.*;
import fi.tuni.tamk.tiko.virjoluca.util.Math;
/**
 * This is the main class of this project
 * 
 * @author Luca Virjo
 */
public class Main {
    final static int MIN = 1; 
    final static int MAX = 40;
    final static int TICKET_SIZE = 7;
    final static String ERROR_MESSAGE_NON_NUMERIC = "The user did not give a number!";
    final static String ERROR_MESSAGE_NON_MIN_AND_MAX = "The number is not between " + MIN + " and " + MAX + "!";
    final static String GIVE_UNIQUE_NUMBER =  "Please give a unique number between " + MIN + " and " + MAX + "!";
    final static String NUMBER_MUST_BE_UNIQUE = "The number must be unique!";
    final static String ERROR_MESSAGE_NOT_AN_OPTION = "You must answer with one of the two options.";
    /**
     * This is the main method of the class
     * 
     * @param args doesn't do anything in this app
     */
    public static void main(String [] args) {
        int[] ticket = fillTicket(TICKET_SIZE, MIN, MAX);
        Arrays.sort(ticket);
        int[] lotto = new int [TICKET_SIZE];
        int best = 0;
        long weeks = 0;
        boolean win = false;
        boolean showAllInput = Console.twoOptions("Yes", "No", "Do you want to see your ticket next to the winning numbers\nevery time you get a bigger win than before?", ERROR_MESSAGE_NOT_AN_OPTION);
        while(!win) {
            lotto = calculateLotto(TICKET_SIZE, MIN, MAX);
            weeks++;
            if(Arrays.containsSameValues(ticket, lotto) > best) {
                if(showAllInput) {
                    System.out.print("\nYour numbers:        ");
                    Arrays.printFilled(ticket, 2, '0');
                    Arrays.sort(lotto);
                    System.out.print("The winning numbers: ");
                    Arrays.printFilled(lotto, 2, '0');
                    System.out.println(); 
                }
                best = Arrays.containsSameValues(ticket, lotto);
                int years = (int)(weeks / 52);
                String yearString = Integers.formatIntToString(years, 3);
                System.out.println("You got " + best + " right! It only took " + yearString + " years!");
                if(Arrays.containsSameValues(ticket, lotto) == TICKET_SIZE && years <= 120) {
                    win = true;
                } else if(Arrays.containsSameValues(ticket, lotto) == TICKET_SIZE) {
                    System.out.println("\nYou won!\nIt's still more than a lifetime though, so let's try again!\n");
                    best = 0;
                    weeks = 0;
                }
            }
        }
    }
    /**
     * This method fills a lotto ticket
     * 
     * @param size the amount of numbers that go on the lotto ticket
     * @param min the smallest number that the user can choose
     * @param max the largest number that the user can choose
     * @param errrorMessageNonNumeric the error message that is displayed if the user inputs 
     * something that is not a number
     * @param errorMessageNonMinAndMax the error message that is displayed if the user inputs 
     * a number that is either too big or too small
     * @param giveUniqueNumberMessage the message to user that asks them to input a number between min and max
     * @return a filled out ticket
     */
    private static int[] fillTicket(int size, int min, int max) {
        int[] ticket = new int [size];
        for(int i = 0; i < size; i++) {
            System.out.println(GIVE_UNIQUE_NUMBER);
            int input = Console.readInt(min, max, ERROR_MESSAGE_NON_NUMERIC, ERROR_MESSAGE_NON_MIN_AND_MAX);
            if(Arrays.contains(input, ticket)) {
                System.out.println(NUMBER_MUST_BE_UNIQUE);
                i--;
            } else {
                ticket[i] = input;
            }
        }
        return ticket;
    }
    /**
     * This method calculates a random winning lotto row
     * 
     * @param size the size of the lotto row
     * @param min the minimum value that can be in the row
     * @param max the maximum value that can be in the row
     * @return a randomized lotto row
     */
    private static int[] calculateLotto(int size, int min, int max) {
        int[] lotto = new int [size];
        int[] numbers = new int [max - min + 1];
        for(int i = 0; i < numbers.length; i++) {
            numbers [i] = min + i;
        }
        for(int i = 0; i < lotto.length; i++) {
            int index = Math.getRandom(0, numbers.length - 1);
            lotto [i] = numbers [index];
            numbers = Arrays.removeIndex(numbers, index);
        }
        return lotto;
    }
}
