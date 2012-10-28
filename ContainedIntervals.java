import java.util.Scanner;

//Problem : 1.20

public class ContainedIntervals {

public static void main(String args[]){
//	User Input or just use the testCases
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
	System.out.println("Enter the number of intervals");
	int number = scan.nextInt();
	System.out.println("Enter the (start,end) pair for each inteval with a  space in between : ");
	int intervals[][] = new int[number][2];
	for (int i = 0; i < number; i++) {
		int start = scan.nextInt();
		int end = scan.nextInt();
		intervals[i][0] = start;
		intervals[i][1] = end;
	}
	
	// uses mergeSort to sort the Pairs
	sortIntervals(intervals,0,number-1);
	findInterval(intervals);
}

/**
 * 	using the sorted interval sees if any of the interval is with in the previous interval
 */
private static void findInterval(int[][] intervals) {
	int i;
	for (i = 1; i < intervals.length; i++) {
		if(intervals[i-1][1]>=intervals[i][1]){
			System.out.print("The interval ");
			System.out.print("("+intervals[i][0]+","+intervals[i][1]+")");
			System.out.print(" is contained with in the interval ");
			System.out.print("("+intervals[i-1][0]+","+intervals[i-1][1]+")");
			break;
		}
	}
	if(i==intervals.length){
		System.out.println("There are No intervals that is Contained");
	}
}

/**
 *  Sorts the intervals in leftmost first manner
 */
private static void sortIntervals(int[][] intervals,int low,int high) {
	if(low<high){
		int mid = low+(high-low)/2;
		sortIntervals(intervals,low,mid);
		sortIntervals(intervals,mid+1,high);
		merge(intervals,low,high,mid);
	}
}

private static void merge(int[][] intervals, int low, int high, int mid) {
    int i, j, k=0;
    int temp[][] = new int[low+high+1][2];
    i=low;
    j=mid+1;
    while((i<=mid)&&(j<=high)){
        if(intervals[i][0]<intervals[j][0]){
            temp[k][0]=intervals[i][0];
            temp[k][1] = intervals[i][1];
            k++;
            i++;
        }else if(intervals[i][0]==intervals[j][0]){
        	if(intervals[i][1]>intervals[j][1]){
	            temp[k][0]=intervals[i][0];
	            temp[k][1] = intervals[i][1];
	            k++;
	            i++;
        	}else{
        		temp[k][0]=intervals[j][0];
 	            temp[k][1] = intervals[j][1];
 	            k++;
 	            j++;
        	}
        }else{
            temp[k][0]=intervals[j][0];
            temp[k][1] = intervals[j][1];
            k++;
            j++;
        }
    }
    while(i<=mid){
        temp[k][0]=intervals[i][0];
        temp[k][1]=intervals[i][1];
        k++;
        i++;
    }
    while(j<=high){
        temp[k][0]=intervals[j][0];
        temp[k][1]=intervals[j][1];
        k++;
        j++;
    }
    for(i=low,j=0;j<k;i++,j++){
        intervals[i][0]=temp[j][0];
        intervals[i][1]=temp[j][1];
    }
}

private static void testCaseRunner() {
	int intervals[][][] = {
					{{1,2},{3,4},{-1,3},{4,6}},
					{{4,5},{2,3},{1,2},{5,6},{9,10},{3,4}},
					{{0,3},{-1,3},{0,3},{6,3},{-2,2}},
					{{1,3},{1,2},{4,7},{0,4}}
	};
	for(int i=0;i<intervals.length;i++){
		System.out.println("\n\nThe intervals are : ");
		for(int j =0 ;j<intervals[i].length;j++){
			System.out.println("("+intervals[i][j][0]+","+intervals[i][j][1]+")");
		}
		sortIntervals(intervals[i],0,intervals[i].length-1);
		findInterval(intervals[i]);
	}
}


}
