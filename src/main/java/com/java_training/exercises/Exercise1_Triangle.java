package com.java_training.exercises;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercise1_Triangle {
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
			
			String menu = "==== Exercise 1 - Triangle ===="
			        + "\n(A) Calculate the hypotenuse (Pythagorean Theorem)"
			        + "\n(B) Calculate the area of triangle"
			        + "\nSelect an option to compute: ";

			System.out.print(menu);
			option = input.next();
			if (option.equalsIgnoreCase("A") || option.equalsIgnoreCase("B")) {
				validOption = true; 
			}
			
			while (!validOption) {
				if (option.equalsIgnoreCase("A") || option.equalsIgnoreCase("B")) {
					validOption = true;
				} else {
					System.out.print("Invalid option. Please select correct option: ");
					option = input.next();
				}
			}
			
			switch(option.toUpperCase()) {
				case "A": calculateHypotenuse();
							break;
				case "B": calculateArea();
							break;
				default:
					break;
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	private static void calculateHypotenuse() {
		try (Scanner input = new Scanner(System.in)) {
			double side1;
			double side2;
			double hypotenuse;
			String tryAgain = "Y";
			
			System.out.println("\n=== Calculate Hypotenuse ===");
			while (tryAgain.equals("Y")) {
				System.out.print("\nEnter value for Side 1: ");
				side1 = input.nextDouble();
				System.out.print("Enter value for Side 2: ");
				side2 = input.nextDouble();
				
				hypotenuse = Math.sqrt((side1 * side1) + (side2 * side2));
				System.out.print("\nYour triangle's hypotenuse is: " + df.format(hypotenuse));
				System.out.print(TRY_AGAIN_MSG);
				tryAgain = input.next().toUpperCase();
			}
			
			System.out.print(BACK_MAINMENU_MSG);
			if (input.next().equalsIgnoreCase("Y")) {
				startMenu();
			} else {
				System.out.println(EXIT_MSG);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	private static void calculateArea() {
		try (Scanner input = new Scanner(System.in)) {
			double base;
			double height;
			double area;
			String tryAgain = "Y";
			
			System.out.println("\n=== Calculate Area of Triangle ===");
			while (tryAgain.equals("Y")) {
				System.out.print("\nEnter value for base: ");
				base = input.nextDouble();
				System.out.print("Enter value for height: ");
				height = input.nextDouble();
				
				area = (base * height)/2;
				System.out.print("\nYour triangle's area is: " + df.format(area));
				System.out.print(TRY_AGAIN_MSG);
				tryAgain = input.next().toUpperCase();
			}
			System.out.print(BACK_MAINMENU_MSG);
			if (input.next().equalsIgnoreCase("Y")) {
				startMenu();
			} else {
				System.out.println(EXIT_MSG);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
