import java.util.Scanner;

public class IntersectingLines {


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
		System.out.println("Enter the number of lines");
		int number = scan.nextInt();
		System.out.println("The lines are considered according the equation y=mx+c : ");
		System.out.println("Enter the (m,c) pair for each line with a  space in between : ");
		int pair[][] = new int[number][2];
		for (int i = 0; i < number; i++) {
			int m = scan.nextInt();
			int c = scan.nextInt();
			pair[i][0] = c;
			pair[i][1] = m;
		}
		
		// uses mergeSort to sort the Pairs
		sortPair(pair,0,number-1);
		findPair(pair);
	}

	
	/**
	 * 	finds the pair of lines that intersect
	 */
	private static void findPair(int[][] pair) {
		int i;
		for (i = 0; i < pair.length-1; i++) {
			if((pair[i][0]+pair[i][1])>(pair[i+1][0]+pair[i+1][1])){
				System.out.println("The pair of lines that intersect are the lines with the (m,c) pair: ");
				System.out.print("("+pair[i][0]+","+pair[i][1]+") and ");
				System.out.print("("+pair[i+1][0]+","+pair[i+1][1]+")");
				break;
			}
		}
		if(i==pair.length-1){
			System.out.println("There are No pair of lines that intersects");
		}
	}

	/**
	 * 	sorts the lines based on the y-intercept using mergesort for better time efficiency
	 */
	private static void sortPair(int[][] pair,int low,int high) {
		if(low<high){
			int mid = low+(high-low)/2;
			sortPair(pair,low,mid);
			sortPair(pair,mid+1,high);
			merge(pair,low,high,mid);
		}
	}

	private static void merge(int[][] pair, int low, int high, int mid) {
	    int i, j, k=0;
	    int temp[][] = new int[low+high+1][2];
	    i=low;
	    j=mid+1;
	    while((i<=mid)&&(j<=high)){
	        if(pair[i][0]<pair[j][0]){
	            temp[k][0]=pair[i][0];
	            temp[k][1] = pair[i][1];
	            k++;
	            i++;
	        }else{
	            temp[k][0]=pair[j][0];
	            temp[k][1] = pair[j][1];
	            k++;
	            j++;
	        }
	    }
	    while(i<=mid){
	        temp[k][0]=pair[i][0];
	        temp[k][1]=pair[i][1];
	        k++;
	        i++;
	    }
	    while(j<=high){
	        temp[k][0]=pair[j][0];
	        temp[k][1]=pair[j][1];
	        k++;
	        j++;
	    }
	    for(i=low,j=0;j<k;i++,j++){
	        pair[i][0]=temp[j][0];
	        pair[i][1]=temp[j][1];
	    }
	}

	private static void testCaseRunner() {
		int pair[][][] = {
						{{1,2},{3,4},{-1,3},{4,2}},
						{{4,5},{2,3},{1,2},{5,6},{9,1},{3,2}},
						{{0,3},{-1,3},{0,3},{9,3},{-2,2}},
						{{9,3},{1,2},{4,3},{0,4}}
		};
		for(int i=0;i<pair.length;i++){
			System.out.println("\n\nThe lines with Pairs(m,c) are : ");
			for(int j =0 ;j<pair[i].length;j++){
				System.out.println("("+pair[i][j][0]+","+pair[i][j][1]+")");
			}
			sortPair(pair[i],0,pair[i].length-1);
			findPair(pair[i]);
		}
	}

}
