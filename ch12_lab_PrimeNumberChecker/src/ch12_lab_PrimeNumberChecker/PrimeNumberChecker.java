package ch12_lab_PrimeNumberChecker;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PrimeNumberChecker
{
	public static void main(String[] args)
	{
		int primeNumber = 0;
		String programEnd = "";
		boolean errorCheck = false;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Prime Number Checker");
		System.out.println();
		
		do
		{
			do 
			{
				try
				{
					System.out.print("Please enter an integer between 1 and 5000: ");
					primeNumber = sc.nextInt();
						
					while (primeNumber <= 0 || primeNumber > 5000)
					{
						System.out.println();
						System.out.print("Error, please enter an integer between 1 and 5000: ");
						primeNumber = sc.nextInt();
					}
					errorCheck = true;
				}
				catch (InputMismatchException e)
				{
					System.out.println();
					System.out.print("Error, ");
					sc.nextLine();
					continue;
					
					/*
					 * Error, please enter an integer between 1 and 5000: p

					 * Error, 
					 * Bye!

					 */
				}	
			}
			while (errorCheck = false);
			
			//arrayList
			
			//for loop to check if number entered is prime
			//primeNumber = index of the array
			for (int i = 0; i < primeNumber; i++)
			{
				
			}
			
			//else print factors of non-prime number
			
			System.out.println();
			System.out.print("Try again? (y/n): ");
			programEnd = sc.next();
		}
		while (programEnd.equalsIgnoreCase("y"));
		System.out.println();
		System.out.println("Bye!");
	}
}