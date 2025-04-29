import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Random rm = new Random();

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("=====================================");

        boolean playAgain = true;

        while (playAgain) {
            System.out.print("\nEnter the range of numbers (e.g., 1-100): ");
            int lowerBound = kb.nextInt();
            int upperBound = kb.nextInt();

            System.out.print("Enter the maximum number of attempts: ");
            int maxAttempts = kb.nextInt();

            int randomNumber = rm.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;
            boolean isGuessed = false;

            System.out.println("\nI have picked a random number between " + lowerBound + " and " + upperBound + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess it. Good luck!");

            while (attempts < maxAttempts) {
                System.out.print("\nEnter your guess: ");
                int guess = kb.nextInt();
                attempts++;

                if (guess == randomNumber) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    isGuessed = true;
                    break;
                } else if (guess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                System.out.println("Attempts left: " + (maxAttempts - attempts));
            }

            if (!isGuessed) {
                System.out.println("\nSorry, you've used all your attempts. The correct number was " + randomNumber + ".");
            }

            System.out.print("\nDo you want to play again? (yes/no): ");
            String response = kb.next();
            playAgain = response.equalsIgnoreCase("yes");
        }
          kb.close();
        System.out.println("\nThank you for playing the Number Guessing Game!");
    }
}
