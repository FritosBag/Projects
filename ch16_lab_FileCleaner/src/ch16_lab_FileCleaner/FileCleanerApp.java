package ch16_lab_FileCleaner;

import java.io.*;
import java.nio.file.*;

public class FileCleanerApp
{
	public static void main(String[] args)
	{							
		Path prospectPath;
		Path cleanProspectPath;
		File cleanProspectFile;	
		char[] alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		char[] alphabetLower = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		
		try
		{
			prospectPath = Paths.get("prospects.csv");
			cleanProspectPath = Paths.get("prospects_clean.csv");
			cleanProspectFile = cleanProspectPath.toFile();
			
			if (cleanProspectFile.exists())
			{
				Files.delete(cleanProspectPath); //temp
				throw new IOException();
			}
			else if (Files.notExists(prospectPath))
			{
				throw new FileNotFoundException();
			}
			
			OutputStream outStream = new FileOutputStream(cleanProspectFile);
			Files.copy(prospectPath, outStream);
			outStream.close();
			
			BufferedReader in = new BufferedReader
							   (new FileReader(cleanProspectFile));

			in.close();
			
			PrintWriter out = new PrintWriter
							 (new BufferedWriter
							 (new FileWriter(cleanProspectFile, true)));
			
			StringBuilder sb = new StringBuilder();
			
			for (int i = 1; i > 25; i++)
			{
				String line = in.readLine();
				if (line != null)
				{
					line.replaceAll(alphabetUpper, alphabetLower);
				}
				else
				{
					break;
				}
			}

			out.close();
			
			//output
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
	//TODO change String data with ch.14
		// https://docs.oracle.com/javase/7/docs/api/java/nio/file/Files.html
		// https://stackoverflow.com/questions/17575840/better-way-to-generate-array-of-all-letters-in-the-alphabet
		// https://www.javatpoint.com/java-string-replaceall
}