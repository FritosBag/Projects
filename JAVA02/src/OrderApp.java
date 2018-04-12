/*
Author: Kobe Converse
Date Completed: -
Purpose: Ordering system for the use of a fastfood restaurant -- Revised with classes
*/

import java.util.Scanner;
import java.text.NumberFormat;

public class OrderApp
{
	public static void main(String[] args)
	{	
		String programEnd;
		String orderEnd;
		int selection;
		int burgerTotal = 0, friesTotal = 0, sodaTotal= 0;
		
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
					sodaTotal = OrderConsole.getInt("Enter the number of sodas you want: ");
					break;
				}
				orderEnd = orderLoop();
			}
			while (orderEnd.equalsIgnoreCase("no"));
			Order order = new Order(burgerTotal, friesTotal, sodaTotal);
			orderCalculate(order);
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
		int selection = 0;
		
		OrderConsole.orderSelectionPrompt("Enter 1 for Yum Yum Burger | Enter 2 for Grease Yum Fries | "
										+ "Enter 3 for Soda Yum | Enter now: ");
		return selection;
	}
	
	public static void orderCalculate(Order order)
	{	
		double subTotal;
		double grandTotal;
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		
		subTotal = order.burgerCalc(order.getBurgerAmount()) + order.friesCalc(order.getFriesAmount())
									+ order.sodaCalc(order.getSodaAmount());
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