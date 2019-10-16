package com.revature.util;

import java.util.Scanner;

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
}
