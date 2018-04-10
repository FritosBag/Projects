import java.util.InputMismatchException;
import java.util.Scanner;

public class OrderConsole
{
	public static void orderEndPrompt()
	{
		System.out.print("Do you want to end your order? (Enter yes or no): ");
	}
	
	public static void orderEndPromptError()
	{
		System.out.println("-- Invalid Entry --");
		System.out.print("Do you want to end your order? (Enter yes or no): ");
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
		int burgerAmount;
		while(true)
		{
			try
			{
				System.out.print(prompt);
				burgerAmount = keyboard.nextInt();
			}
			catch (InputMismatchException e)
			{
				System.out.println("-- Invalid Entry --");
				keyboard.nextLine();
				continue;
			}
			break;
		}
		return burgerAmount;
	}
	
	/* public static void burgerAmountPrompt()
	{
		System.out.print("Enter the number of burgers you want: ");
	}
	
	public static void burgerAmountPromptError()
	{
		System.out.println("-- Invalid Entry --");
		System.out.print("Enter the number of burgers you want: ");
	}
	
	public static void friesAmountPrompt()
	{
		System.out.print("Enter the number of fries you want: ");
	}
	
	public static void friesAmountPromptError()
	{
		System.out.println("-- Invalid Entry --");
		System.out.print("Enter the number of fries you want: ");
	}
	
	public static void sodaAmountPrompt()
	{
		System.out.print("Enter the number of sodas you want: ");
	}
	
	public static void sodaAmountPromptError()
	{
		System.out.println("-- Invalid Entry --");
		System.out.print("Enter the number of sodas you want: ");
	}
	
	public static void programEndPrompt()
	{
		System.out.print("Do you want to end program? (Enter no to process a new order): ");
	}
	
	public static void programEndPromptError()
	{
		System.out.println("-- Invalid Entry --");
		System.out.print("Do you want to end program? (Enter no to process a new order): ");
	}
	*/
}