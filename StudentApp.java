package ch11_lab_StudentScores;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentApp
{
	public static void main(String[] args)
	{
		System.out.println("The Student Scores application");
		System.out.println();
		
		int studentNumber = 0;
		int errorCheck = 0;
		Student Student = new Student();
		Scanner sc = new Scanner(System.in);
		
		while (errorCheck == 0)
		{
			try
			{
				System.out.print("Number of students: ");
				studentNumber = sc.nextInt();
				
				while (studentNumber <= 0 || studentNumber > 500)
				{
					System.out.println("Error: Invalid amount of students (1-500)");
					System.out.print("Number of students: ");
					studentNumber = sc.nextInt();
					System.out.println();
				}
				errorCheck = 1;
			}
			catch (InputMismatchException e1)
			{
				System.out.println("Error: Input entered must be a whole number");
				sc.nextLine();
				continue;
			}
		}
		
		Student[] studentArray = new Student[studentNumber];
		studentNumber = studentArray.length;
		
		for (int i = 0; i < studentArray.length; i++)
		{
			System.out.println();
			System.out.println("STUDENT " + (i + 1));
			
			try
			{
				System.out.print("Last name: ");
				String lastName = sc.nextLine();
				
				if (lastName == null || lastName == "")
				{
					throw new java.lang.Exception();
				}
				// throw new exception
			}
			catch (Exception e2)
			{
				System.out.println("Error: last name cannot be blank");
				sc.nextLine();
				continue;
			}
			System.out.println();
			try
			{
				System.out.print("First name: ");
				String firstName = sc.nextLine();
				
				//throw new exception
			}
			catch (Exception e2)
			{
				System.out.println("Error: first name cannot be blank");
				sc.nextLine();
				continue;
			}
			
			try
			{
				System.out.print("Score: ");
				int studentScore = sc.nextInt();
				System.out.println();
				
				while (studentScore <= 0 || studentScore > 100)
				{
					System.out.println("Error: Invalid score (0-100)");
					System.out.print("Score: ");
					studentScore = sc.nextInt();
				}
			}
			catch (InputMismatchException e1)
			{
				System.out.print("Error: student score must be a whole number");
				sc.nextLine();
				continue;
			}
		}
		
		//sort array
		//sorted summary
	}
}