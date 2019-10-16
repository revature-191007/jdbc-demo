package com.revature.views;

import com.revature.util.ScannerUtil;

public class MainMenu implements View {

	public void printMenu() {
		System.out.println("1. Manage Users");
		System.out.println("2. Manage Teams");
		System.out.println("0. Quit");
	}
	
	public View process() {
		printMenu();
		int selection = ScannerUtil.getInput(2);
		
		switch(selection) {
			case 0: return null;
			case 1: return new UserMenu();
			case 2: return new TeamMenu();
			default: return null;
		}
	}

}
