import java.util.Scanner;

public class PersonApp
{
	public static void main(String args[])
	{		
		System.out.println("Welcome to the Person Tester application");
		System.out.println();
		
		Scanner keyboard = new Scanner(System.in);
		String choiceContinue = "y";
		String choicePerson;
		String firstName;
		String lastName;
		String emailAddress;
		String customerNumber;
		String socialNumber;
		
		while (choiceContinue.equalsIgnoreCase("y"))
		{		
			choicePerson = Console.getString("Create customer or employee? (c/e): ");
			Customer c = new Customer();
			Employee e = new Employee();
			
			if (choicePerson.equalsIgnoreCase("c"))
			{
				System.out.println(c.getMotto());
				firstName = Console.getString("Enter first name: ");
				lastName = Console.getString("Enter last name: ");
				emailAddress = Console.getString("Enter email address: ");
				customerNumber = Console.getString("Customer number: ");
				
				System.out.println("Name: " + super.toString());
				System.out.println("Email: " + super.toString());
				System.out.println("Customer number: " + super.toString());
				
			}
			else if (choicePerson.equalsIgnoreCase("e"))
			{
				System.out.println(e.getMotto());
				firstName = Console.getString("Enter first name: ");
				lastName = Console.getString("Enter last name: ");
				emailAddress = Console.getString("Enter email address: ");
				socialNumber = Console.getString("Social security number: ");
				
				System.out.println("Name: " + super.toString());
				System.out.println("Email: " + super.toString());
				System.out.println("Social security number: " + super.toString());
			}
			
			System.out.println("Total Entries: " + Person.getCount() + "\n");
			
            choiceContinue = Console.getString("Continue? (y/n): ");
            System.out.println();
		}
	}
}