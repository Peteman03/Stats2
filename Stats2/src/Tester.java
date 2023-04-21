import java.util.Scanner;

public class Tester {

	public static void main(String[] args) 
	{
		CSV test = new CSV();
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Where do you want the graph to start: ");
		int start = reader.nextInt();
		System.out.println("Where do you want the graph to end: ");
		int end = reader.nextInt();
		System.out.println("What should the incriment of the graph be: ");
		double incriment = reader.nextDouble();
		
		test.writetoFile(start, end, incriment);

	}

}
