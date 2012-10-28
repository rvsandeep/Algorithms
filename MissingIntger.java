package week2;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MissingIntger {

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
		System.out.println("Enter the number of integers in the array");
		int number  =scan.nextInt();
		int integerArray[] = new int[number];
		for(int i=0;i<number;i++){
			integerArray[i] = scan.nextInt();
		}
		findTheInteger(integerArray);
		
	}

	private static void testCaseRunner() {
		
		int integerArray[][] = {{2,1,5,7,3,4},{33,31,34,35},{63,65,66,67,68},{101,102,104,105}};
		for(int i=0;i<integerArray.length;i++){
			findTheInteger(integerArray[i]);
		}
	}

	/**
	 * 	finds the missing integer in the array by expressing the array elements in bit vector
	 */
	private static void findTheInteger(int[] integerArray) {
		print(integerArray);
		int bitVector[] = new int[integerArray.length+1];
		Map<Integer,Integer> keysAndPositions = new LinkedHashMap<Integer,Integer>();
		for (int i = 0; i < integerArray.length; i++) {
			int index =(integerArray[i])%(integerArray.length+1); 
			bitVector[index]=1;
			keysAndPositions.put(index, integerArray[i]);
		}
		int numberIndex =getMissingIndex(bitVector);
		int missingInteger = getTheNumber(numberIndex,integerArray,keysAndPositions);
		System.out.println("The Missing number in the array is: "+ missingInteger+"\n\n");
	}

	private static void print(int[] integerArray) {
		System.out.println("The array is : ");
		for(int each:integerArray){
			System.out.print(each+" ");
		}
		System.out.println();
	}

	/**
	 * 	returns the index of the missing the element
	 */
	private static int getMissingIndex(int[] bitVector) {
		int i;
		for(i=0 ;i<bitVector.length;i++){
			if(bitVector[i]==0){
				break;
			}
		}
		return i;
	}

	/**
	 * 	returns the number supposed to be in the missing position
	 */
	private static int getTheNumber(int numberIndex,int[] array, Map<Integer, Integer> keysAndPositions) {
		if(numberIndex==0){
			return (keysAndPositions.get(array.length-1)+1);
		}
		return (keysAndPositions.get(numberIndex-1)+1);
	}


}
