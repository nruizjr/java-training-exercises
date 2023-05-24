package com.java_training.exercises.exercise8;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

import com.java_training.exercises.exercise5.DatabaseConnectionManager;
import com.java_training.exercises.exercise7.OrderItem;
import com.java_training.exercises.exercise7.DAO.OrderItemDAOImpl;

public class MainClass {
	


	static DecimalFormat df = new DecimalFormat("#.##");
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
		System.out.println("             EXERCISE 8 - FILTER QUERY            ");
		System.out.println("==================================================");
		System.out.println("\nRegions [West, Central, East]");
		
		input = new Scanner(System.in);
		String region = "";
		boolean validInput = false;
		try {
			while (!validInput) {
				System.out.print("Please enter chosen region: ");
				region = input.nextLine().toLowerCase();
				if (isValidInput(region)) {
					validInput = true;
				} else {
					System.err.print("Input is invalid. ");					
				}
			}
			printFilteredOrders(region);
		} catch (Exception ex) {
			System.out.println("An exception has occured: " + ex.getMessage());
			System.out.println(EXIT_MSG);
		}
	}
	
	private static boolean isValidInput(String region) {
		boolean flag = false;
		if (!region.isEmpty() || region.equalsIgnoreCase("central") || 
				region.equalsIgnoreCase("east") || region.equalsIgnoreCase("west")) {
			flag = true;
		}
		return flag;
	}
	
	private static void printFilteredOrders(String region) throws SQLException {
		String tryAgain;
		List<OrderItem> orders = dao.getOrdersByRegion(region);
		
		if (orders != null) {
			//prints the order item in tabular format
			System.out.println();
			System.out.println("======================================================================================================");
			System.out.println("                                               ORDER ITEM                                             ");
			System.out.println("======================================================================================================");
			System.out.printf("%7s %15s %12s %11s %12s %11s %13s %10s", "CODE", "ORDER DATE", "REGION", "REP", "ITEM", 
					"UNITS", "UNIT COST", "TOTAL");
			System.out.println();
			System.out.println("======================================================================================================");
			
			for(OrderItem order: orders)  
			{  
				System.out.format("%7s %15s %12s %12s %12s %8s %12s %13s", order.getCode(), order.getOrder_date(), 
						order.getRegion(), order.getRep(), order.getItem(), order.getUnits(), df.format(order.getUnit_cost()),
						df.format(order.getTotal()));
				System.out.println();
			}
			
		} else {
			System.out.println("No entry found with entered region '" + region.toUpperCase() + "'");
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
