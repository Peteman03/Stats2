import java.io.*;
import java.util.*;
import com.opencsv.CSVWriter;

public class CSVSmoother 
{
	/**
	 * Smoother method to smooth the salted function
	 * Utilizes code from the CSVLoader class and CSV class
	 */
	public void Smooth()
	{
		//reused code from the CSVLoader class until line 67
		ArrayList<String> x = new ArrayList<>();
		ArrayList<String> y = new ArrayList<>();
		ArrayList<String> header = new ArrayList<>();

		String filename = "salted.csv";

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
		
		//Start of new code
		//loop through the y arrayylist
		for(int i = 1; i < y.size(); i++)
		{
			//check the index of the arraylist
			//if the index is 1, which is the start of the graph
			if(i == 1)
			{
				//determine the different values in the arraylist by parsing them as doubles and removing the double quotes
				double value = Double.parseDouble(y.get(i).replaceAll("\"", ""));
				double value1 = Double.parseDouble(y.get(i+1).replaceAll("\"", ""));
				double value2 = Double.parseDouble(y.get(i+2).replaceAll("\"", ""));
				double value3 = Double.parseDouble(y.get(i+3).replaceAll("\"", ""));
				
				//creating an answer variable to hold the average
				Double answer = (value + value1 + value2 + value3)/4;
				
				//turning the answer into a string using the toString method
				String smoothed = answer.toString();
				//setting the y value at index i to the new value
				y.set(i, smoothed);
			}
			//if the index is 2, which is the second element of the graph
			else if(i == 2)
			{
				//determine the different values in the arraylist by parsing them as doubles and removing the double quotes
				double value = Double.parseDouble(y.get(i).replaceAll("\"", ""));
				double value1 = Double.parseDouble(y.get(i+1).replaceAll("\"", ""));
				double value2 = Double.parseDouble(y.get(i+2).replaceAll("\"", ""));
				double value3 = Double.parseDouble(y.get(i+3).replaceAll("\"", ""));
				double value4 = Double.parseDouble(y.get(i-1).replaceAll("\"", ""));
				
				Double answer = (value + value1 + value2 + value3 + value4)/5;
							
				//turning the answer into a string using the toString method
				String smoothed = answer.toString();
				//setting the y value at index i to the new value
				y.set(i, smoothed);
				
			}
			//if the index is 3 which, which is the third element of the graph
			else if(i == 3)
			{
				//determine the different values in the arraylist by parsing them as doubles and removing the double quotes
				double value = Double.parseDouble(y.get(i).replaceAll("\"", ""));
				double value1 = Double.parseDouble(y.get(i+1).replaceAll("\"", ""));
				double value2 = Double.parseDouble(y.get(i+2).replaceAll("\"", ""));
				double value3 = Double.parseDouble(y.get(i+3).replaceAll("\"", ""));
				double value4 = Double.parseDouble(y.get(i-1).replaceAll("\"", ""));
				double value5 = Double.parseDouble(y.get(i-2).replaceAll("\"", ""));
				
				//creating an answer variable to hold the average
				Double answer = (value + value1 + value2 + value3 + value4 + value5)/6;
								
				//turning the answer into a string using the toString method
				String smoothed = answer.toString();
				//setting the y value at index i to the new value
				y.set(i, smoothed);
			}
			//if the index is 2 away from the end of the arraylist
			else if(i == y.size()-3)
			{
				//determine the different values in the arraylist by parsing them as doubles and removing the double quotes
				double value = Double.parseDouble(y.get(i).replaceAll("\"", ""));
				double value1 = Double.parseDouble(y.get(i-1).replaceAll("\"", ""));
				double value2 = Double.parseDouble(y.get(i-2).replaceAll("\"", ""));
				double value3 = Double.parseDouble(y.get(i-3).replaceAll("\"", ""));
				double value4 = Double.parseDouble(y.get(i+1).replaceAll("\"", ""));
				double value5 = Double.parseDouble(y.get(i+2).replaceAll("\"", ""));
				
				//creating an answer variable to hold the average
				Double answer = (value + value1 + value2 + value3 + value4 + value5)/6;
				
				//turning the answer into a string using the toString method
				String smoothed = answer.toString();
				//setting the y value at index i to the new value
				y.set(i, smoothed);
			}
			//if the index is 1 away from the end of the arraylist
			else if(i == y.size()-2)
			{
				//determine the different values in the arraylist by parsing them as doubles and removing the double quotes
				double value = Double.parseDouble(y.get(i).replaceAll("\"", ""));
				double value1 = Double.parseDouble(y.get(i-1).replaceAll("\"", ""));
				double value2 = Double.parseDouble(y.get(i-2).replaceAll("\"", ""));
				double value3 = Double.parseDouble(y.get(i-3).replaceAll("\"", ""));
				double value4 = Double.parseDouble(y.get(i+1).replaceAll("\"", ""));
				
				//creating an answer variable to hold the average
				Double answer = (value + value1 + value2 + value3 + value4)/5;
				
				//turning the answer into a string using the toString method
				String smoothed = answer.toString();
				//setting the y value at index i to the new value
				y.set(i, smoothed);
			}
			//if the index is the end of the arraylist
			else if(i == y.size()-1)
			{
				//determine the different values in the arraylist by parsing them as doubles and removing the double quotes
				double value = Double.parseDouble(y.get(i).replaceAll("\"", ""));
				double value1 = Double.parseDouble(y.get(i-1).replaceAll("\"", ""));
				double value2 = Double.parseDouble(y.get(i-2).replaceAll("\"", ""));
				double value3 = Double.parseDouble(y.get(i-3).replaceAll("\"", ""));

				//creating an answer variable to hold the average
				Double answer = (value + value1 + value2 + value3)/4;
				
				//turning the answer into a string using the toString method
				String smoothed = answer.toString();
				//setting the y value at index i to the new value
				y.set(i, smoothed);
			}
			//is the index is between the 3 and size-3 
			else
			{
				//determine the different values in the arraylist by parsing them as doubles and removing the double quotes
				double value = Double.parseDouble(y.get(i).replaceAll("\"", ""));
				double value1 = Double.parseDouble(y.get(i+1).replaceAll("\"", ""));
				double value2 = Double.parseDouble(y.get(i+2).replaceAll("\"", ""));
				double value3 = Double.parseDouble(y.get(i+3).replaceAll("\"", ""));
				double value4 = Double.parseDouble(y.get(i-1).replaceAll("\"", ""));
				double value5 = Double.parseDouble(y.get(i-2).replaceAll("\"", ""));
				double value6 = Double.parseDouble(y.get(i-3).replaceAll("\"", ""));
				
				//creating an answer variable to hold the average
				Double answer = (value + value1 + value2 + value3 + value4 + value5 + value6)/7;
				
				//turning the answer into a string using the toString method
				String smoothed = answer.toString();
				//setting the y value at index i to the new value
				y.set(i, smoothed);
			}
			
		}
		
		//create a string variable to hold the file name
		String smoothedFileName = "smooth.csv";
		//create a new file using the string variable
		File smoothFile = new File(smoothedFileName);
		
		//try block
		try
		{
			//create a filewriter object and tells it to write on the file that was created
			FileWriter filewriter = new FileWriter(smoothedFileName);
			
			//using the CSVWriter method from the opencsv library to create a CSVWriter object with the writer as filewriter and the comma as the separator
			CSVWriter writer = new CSVWriter(filewriter);
			
			//create an array list of type string array to hold the datas
			ArrayList<String[]> data = new ArrayList<String[]>();
			
			//add a header to the file
			data.add(new String[] {"Smoothed data", "x", "y"});
			
			//loop through the x arraylist
			for(int i = 0; i < x.size()-1; i ++)
			{
				//set the x value as the wrapper class Integer variable variable
				Integer variable = i;
				//turn the x value into a string using the toString method
				String xCoordinate = variable.toString();
				//add the new line of data to the arraylist
				data.add(new String[] {null, xCoordinate, y.get(i+1)});
			}
			
			//add all the data to the file
			writer.writeAll(data);
			//close the writer object
			writer.close();
			
		}
		//catch block for file not found errors
		catch (FileNotFoundException e) 
		{
			//print the error message
			System.err.println("File Unavailable: " + e.getMessage());
		} 
		//catch block for io errors
		catch (IOException e) 
		{
			//print the error
			e.printStackTrace();
		}
	}
}
