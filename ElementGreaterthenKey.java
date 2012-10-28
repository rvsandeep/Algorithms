
import java.util.Scanner;

//Problem : 1.17 Finding element greater then key

public class ElementGreaterthenKey extends BinarySearchTrees {

	
	static BinarySearchTrees tree = new BinarySearchTrees();

	/**
	 * 	Main method of the class
	 * 	chooses to use test case or take a fresh input from user
	 */
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
	/**
	 * 	calls the method construct tree in Binary search tree to construct tree for a set
	 * 	of input numbers and returns the root
	 * 	calls searchBySorting to get key and find it
	 */
	private static void userInput(BinaryNode<Integer> root) {
		root = tree.constructTree(root);
		searchBySorting(root);
	}
	/**
	 * 	pre defined numbers are used to find the key
	 */
	private static void testCaseRunner(BinaryNode<Integer> root) {
		
		int integerArray[][] = {{2,23,123,7,121,34},{0,-23,45,5},{1,95,34,67,28},{102,91,85,105}};
		for(int i=0;i<integerArray.length;i++){
			root=tree.constructTree(root,integerArray[i]);
			searchBySorting(root);
			root = tree.deleteTree(root);
			System.out.println("\n");
		}
	}
	/**
	 * 	is the first element greater then the key
	 */
	private static int ELEMENT;
	
	/**
	 * 	Takes the key and searches it by calling inorderSearch method and prints the element if found
	 */
	private static void searchBySorting(BinaryNode<Integer> root) {
		System.out.println("Enter the key : ");
		Scanner scan = new Scanner(System.in);
		int key = scan.nextInt();
		System.out.println("The inorder traversal of the tree is :");
		Boolean found = inorderSearch(root,key,false);
		if(!found){
			System.out.println("\nThere is no element greater then "+ key);
		}else{
			System.out.println("\nThe first element greater then "+key+" is : "+ELEMENT);
		}
	}
	/**
	 * inorder search is searching left child of a node first,then root and then the rigth
	 * traversing inorder will result in increasing order of the elements	
	 */ 
	private static Boolean inorderSearch(BinaryNode<Integer> root, int key,Boolean found) {
		if(root!=null){
			found = inorderSearch(root.left, key,found);
			System.out.print(root.item+" ");
			if(root.item>key&&(!found)){
				ELEMENT=root.item;
				found =  true;
			}
			found = inorderSearch(root.right, key,found);				
		}
		return found;
	}

}
