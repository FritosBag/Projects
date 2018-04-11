import java.util.InputMismatchException;
import java.util.Scanner;

public class OrderConsole
{
	public static void orderEndPrompt(String prompt)
	{
		Scanner keyboard = new Scanner(System.in);
		String orderEnd;
		while(true)
		{
			try
			{
				System.out.print(prompt);
				orderEnd = keyboard.next();
				
				while (!orderEnd.equalsIgnoreCase("no") && !orderEnd.equalsIgnoreCase("yes"))
				{
					System.out.print(prompt);
					orderEnd = keyboard.next();
				}
				System.out.println();
			}
			catch (InputMismatchException e)
			{
				System.out.println("-- Invalid Entry --");
				keyboard.nextLine();
				continue;
			}
			break;
		}
	}
	
	public static void orderSelectionPrompt()
	{
		System.out.println("Enter 1 for Yum Yum Burger");
		System.out.println("Enter 2 for Grease Yum Fries");
		System.out.println("Enter 3 for Soda Yum");
		System.out.print("Enter now -> ");
	}

	public static int getInt(String prompt)
	{
		Scanner keyboard = new Scanner(System.in);
		int Integer;
		while(true)
		{
			try
			{
				System.out.print(prompt);
				Integer = keyboard.nextInt();
				
				while (Integer > 5)
				{
					System.out.println("-- Invalid Entry --");
					System.out.print(prompt);
					Integer = keyboard.nextInt();
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
		return Integer;
	}	
}