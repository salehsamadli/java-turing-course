package az.edu.turing.module01;

import java.util.Random;
import java.util.Scanner;

public class NumbersGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Random random = new Random();

        int numberToGuess = random.nextInt(100) + 1;

        int numberOfGuesses = 0;
        int guess = 0;

        System.out.println("Welcome to the" + "numbers" + " game!");
        System.out.println("I have picked a random number between 1 and 100.");
        System.out.println("Try to guess the number!");

        while (true) {
            System.out.print("Enter your guess: ");
            try {
                guess = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            numberOfGuesses++;

            if (guess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else if (guess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the number " + numberToGuess + " in " + numberOfGuesses + " attempts.");
                break;
            }
        }
        scanner.close();
    }
}
