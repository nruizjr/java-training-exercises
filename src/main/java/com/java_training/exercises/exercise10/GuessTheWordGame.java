package com.java_training.exercises.exercise10;

import java.util.Scanner;

public class GuessTheWordGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = {"raspberry", "watermelon", "nostalgia", "hieroglyphics", "serendipity", 
        		"labyrinth", "accommodate", "euphoria", "pneumonia", "kaleidoscope"};
        String word = words[(int) (Math.random() * words.length)];

        char[] secretWord = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
        	secretWord[i] = '_';
        }

        int maxAttempts = 5;
        int attempts = 0;

        System.out.println("Welcome to the game, player!");
        System.out.println("Guess the letters to reveal the secret word.");
        System.out.println("You have " + maxAttempts + " attempts.");

        boolean gameEnded = false;
        
        while (!gameEnded) {
	        try {        	
                System.out.print("\nSecret word: ");
                for (char character : secretWord) {
                    System.out.print(character + " ");
                }
                System.out.println();
                System.out.print("Enter a letter: ");
                char guess = scanner.nextLine().charAt(0);

                boolean correctGuess = false;

                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guess) {
                    	secretWord[i] = guess;
                        correctGuess = true;
                    }
                }

                if (correctGuess) {
                    System.out.println("Correct guess!");
                } else {
                    attempts++;
                    System.out.println("\u001B[31;1mIncorrect guess! Attempts remaining: " + (maxAttempts - attempts));
                    System.out.print("\u001B[0m");
                }

                if (attempts == maxAttempts) {
                    System.out.println("\nYou lost! The secret word was: " + word);
                    gameEnded = true;
                }

                if (String.valueOf(secretWord).equals(word)) {
                    System.out.println("\nCongratulations! You guessed the word: " + word);
                    gameEnded = true;
                }	            
	        } catch (Exception ex) {
	        	System.err.println("Invalid input. Please try again");
	        }
        }        

        scanner.close();
    }
}

