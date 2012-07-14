
//	Return elements common to two Sorted Arrays efficiently

import java.util.Scanner;

/**
 * @author sandeeprv
 */
public class IntersectionOfArrays {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter size of array1: ");
		int size1 = scan.nextInt();
		System.out.println("Enter a sorted integer array of size "+size1);
		int array1[] = new int[size1];
		
		for (int i = 0; i < size1; i++) {
			array1[i]= scan.nextInt();
		}
		System.out.println("Enter size of array2: ");
		int size2 = scan.nextInt();
		int array2[] = new int[size2];
		System.out.println("Enter another sorted integer array of size "+size2);
		for (int i = 0; i < size2; i++) {
			array2[i]= scan.nextInt();
		}
		if(size2<size1){
			intersect(array2,array1);
		}else{ 
			 intersect(array1,array2);
		}
	}

	/**
	 * 	with one of the array's elements as key performs binary search on the  other array 
	 */
	private static void intersect(int[] array1, int[] array2) {
		int i = 0,k=0;
		int[] intersectedArray =  new int[10]; 
		while(i<array1.length){
			if((binarySearch(array2,array1[i],0,array2.length-1)!=-1)){
				if(binarySearch(intersectedArray, array1[i],0,k-1)==-1){
					intersectedArray[k]=(array1[i]);
					k+=1;
				}
			}
			i+=1;
		}
		System.out.println("Elements common to two arrays : ");
		if(k==0){
			System.out.println("Empty");
		}else{
			for (i = 0; i < k ; i++) {
				System.out.print(intersectedArray[i]+" ");
			}
		}
		System.out.println();
	}
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
