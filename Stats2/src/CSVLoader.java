import java.util.*;
import java.io.*;


public class CSVLoader 
{

	public static void main(String[] args) 
	{
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
					
					ArrayList<String> row = new ArrayList<>();
					
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
		System.out.print(header + "\n");
		System.out.println();
		System.out.print(x + "\n");
		System.out.println();
		System.out.print(y);
	}
}
