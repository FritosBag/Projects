package presentation;

import java.util.Scanner;

import business.Business;
import business.Validation;

public class Presentation
{
	public static void main(String[] args)
	{
		String studentId = "";
		String studentName = "";
		String studentEmail = "";
		String hoursAmount = "";
		double hoursAmountParsed;
		
		studentId = idInput(studentId);
		studentName = nameInput(studentName);
		studentEmail = emailInput(studentEmail);
		hoursAmount = hoursInput(hoursAmount);
		hoursAmountParsed = Business.calcHoursAmount(Double.parseDouble(hoursAmount));

		System.out.println("Student ID: " + studentId);
		System.out.println("Student Name: " + studentName);
		System.out.println("Student Email: " + studentEmail);
		System.out.println("Student Hours: " + hoursAmount);
		System.out.println("Hours calculated: " + hoursAmountParsed);
	}

	public static String idInput(String studentId)
	{
		Scanner sc = new Scanner(System.in);
		
		int min = 1000;
		int max = 9999;
		boolean errorCheck = false;

		do
	  	{
			System.out.println("Enter your student ID: ");
	 		studentId = sc.nextLine();
	 		errorCheck = Validation.isInteger(studentId, "Student ID") && Validation.isWithinRangeInteger(studentId, min, max, "Student ID");
	 		
	 		System.out.println();
	  	}
		while(!errorCheck);

		return studentId;
	}
	
	public static String nameInput(String studentName)
	{
		Scanner sc = new Scanner(System.in);
		boolean errorCheck = false;

		do
	  	{
			System.out.println("Enter your name: ");
	 		studentName = sc.nextLine();
	 		errorCheck = Validation.isStringPresent(studentName, "Student name");
	 		
	 		System.out.println();
	  	}
		while(!errorCheck);

		return studentName;
	}
	
	public static String emailInput(String studentEmail)
	{
		Scanner sc = new Scanner(System.in);
		boolean errorCheck = false;
				
		do
		{
			System.out.println("Enter your email: ");
			studentEmail = sc.nextLine();
			errorCheck = Validation.isStringPresent(studentEmail, "Student email");
	 		
	 		System.out.println();
		}
		while(!errorCheck);
		
		return studentEmail;
	}
	
	public static String hoursInput(String hoursAmount)
	{
		Scanner sc = new Scanner(System.in);
		
		double min = 2.5;
		double max = 18;
		boolean errorCheck = false;
		
		do
		{
			System.out.println("Enter amount of hours: (2.5 to 18)");
			hoursAmount = sc.nextLine();
			errorCheck = Validation.isDouble(hoursAmount, "Hours") && Validation.isWithinRangeDouble(hoursAmount, min, max, "Hours");
	 		
	 		System.out.println();
		}
		while(!errorCheck);
		
		return hoursAmount;
	}
}