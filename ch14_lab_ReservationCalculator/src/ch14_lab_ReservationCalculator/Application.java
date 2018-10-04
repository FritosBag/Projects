package ch14_lab_ReservationCalculator;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.time.LocalDate;

public class Application
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		Reservation reservation = new Reservation();
		LocalDate LocalDate = java.time.LocalDate.now();
		
		int arrivalMonth = 0;
		int arrivalDay = 0;
		int arrivalYear = 0;
		int departureMonth = 0;
		int departureDay = 0;
		int departureYear = 0;
		Boolean inputCheck = false;
		String programEnd = "";
		
		do
		{
			System.out.println("Reservation Calculator");
			System.out.println();
			
			do //arrival month 
			{
				try
				{
					System.out.print("Enter the arrival month (1-12): ");
					arrivalMonth = sc.nextInt();
					
					while (arrivalMonth < 1 || arrivalMonth > 12)
					{
						System.out.println();
						System.out.print("Error: enter the arrival month (1-12): ");
						arrivalMonth = sc.nextInt();
					}
					inputCheck = true;
				}
				catch (InputMismatchException e)
				{
					System.out.println("Error: Enter a whole number");
					System.out.println();
					sc.nextLine();
					continue;
				}
			}
			while (inputCheck != true);
			inputCheck = false;
			
			do //arrival day
			{
				try
				{
					System.out.print("Enter the arrival day (1-31): ");
					arrivalDay = sc.nextInt();
					
					while (arrivalDay < 1 || arrivalDay > 31)
					{
						System.out.println();
						System.out.print("Error: enter the arrival day (1-31): ");
						arrivalDay = sc.nextInt();
					}
					inputCheck = true;
				}
				catch (InputMismatchException e)
				{
					System.out.println("Error: Enter a whole number");
					System.out.println();
					sc.nextLine();
					continue;
				}
			}
			while (inputCheck != true);
			inputCheck = false;
			
			do //arrival year
			{
				try
				{
					System.out.print("Enter the arrival year: ");
					arrivalYear = sc.nextInt();
					
					while (arrivalYear < LocalDate.getYear())
					{
						System.out.println();
						System.out.print("Error: enter a valid year (" + LocalDate.getYear() + "+): ");
						arrivalYear = sc.nextInt();
					}
					inputCheck = true;
				}
				catch (InputMismatchException e)
				{
					System.out.println("Error: Enter a whole number");
					System.out.println();
					sc.nextLine();
					continue;
				}
			}
			while (inputCheck != true);
			inputCheck = false;
			System.out.println();
			
			do //departure month
			{
				try
				{
					System.out.print("Enter the departure month (1-12): ");
					departureMonth = sc.nextInt();
					
					while (departureMonth < 1 || departureMonth > 12)
					{
						System.out.println();
						System.out.print("Error: enter the departure month (1-12): ");
						departureMonth = sc.nextInt();
					}
					inputCheck = true;
				}
				catch (InputMismatchException e)
				{
					System.out.println("Error: Enter a whole number");
					System.out.println();
					sc.nextLine();
					continue;
				}
			}
			while (inputCheck != true);
			inputCheck = false;
			
			do //departure day
			{
				try
				{
					System.out.print("Enter the departure day (1-31): ");
					departureDay = sc.nextInt();
					
					while (departureDay < 1 || departureDay > 31)
					{
						System.out.println();
						System.out.print("Error: enter the departure day (1-31): ");
						departureDay = sc.nextInt();
					}
					inputCheck = true;
				}
				catch (InputMismatchException e)
				{
					System.out.println("Error: Enter a whole number");
					System.out.println();
					sc.nextLine();
					continue;
				}
			}
			while (inputCheck != true);
			inputCheck = false;
			
			do //departure year
			{
				try
				{
					System.out.print("Enter the departure year: ");
					departureYear = sc.nextInt();
					
					while (departureYear < arrivalYear || departureYear < LocalDate.getYear())
					{
						System.out.println();
						System.out.print("Error: enter a valid year (" + arrivalYear + "+): ");
						departureYear = sc.nextInt();
					}
					inputCheck = true;
				}
				catch (InputMismatchException e)
				{
					System.out.println("Error: Enter a whole number");
					System.out.println();
					sc.nextLine();
					continue;
				}
			}
			while (inputCheck != true);
			inputCheck = false;
			
			LocalDate arrivalDate = java.time.LocalDate.of(arrivalYear, arrivalMonth, arrivalDay);
			reservation.setArrivalDate(arrivalDate);
			
			LocalDate departureDate = java.time.LocalDate.of(departureYear, departureMonth, departureDay);
			reservation.setDepartureDate(departureDate);
			
			if (departureDate.isBefore(arrivalDate))
			{
				System.out.println();
				System.out.println("Error: departure is before arrival, the program will now restart");
				programEnd = "y";
				System.out.println();
			}
			else
			{
				System.out.println();
				System.out.println("Arrival Date: " + reservation.getArrivalDateFormatted());
				System.out.println("Departure Date: " + reservation.getDepartureDateFormatted());
				System.out.println("Price: " + reservation.getPricePerNightFormatted() + " per night");
				System.out.println("Total price: " + reservation.getTotalPriceFormatted() + 
								   " for " + reservation.getDaysBetweenString() + " nights");
				System.out.println();
				
				do
				{
					try
					{
						System.out.print("Continue? (y/n) ");
						programEnd = sc.next();
						System.out.println();
						
						while (!programEnd.equalsIgnoreCase("y") && !programEnd.equalsIgnoreCase("n"))
						{
							System.out.println();
							System.out.println("Error: Enter y/n");
							programEnd = sc.next();
						}
						inputCheck = true;
					}
					catch (InputMismatchException e)
					{
						System.out.println();
						System.out.println("Error: Enter y/n");
						sc.next();
						continue;
					}
				}
				while (inputCheck != true);
			}
		}
		while (programEnd.equalsIgnoreCase("y"));
			
		System.out.println("Bye!");
	}
}