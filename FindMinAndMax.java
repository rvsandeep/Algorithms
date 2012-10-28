import java.util.Scanner;

public class FindMinAndMax {
// Problem 2.4 Finding minimum and maximum simultaneously
	
	
	public static void main(String args[]){
//		User Input or just use the testCases
		int choice;
		Scanner scan =  new Scanner(System.in);
		System.out.println("Enter choice : \n1:To use Test Cases 2: To give input");
		choice = scan.nextInt();
		switch (choice) {
		case 1:
			testCaseRunner();
			break;
		case 2:
			userInput();
		default:
			break;
		}
	}

	/**
	 * 	take input from the user instead of using the testcases
	 */
	private static void userInput() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of elements in the array");
		int number  =scan.nextInt();
		int heights[] = new int[number];
		System.out.println("Enter the elements : ");
		for(int i=0;i<number;i++){
			heights[i] = scan.nextInt();
		}
		findMinAndMax(heights);
		
	}
	private static void testCaseRunner() {
		
		int integerArray[][] = {{2,1,5,7,3,4},{33,31,34,35},{63,65,66,67,68},{91,102,104,105}};
		for(int i=0;i<integerArray.length;i++){
			findMinAndMax(integerArray[i]);
		}
	}

	//	COMPARISIONCOUNT	keeps count of the total number of comparisons involved 
	
	private static int COMPARISONCOUNT = 0 ;
	
	/**
	 * 	This method divides the array into pairs and 
	 * 	separates the maximum and minimum to different sets
	 */
	private static void findMinAndMax(int[] integers) {
		COMPARISONCOUNT =0;
		System.out.print("\nThe Elements in the array are : ");
		for (int i = 0; i < integers.length; i++) {
			System.out.print(integers[i]+" ");
		}
		System.out.println("\n");
		int i =0, maxiter=0,miniter=0 ;
		int maxSet[] = new int[integers.length];
		int minSet[] = new int[integers.length];
		while(i<integers.length){
			
			if(i+1==integers.length){
				maxSet[maxiter++]=integers[i++];
			}else{
				if(integers[i]>integers[i+1]){
					maxSet[maxiter++]=integers[i++];
					minSet[miniter++]=integers[i++];
				}else{
					minSet[miniter++]=integers[i++];
					maxSet[maxiter++]=integers[i++];
				}
				COMPARISONCOUNT++;
			}
		}
		
		int minimum = findMin(minSet,miniter);
		int maximum = findMax(maxSet,maxiter);
		
		System.out.println("Minimum element in the array is : "+minimum);
		System.out.println("Maximum element in the array is : "+maximum);
		System.out.println("Comparision Count : "+ COMPARISONCOUNT + "\nTheoritcal count : "+(3*integers.length/2-1));
	}

	/**
	 * 	finds the maximum in the set having the maximum among the pairs
	 */
	private static int findMax(int[] maxSet, int maxiter) {
		int maximum = maxSet[0];
		for (int j = 1; j < maxiter; j++) {
			if(maxSet[j]>maximum){
				maximum = maxSet[j];
			}
			COMPARISONCOUNT++;
		}
		return maximum;
	}

	/**	
	 * 	returns the minimum in the set with minimum of the two pairs
	 */
	private static int findMin(int[] minSet, int miniter) {
		int minimum = minSet[0];
		for (int j = 1; j <miniter; j++) {
			if(minSet[j]<minimum){
				minimum = minSet[j];
			}
			COMPARISONCOUNT++;
		}
		return minimum;
	}

}
