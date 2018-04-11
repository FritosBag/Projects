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
		Order Order = new Order();
		
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
					Order.getBurgerTotal();
					break;
				case 2:
					friesTotal = OrderConsole.getInt("Enter the number of fries you want: ");
					Order.getFriesTotal();
					break;
				case 3:
					sodaTotal = OrderConsole.getInt("Enter the number of sodas you want: ");
					Order.getSodaTotal();
					break;
				}
				orderEnd = orderLoop();
			}
			while (orderEnd.equalsIgnoreCase("no"));
			orderCalculate();
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
		
		//OrderConsole.orderEndPrompt("Do you want to end your order? (Enter yes or no): ");
		//return orderEnd;
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
		
		Order.burgerCalc(Order.getBurgerAmount(), Order.getBurgerTotal());
		return Order.getBurgerTotal();
	}
	
	public static double friesInput()
	{
		Order Order = new Order();
		
		Order.friesCalc(Order.getFriesAmount(), Order.getFriesTotal());
		return Order.getFriesTotal();
	}
	
	public static double sodaInput()
	{
		Order Order = new Order();

		Order.sodaCalc(Order.getSodaAmount(), Order.getSodaTotal());
		return Order.getSodaTotal();
	}
	
	public static void orderCalculate()
	{
		Order Order = new Order();
		
		double subTotal;
		double grandTotal;
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		
		subTotal = Order.getBurgerTotal() + Order.getFriesTotal() + Order.getSodaTotal();
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