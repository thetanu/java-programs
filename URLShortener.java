import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class URLShortener {
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int SHORT_URL_LENGTH = 6;

    private final Map<String, String> urlMap; // Stores short URL to original URL mappings
    private final Map<String, String> reverseUrlMap; // Stores original URL to short URL mappings
    private final Random random;

    public URLShortener() {
        urlMap = new HashMap<>();
        reverseUrlMap = new HashMap<>();
        random = new Random();
    }

    // Generates a short URL for the given original URL
    public String shortenURL(String originalURL) {
        if (reverseUrlMap.containsKey(originalURL)) {
            return reverseUrlMap.get(originalURL); // Return existing short URL if already shortened
        }

        String shortURL;
        do {
            shortURL = generateShortURL();
        } while (urlMap.containsKey(shortURL)); // Ensure the generated short URL is unique

        urlMap.put(shortURL, originalURL);
        reverseUrlMap.put(originalURL, shortURL);

        return shortURL;
    }

    // Retrieves the original URL for the given short URL
    public String getOriginalURL(String shortURL) {
        return urlMap.getOrDefault(shortURL, "URL not found!"); // Return original URL or error message
    }

    // Generates a random short URL of fixed length
    private String generateShortURL() {
        StringBuilder shortURL = new StringBuilder(SHORT_URL_LENGTH);
        for (int i = 0; i < SHORT_URL_LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            shortURL.append(CHARACTERS.charAt(index));
        }
        return shortURL.toString();
    }
}