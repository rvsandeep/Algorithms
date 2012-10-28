import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

// Problem : 1.9 Search for Pair of numbers which sums to S
public class SearchPair {
	
	/**
	 * 	Array in which in the pair of numbers will be searched 
	 */
	private static int array[] = {1,2,3,49,10,11,12,13,14,15};
	
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
		int sum;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter sum");
		sum = scan.nextInt();
		findPair(sum);
	}

	private static void testCaseRunner() {
//		an array of sums
		int sums[] = {23,12,15,20,21,22,48};
		for (int i = 0; i < sums.length; i++) {
			findPair(sums[i]);
		}
	}

	/**
	 * 	finds the pair by subtracting each element in the array from the sum 
	 * 	and checks if the difference is in the array if yes prints these two as the pair
	 */
	private static void findPair(int sum) {
		System.out.println("The array is : ");
		for(int each:array){
			System.out.print(each + " ");
		}
		System.out.println();
		Map<Integer,Integer> map = new LinkedHashMap<Integer,Integer>();
		for(int i=0 ;i<array.length;i++){
			map.put(array[i],i);
		}
		boolean aPairExist = false;
		for(int each : map.keySet()){
			if (each<sum) {
				int key = sum - each;
				if(map.containsKey(key)){
					aPairExist = true;
					System.out.println("Given Sum : " +sum + "\nValues : "+each+" + "+key+" = "+sum);
					System.out.println("There index : " + map.get(each) +" "+map.get(key)+"\n");
					break;
				}
			}
		}
		if (!aPairExist) {
			System.out.println(" No such Pair Exist whose sum is " + sum);			
		}
		
	}


}
