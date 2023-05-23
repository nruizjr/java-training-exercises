package com.java_training.exercises.exercise5;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.java_training.exercises.exercise5.DAO.GroceryItemDAOImpl;

public class MainClass {
	static final String BACK_MAINMENU_MSG = "\nGo back to main menu (Y/N)? ";
	static final String EXIT_MSG = "Application has exited. Thank you.";
	static final String REPURCHASE_ANOTHER = "\nPurchase another item (Y/N)? ";
	
	static DecimalFormat df = new DecimalFormat("0.00");
	
	static Connection conn;
	static GroceryItemDAOImpl dao;
	
	public static void main(String[] args) throws SQLException {
		
		DatabaseConnectionManager dcm = new DatabaseConnectionManager();
		Connection conn = dcm.connect();
		if (conn != null) {
			if (dcm.initializeDatabase(conn)) {
				dao = new GroceryItemDAOImpl(conn);
				startMenu(dao);
			}
			
		} else {
			System.err.println(EXIT_MSG);
		}
	}
	
	private static void startMenu(GroceryItemDAOImpl dao) throws SQLException {

		List<GroceryItem> groceries = dao.getAllGroceries();
		dao.emptyPurchaseCart();
		
		//prints the list objects in tabular format
		System.out.println("==================================================");
		System.out.println("                   GROCERY LIST                   ");
		System.out.println("==================================================");
		System.out.printf("%5s %15s %10s %15s", "ID", "PRODUCT", "PRICE", "DISCOUNT (%)");
		System.out.println();
		System.out.println("==================================================");
		
		//iterates over the list of groceries
		for(GroceryItem grocery: groceries)  
		{  
			System.out.format("%5s %15s %10s %10s", grocery.getId(), grocery.getProductName(), df.format(grocery.getPrice()), 
					grocery.getDiscount());
			System.out.println();
		}
		System.out.println("==================================================");
		purchaseItem();
		
	}
	
	public static void purchaseItem() {
		int option;
		int quantityInput;
		String tryAgain = "Y";
		
		GroceryItem selectedGrocery;
		
		try (Scanner input = new Scanner(System.in)) {
			while (tryAgain.equals("Y"))
			{
				System.out.print("\nSelect ID of product you want to purchase: ");
				option = input.nextInt();
				selectedGrocery = dao.getGroceryItemById(option);
				
				System.out.print("Input quantity of " + selectedGrocery.getProductName() +  " to purchase: ");
				quantityInput = input.nextInt();
				
				if (quantityInput > 0) {				
					addItemToPurchaseList(selectedGrocery, quantityInput);
				} else {
					System.err.println("Invalid input. " + EXIT_MSG);
				}
				System.out.print(REPURCHASE_ANOTHER);
				tryAgain = input.next().toUpperCase();
				if (!tryAgain.equals("Y")) {
					printReceipt();
				}
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InputMismatchException e) {
			System.err.println("Invalid input: " + EXIT_MSG);
		} 
	}
	
	private static void addItemToPurchaseList(GroceryItem grocery, int quantity) throws SQLException {
		grocery.setQuantity(quantity);
		grocery.setAmount(computeAmount(grocery));
		dao.addToPurchaseCart(grocery);
	}

	private static double computeAmount(GroceryItem grocery) {
		double amount = 0;
		double discountInDecimal = (double)grocery.getDiscount() / 100;
		amount = (grocery.getPrice() - (grocery.getPrice() * discountInDecimal)) * grocery.getQuantity();
		return amount;
	}
	
	private static double computeTotalAmount(List<GroceryItem> groceries) {
		double totalAmount = 0;
		
		for (GroceryItem grocery: groceries) {
			totalAmount += grocery.getAmount();
		}
		
		return totalAmount;
	}
	
	private static void printReceipt() {
		List<GroceryItem> purchaseList = dao.getAllPurchaseList();
		
		//prints the list objects in tabular format
		System.out.println();
		System.out.println("==============================================================================");
		System.out.println("                                 PURCHASE CART                                ");
		System.out.println("==============================================================================");
		System.out.printf("%5s %15s %10s %15s %13s %13s", "ID", "PRODUCT", "PRICE", "DISCOUNT (%)", "QUANTITY", "AMOUNT");
		System.out.println();
		System.out.println("==============================================================================");
		
		//iterates over the list of groceries
		for(GroceryItem grocery: purchaseList)  
		{  
			System.out.format("%5s %15s %10s %10s %14s %17s", grocery.getId(), grocery.getProductName(), df.format(grocery.getPrice()), 
					grocery.getDiscount(), grocery.getQuantity(), df.format(grocery.getAmount()));
			System.out.println();
		}
		System.out.println("==============================================================================");
		System.out.format("%64s %11s", "TOTAL AMOUNT", df.format(computeTotalAmount(purchaseList)));
		
	}
}
