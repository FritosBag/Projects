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
				
		try
		{
			prospectPath = Paths.get("prospects.csv");
			prospectFile = prospectPath.toFile();
			
			cleanProspectPath = Paths.get("prospects_clean.csv");
			Files.createFile(cleanProspectPath);
			cleanProspectFile = cleanProspectPath.toFile();
						
			BufferedReader in = new BufferedReader
							   (new FileReader(prospectFile));
			
			PrintWriter out =   new PrintWriter
			 		 		   (new BufferedWriter
			 		 		   (new FileWriter(cleanProspectFile, true)));
			
			String readLine = in.readLine();
			do
			{
				//Split and trim
				String firstSub = "";
				String lastSub = "";
				String comma = ",";
				String[] fields = new String[2];
				fields = readLine.split(comma);
				String firstName = fields[0].trim();
				String lastName = fields[1].trim();
				String email = fields[2].trim();

				//Write
				StringBuilder b1 = new StringBuilder(firstName);
				firstName = firstName.toLowerCase();
				firstSub = b1.substring(0, 1);
				firstSub = firstSub.toUpperCase();
				firstName = firstSub + firstName;
				
				StringBuilder b2 = new StringBuilder(lastName);
				lastName = lastName.toLowerCase();
				lastSub = b2.substring(0, 1);
				lastSub = lastSub.toUpperCase();
				lastName = lastSub + lastName;
				
				email = email.toLowerCase();
				email = email.replaceFirst("email", "Email");
				
				StringBuilder b3 = new StringBuilder(firstName);
				b3.deleteCharAt(1);
				firstName = b3.toString();
				
				StringBuilder b4 = new StringBuilder(lastName);
				b4.deleteCharAt(1);
				lastName = b4.toString();
				
				//Display
				out.println(String.join(comma, firstName, lastName, email));
				readLine = in.readLine();
			}
			while (readLine != null);
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
		}
		catch (IOException exception2)
		{
			System.out.println("File already exists/could not be read");
		}
	}
}