
import java.util.Scanner;
//Problem 1.13

public class RobotBatteryCapacity {

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
		System.out.println("Enter the number of ascents the robot has to climb");
		int number  =scan.nextInt();
		int heights[] = new int[number];
		System.out.println("Enter the heights : ");
		for(int i=0;i<number;i++){
			heights[i] = scan.nextInt();
		}
		int minCapacity = findBatteryCapacity(heights);
		System.out.println("The Minimum Battery Capacity should be : "+minCapacity);
		
	}

	/**
	 * 	finds the minimum battery capacity the robot should have
	 * 	the difference between the highest valley and the lowest one is the required minimum capacity
	 */
	private static int findBatteryCapacity(int[] heights) {
		if(heights.length<2){
			return 0;
		}
		int min=heights[0];
		int result=-1;
		for(int i=1;i<heights.length;i++){
			if(heights[i]-min>result){
				result=heights[i]-min;
			}
			if(heights[i]<min){
				min=heights[i];
			}
		}
		return result;
	}

	private static void testCaseRunner() {
		
		int integerArray[][] = {{2,1,5,7,3,4},{33,31,34,35},{63,65,66,67,68},{91,102,104,105}};
		for(int i=0;i<integerArray.length;i++){
			int minCapacity=findBatteryCapacity(integerArray[i]);
			System.out.println("The Minimum Battery Capacity should be : "+minCapacity);
		}
	}



}
