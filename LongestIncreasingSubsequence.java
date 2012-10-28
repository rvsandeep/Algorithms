// Problem : 3.1
import java.util.Scanner;

/**
 * 	@author sandeeprv
 *	Find the longest increasing subsequence in an array
 */

public class LongestIncreasingSubsequence {

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

	
	private static void userInput() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of elements");
		int number  =scan.nextInt();
		int elements[] = new int[number];
		System.out.println("Enter the integers : ");
		for(int i=0;i<number;i++){
			elements[i] = scan.nextInt();
		}
		findLongestIncreasingsequence(elements);		
	}

	private static void findLongestIncreasingsequence(int[] elements) {
		System.out.println();
		for (int i : elements) {
			System.out.print(i+" ");
		}
		System.out.println();
//		the index of the last element of the sequence 
		int answer = 0;
//		bestLength of each element is the length of the subsequence with the element being the last element in the sequence
		int bestLength[] = new int[elements.length];
//		previousElement of an element is that before it in the last element less then it 
		int previousElement[] = new int[elements.length];
//		bestLength of each element is one since it can be the only element in the sequence if none greater then it is there
//		previousElement of each is initially undetermined and is -1
		for(int i =0;i<elements.length;i++){
			bestLength[i]=1;
			previousElement[i] = -1;
		}
		
		for(int i = 0 ;i<elements.length;i++){
			for(int j=i+1;j<elements.length;j++){
				if(elements[i]<=elements[j]){
//				to get the largest possible sequence
					if(bestLength[i]+1>bestLength[j]){
						bestLength[j]=bestLength[i]+1;
						previousElement[j]=i;
					}
					if(bestLength[j]>bestLength[answer]){
						answer = j;
					}
				}
				
			}
		}
		int subSequence[] = new int[bestLength[answer]];
		int length = bestLength[answer];
//		following the previousElements of the answer gets the sequence
		for(int i = length-1;i>=0;i--){
			subSequence[i] = elements[answer];
			answer = previousElement[answer];
		}
//		finally the answer :)
		System.out.println("The longest subsequence is : ");
		for(int each: subSequence){
			System.out.print(each+" ");
		}
		System.out.println();	
	}
	private static void testCaseRunner() {
		
		int integerArray[][] = {{2,1,5,7,3,4},{33,31,30,35},{63,60,-1,67,68},{170,102,04,55}};
		for(int i=0;i<integerArray.length;i++){
			findLongestIncreasingsequence(integerArray[i]);
		}
	}
}
