import java.math.BigInteger;
import java.util.*;

public class StatsLibrary
{	
	/**
	 * take in an arraylist of integers and determine what the mean of the list is
	 * @param arraylist of type integer
	 * @return the mean of the arraylist
	 */
	public double mean(ArrayList<Integer> list)
	{
		//initialize the necessary variables
		int sum = 0;
		double average;
		
		//loop through the list
		for(int i = 0; i < list.size(); i ++)
		{
			//add the values of the list to the sum
			sum += list.get(i);
		}

		//divide the sum by the size of the list then cast that value to a double and return the value
		average = (double)sum/list.size();
		return average;
	}
	
	/**
	 * take in an arraylist of integers and determine what the median is or return null if no median exists
	 * @param arraylist of type integer
	 * @return the median of the arraylist or null if none exists
	 */
	public Object median(ArrayList<Integer> list)
	{
		//check if the length of the arraylist is odd
		if(list.size() % 2 == 1)
		{
			//set the median equal to the number in the middle of the arryalist and return
			int median = list.get(list.size()/2);
			return median;
		}
		
		//if the length of the arraylist is even
		else
		{
			return null;
		}
	}
	
	/**
	 * take in an arraylist and see what item appears the most or null if multiple items appear the most 
	 * created using the help of stack overflow
	 * @param arraylist of type integer
	 * @return the mode of the set or null if none exists
	 */
	public Object mode(ArrayList<Integer> list)
	{
		//initialize the necessary variables
		int counter = 0;
		int modeCounter = 0;
		int mode = 0;
		boolean test = false;
		
		//loop through the arraylist
		for(int i = 0; i < list.size(); i ++)
		{
			//set the index equal to the element in the arraylist
			int index = list.get(i);
			counter = 0;
			
			//loop through the rest of the arraylist after the index of the outer loop
			for(int j = i+1; j < list.size(); j ++)
			{
				//check if any other elements in the arraylist match the value of the index
				if(list.get(j) == index)
				{
					//increment the counter 
					counter++;
					
					//check if the index is now the mode
					if(counter > modeCounter)
					{
						//make the mode the index and set the mode counter equal to the counter
						mode = index;
						modeCounter = counter;
						
					}
					//check if there is no clear mode
					else if(counter == modeCounter)
					{
						//set the test value to true and exit the inner for loop
						test = true;
						break;
					}
				}
			}
		}
		
		//check if there is no clear mode
		if(test || mode == 0)
		{
			return null;
		}
		//if there is a clear mode
		else
		{
			//return the mode
			return mode;
		}
	}
	
	/**
	 * take in an arraylist of integers and determine the standard deviation of the list
	 * @param an arraylist of integers
	 * @return return the standard deviation of the arraylist
	 */
	public double standardDeviation(ArrayList<Integer> list)
	{
		//initialize the necessary variables
		int sum = 0;
		double standardDeviation;
		
		//loop through the arraylist
		for(int i = 0; i < list.size(); i ++)
		{
			//add up values of the list minus the mean of the arraylist squared
			sum += Math.pow(list.get(i) - mean(list), 2);
		}
		
		//set the answer equal to the square root of the sum divided by size of the list
		standardDeviation = Math.sqrt(sum/list.size());
		
		//return the answer
		return standardDeviation;
	}
	
	/**
	 * find the number of combinations in a set given the size of the set and how many numbers are being taken
	 * @param n, the size of the set
	 * @param r, the number taken from the set
	 * @return the total number of combinations of n and r
	 */
	public BigInteger combination(int n, int r)
	{	
		//get the permutation of n and r
		BigInteger permutation = permutation(n,r);
		
		//get the factorial of r
		BigInteger factorialR = factorial(r);
		
		//divide the permutation of n and r by the factorial of r
		BigInteger combination = permutation.divide(factorialR);
		
		//return the answer
		return combination;
	}
	
	/**
	 * find the number of permutations in a set given the size of the set and how many numbers are being taken
	 * Using the factorial method
	 * @param n, the size of the set
	 * @param r, the number taken from the set, without replacing
	 * @return the number of permutations of n and r
	 */
	public BigInteger permutation(int n, int r)
	{
		//divide the factorial of n by the factorial of the difference of n and r 
		BigInteger permutation = factorial(n).divide(factorial(n-r));
		
		//return the answer
		return permutation;
	}
	
	/**
	 * Method to find the factorial of a given number using BigIntegers
	 * Looked up on GeeksForGeeks on how to properly utilize BigInteger methods
	 * @param number
	 * @return the factorial of the given number as a BigInteger
	 */
	public BigInteger factorial(int number)
	{
		//set the factorial equal to 1
		BigInteger factorial = new BigInteger("1");
		
		//loop through each value from 2 to the number inputed
		for(int i = 2; i <= number; i++)
		{
			//multiply the factorial by the value of i
			factorial = factorial.multiply(BigInteger.valueOf(i));
		}
	
		//return the answer
		return factorial;
	}
	
	/**
	 * Method to determine the binomial distribution of an exact y
	 * @param n, number of trials
	 * @param p, probability of success
	 * @param y, number of success
	 * @return the binomial distribution given n,p, and y
	 */
	public double binomialDistributionExact(int n, double p, int y)
	{
		//cast the combination of n and y to a double
		double combination = combination(n,y).doubleValue();  
		
		//take p and raise it to the y power
		double pxy = Math.pow(p, y); 
		
		//take 1-p and raise it to the n-y power
		double qxy = Math.pow(1-p, n-y);
		
		//multiply the combination pxy and qxy values together and return the result
		return combination*pxy*qxy;
		
	}
	
	/**
	 * Method to determine the binomial distribution from y to max
	 * @param n, number of trials
	 * @param p, probability of success
	 * @param y, number of success
	 * @param max, max number of success
	 * @return the binomial distribution given n,p,y, and max
	 */
	public double binmoialDistribution(int n, double p, int y, int max)
	{
		//initialize the answer variable
		double answer = 0;
		
		//loop from the first number to the max number
		for(int i = y; i <= max; i ++)
		{
			//add the binomial distributions together
			answer += binomialDistributionExact(n,p,i);
		}
		//return the answer
		return answer;
	}
	
	/**
	 * Method to determine the geometric distribution of an event occurring given the number of trials and probability of success
	 * @param y the number of trials
	 * @param p the probability of success
	 * @return the geometric distribution of the event occurring first on trial y with probability p
	 */
	public double geometricDistribution(int y, double p)
	{
		return Math.pow(1-p, y-1) * p;
	}
	
	/**
	 * Method to determine the geometric distribution of an event occurring on or before the given trial with probability p
	 * @param y the number of trials
	 * @param p the probability of success
	 * @return the geometric distribution of the event occurring on or before y with probability p
	 */
	public double geometricDistributionOnOrBefore(int y, double p)
	{
		return 1-Math.pow(1-p, y);
	}
	
	/**
	 * Method to determine the geometric distribution of an event occurring before the given trial with probability p
	 * @param y the number of trials
	 * @param p the probability of success
	 * @return the geometric distribution of the event occurring before trial y with probability p
	 */
	public double geometricDistributionBefore(int y, double p)
	{
		return 1-Math.pow(1-p, y-1);
	}
	
	/**
	 * Method to determine the geometric distribution of an event occurring on or after the given trial with probability p
	 * @param y the number of trials
	 * @param p the probability of success
	 * @return the geometric distribution of the event occurring on or after trial y with probability p
	 */
	public double geometricDistributionOnOrAfter(int y, double p)
	{
		return Math.pow(1-p, y-1);
	}
	
	/**
	 * Method to determine the geometric distribution of an event occurring after the given trial with the probability p
	 * @param y the number of trials
	 * @param p the probability of success
	 * @return the geometric distribution of the event occurring after trial y with probability p
	 */
	public double geometricDistributionAfter(int y, double p)
	{
		return Math.pow(1-p, y);
	}
	
	/**
	 * Method to determine the hypergeometric distribution of an event given N, n, r, and y
	 * @param N set of elements
	 * @param n sample of elements
	 * @param r element of interest
	 * @param y variable of interest
	 * @return the hypergeomtric distribution as a double
	 */
	public double hypergeometricDistribution(int N, int n, int r, int y)
	{
		//get part of the numerator by doing a combination between r and y
		BigInteger combo1 = combination(r,y);
		//get the other part of the numerator by doing a combination between N-r and n-y
		BigInteger combo2 = combination(N-r,n-y);
		//get the denominator by doing the combination of N and n
		BigInteger combo3 = combination(N,n);
		
		//set the values equal to a double and multiply the parts of the numerator together and divide by the denominator
		return (combo1.doubleValue()*combo2.doubleValue())/(combo3.doubleValue());
	}
	
	/**
	 * Determine the poisson distribution for an event given y and h as lambda
	 * @param y the variable of interest
	 * @param h is lambda or the rate
	 * @return the poisson distribution as a double
	 */
	public double poissonDistribution(int y, double h)
	{
		//get the denominator by doing the factorial of y
		BigInteger denominator = factorial(y);
		//get the numerator by multiplying lambda to the y power and e to the negative lambda power
		double numerator = Math.pow(h, y) * Math.pow(Math.E, -h);
		
		//set the value of a denominator to a double and divide the numerator by it
		return numerator/denominator.doubleValue();
	}
}
