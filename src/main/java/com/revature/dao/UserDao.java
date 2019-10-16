package com.revature.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;
import com.revature.util.ConnectionUtil;

/**
 * User Data Access Object (DAO)
 *
 */
public class UserDao {

	/**
	 * Connection is the fundamental JDBC interface
	 * Connections are created by using DriverManager (or DataSource)
	 * Connections can be used to create instances of the Statement,
	 *  PreparedStatement and CallableStatement interfaces
	 * Statements that return results will supply an instance of the
	 * ResultSet interface.
	 * 
	 * Major Interfaces of JDBC:1
	 * 1. Connection
	 * 2. Statement
	 * 3. PreparedStatement
	 * 4. CallableStatement
	 * 5. ResultSet
	 * @return
	 */
	public List<User> getAllUsers() {
		try(Connection connection = ConnectionUtil.getConnection()) {
			Statement statement = connection.createStatement();
			String query = "SELECT * FROM employees";
			ResultSet resultSet = statement.executeQuery(query);
			
			// results (by default) only go one direction
			// you can move the result set forward by calling the .next method
			// .next returns true when it moves forward, and false if at end
			// the result set starts BEFORE the first item
			List<User> users = new ArrayList<>();
			
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String firstName = resultSet.getString("first_name");
				String salaryString = resultSet.getString("salary");
				salaryString = salaryString.substring(1).replace(",", "");
				System.out.println(salaryString);
				BigDecimal salary = new BigDecimal(salaryString);
				LocalDate startDate = resultSet.getDate("start_date")
										.toLocalDate();
				int teamId = resultSet.getInt("team_id");
				
				User user = new User(id, firstName, startDate, salary, teamId);
				users.add(user);
			}
			
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
