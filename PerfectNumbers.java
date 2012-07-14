import java.util.ArrayList;

/**
 * A Perfect number is a number whose sum of the divisors less then the number is the number itself
 * Ex : Number 6 : Divisors 1,2,3 => 1+2+3 = 6 Therfore 6 is perfect number
 * This program is used to find a set of perfect numbers between 1 and 10000
 *
 * @author sandeeprv
 */
public class PerfectNumbers {
	/**
	 * 	Main method of the program 
	 */
	public static void main(String[] args) {
		
	// remove the following Block comments and comment the for loop if you want to find whether a specific number is perfect or not	
	
	/*	Scanner scan = new Scanner(System.in);
		int number = scan.nextInt(); 
		printIfPerfect(number)
	*/
		for(int i=1;i<10000;i++){
			printIfPerfect(i);
		}
	
	}
	public static  void printIfPerfect(int number) {
		if (isPerfect(number)) {
			System.out.println(number + " is a perfect number");
		} // Uncomment else block to test print if not perfect
		/*else {
			System.out.println(number + " is not a perfect number");
		}*/
	}
	/**
	 * Returns true if a number is Perfect false otherwise
	 */
	public static Boolean isPerfect(int number) {
		ArrayList<Integer> divisors =  new ArrayList<Integer>();
		divisors = findDivisor(number);
		int sum = findSum(divisors);
		if (sum == number) {
			return true;
		}
		return false;
	}
	/**
	 *  returns a list of divisors of the number less then the number itself
	 */
	private static ArrayList<Integer> findDivisor(int number) {
		ArrayList<Integer> divisors = new ArrayList<Integer>(); 
		for (int i = 1; i <= number/2; i++) {
			if (number%i==0) {
				divisors.add(i);
			}
		}
		return divisors;
	}	
	/**
	 *	 returns sum of the integers in the list
	 */
	private static int findSum(ArrayList<Integer> divisors) {
		int sum = new Integer(0);
		for (Integer divisor : divisors) {
			sum += divisor;
		}
		return sum;
	}
}

