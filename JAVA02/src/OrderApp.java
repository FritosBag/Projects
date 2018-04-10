/*
Author: Kobe Converse
Date Completed: -
Purpose: Ordering system for the use of a fastfood restaurant -- Revised with classes
*/

import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.NumberFormat;

public class OrderApp
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
					burgerTotal = OrderConsole.getInt("Enter the number of burgers you want: ");
					break;
				case 2:
					friesTotal = OrderConsole.getInt("Enter the number of fries you want: ");
					break;
				case 3:
					//sodaTotal = sodaInput();
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
		
		OrderConsole.orderEndPrompt();
		orderEnd = keyboard.next();
		
		while (!orderEnd.equalsIgnoreCase("no") && !orderEnd.equalsIgnoreCase("yes"))
		{
			OrderConsole.orderEndPromptError();
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
				OrderConsole.orderSelectionPrompt();
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
		Order Order = new Order();
		Scanner keyboard = new Scanner(System.in);
		
		OrderConsole.getInt("Enter the number of burgers you want: ");
		
		while (Order.getBurgerAmount() > 5)
		{
			System.out.println("-- Invalid Entry --");
			System.out.print("Enter the number of burgers you want: ");
			keyboard.nextInt();
		}
		
		return Order.burgerCalc(Order.getBurgerAmount(), Order.getBurgerTotal());
	}
	
	/*public static double friesInput()
	{
		Scanner keyboard = new Scanner(System.in);
		int friesAmount;
		while(true)
		{
			try
			{
				OrderConsole.friesAmountPrompt();
				friesAmount = keyboard.nextInt();
				
				while (friesAmount > 5)
				{
					OrderConsole.friesAmountPromptError();
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
				OrderConsole.sodaAmountPrompt();
				sodaAmount = keyboard.nextInt();
				
				while (sodaAmount > 5)
				{
					OrderConsole.sodaAmountPromptError();
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
	*/
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