import java.util.*;
import java.io.*;
import com.opencsv.CSVWriter;

public class Plotter 
{
	/**
	 * The method the write data to a file using the OpenCSV library and its CSVWriter method
	 * @param start the location that the user wants the graph to start
	 * @param end the location on the graph where the user wants the graph to end
	 * @param increment what the user wants the graph to increment by
	 */
	public void writetoFile(int start, int end, int increment)
	{
		//create a file with the name function.csv
		File file = new File("function.csv");
		
		//try block
		try
		{
			//create a filewriter object and tells it to write on the file that was created
			FileWriter filewriter = new FileWriter(file);
			
			//using the CSVWriter method from the opencsv library to create a CSVWriter object with the writer as filewriter and the comma as the separator
			CSVWriter writer = new CSVWriter(filewriter);
			
			//create the arraylist of string arrays to store the data
			ArrayList<String[]> data = new ArrayList<String[]>();
			
			//add the heading line to the CSV fie
			data.add(new String[] {"y=x^3+x^2", "x", "y"});
			
			//for loop to loop through the graph sating at the start point and ending at the end point going up by the increment
			for(int i = start; i <= end; i += increment)
			{
				//set the x coordinate to variable looping through the array and set it to the wrapper class Integer
				Integer variable = i;
				//get the y value by adding x^3 and x^2 together and set it to the wrapper class Integer
				Integer answer = (int)(Math.pow(i, 3) + Math.pow(i, 2));
				//turn the answer into a string so it can be put in the array 
				String y = answer.toString();
				//turn the x coordinate into a string so it can be entered into the array
				String x = variable.toString();
				//add the new line of data to the array
				data.add(new String[] {null, x, y});
			}
			
			//write all the elements in the ArrayList data to the file
			writer.writeAll(data);
			//close the writer
			writer.close();
		}

		//catch block to catch any IO exception errors
		catch (IOException e) 
		{
				//print the error
		        e.printStackTrace();
		}
	}
}
