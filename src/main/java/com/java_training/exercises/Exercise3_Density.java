package com.java_training.exercises;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercise3_Density {

	static DecimalFormat df = new DecimalFormat("#.##");
	static final String TRY_AGAIN_MSG = "\n\nWould you like to try again(Y/N)? ";
	static final String BACK_MAINMENU_MSG = "\nGo back to main menu (Y/N)? ";
	static final String EXIT_MSG = "Application has exited. Thank you.";
	
	public static void main(String[] args) {
		startMenu();
	}
	
	private static void startMenu() {
		try (Scanner input = new Scanner(System.in)) {
			boolean validOption = false;
			String option;
			
			String menu = "==== Exercise 3 - Computation of Density ===="
			        + "\n(A) Compute density"
			        + "\n(B) Compute mass"
			        + "\n(C) Compute volume"
			        + "\nSelect an option to compute: ";

			System.out.print(menu);
			option = input.next();
			if (option.equalsIgnoreCase("A") || option.equalsIgnoreCase("B") || option.equalsIgnoreCase("C")) {
				validOption = true; 
			}
			
			while (!validOption) {
				if (option.equalsIgnoreCase("A") || option.equalsIgnoreCase("B") || option.equalsIgnoreCase("C")) {
					validOption = true;
				} else {
					System.out.print("Invalid option. Please select correct option: ");
					option = input.next();
				}
			}
			
			switch(option.toUpperCase()) {
				case "A": computeDensity();
							break;
				case "B": computeMass();
							break;
				case "C": computeVolume();
							break;
				default:
					break;
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	private static void computeDensity() {
		try (Scanner input = new Scanner(System.in)) {
			double mass;
			double volume;
			double density;
			String tryAgain = "Y";
			
			System.out.println("\n=== Compute Density ===");
			while (tryAgain.equals("Y")) {
				System.out.print("\nEnter value for Mass: ");
				mass = input.nextDouble();
				System.out.print("Enter value for Volume: ");
				volume = input.nextDouble();
				
				density = mass / volume;
				System.out.print("\nThe computed density is: " + df.format(density));
				System.out.print(TRY_AGAIN_MSG);
				tryAgain = input.next().toUpperCase();
			}
			
			System.out.print(BACK_MAINMENU_MSG);
			if (input.next().equalsIgnoreCase("Y")) {
				startMenu();
			} else {
				System.out.println(EXIT_MSG);
			}
		}
	}
	
	private static void computeMass() {
		try (Scanner input = new Scanner(System.in)) {
			double mass;
			double volume;
			double density;
			String tryAgain = "Y";
			
			System.out.println("\n=== Compute Density ===");
			while (tryAgain.equals("Y")) {
				System.out.print("\nEnter value for Density: ");
				density = input.nextDouble();
				System.out.print("Enter value for Volume: ");
				volume = input.nextDouble();
				
				mass = density * volume;
				System.out.print("\nThe computed mass is: " + df.format(mass));
				System.out.print(TRY_AGAIN_MSG);
				tryAgain = input.next().toUpperCase();
			}
			
			System.out.print(BACK_MAINMENU_MSG);
			if (input.next().equalsIgnoreCase("Y")) {
				startMenu();
			} else {
				System.out.println(EXIT_MSG);
			}
		}
	}
	
	private static void computeVolume() {
		try (Scanner input = new Scanner(System.in)) {
			double mass;
			double volume;
			double density;
			String tryAgain = "Y";
			
			System.out.println("\n=== Compute Volume ===");
			while (tryAgain.equals("Y")) {
				System.out.print("\nEnter value for Density: ");
				density = input.nextDouble();
				System.out.print("Enter value for Mass: ");
				mass = input.nextDouble();
				
				volume = mass / density;
				System.out.print("\nThe computed volume is: " + df.format(volume));
				System.out.print(TRY_AGAIN_MSG);
				tryAgain = input.next().toUpperCase();
			}
			
			System.out.print(BACK_MAINMENU_MSG);
			if (input.next().equalsIgnoreCase("Y")) {
				startMenu();
			} else {
				System.out.println(EXIT_MSG);
			}
		}
	}
}
