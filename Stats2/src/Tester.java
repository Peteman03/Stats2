import java.io.IOException;
import java.util.Scanner;

//tester method for the CSV writer salter and smoother
public class Tester 
{

	public static void main(String[] args) 
	{
		StatsLibrary tester = new StatsLibrary();
		
		System.out.println(tester.hypergeometricDistribution(10, 3, 5, 3));
		System.out.println(tester.poissonDistribution(4, 3.5));
		
		Plotter testCSV = new Plotter();
		CSVSalter testSalt = new CSVSalter();
		CSVSmoother testSmooth = new CSVSmoother();
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Where do you want the graph to start: ");
		int start = reader.nextInt();
		System.out.println("Where do you want the graph to end: ");
		int end = reader.nextInt();
		System.out.println("What should the incriment of the graph be: ");
		int incriment = reader.nextInt();
		
		testCSV.writetoFile(start, end, incriment);
		
		testSalt.Salter();
		
		testSmooth.Smooth();
	
	}

}
