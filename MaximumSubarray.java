
import java.util.Scanner;

public class MaximumSubarray {

		public static void main(String args[]){
//			User Input or just use the testCases
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
			int array[] = new int[number];
			System.out.println("Enter the integers : ");
			for(int i=0;i<number;i++){
				array[i] = scan.nextInt();
			}
			findMaximumsubarray(array);			
		}

		/* 
		 * in case the start and end index are not needed a much simpler on would be (algorithm is in python)
		 *	 def MaximumSubarray(array):
    			maxsoFar = 0
    			maxend = 0
    			for each in array:
        			maxend = max(0,maxend+each)
        			maxsoFar  = max(maxend,maxsoFar)
    			return maxsoFar
		 */
		private static void findMaximumsubarray(int[] array){
			System.out.println("The array is: ");
			for (int i : array) {
				System.out.print(i+" ");
			}
			System.out.println();
			int startIndex =0 ;
			int endIndex =0 ;
			int sum = array[0];
			int maximumSum = array[0]; 
			for(int i=1;i<array.length;i++){
				sum += array[i];
				if(sum<array[i]&&maximumSum<array[i]){
					sum = array[i];
					startIndex = i;
					endIndex = i;
				}
				if(sum>maximumSum){
					maximumSum = sum;
					endIndex = i;
				}
			}
			System.out.println("The Maximum sum should be  "+maximumSum + " with start index as "+startIndex+" end as "+endIndex+"\n\n");
			return ;
		}

		private static void testCaseRunner() {	
			int integerArray[][] = {{-2,2,5,7,3,4},{33,-31,34,35},{63,65,-66,64,-68},{91,-102,-104,-105},{-102,-104,-105,91}};
			for(int i=0;i<integerArray.length;i++){
				findMaximumsubarray(integerArray[i]);
			}
		}
}
