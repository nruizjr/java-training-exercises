package com.java_training.exercises.exercise4;

import java.util.Scanner;

public class MainPizzaClass {
	
	static final String BACK_MAINMENU_MSG = "\nGo back to main menu (Y/N)? ";
	static final String EXIT_MSG = "Application has exited. Thank you.";
	
	public static void main(String[] args) {
		startMenu();
	}
	
	private static void startMenu() {
		try (Scanner input = new Scanner(System.in)) {
			String option;
			boolean validOption = false;
			
			String menu = " ==== Exercise 4 - Pizza App ====\n"
						+ "|                                |\n"
				        + "| (A) Pepperoni Pizza            |\n"
				        + "| (B) Hawaiian Pizza             |\n"
				        + "| (C) Buffalo Pizza              |\n"
				        + "| (D) All Meat Pizza             |\n"
				        + "|                                |\n"
				        + " ================================ \n"
				        + "\nChoose a pizza to display: ";

			System.out.print("\n" + menu);

			option = input.next();
			validOption = checkValidOption(option);
			
			while (!validOption) {
				if (checkValidOption(option)) {
					validOption = true;
				} else {
					System.out.print("Invalid option. Please select correct option: ");
					option = input.next();
				}
			}
			
			switch(option.toUpperCase()) {
				case "A": displayPepperoniPizza();
							break;
				case "B": displayHawaiianPizza();
							break;
				case "C": displayBuffaloPizza();
							break;
				case "D": displayAllMeatPizza();
							break;
				default:
					break;
			}
		} catch (Exception ex) {
			System.out.println("Exception occured due to unsupported input type. Application will exit.");
		}
	}
	
	private static boolean checkValidOption(String option) {
		boolean flag = false;
		if (option.equalsIgnoreCase("A") || option.equalsIgnoreCase("B")
				|| option.equalsIgnoreCase("C") || option.equalsIgnoreCase("D")) {
			flag = true;
		}
		return flag;
	}
	
	private static void displayAllMeatPizza() {
		System.out.println("\n--- All Meat Pizza ---");
		AllMeatPizza allMeatPizza = new AllMeatPizza();
		outputPizzaDetails(allMeatPizza);
		
		backtoMenu();
	}
	
	private static void displayBuffaloPizza() {
		System.out.println("\n--- Buffalo Pizza ---");
		BuffaloPizza buffaloPizza = new BuffaloPizza();
		outputPizzaDetails(buffaloPizza);
		
		backtoMenu();
	}
	
	private static void displayHawaiianPizza() {
		System.out.println("\n--- Hawaiian Pizza ---");
		HawaiianPizza hawaiianPizza = new HawaiianPizza();
		outputPizzaDetails(hawaiianPizza);
		
		backtoMenu();
	}
	
	private static void displayPepperoniPizza() {		
		System.out.println("\n--- Pepperoni Pizza ---");
		PepperoniPizza pepperoniPizza = new PepperoniPizza();
		outputPizzaDetails(pepperoniPizza);
		
		backtoMenu();
	}
	
	private static void outputPizzaDetails(PizzaBase pizza) {
		System.out.println("Name: " + pizza.getName());
		System.out.println("Description: " + pizza.getDescription());
		System.out.println("Price: ₱" + pizza.getPrice());
		System.out.println("Ingredients: " + pizza.getIngredients());
		System.out.println("Discount: " + pizza.getDiscount() + "%");
		
	}
	
	private static void backtoMenu() {
		try (Scanner input = new Scanner(System.in)) {
			System.out.print(BACK_MAINMENU_MSG);
			if (input.next().equalsIgnoreCase("Y")) {
				startMenu();
			} else {
				System.out.println(EXIT_MSG);
			}
		}
	}
}
