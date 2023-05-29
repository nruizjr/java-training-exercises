package com.java_training.exercises.exercise7;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Scanner;

import com.java_training.exercises.exercise5.DatabaseConnectionManager;
import com.java_training.exercises.exercise7.DAO.OrderItemDAOImpl;

public class MainClass {

	static DecimalFormat df = new DecimalFormat("0.00");
	static final String EXIT_MSG = "Application has exited. Thank you.";
	static final String TRY_AGAIN_MSG = "\n\nWould you like to try again(Y/N)? ";
	
	static Connection conn;
	static OrderItemDAOImpl dao;

	static Scanner input;

	public static void main(String[] args) throws SQLException {
		DatabaseConnectionManager dcm = new DatabaseConnectionManager();
		Connection conn = dcm.connect();
		if (conn != null) {
			if (dcm.initializeDatabase(conn)) {
				dao = new OrderItemDAOImpl(conn);
				startMenu(dao);
			}
			
		} else {
			System.err.println(EXIT_MSG);
		}
	}
	
	private static void startMenu(OrderItemDAOImpl dao) throws SQLException {
		
		System.out.println();
		System.out.println("==================================================");
		System.out.println("            EXERCISE 7 - DATABASE SETUP           ");
		System.out.println("==================================================");
		
		input = new Scanner(System.in);
		String code = "";
		try {
			while (code.isEmpty()) {
				System.out.print("Please enter code: ");
				code = input.nextLine();
				if (code.isEmpty()) {
					System.err.print("Input is empty. ");
				} 
			}
			printOrderItem(code);
		} catch (Exception ex) {
			System.out.println("An exception has occured: " + ex.getMessage());
			System.out.println(EXIT_MSG);
		}
	}
	
	private static void printOrderItem(String code) throws SQLException {

		String tryAgain;
		OrderItem order = dao.getOrderItemByCode(code.toUpperCase());
		
		if (order != null) {
			//prints the order item in tabular format
			System.out.println();
			System.out.println("======================================================================================================");
			System.out.println("                                               ORDER ITEM                                             ");
			System.out.println("======================================================================================================");
			System.out.printf("%7s %15s %12s %11s %12s %11s %13s %10s", "CODE", "ORDER DATE", "REGION", "REP", "ITEM", 
					"UNITS", "UNIT COST", "TOTAL");
			System.out.println();
			System.out.println("======================================================================================================");
			
			System.out.format("%7s %15s %12s %12s %12s %8s %12s %13s", order.getCode(), order.getOrder_date(), 
					order.getRegion(), order.getRep(), order.getItem(), order.getUnits(), df.format(order.getUnit_cost()),
					df.format(order.getTotal()));
			System.out.println();
		} else {
			System.out.println("No entry found with entered code '" + code.toUpperCase() + "'");
		}
		
		System.out.print(TRY_AGAIN_MSG);
		tryAgain = input.next().toUpperCase();
		if (tryAgain.equalsIgnoreCase("Y")) {
			startMenu(dao);
		} else {
			input.close();
			System.out.println(EXIT_MSG);
		}		
	}
}
