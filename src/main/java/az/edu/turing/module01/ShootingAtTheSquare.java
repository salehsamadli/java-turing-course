package az.edu.turing.module01;

import java.util.Random;
import java.util.Scanner;

public class ShootingAtTheSquare {

    public static void main(String[] args) {
        final int GRID_SIZE = 10;
        final int SQUARE_SIZE = 3;

        Scanner scanner = new Scanner(System.in);

        Random random = new Random();

        int squareX = random.nextInt(GRID_SIZE - SQUARE_SIZE + 1);
        int squareY = random.nextInt(GRID_SIZE - SQUARE_SIZE + 1);

        System.out.println("Welcome to 'Shooting at the Square'!");
        System.out.println("Try to shoot at the square hidden on a " + GRID_SIZE + "x" + GRID_SIZE + " grid.");
        System.out.println("The square is " + SQUARE_SIZE + "x" + SQUARE_SIZE + " in size.");

        int shotX, shotY;

        while (true) {
            System.out.print("Enter your shot coordinates (x y): ");
            try {
                String input = scanner.nextLine();
                String[] parts = input.split(" ");
                shotX = Integer.parseInt(parts[0]);
                shotY = Integer.parseInt(parts[1]);

                if (shotX < 0 || shotX >= GRID_SIZE || shotY < 0 || shotY >= GRID_SIZE) {
                    System.out.println("Invalid coordinates. Please enter values between 0 and " + (GRID_SIZE - 1) + ".");
                    continue;
                }

                if (shotX >= squareX && shotX < squareX + SQUARE_SIZE && shotY >= squareY && shotY < squareY + SQUARE_SIZE) {
                    System.out.println("Congratulations! You hit the square.");
                    break;
                } else {
                    System.out.println("Missed! Try again.");
                }

            } catch (Exception e) {
                System.out.println("Invalid input. Please enter two integers separated by a space.");
            }
        }

        scanner.close();
    }
}
