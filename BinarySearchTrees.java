import java.util.Scanner;


public class BinarySearchTrees{
	
	/**
	 *	the class binary Node is for each node of the tree
	 * 	it has a right and left field which points to the right and left child of the node
	 */
	public static class BinaryNode<T> {
		  public T item;
		  public BinaryNode<T> left = null;
		  public BinaryNode<T> right= null;
	}
	
	
	/**
	 * 	Searches a given element in the tree iteratively
	 */
	protected Boolean lookupIteratively(BinaryNode<Integer> root, int key) {
		while(root!=null){
			if((root.item).equals(key)){
				return true;
			}else if((root.item)<key){
				root=root.right;
			}else{
				root=root.left;
			}
		}
		return false;
	}

	/**
	 * 	Searches a given element in the tree recursively 
	 */
	protected Boolean lookUpRecursively(BinaryNode<Integer> root, int key) {
		if(root==null){
			return false;
		}
		if(root.item>key){
			return(lookUpRecursively(root.left,key));
		}else if(root.item<key){
			return(lookUpRecursively(root.right,key));
		}else {
			return true;
		}
	}

	/**
	 * 	Constructs a tree for each element taken and returns the root of the tree
	 */
	protected BinaryNode<Integer> constructTree(BinaryNode<Integer> root) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of nodes to be added to the tree initially");
		int number  =scan.nextInt();
		System.out.println("Enter the values : ");
		for(int i=0;i<number;i++){
			root = insert(root,scan.nextInt());
		}
		return root;
	}

	/**
	 * 	Inserts the element in its appropriate position and duplicates are ignored
	 */
	private static BinaryNode<Integer> insert(BinaryNode<Integer> root, int nextInt) {
		if(root==null){
			BinaryNode<Integer> newRoot = new BinaryNode<Integer>();
			newRoot.item=nextInt;
			return newRoot;
		}
		if(root.item>nextInt){
			root.left=insert(root.left,nextInt);
		}else if(root.item<nextInt){
			root.right=insert(root.right,nextInt);
		}else{
			;		// do nothing for duplicates
		}
		return root;
	}
	
	/**
	 * 	Construct tree using the array of nodes
	 */
	protected BinaryNode<Integer> constructTree(BinaryNode<Integer> root, int[] nodes) {
		System.out.println("The nodes are : ");
		for(int i=0;i<nodes.length;i++){
			System.out.print(nodes[i]+" ");
			root = insert(root,nodes[i]);
		}
		System.out.println();
		return root;
	}

	/**
	 * logically deletes the tree i.e nullifies the root
	 */
	protected BinaryNode<Integer> deleteTree(BinaryNode<Integer> root){
		root=null;
		return (root);
	}
}
