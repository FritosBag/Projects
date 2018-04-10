package murach.games;

import java.util.Scanner;

public class Main
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to the Number Guessing Game");
		System.out.println();
		
		NumberGame numberGame = new NumberGame();
		
		System.out.print("Enter your guess: ");
		int guess = Integer.valueOf(sc.nextLine());
		
		while (guess != numberGame.getNumber())
		{
			if (guess < numberGame.getNumber())
			{
				System.out.println("Your guess is too low.\n");
			}
			else if (guess > numberGame.getNumber())
			{
				System.out.println("Your guess is too high.\n");
			}
			System.out.print("Enter your guess: ");
			guess = Integer.valueOf(sc.nextLine());
			numberGame.getIncrementGuessCount();
		}
		System.out.println("Correct!\n");
		
		System.out.println("You guessed the correct number in " + (numberGame.getIncrementGuessCount() - 1) + " guesses.\n");
		System.out.println("Bye!");
	}
}