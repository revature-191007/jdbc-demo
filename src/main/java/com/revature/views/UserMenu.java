package com.revature.views;

import java.util.List;

import com.revature.dao.UserDao;
import com.revature.models.User;
import com.revature.util.ScannerUtil;

public class UserMenu implements View {

	private UserDao userDao = new UserDao();
	
	private void printMenu() {
		System.out.println("----- User Menu ------");
		System.out.println("1. View All Users");
		System.out.println("2. Get User By Id");
		System.out.println("3. Create User");
		System.out.println("4. Update User");
		System.out.println("0. Back");
	}
	

	public View process() {
		printMenu();
		int selection = ScannerUtil.getInput(4);
		switch (selection) {
			case 0: return new MainMenu();
			case 1: viewAllUsers(); return this;
			case 2: return null;
			case 3: return null;
			case 4: return null;
			default: return null;
		}
	}
	
	public void viewAllUsers() {
		// call dao method to get users
		List<User> users = userDao.getAllUsers();
		
		// print users
		System.out.println("-------------------------- Users -------------------------");
		System.out.println("| id |   first name   |  salary |  start date  | team_id |");
		for(User user : users) {
			System.out.printf("| %2d | %-14s | %7s | %12s | %7d |%n", 
					user.getId(), user.getFirstName(), user.getSalary(),
					user.getStartDate(), user.getTeamId());
		}
		System.out.println("----------------------------------------------------------");

	}

}
