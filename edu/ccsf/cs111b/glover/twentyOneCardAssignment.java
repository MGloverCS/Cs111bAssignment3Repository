
//package (default package); //Assigns Java file to appropriate package
package edu.ccsf.cs111b.glover; //Assigns Java file to appropriate package

import java.util.Scanner; //Imports scanner in order for code to accept inputs.
import java.lang.String; //Imports String data type.

public class twentyOneCardAssignment { // Declares class of program
	public static void main(String[] args) { // Declares main function

		// Creates the initial 1-dimensional array of 21 consecutive integers (1 to 21).
		int[] deck = new int[21];
		for (int i = 0; i < 21; i++) {
			deck[i] = i + 1;
		}

		// Prints out 1-dimensional array of 21 consecutive integers. Not in columns
		// yet, but as a simple list.
		System.out.print(deck[0]);
		for (int i = 1; i < deck.length; i++) {
			System.out.print(", " + deck[i]);
		}

		System.out.print("\nPick a number from 1 to 21. Remember it for yourself, but don't tell me!"); // Program asks
																										// user to
																										// remember a
																										// number from 1
																										// to 21 for
																										// themselves
		Scanner scan = new Scanner(System.in); // Sets scanner input as an int
		System.out.print("\nEnter \"0\" to start trick : "); // User inputs "0" to start trick.
		int n = scan.nextInt();
		while (n != 0) { // If user input is not 0, while loop engages, and asks user to input 0.
			System.out.print("ERROR: Enter \"0\" to start : \t"); // Error message. User is asked for new input.
			n = scan.nextInt(); // New input
		}

		for (int i = 0; i < 3; i++) { // For loop repeats user input, shuffling, and display process of program three
										// times.
			displayDeck(deck); // Calls display function of program.
			scan = new Scanner(System.in);
			System.out.print("Is your number in column 1, 2, or 3?: \t"); // Program asks user to inputs which column
																			// their number is in.
			int userColumn = scan.nextInt(); // User inputs which column their number is in.
			while (userColumn > 3 || userColumn < 1) { // While loop engages if user inputs integer other than 1, 2, or
														// 3.
				System.out.print("ERROR: Invalid number: \t"); // Error message
				userColumn = scan.nextInt(); // User inputs valid number
			}
			userColumn--; // User input will be number from 1 to 3. However, actual column numbering
							// starts at 0. Thus, it is necessary to subtract 1 from user input.
			deck = pickup(deck, userColumn); // New deck is created using the pickup function. Pickup function accepts
												// old deck array, as well as the above user input, "userColumn", as
												// parameters.
		}
		displayDeck(deck); // displayDeck function accepts deck array values as parameter

		System.out.print("Is your number " + deck[10] + "? (Enter \"y\" for \"yes\", or \"n\" for \"no\"): \t"); // User
																													// asked
																													// if
																													// element
																													// 10
																													// of
																													// deck
																													// array
																													// is
																													// there
																													// number.
																													// User
																													// inputs
																													// "y"
																													// to
																													// confirm,
																													// or
																													// "n"
																													// to
																													// deny.
		char finalInput = scan.next().charAt(0); // Calls char scan.
		if (finalInput == 'y') {
			System.out.print("Yay! I'm always right!");
		} else {
			System.out.print("CHEATER! I'm always right!");
		}
		scan.close(); // Closes scanner.
	}

	// pickup function places column that user indicates contains their number into
	// middle of array.
	public static int[] pickup(int[] deck, int userColumn) {
		int[] newDeck = new int[deck.length]; // newDeck acts as temporary array for the pickup function.
		int selectedIndex = 7; // Initial index location for user selected column is set as 7 (the middle of
								// the array) in newDeck.
		int unselectedIndex = 0; // Initial index location for columns not selected by user is set as 0 (first
									// position of array) in newDeck.
		for (int i = 0; i < deck.length; i++) { // For statement begins populating newdeck, in appropriate order, from
												// elements already in deck.
			// If i % 3 equals the column value the user has inputed, then it will be added
			// to the middle of the new array, or "deck".
			if (i % 3 == userColumn) {
				newDeck[selectedIndex++] = deck[i];
				// If the i % 3 value is not equal to the user chosen column value, then said
				// value will be added to either the beginning or last 1/3 of the array.
			} else {
				newDeck[unselectedIndex++] = deck[i];
				// If statement causes for statement to skip over middle of array, in order to
				// only populate the beginning and end of array.
				if (unselectedIndex == 7) {
					unselectedIndex = 14;
				}
			}
		}

		return newDeck; // pickup function returns newly shuffled array.
	}

	// displayDeck function displays the 1-dimensional array that contains the
	// numbers in the deck, as three columns.
	public static void displayDeck(int[] deck) {
		System.out.print("\n");

		for (int i = 0; i < deck.length; i++) {
			System.out.print("\t");
			if ((i + 1) % 3 != 0) {
				System.out.print(deck[i] + ", ");

			} else {
				System.out.println(deck[i]);
			}
		}
	}
}
