/**
 * @author Mr. Rasmussen
 */

package fracCalc;
import java.util.*;
public class FracCalc {
	
	static int iwhole1;
	static int iwhole2;
	static int inumer1;
	static int inumer2;
	static int idenom1;
	static int idenom2;
	static int recip;
	
    public static void main(String[] args) {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	Scanner in = new Scanner(System.in);
    	System.out.println("Welcome to the fraction calculator");
    	System.out.println("Underscore divides numbers and their fractions for example 1_1/2");
    	System.out.println("Spaces divide different numbers for example 1 + 2_1/2");
    	System.out.print("Enter an expression: ");
    	String input = in.nextLine();
    	produceAnswer(input);
    	//System.out.println(produceAnswer(input));
    	in.close();
    }
    //public static int combine() {
    	
    //}

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
    	String whole1 = "**";
    	String numer1 = "**";
    	String denom1 = "**";
    	if ( first.indexOf("_") > 0 || first.indexOf("/") > 0) {
    		if ( first.indexOf("_") > 0 ) {
	    		whole1 = first.substring(0, first.indexOf("_"));
	    		numer1 = first.substring(first.indexOf("_") + 1, first.indexOf("/"));
	    		denom1 = first.substring(first.indexOf("/") + 1, first.length());
    		} else if (first.indexOf("/") > 0) {
    			whole1 = "0";
    			numer1 = first.substring(0, first.indexOf("/"));
    			denom1 = first.substring(first.indexOf("/") + 1, first.length());
    		}
    	} else {
    		whole1 = first;
    		numer1 = "0";
    		denom1 = "1";
    	}
    	String whole2 = "**";
    	String numer2 = "**";
    	String denom2 = "**";
    	if ( last.indexOf("_") > 0 || last.indexOf("/") > 0) {
    		if ( last.indexOf("_") > 0) {
	    		whole2 = last.substring(0, last.indexOf("_"));
	    		numer2 = last.substring(last.indexOf("_") + 1, last.indexOf("/"));
	    		denom2 = last.substring(last.indexOf("/") + 1, last.length());
    		} else if ( last.indexOf("/") > 0) {
    			whole2 = "0";
    			numer2 = last.substring(0, last.indexOf("/"));
    			denom2 = last.substring(last.indexOf("/") + 1, last.length());
    		}
    	} else {
    		whole2 = last;
    		numer2 = "0";
    		denom2 = "1";
    		
    	}
    	
    	//parsing strings to integers after separating the fractions and whole numbers
    	
    	iwhole1 = Integer.parseInt(whole1);
    	iwhole2 = Integer.parseInt(whole2);
    	inumer1 = Integer.parseInt(numer1);
    	inumer2= Integer.parseInt(numer2);
    	idenom1 = Integer.parseInt(denom1);
    	idenom2 = Integer.parseInt(denom2);
    	
    	//combine(iwhole1, iwhole2, inumer1, inumer2, idenom1, idenom2);
    	
    	String check2 = "whole:" + iwhole2 + " numerator:" + inumer2 + " denominator:" + idenom2;

    	return check2;
    	//return number;
    }
}
