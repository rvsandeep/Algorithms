import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	int SortedArray[] = new int[10];
	System.out.println("Enter an array of 10 integers in increasing order\n");
	for (int i = 0; i < 10; i++) {
	    SortedArray[i] = scan.nextInt(); 
	}
	System.out.println("Enter key to search in the array: ");
	int key = scan.nextInt();
	int position = binarySearch(SortedArray,key,0,9);
	if(position!= -1){
	    System.out.println("Element found at position: " +( position + 1));
	}
	else{
	    System.out.println("Element not found");
	}
    }
    // search recursively half the array 
    private static int binarySearch(int[] sortedArray, int key, int low, int high) {
	if(low<=high){
	    int mid = low + (high-low)/2;
	    if(key == sortedArray[mid]){
		return mid;
	    }else if (key<sortedArray[mid]) {
		high  = mid -1;
	    }else{
		low = mid+1;
	    }
	    return(binarySearch(sortedArray, key, low, high));
	}
	return -1;
    }

}
