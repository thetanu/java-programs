import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        URLShortener urlShortener = new URLShortener();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the URL Shortener!");
        System.out.println("=============================");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Shorten a URL");
            System.out.println("2. Retrieve original URL from short URL");
            System.out.println("3. Exit");
            System.out.print("Your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left by nextInt()

            switch (choice) {
                case 1 -> {
                    System.out.print("\nEnter the original URL: ");
                    String originalURL = scanner.nextLine();
                    String shortURL = urlShortener.shortenURL(originalURL);
                    System.out.println("Shortened URL: " + shortURL);
                }
                case 2 -> {
                    System.out.print("\nEnter the short URL: ");
                    String shortURL = scanner.nextLine();
                    String originalURL = urlShortener.getOriginalURL(shortURL);
                    System.out.println("Original URL: " + originalURL);
                }
                case 3 -> {
                    System.out.println("Thank you for using the URL Shortener!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}