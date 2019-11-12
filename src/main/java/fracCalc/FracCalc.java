/**
 * @author Mr. Rasmussen
 */

package fracCalc;
import java.util.*;
public class FracCalc {

    public static void main(String[] args) {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	Scanner in = new Scanner(System.in);
    	System.out.println("Welcome to the fraction calculator");
    	System.out.println("Underscore divides numbers and their fractions for example 1_1/2");
    	System.out.println("Spaces divide different numbers for example 1 + 2_1/2");
    	System.out.print("Enter an expression: ");
    	String input = in.nextLine();
    	
    	System.out.println(produceAnswer(input));
    	in.close();
    }

    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input) {
        // TODO: Implement this function to produce the solution to the input
    	int space1 = input.indexOf(" ");
    	String first = input.substring(0, space1);
    	String operate = input.substring(space1, space1 + 3);
    	String last = input.substring(space1 + 3);
    	int num1 = first.charAt(0);
    	int num2 = last.charAt(0);
    	//System.out.println(first);
    	//System.out.println(operate);
    	//System.out.println(last);
    	return last;
    }

    // TODO: Fill in the space below with any helper methods that you think you will need

}
