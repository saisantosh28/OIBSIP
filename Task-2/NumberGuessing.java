import java.util.*;
public class NumberGuessing {
    public static void main(String[] args) {
        int minRange = 1; 
        int maxRange = 100; 
        int maxAttempts = 5;
        int score = 0; 
        boolean playAgain = true; 

        System.out.println("Welcome to the Guess the Number Game!");

        Scanner scanner = new Scanner(System.in);

        while (playAgain) {
            int numberToGuess = generateRandomNumber(minRange, maxRange);
            int attempts = 0;
            boolean hasGuessedCorrectly = false;

            while (!hasGuessedCorrectly && attempts < maxAttempts) {
                System.out.print("Guess a number between " + minRange + " and " + maxRange + ": ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == numberToGuess) {
                    hasGuessedCorrectly = true;
                    score += (maxAttempts - attempts + 1) * 10;
                    System.out.println("Congratulations! You guessed the number correctly in " +(5-attempts) + " attempts.");
                } else if (guess < numberToGuess) {
                    if (numberToGuess - guess > 10) {
                        System.out.println("Too low! The number is much higher.You have "+(5-attempts)+" attempts.");
                    } else {
                        System.out.println("Too low! The number is higher.You have "+(5-attempts)+" attempts.");
                    }
                } else {
                    if (guess - numberToGuess > 10) {
                        System.out.println("Too high! The number is much lower.You have "+(5-attempts)+" attempts.");
                    } else {
                        System.out.println("Too high! The number is lower.You have "+(5-attempts)+" attempts.");
                    }
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you couldn't guess the number. The correct number was: " + numberToGuess);
            }

            System.out.println("Current score: " + score);

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainOption = scanner.next();
            playAgain = playAgainOption.equalsIgnoreCase("yes") || playAgainOption.equalsIgnoreCase("y");
        }

        System.out.println("Game over! Your final score is: " + score);

        scanner.close();
    }

    private static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
