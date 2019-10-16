package com.revature.util;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Helper class to manage the Scanner instance and expose methods
 * that will allow me to abstract the process of getting information
 * from the user.
 *
 */
public class ScannerUtil {

	static Scanner scanner = new Scanner(System.in);
	
	public static int getInput(int max) {
		int input = -1;
		
		while(input < 0 || input > max) {
			System.out.println("Please insert an integer value between 0 and " + max);
			if(!scanner.hasNextInt()) {
				scanner.nextLine();
				continue;
			}
			input = scanner.nextInt();			
		}
		
		return input;
	}

	public static String getStringInput() {
		String input = "";
		while(input.isEmpty()) {
			input = scanner.nextLine();
//			scanner.nextLine();
		}
		return input;
	}
	
	public static double getInput(double max) {
		double input = -1;
		
		while(input < 0 || input > max) {
			System.out.println("Please insert an number value between 0 and " + max);
			if(!scanner.hasNextDouble()) {
				scanner.nextLine();
				continue;
			}
			input = scanner.nextDouble();			
		}
		
		return input;
	}
}
