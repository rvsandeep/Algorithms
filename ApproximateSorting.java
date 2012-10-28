import java.util.Scanner;

public class ApproximateSorting {
	
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
		System.out.println("Enter the number of intgers: ");
		int number  =scan.nextInt();
		int integers[] = new int[number];
		System.out.println("Enter the value which atmost the positions of the integers differ from: ");
		int key = scan.nextInt();
		System.out.println("Enter the integers : ");
		for(int i=0;i<number;i++){
			integers[i] = scan.nextInt();
		}
		doApproximateSort(integers,key);
	}
	
	private static void doApproximateSort(int[] integers, int key) {
		// use priority queue
		Heap minHeap = new Heap();
		System.out.println("Sorted array is : ");
		for(int i =0 ;i<integers.length;i++){
			minHeap.insert(new Pair(integers[i],i));
			if(minHeap.size()==key){
				Pair min = minHeap.deleteMin();
				System.out.println(min.getFirst());
			}	
		}
		while(minHeap.size()!=0){
			Pair min = minHeap.deleteMin();
			System.out.println(min.getFirst());
		}
	}

	private static void testCaseRunner() {
		int integers[] = {6,4,1,7,2,5,9,10,17,12};
		int key = 5;
		doApproximateSort(integers,key);
	}


}
