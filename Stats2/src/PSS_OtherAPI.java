import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;

//import the necessary methods from JFreeChart
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class PSS_OtherAPI extends JFrame
{
	private JFrame frame;
	
	/**
	 * Create the application.
	 */
	public PSS_OtherAPI() 
	{
		super("Plotter Smoother Solver");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		//make and set the bounds for the graph
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//create the xylinechart with a title, labels, and the proper dataset
		JFreeChart chart = ChartFactory.createXYLineChart("Plotter Salter Smoother", "X", "Y", createDataset());
		
		//create a chartpanel object that takes in the xylinechart as a parameter
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setLocation(0, 0);
		chartPanel.setSize(444, 266);
        frame.add(chartPanel, BorderLayout.CENTER);
		
	}
	
	//method to create the dataset that will hold the data from each CSV file
	private XYDataset createDataset()
	{
		//create the dataset object of type xyseriescollection since the graph is going to be a xyline graph
		XYSeriesCollection dataset = new XYSeriesCollection();
		
		//create a series for each of the different functions
		XYSeries plotter = new XYSeries("Plotter"); 
		XYSeries salter = new XYSeries("Salter");
		XYSeries smoother = new XYSeries("Smooter");
		
		//use the csvloader for each of the functions
		CSVLoader plot = new CSVLoader("function.csv");
		CSVLoader salt = new CSVLoader("salted.csv");
		CSVLoader smooth = new CSVLoader("smooth.csv");
		
		//for loop to loop through the regular function
		for(int i = 1; i < plot.getX().size(); i++)
		{
			//parse the values of the csv file to a double
			double x = Double.parseDouble(plot.getX().get(i).replaceAll("\"", ""));
			double y = Double.parseDouble(plot.getY().get(i).replaceAll("\"", ""));
			//add the data to the data series
			plotter.add(x, y);
		}
		
		//for loop to loop through the salted function
		for(int i = 1; i < salt.getX().size(); i++)
		{
			//parse the values of the csv file to a double
			double x = Double.parseDouble(salt.getX().get(i).replaceAll("\"", ""));
			double y = Double.parseDouble(salt.getY().get(i).replaceAll("\"", ""));
			//add the data to the data series
			salter.add(x, y);
		}
		
		//for loop to loop through the smoothed function
		for(int i = 1; i < smooth.getX().size(); i++)
		{
			//parse the values of the csv file to a double
			double x = Double.parseDouble(smooth.getX().get(i).replaceAll("\"", ""));
			double y = Double.parseDouble(smooth.getY().get(i).replaceAll("\"", ""));
			//add the data to the series
			smoother.add(x, y);
		}
		
		//add all of the series to the data set
		dataset.addSeries(plotter);
		dataset.addSeries(salter);
		dataset.addSeries(smoother);
		
		//return the data set
		return dataset;
	}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					PSS_OtherAPI window = new PSS_OtherAPI();
					window.frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
}