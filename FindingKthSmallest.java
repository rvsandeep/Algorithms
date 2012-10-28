import java.util.Scanner;
//Problem : 1.17

/**
* @author sandeeprangam
*/
public class FindingKthSmallest {


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
	 * 	take input from the user instead of using the test cases
	 */
	private static void userInput() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of integers in the first array");
		int number1  =scan.nextInt();
		int integerArray1[] = new int[number1];
		for(int i=0;i<number1;i++){
			integerArray1[i] = scan.nextInt();
		}
		System.out.println("Enter the number of integers in the second array");
		int number2  =scan.nextInt();
		int integerArray2[] = new int[number2];
		for(int i=0;i<number2;i++){
			integerArray2[i] = scan.nextInt();
		}
		getK(number1, integerArray1, number2, integerArray2);
		
	}

	/**
	 * 	Obtains K from user and prints the Kth smallest element
	 */
	private static void getK(int number1, int[] integerArray1, int number2,
			int[] integerArray2) {
		System.out.println("\nEnter the K (to find Kth Smallest element)?");
		Scanner scan = new Scanner(System.in);
		int K = scan.nextInt();
		int element = findKthSmallest(integerArray1,number1,integerArray2,number2,K);
		System.out.println(K+"th smallest element found is "+element);
	}
	/**
	 * finds the Kth smallest element in two  sorted arrays in O(log(m)+log(n))
	 * where m and n are the size of the two arrays i.e number1 and number2 in this case
	 */
	private static int findKthSmallest(int[] integerArray1, int number1,
			int[] integerArray2, int number2, int k) {
		
		assert(number1==0&&number2==0);
		assert(number1+number2<k);
		assert(k>0);
		int begin = Math.max(0,k-number2);
		int end = Math.min(number1, k);
		while(begin<end){
			int l = (begin+end)/2;
			if(l<number1&&k-l>0&&integerArray1[l]<integerArray2[k-l-1]){
				begin = l+1;
			}else if(l>0&&(k-l<number2)&&(integerArray1[l-1]>integerArray2[k-l])){
				end=l;
			}else{
				begin = l;
				break;
			}
		}
		if(begin==0){
			return(integerArray2[k-1]);
		}else if(begin==k){
			return integerArray1[k-1];
		}else{
			return Math.max(integerArray1[begin-1],integerArray2[k-begin-1]);
		}					
	}

	private static void testCaseRunner() {
		
		int integerArray[][] = {{1,5,16,27,38},{0,0,2,8,14},{-1,3,7,9},{10,12,24,35}};
		for(int i=0;i<integerArray.length-1;i++){
			
			showArray(integerArray[i],integerArray[i+1]);
			getK(integerArray[i].length,integerArray[i],integerArray[i+1].length,integerArray[i+1]);
		}
	}

	/**
	 * prints the two arrays
	 */
	private static void showArray(int[] list1, int[] list2) {
		System.out.println("array1 : ");
		for(int each:list1){
			System.out.print(each+ " ");
		}
		System.out.println("\narray2 : ");
		for(int each:list2){
			System.out.print(each+" ");
		}
	}

}
