package ch12_lab_PrimeNumberChecker;

import java.util.ArrayList;
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
			
			ArrayList<Integer> primeArrayList = new ArrayList<Integer>(primeNumber);
			ArrayList<Integer> factorArrayList = new ArrayList<Integer>(primeNumber);
			
			//primeNumber = index of the array
			for (int i = 1; i <= primeNumber; i++)
			{
				if (primeNumber % i == 0)
				{
					primeArrayList.add(i);
				}
			}
			
			for(int i = 1; i <= primeNumber; i++)
			{
				factorArrayList.add(i);
			}
			
			if (primeArrayList.size() == 2)
			{
				System.out.println(primeNumber + " is a prime number.");
			}
			else
			{
				System.out.println(primeNumber + " is NOT a prime number.");
				for (int i : factorArrayList)
				{
					System.out.print(i + ", ");
				}
				//put in method
				
				System.out.println("It has " + factorArrayList.size() + " factors: " + factorArrayList);

			}
			
			System.out.println();
			System.out.print("Try again? (y/n): ");
			programEnd = sc.next();
			System.out.println();
		}
		while (programEnd.equalsIgnoreCase("y"));
		System.out.println();
		System.out.println("Bye!");
	}
}