import java.util.*;


public class numberguessing {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int maxNumber = 100; // Change this to adjust the guess range
        int attempts = 5; // Number of allowed guesses
        int totalRounds = 3; // Number of rounds to play

        int score = 0;

        for (int round = 1; round <= totalRounds; round++) {
            int randomNumber = random.nextInt(maxNumber) + 1; // Generate random number between 1 and maxNumber

            System.out.println("Round " + round + ": Guess a number between 1 and " + maxNumber);

            int guessCount = 0;
            boolean guessedCorrectly = false;

            while (guessCount < attempts && !guessedCorrectly) {
                int guess = scanner.nextInt();
                guessCount++;

                if (guess == randomNumber) {
                    guessedCorrectly = true;
                    System.out.println("Congratulations! You guessed the number in " + guessCount + " attempts.");

                    // Calculate points based on attempts (higher attempts = lower points)
                    int points = attempts - guessCount;
                    score += points;
                    System.out.println("Points earned this round: " + points);
                } else if (guess < randomNumber) {
                    System.out.println("Your guess is too low. Try again.");
                } else {
                    System.out.println("Your guess is too high. Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("You ran out of attempts! The number was: " + randomNumber);
            }
        }

        System.out.println("Total score: " + score);
        System.out.println("Thanks for playing!");
        scanner.close();
    
    }
}
