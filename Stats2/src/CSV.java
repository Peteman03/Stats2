import java.util.*;
import java.io.*;
import com.opencsv.CSVWriter;

public class CSV 
{
	public void writetoFile(int start, int end, double incriment)
	{
		File file = new File("function.csv");
		
		try
		{
			FileWriter filewriter = new FileWriter(file);
			
			CSVWriter writer = new CSVWriter(filewriter);
			
			ArrayList<String[]> data = new ArrayList<String[]>();
			
			data.add(new String[] {"y=x^3+x^2", "x", "y"});
			
			for(double i = start; i <= end; i += incriment)
			{
				Double variable =i;
				Double answer = Math.pow(i, 3) + Math.pow(i, 2);
				String y = answer.toString();
				String x = variable.toString();
				data.add(new String[] {null, x, y});
			}
			
			writer.writeAll(data);
			writer.close();
		}

		catch (IOException e) 
		{
		        e.printStackTrace();
		}
	}
}
