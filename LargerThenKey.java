
//	Find first element larger then key in a sorted array
import java.util.Scanner;

/**
 * @author sandeeprv
 */
public class LargerThenKey {


	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int sortedArray[] = new int[10];
		System.out.println("Enter an array of 10 integers in increasing order\n");
		for (int i = 0; i < 10; i++) {
			sortedArray[i] = scan.nextInt(); 
		}
		System.out.println("Enter key whose first element larger then key should be found in the array: ");
		int key = scan.nextInt();
		int position = binarySearch(sortedArray,key,0,9);
		if(position!= -1){
			System.out.println("First element larger then"+ key +" is found at position: " +( position + 1) + " and it is : " + sortedArray[position]);
		}
		else{
			System.out.println("Element not found");
		}
	}

	private static int binarySearch(int[] sortedArray, int key, int low, int high) {
		if(low<high){
			int mid = low + (high-low)/2;
			if(key == sortedArray[mid]){
				return mid+1;
			}else if (key<sortedArray[mid]) {
				high  = mid -1;
			}else{
				low = mid+1;
			}
			return(binarySearch(sortedArray, key, low, high));
		}else if (low==high) {
			if(sortedArray[high]==key || sortedArray[high]<key){
				if(high+1<sortedArray.length)
					return high+1;
				else
					return -1;
			}
			return high;
		}
		
		return -1;
	}


}
