import java.util.Arrays;
import java.util.Scanner;



public class CompletionSearch {
	
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
		System.out.println("Enter the number of employees : ");
		int number  =scan.nextInt();
		int payrolls[] = new int[number];
		System.out.println("Enter their previous pays : ");
		for(int i=0;i<number;i++){
			payrolls[i] = scan.nextInt();
		}
		Arrays.sort(payrolls);
		System.out.println("Enter the payroll expense: ");
		int expense = scan.nextInt();
		int cap = findCap(payrolls,expense);
		if(cap>=0){
			System.out.println("The Maximum pay to maintain the expenses is : "+cap);
		}else{
			System.out.println("Expenses Cannot be met");
		}
	}
	
	private static int findCap(int[] payrolls, int expense) {
		int range = getRange(payrolls,expense);
		if(range<0){
			return -1;
		}
		int cap = getCap(payrolls[range],payrolls[range+1],payrolls,expense);		
		return cap;
	}

	private static int getRange(int[] payrolls, int expense) {
		int sum = 0 ;
		for (int i = 0; i < payrolls.length-1; i++) {
			sum += payrolls[i];
			int payExpenseWithCapAsi =sum+(payrolls.length-i-1)*payrolls[i];
			int payExpenseWithCapAsNextToi = sum +payrolls[i+1]*(payrolls.length-i-1);
			if(payExpenseWithCapAsi<=expense&&payExpenseWithCapAsNextToi>=expense){
				return i;
			}
		}
		return -1;
	}

	private static int getCap(int low, int high, int[] payrolls, int expense) {
		if(low<=high){
//			System.out.println("low : "+low+" high: "+high+" expense: "+expense);
			int cap =low+(high-low)/2;
			/*if(cap==low||cap==high){
				return -1;
			}*/
			int payExpense = sumOf(cap,payrolls);
			if(payExpense<expense){
				return getCap(cap+1, high, payrolls, expense);
			}else if(payExpense>expense){
				return getCap(low, cap-1, payrolls, expense);
			}else{
				return cap;
			}
		}
		return -1;
	}
	
		private static int sumOf(int cap, int[] payrolls) {
			int sum=0 ; 
			for (int i = 0; i < payrolls.length; i++) {
				if(cap<=payrolls[i]){
					int expense = sum+(cap*(payrolls.length-i));
					return expense;
				}
				sum += payrolls[i];
			}
			return sum;
	}

	private static void testCaseRunner() {
		int integerArray[][] = {{2,1,5,7,3,4},{33,31,34,35},{63,65,66,67,68},{91,102,104,105}};
		for(int i=0;i<integerArray.length;i++){
//			int minCapacity=findBatteryCapacity(integerArray[i]);
//			System.out.println("The Minimum Battery Capacity should be : "+minCapacity);
		}
	}
}
