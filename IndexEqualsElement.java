
//Problem Search a sorted array for A[i]=i
import java.util.Scanner;

public class IndexEqualsElement {

    public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	System.out.println("Enter the number of elements in the array : ");
	int number = scan.nextInt();
	int SortedArray[] = new int[10];
	System.out.println("Enter array elements in increasing order\n");
	for (int i = 0; i < number; i++) {
	    SortedArray[i] = scan.nextInt(); 
	}
	int position = binearySearch(SortedArray,0,number-1);
	if(position!= -1){
	    System.out.println("Element found at Index : "+ position + " and Element: " + SortedArray[position]);
	}
	else{
	    System.out.println("None of the Element is same as its index ");
	}
    }

    private static int binearySearch(int[] sortedArray, int low, int high) {
	if(low<=high){
	    int mid = low + (high-low)/2;
	    if(mid == sortedArray[mid]){
		return mid;
	    }else if(sortedArray[mid]-mid<0){
		low = mid+1;
	    }else{
		high = mid-1;
	    }
	    return(binearySearch(sortedArray, low, high));
	}
	return -1;
    }


}
