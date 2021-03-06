package com.revature.views;

import com.revature.util.ScannerUtil;

public class TeamMenu implements View {
	private void printMenu() {
		System.out.println("----- Team Menu ------");
		System.out.println("1. View All Teams");
		System.out.println("2. Get Team By Id");
		System.out.println("3. Update Team");
		System.out.println("0. Back");
	}
	

	public View process() {
		printMenu();
		int selection = ScannerUtil.getInput(3);
		switch (selection) {
			case 0: return new MainMenu();
			case 1: return null;
			case 2: return null;
			case 3: return null;
			default: return null;
		}
	}
}
