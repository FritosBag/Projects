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
		Student Student = new Student();
		Scanner sc = new Scanner(System.in);
		
		try
		{
			System.out.print("Number of students: ");
			studentNumber = sc.nextInt();
			System.out.println();
			
			while (studentNumber <= 0 || studentNumber > 500)
			{
				System.out.println("Error: Invalid amount of students (1-500)");
				System.out.print("Number of students: ");
				studentNumber = sc.nextInt();
				System.out.println();
			}
		}
		catch (InputMismatchException e)
		{
			System.out.println("Error: Input entered must be a whole number");
			studentNumber = sc.nextInt();
		}
		
		Student[] studentArray = new Student[studentNumber];
		studentNumber = studentArray.length;
		for (int i = 0; i < studentArray.length; i++)
		{
			System.out.println("STUDENT " + (i + 1));	
			
			System.out.print("Last name: ");
			String lastName = sc.nextLine();
			System.out.println();
			
			System.out.print("First name: ");
			String firstName = sc.nextLine();
			System.out.println();
			
			System.out.print("Score: ");
			int studentScore = sc.nextInt();
			System.out.println();
		}
	
		//System.out.println("Last name: ");
		//System.out.println("First name: ");
		//System.out.println("Score: ");
		
		//sort array
		//sorted summary
	 }
}