import java.util.Scanner;
import java.util.Random;

public class StonePaperScissorsGame {
    public static void main(String[] args) {
        // Initialize Game
        StonePaperScissorsGame game = new StonePaperScissorsGame();
        game.start();
    }

    private final Scanner kb;
    private final Random rm;

    public StonePaperScissorsGame() {
        kb = new Scanner (System.in);
        rm = new Random();
    }

    public void start() {
        System.out.println("Welcome to Stone-Paper-Scissors Game!");
        System.out.println("======================================");

        boolean playAgain = true;

        while (playAgain) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Stone");
            System.out.println("2. Paper");
            System.out.println("3. Scissors");
            System.out.print("Your choice: ");

            int userChoice = kb.nextInt();
            if (userChoice < 1 || userChoice > 3) {
                System.out.println("Invalid choice! Please choose between 1 and 3.");
                continue;
            }

            int computerChoice = rm.nextInt(3) + 1;

            System.out.println("\nYou chose: " + getChoiceName(userChoice));
            System.out.println("Computer chose: " + getChoiceName(computerChoice));

            String result = determineWinner(userChoice, computerChoice);

            System.out.println("\n" + result);

            System.out.print("\nDo you want to play again? (yes/no): ");
            String response = kb.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("\nThank you for playing!");
    }

    private String getChoiceName(int choice) {
        return switch (choice) {
            case 1 -> "Stone";
            case 2 -> "Paper";
            case 3 -> "Scissors";
            default -> "Unknown";
        };
    }

    private String determineWinner(int userChoice, int computerChoice) {
        if (userChoice == computerChoice) {
            return "It's a tie!";
        }

        if ((userChoice == 1 && computerChoice == 3) || // Stone beats Scissors
            (userChoice == 2 && computerChoice == 1) || // Paper beats Stone
            (userChoice == 3 && computerChoice == 2)) { // Scissors beats Paper
            return "Congratulations! You win!";
        } else {
            return "Oops! Computer wins.";
        }
    }
}