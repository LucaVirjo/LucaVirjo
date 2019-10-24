package fi.tuni.tamk.tiko.virjoluca.util;

import java.util.Scanner;
/**
 * This class has different methods involving user input
 * 
 * @author Luca Virjo
 */
public class Console {
    /**
     * This method gets an integer between two values from the user
     * 
     * @param min the minimum value that the user is allowed to give
     * @param max the maximum value that the user is allowed to give
     * @param errorMessageNonNumeric the error message that is shown if the user gives a 
     * value that is not a number
     * @param errorMessageNonMinAndMax the error message that is shown if the user gives 
     * a value that is larger than the maximum or smaller than the minimum
     * @return the number that is given by the user and acceted by the method
     */
    public static int readInt(int min, int max, String errorMessageNonNumeric, String errorMessageNonMinAndMax) {   
        Scanner s = new Scanner(System.in);
        while(true) {
            try {
                int input = Integer.parseInt(s.nextLine());
                if(input <= max && input >= min) {
                    return input;
                } else {
                    System.out.println(errorMessageNonMinAndMax);
                }
            } catch(NumberFormatException e) {
                System.out.println(errorMessageNonNumeric);
            }
        }
    }
    /**
     * This method asks the user to choose one of two options and returns the result
     * 
     * @param option1 the first option for the user
     * @param option2 the second option for the user
     * @param question the question to be asked from the user
     * @param errorMessageNotAnOption the error message for when the user inputs something that is not an option
     * @return the boolean value true if the user picks option1 and false if the user picks option2
     */
    public static boolean twoOptions(String option1, String option2, String question, String errorMessageNotAnOption) {
        Scanner s = new Scanner(System.in);
        boolean inputOk = false;
        boolean answer;
        String input = "";
        while(!inputOk) {
            System.out.println(question);
            System.out.println("\"" + option1 + "\" / \"" + option2 + "\"");
            input = s.nextLine();
            if(input.equals(option1) || input.equals(option2)) {
                inputOk = true;
            } else {
                System.out.println(errorMessageNotAnOption);
            }
        }
        if(input.equals(option1)) {
            return true;
        } else {
            return false;
        }
    }
}
