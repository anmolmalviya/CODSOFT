import java.util.Random;
import java.util.Scanner;

public class task1 {
//    Number Guessing Game
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int roundsWon = 0;
        int totalAttempts = 0;

        System.out.print("How many rounds would you like to play? ");
        int rounds = scanner.nextInt();

        for (int round = 1; round <= rounds; round++) {
            System.out.println("\nRound " + round);
            int[] result = playRound(scanner);
            totalAttempts += result[0];
            if (result[1] == 1) {
                roundsWon++;
            }
        }

        System.out.println("\nGame Over!");
        System.out.println("You won " + roundsWon + " out of " + rounds + " rounds.");
        System.out.printf("Your average number of attempts per round: %.2f\n", (double) totalAttempts / rounds);
    }

    // Method to play a single round
    public static int[] playRound(Scanner scanner) {
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;  // Random number between 1 and 100
        int attempts = 0;
        int maxAttempts = 10;
        boolean guessedCorrectly = false;

        System.out.println("I have selected a number between 1 and 100.");
        System.out.println("You have " + maxAttempts + " attempts to guess the number.");

        while (attempts < maxAttempts && !guessedCorrectly) {
            System.out.print("Attempt " + (attempts + 1) + "/" + maxAttempts + ": Enter your guess: ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else if (guess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else {
                guessedCorrectly = true;
                System.out.println("Congratulations! You've guessed the number " + numberToGuess + " correctly in " + attempts + " attempts.");
            }
        }

        if (!guessedCorrectly) {
            System.out.println("Sorry, you've run out of attempts. The correct number was " + numberToGuess + ".");
        }

        return new int[] {attempts, guessedCorrectly ? 1 : 0}; // Return attempts and 1 if correct, 0 if not
    }
}

