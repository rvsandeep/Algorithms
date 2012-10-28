import java.util.Scanner;
//Problem 1.16

public class LookUp extends BinarySearchTrees{
	
	/**
	 *  defined BinarySearchtrees class
	 */
	static BinarySearchTrees tree = new BinarySearchTrees();
	public static void main(String args[]){
		int choice;
		Scanner scan =  new Scanner(System.in);
		System.out.println("Enter choice : \n1:To use Test Cases 2: To give input");
		choice = scan.nextInt();
		switch (choice) {
		case 1:
			testCaseRunner(null);
			break;
		case 2:
			userInput(null);
		default:
			break;
		}			
	}
	
	private static void userInput(BinaryNode<Integer> root) {
		root = tree.constructTree(root);
		lookUp(root);
	}


	
	private static void testCaseRunner(BinaryNode<Integer> root) {
		
		int integerArray[][] = {{2,1,5,7,3,4},{33,31,34,35},{63,65,66,67,68},{91,102,104,105}};
		for(int i=0;i<integerArray.length;i++){
			root=tree.constructTree(root,integerArray[i]);
			lookUp(root);	
		}
	}
	/**
	 * 	takes a key and searches for the key in the tree
	 */
	public static void lookUp(BinaryNode<Integer> root) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the key to search in the tree : ");
		int key = scan.nextInt();
		Boolean found  = tree.lookUpRecursively(root,key);
		if(found){
			System.out.println("Value found on recursive look up");
		}else{
			System.out.println("Value Not found on recursive lookup");
		}
		found  = tree.lookupIteratively(root,key);
		if(found){
			System.out.println("Value found on iterative look up");
		}else{
			System.out.println("Value Not found on iterative lookup");
		}
	}



}
