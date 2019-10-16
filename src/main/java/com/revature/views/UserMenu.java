package com.revature.views;

import java.math.BigDecimal;
import java.util.List;

import com.revature.dao.UserDao;
import com.revature.models.User;
import com.revature.util.ScannerUtil;

public class UserMenu implements View {

	private UserDao userDao = new UserDao();
	
	private void printMenu() {
		System.out.println("----- User Menu ------");
		System.out.println("1. View All Users");
		System.out.println("2. Get Users by First Name");
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
			case 2: getUsersByFirstName(); return this;
			case 3: createUser(); return this;
			case 4: return null;
			default: return null;
		}
	}
	
	private void createUser() {
		System.out.println("Enter first name: ");
		String firstName = ScannerUtil.getStringInput();
		
		System.out.println("Enter salary: ");
		BigDecimal salary = new BigDecimal(ScannerUtil.getInput(10000.0));
		
		System.out.println("Enter team id: ");
		int teamId = ScannerUtil.getInput(5);
		
	}


	public void viewAllUsers() {
		// call dao method to get users
		List<User> users = userDao.getAllUsers();
		
		// print users
		printUserList(users);
	}
	
	public void getUsersByFirstName() {
		System.out.println("Enter first name: ");
		String firstName = ScannerUtil.getStringInput();
		List<User> users = userDao.getUsersByFirstName(firstName);
		printUserList(users);
	}

	private void printUserList(List<User> users) {
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
