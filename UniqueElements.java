import java.util.Arrays;
import java.util.Scanner;

/**
 * @author sandeeprv
 *
 */
public class UniqueElements {

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
		System.out.println("Enter the number of names: ");
		int number  =scan.nextInt();
		String names[] = new String[number];
		System.out.println("Enter names: ");
		for(int i=0;i<number;i++){
			names[i] = scan.nextLine();
		}
		printUniqueNames(names);
	}

	/**
	 * provides a some number of dictionary of words
	 */
	private static void testCaseRunner() {
		
		String names[][] = {{"sheldon","penny","rajesh","howard","sheldon","rajesh"},{"zoro","tintin","tintin","john","jack","zoro","mark","henessy","mark","zoro","penny","tintin","zoro"}};
		for(int i=0;i<names.length;i++){
			printUniqueNames(names[i]);
		}
	}

	private static void printUniqueNames(String[] strings) {
		System.out.println("Entered names are : ");
		for (String string : strings) {
			System.out.println(string);
		}
		System.out.println();
//		the array is sorted in lexicographic order,takes O(nlogn) complexity
		Arrays.sort(strings);
//		replacing elements inline while traversing for better space efficiency
		int j=1;
		for (int i = 1; i < strings.length; i++) {
			if(strings[i]!=strings[j-1]){
				strings[j]=strings[i];
				j++;
			}
		}
		System.out.println("Unique Names are : ");
		for (int i = 0; i <j; i++) {
			System.out.println(" "+strings[i]);
		}
		System.out.println("\n");
	}

}
