import java.util.*;
import java.io.*;

//This csv loader was provided by my data structures II professor last semester
//I just altered the code to work for this project
public class CSVLoader 
{

	public static void main(String[] args) 
	{
		//create three arraylist of type string to hold the data, one for the x value, one for the y value, and 1 for the header
		ArrayList<String> x = new ArrayList<>();
		ArrayList<String> y = new ArrayList<>();
		ArrayList<String> header = new ArrayList<>();
		
		//create a file with the filename function.csv
		File file = new File("function.csv");
		
		//create a scanner object
		Scanner in = null;
		
		//try block to make sure the file exists
		try 
		{
			//create a new scanner that pulls data from the file
			in = new Scanner(file);
			
			//try block to make sure the file is readable
			try
			{
				//check that the file has a line to read in
				while(in.hasNextLine())
				{
					//create a string variable and set it to the line that is being read in
					String line = in.nextLine();
					
					//create an array of type string to hold the variable line that is split around commas
					String[] data = line.split(",");
					
					//add the first element of the array to the header arraylist
					header.add(data[0]);
					//add the second element of the array to the x arraylist
					x.add(data[1]);
					//add the third element of the array to the y arraylist
					y.add(data[2]);
				
				}
			}
			//catch statement for a no such element error
			catch (NoSuchElementException e) 
			{
				//print statement for the error
				System.err.println("Record Error: " + e.getMessage());
			} 
			//catch statement for the index out of bounds error
			catch (IndexOutOfBoundsException e) 
			{
				//print statement for the error
				System.err.println("Parse Error: " + e.getMessage());
			} 
			//catch statement for the number format exception error
			catch (NumberFormatException e) 
			{
				//print statement for the error
				System.err.println("Data Error: " + e.getMessage());
			} 
			finally 
			{
				//close the scanner object
				in.close();
			}
			
		} 
		//catch block if the file is not found
		catch (FileNotFoundException e) 
		{
			//Print statement for the error
			System.err.println("File Unavailable: " + e.getMessage());
		}
		
		//Print statements to print out all of the arrays with spaces between
		System.out.print(header + "\n");
		System.out.println();
		System.out.print(x + "\n");
		System.out.println();
		System.out.print(y);
	}
}
