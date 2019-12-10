/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.*;

public class FracCalc {

	public static void main(String[] args) {
		// Taking user input and using their input as parameter to calculate
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to the fraction calculator");
		System.out.println("Underscore divides numbers and their fractions for example 1_1/2");
		System.out.println("Spaces divide different numbers for example 1 + 2_1/2");
		System.out.print("Enter an expression or \"quit\": ");
		boolean running = true;
		while ( running ) {
			String input = in.nextLine();
			if (input.equals("quit")) {
				running = false;
			} else {
				System.out.println(produceAnswer(input));
			}
		}
		System.out.println("quit");
		in.close();
	}

	public static String produceAnswer(String input) {
		// Running the user input through multiple methods to pull out and parse certain
		// parts of the string
		int space1 = input.indexOf(" ");
		String first = input.substring(0, space1);
		char op = input.charAt(space1 + 1);
		String last = input.substring(space1 + 3);
		int sign1 = getSign(first);
		int sign2 = getSign(last);
		int whole1 = getWhole(first, sign1);
		int whole2 = getWhole(last, sign2);
		int numer1 = getNumer(first, sign1);
		int numer2 = getNumer(last, sign2);
		int denom1 = getDenom(first);
		int denom2 = getDenom(last);

		// Converting all the numbers into improper fractions
		numer1 = sign1 * getImproper(whole1, numer1, denom1);
		numer2 = sign2 * getImproper(whole2, numer2, denom2);
		// Combining the integers and changing it back to a String
		String combined = "";
		if (op == '+') {
			combined = add(numer1, numer2, denom1, denom2);
		} else if (op == '-') {
			numer2 = -numer2;
			combined = add(numer1, numer2, denom1, denom2);
			System.out.println(combined);
		} else if (op == '*') {
			combined = multiply(numer1, numer2, denom1, denom2);
		} else if (op == '/') {
			if (numer2 < 0) {
				numer2 = -numer2;
				denom2 = -denom2;
			}
			combined = multiply(numer1, denom2, denom1, numer2);
		}
		// Getting sign of the number (positive or negative) and adding to front of String
		int sign = getSign(combined);
		int numer = getNumer(combined, sign);
		int denom = getDenom(combined);
		String result = simplify(sign, numer, denom);
		return result;
	}
	//
	public static int getSign(String whole) {
		if (whole.charAt(0) != '-') {
			return 1;
		} else {
			return -1;
		}
	}

	public static int getWhole(String in, int sign) {
		int start = 0;
		if (sign == -1) {
			start = 1;
		}
		if (in.contains("_")) {
			return Integer.parseInt(in.substring(start, in.indexOf("_")));
		} else if (in.contains("/")) {
			return 0;
		} else {
			return Integer.parseInt(in.substring(start, in.length()));
		}
	}

	public static int getNumer(String in, int sign) {
		int start = 0;
		int end = in.indexOf("/");
		if (sign == -1) {
			start = 1;
		}
		if (in.contains("_")) {
			start = in.indexOf("_") + 1;
			return Integer.parseInt(in.substring(start, end));
		} else if (in.contains("/")) {
			return Integer.parseInt(in.substring(start, end));
		} else {
			return 0;
		}
	}

	public static int getDenom(String in) {
		if (in.contains("/")) {
			return Integer.parseInt(in.substring(in.indexOf("/") + 1, in.length()));
		} else {
			return 1;
		}
	}

	public static int getImproper(int whole, int numer, int denom) {
		return whole * denom + numer;
	}

	public static String add(int n1, int n2, int d1, int d2) {
		int n = (n1 * d2) + (n2 * d1);
		int d = d1 * d2;
		return n + "/" + d;
	}

	public static String multiply(int n1, int n2, int d1, int d2) {
		int n = n1 * n2;
		int d = d1 * d2;
		return n + "/" + d;
	}

	public static String simplify(int sign, int n, int d) {
		int whole = n / d;
		n = n % d;
		for (int i = 2; i <= n; i++) {
			while (n % i == 0 && d % i == 0) {
				n /= i;
				d /= i;
			}
		}
		String sign_str = "";
		if (sign == -1) {
			sign_str = "-";
		}
		if (whole != 0) {
			if (n > 0) {
				return sign_str + whole + "_" + n + "/" + d;
			} else {
				return sign_str + whole;
			}
		} else {
			if (n != 0) {
				return sign_str + n + "/" + d;
			} else {
				return "0";
			}			
		} 
	}
}
