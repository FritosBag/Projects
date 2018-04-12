import java.util.InputMismatchException;
import java.util.Scanner;

public class OrderConsole
{
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
				
				while (Integer > 5 || Integer < 0)
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
	
	public static void orderSelectionPrompt(String prompt)
	{
		Scanner keyboard = new Scanner(System.in);
		int selection;
		while(true)
		{
			try
			{
				System.out.print(prompt);
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
	}
}