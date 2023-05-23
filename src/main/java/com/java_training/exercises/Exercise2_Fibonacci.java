package com.java_training.exercises;

import java.util.Scanner;

public class Exercise2_Fibonacci {

	static final String TRY_AGAIN_MSG = "\n\nWould you like to try again(Y/N)? ";
	static final String EXIT_MSG = "Application has exited. Thank you.";
	
	public static void main(String[] args) {

		String tryAgain = "Y";
		int iterator = 0;
		int range = 0;
		int num1 = 1;
		int num2 = 2;
		
		try (Scanner input = new Scanner(System.in)) {		
			
			System.out.println("==== Exercise 2 - Fibonacci Sequence ====");

			while (tryAgain.equals("Y")) {
				iterator = 0;
				range = 0;
				num1 = 6;
				num2 = 7;
				
				System.out.print("Please enter the range: ");
				range = input.nextInt();
				
				System.out.print("\nOutput: ");
				while (iterator < range) {
					System.out.print(num1 + " ");
					
					// Swap numbers
					int num3 = num1 + num2;
					num1 = num2;
					num2 = num3;
					iterator++;
				}
				System.out.print(TRY_AGAIN_MSG);
				tryAgain = input.next().toUpperCase();
			}
			
			System.out.println(EXIT_MSG);
		} catch (Exception ex) {
			System.out.println("Exception occured due to unsupported input type. Application will exit.");
		}
	}
}
