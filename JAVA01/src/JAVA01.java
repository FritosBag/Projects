/*
Author: Kobe Converse
Date Completed: 2/22/18
Purpose: Ordering system for the use of a fastfood restaurant
Note: Java program is vastly different from raptor program due to logic errors
*/

import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.NumberFormat;

public class JAVA01
{
	public static void main(String[] args)
	{
		String programEnd;
		String orderEnd;
		int selection;
		double burgerTotal = 0, friesTotal = 0, sodaTotal = 0;
		
		do
		{
			do
			{
				selection = orderInput();
				switch (selection)
				{
				case 1:
					burgerTotal = burgerInput();
					break;
				case 2:
					friesTotal = friesInput();
					break;
				case 3:
					sodaTotal = sodaInput();
					break;
				}
				orderEnd = orderLoop();
			}
			while (orderEnd.equalsIgnoreCase("no"));
			orderCalculate(burgerTotal, friesTotal, sodaTotal);
			programEnd = programEnd();
		}
		while (programEnd.equalsIgnoreCase("no"));
	}
	
	public static String orderLoop()
	{
		Scanner keyboard = new Scanner(System.in);
		String orderEnd = "no";
		
		System.out.print("Do you want to end your order? (Enter yes or no): ");
		orderEnd = keyboard.next();
		
		while (!orderEnd.equalsIgnoreCase("no") && !orderEnd.equalsIgnoreCase("yes"))
		{
			System.out.println("-- Invalid Entry --");
			System.out.print("Do you want to end your order? (Enter yes or no): ");
			orderEnd = keyboard.next();
		}
		System.out.println();
		return orderEnd;
	}
	
	public static int orderInput()
	{
		Scanner keyboard = new Scanner(System.in);
		int selection;
		while(true)
		{
			try 
			{
				System.out.println("Enter 1 for Yum Yum Burger");
				System.out.println("Enter 2 for Grease Yum Fries");
				System.out.println("Enter 3 for Soda Yum");
				System.out.print("Enter now -> ");
				selection = keyboard.nextInt();
				if (selection != 1 && selection != 2 && selection != 3)
				{
					System.out.println("-- Invalid Entry --");
					keyboard.nextLine();
					continue;
				}
				else
				{
					break;
				}
			}
			catch (InputMismatchException e)
			{
				System.out.println("-- Invalid Entry --");
				keyboard.nextLine();
				continue;
			}
		}
		return selection;
	}
	
	public static double burgerInput()
	{
		Scanner keyboard = new Scanner(System.in);
		int burgerAmount;
		while(true)
		{
			try
			{
				System.out.print("Enter the number of burgers you want: ");
				burgerAmount = keyboard.nextInt();
				
				while (burgerAmount > 5)
				{
					System.out.println("-- Invalid Entry --");
					System.out.print("Enter the number of burgers you want: ");
					burgerAmount = keyboard.nextInt();
				}
			}
			catch (InputMismatchException e)
			{
				System.out.println("-- Invalid Entry --");
				keyboard.nextLine();
				continue;
			}
			break;
		}
		double burgerTotal = burgerAmount * .99;
		return burgerTotal;
	}
	
	public static double friesInput()
	{
		Scanner keyboard = new Scanner(System.in);
		int friesAmount;
		while(true)
		{
			try
			{
				System.out.print("Enter the number of fries you want: ");
				friesAmount = keyboard.nextInt();
				
				while (friesAmount > 5)
				{
					System.out.println("-- Invalid Entry --");
					System.out.print("Enter the number of fries you want: ");
					friesAmount = keyboard.nextInt();
				}
			}
			catch (InputMismatchException e)
			{
				System.out.println("-- Invalid Entry --");
				keyboard.nextLine();
				continue;
			}
			break;
		}
		double friesTotal = friesAmount * .79;
		return friesTotal;
	}
	
	public static double sodaInput()
	{
		Scanner keyboard = new Scanner(System.in);
		int sodaAmount;
		while(true)
		{
			try
			{
				System.out.print("Enter the number of sodas you want: ");
				sodaAmount = keyboard.nextInt();
				
				while (sodaAmount > 5)
				{
					System.out.println("-- Invalid Entry --");
					System.out.print("Enter the number of sodas you want: ");
					sodaAmount = keyboard.nextInt();
				}
			}
			catch (InputMismatchException e)
			{
				System.out.println("-- Invalid Entry --");
				keyboard.nextLine();
				continue;
			}
			break;
		}
		double sodaTotal = sodaAmount * 1.09;
		return sodaTotal;
	}
	
	public static void orderCalculate(double burgerTotal, double friesTotal, double sodaTotal)
	{
		double subTotal;
		double grandTotal;
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		
		subTotal = burgerTotal + friesTotal + sodaTotal;
		grandTotal = subTotal * 1.06;
		System.out.println("The total price is " + currency.format(grandTotal));
	}
	
	public static String programEnd()
	{
		Scanner keyboard = new Scanner(System.in);
		String programEnd;
		
		System.out.print("Do you want to end program? (Enter no to process a new order): ");
		programEnd = keyboard.next();
		
		while (!programEnd.equalsIgnoreCase("no") && !programEnd.equalsIgnoreCase("yes"))
		{
			System.out.println("-- Invalid Entry --");
			System.out.print("Do you want to end program? (Enter no to process a new order): ");
			programEnd = keyboard.next();
		}
		System.out.println();
		return programEnd;
	}
}