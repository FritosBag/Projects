package ch16_lab_FileCleaner;

import java.io.*;
import java.nio.file.*;

public class FileCleanerApp
{
	public static void main(String[] args)
	{							
		Path prospectPath;
		File prospectFile;
		Path cleanProspectPath;
		File cleanProspectFile;
		String comma = ",";
		
		String alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String alphabetLower = "abcdefghijklmnopqrstuvwxyz";
		
		try
		{
			prospectPath = Paths.get("prospects.csv");
			prospectFile = prospectPath.toFile();
			
			if (Files.notExists(prospectPath))
			{
				throw new FileNotFoundException();
			}
			cleanProspectPath = Paths.get("prospects_clean.csv");
			Files.createFile(cleanProspectPath);
			cleanProspectFile = cleanProspectPath.toFile();
						
			BufferedReader in = new BufferedReader
							   (new FileReader(prospectFile));
			
			PrintWriter out =   new PrintWriter
			 		 		   (new BufferedWriter
			 		 		   (new FileWriter(cleanProspectFile, true)));
			
			String readLine = in.readLine();
			
			while (readLine != null)
			{
				//read
				String[] fields = new String[2];
				fields = readLine.split(comma);
				String firstName = fields[0];
				String lastName = fields[1];
				String email = fields[2];
				String firstSub = "";
				String lastSub = "";
				StringBuilder b1 = new StringBuilder(firstName);
				StringBuilder b2 = new StringBuilder(lastName);
				
				//write
				firstName = firstName.trim(); 
				firstName = firstName.toLowerCase();
				firstSub = b1.substring(0, 1);
				firstSub = firstSub.toUpperCase();
				
				lastName = lastName.trim();
				lastName = lastName.toLowerCase();
				lastSub = b2.substring(0, 1);
				lastSub = lastSub.toUpperCase();
				
				email = email.trim();
				email = email.toLowerCase();
				
				//b.deleteCharAt(firstName.indexOf(0));
				//display
				out.println(firstName + comma + lastName + comma + email);
				readLine = in.readLine();
			}
			out.close();
			in.close();
			
			//console output
			System.out.println("File Cleaner");
			System.out.println();
			
			System.out.println("Source file: " + prospectPath.getFileName());
			System.out.println("Cleaned file: " + cleanProspectPath.getFileName());
			System.out.println();
			
			System.out.println("Congratulations! Your file has been cleaned!");
		}
		catch (FileNotFoundException exception1)
		{
			System.out.println("File could not be found");
			exception1.printStackTrace();
		}
		catch (IOException exception2)
		{
			System.out.println("File already exists");
			exception2.printStackTrace();
		}
	}
	//TODO change String data with ch.13
		// https://docs.oracle.com/javase/7/docs/api/java/nio/file/Files.html
}