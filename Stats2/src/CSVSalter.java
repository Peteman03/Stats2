import java.io.*;
import java.util.*;
import com.opencsv.CSVWriter;

public class CSVSalter 
{
	/**
	 * Salter method to salt the function provided
	 * Uses a bunch of code from CSVLoader and CSV
	 */
	public void Salter()
	{
		//reused code from the CSVLoader class until line 67
		ArrayList<String> x = new ArrayList<>();
		ArrayList<String> y = new ArrayList<>();
		ArrayList<String> header = new ArrayList<>();
	
		String filename = "function.csv";
	
		File file = new File(filename);
		
		Scanner in = null;
	
		try 
		{
			in = new Scanner(file);
			
			try
			{
				while(in.hasNextLine())
				{
					String line = in.nextLine();
					
					String[] data = line.split(",");
				
					header.add(data[0]);
					x.add(data[1]);
					y.add(data[2]);
			
				}
			}
			catch (NoSuchElementException e) 
			{
				System.err.println("Record Error: " + e.getMessage());
			} 
			catch (IndexOutOfBoundsException e) 
			{
				System.err.println("Parse Error: " + e.getMessage());
			} 
			catch (NumberFormatException e) 
			{
				System.err.println("Data Error: " + e.getMessage());
			} 
			finally 
			{
				in.close();
			}
		
		} 
		catch (FileNotFoundException e) 
		{
			System.err.println("File Unavailable: " + e.getMessage());
		}
		
		//start of the new code
		//create random object
		Random generator = new Random();
		//loop through the y arraylist
		for(int i = 1; i < y.size(); i++)
		{
			//change variable to determine how much the data point is going to shift
			int change = generator.nextInt(500)+1000;
			//sign variable to determine whether that change is going to be positive or negative
			int sign = generator.nextInt(2);
			//set value equal to the y value by removing the double quotation marks and parsing the value to the wrapper class Integer
			Integer value = Integer.parseInt(y.get(i).replaceAll("\"", ""));
			
			//check if the sign variable is going to be positive or negative
			//if the sign variable is 0 add the change to the y value
			if(sign == 0)
			{
				//set value equal to value plus change
				value+=change;
			}
			//is the sign variable is 1 subtract the change variable form the y value
			else
			{
				//set value equal to value minus change
				value-=change;
			}
			
			//turn value back into a string using the to String method
			String salted = value.toString();
			
			//set the value at index i in the arraylist y to the new value
			y.set(i, salted);
		}
		
		//make a string variable with the name of the new file
		String saltedFileName = "salted.csv";
		
		//make a new file using the string variable
		File saltedFile = new File(saltedFileName);
		
		//try block
		try
		{
			//create a filewriter object and tells it to write on the file that was created
			FileWriter filewriter = new FileWriter(saltedFileName);
			
			//using the CSVWriter method from the opencsv library to create a CSVWriter object with the writer as filewriter and the comma as the separator
			CSVWriter writer = new CSVWriter(filewriter);
			
			//create the arraylist data of type staring array to hold the data
			ArrayList<String[]> data = new ArrayList<String[]>();
			
			//add the header line to the file
			data.add(new String[] {"Salted data", "x", "y"});
	
			//loop through the x arraylist
			for(int i = 0; i < x.size()-1; i ++)
			{
				//set the x coordinate to the wrapper class variable 
				Integer variable = i;
				//set the string xCoordinate equal to variable using the toString method
				String xCoordinate = variable.toString();
				//add the new line of data to the arraylist
				data.add(new String[] {null, xCoordinate, y.get(i+1)});
			}
			
			//use the writeAll method to write all the lines of data to the csv file
			writer.writeAll(data);
			//close the writer object 
			writer.close();
		}		
		//catch block to catch file not found errors
		catch (FileNotFoundException e) 
		{
			//print the error message
			System.err.println("File Unavailable: " + e.getMessage());
		}
		//catch block to catch io errors
		catch (IOException e) 
		{
			//print the error message
			e.printStackTrace();
		}
	}
}
