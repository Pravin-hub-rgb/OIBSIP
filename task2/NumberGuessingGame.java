import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		int minimum = 1;
		int maximum = 100;
		int maxAttempts = 10;
		int totalRounds = 0;
		int totalAttempts = 0;

		System.out.println("WELCOME TO NUMBER GUESSING GAME");

		while (true) {
			int randomNumber = random.nextInt(maximum - minimum + 1) + minimum;
			System.out.println("\nRound : " + (totalRounds + 1));
			System.out.println("Computer has generated a random number between " + minimum + " and " + maximum);
			System.out.println("Try to guess the number in " + maxAttempts + " attempts");

			int attempt = 0;
			boolean roundWon = false;

			while (attempt < maxAttempts) {
				System.out.print("Attempt " + (attempt + 1) + "/" + maxAttempts + ": Guess the number: ");
				int userGuess = scanner.nextInt();
				attempt++;

				if (userGuess > randomNumber) {
					System.out.println("The number is too high");
				} else if (userGuess < randomNumber) {
					System.out.println("The number is too low");
				} else {
					System.out.println("Congratulations!!! You guessed the right number.");
					roundWon = true;
					break;
				}
			}

			if (roundWon) {
				totalRounds++;
				totalAttempts += attempt;
			} else {
				System.out.println("Sorry! You were unable to guess the number. The number was: " + randomNumber);
			}

			System.out.print("Do you want to play again [yes/no]: ");
			String playAgainChoice = scanner.next();
			if (!playAgainChoice.equalsIgnoreCase("yes")) {
				break;
			}
		}

		System.out.println("Game Over! Thank you for playing.");
		System.out.println("The Final Score is ");
		System.out.println("Total Rounds Won: " + totalRounds);
		System.out.println("Total Attempts: " + totalAttempts);

		scanner.close();
	}
}
