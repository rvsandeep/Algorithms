package week2;

import java.util.ArrayList;
import java.util.Scanner;
//	uses classes Heap , Files and Pair.

/**
 * 	@author sandeeprv
 *	Problem 2.10
 */
public class MergingSortedArrays {

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
		System.out.println("Enter the files: ");
		int number  =scan.nextInt();
		Files files = new Files();
		System.out.println("Enter the files : ");
		for(int i=0;i<number;i++){
			System.out.println("Enter number of sub contents in file");
			int subNumber  =scan.nextInt();
			ArrayList<Integer> file = new ArrayList<Integer>();
			for (int j = 0; j < subNumber; j++) {
				file.add(scan.nextInt());
			}
			files.insert(file);
		}
		files.print();
		mergeFiles(files);
	}

	/**
	 * 	Creating a minHeap and extracting the minimum each time would give the 
	 * 	sorted merged file list
	 */
	private static void mergeFiles(Files files) {
		Heap minHeap = new Heap(files);
		while(!files.isEmpty()){
			Pair min = minHeap.deleteMin(files);
			min.print();
		}
	}

	private static void testCaseRunner() {
//		ArrayList of files
		ArrayList<Integer> file1 =new ArrayList<Integer>();
		ArrayList<Integer> file2 =new ArrayList<Integer>();
		ArrayList<Integer> file3 =new ArrayList<Integer>();
		ArrayList<Integer> file4 =new ArrayList<Integer>();

		//		initializing each file
		file1.add(3);file1.add(8); file1.add(9);file1.add(15);file1.add(17);
		file2.add(1);file2.add(2); file2.add(5);file2.add(7);file2.add(13);file2.add(19);
		file3.add(4); file3.add(6);file3.add(10);file3.add(12);
		file4.add(11);file4.add(14); file4.add(16);file4.add(18);

		//		intializing files
		Files files = new Files();
		
		files.insert(file1);
		files.insert(file2);
		files.insert(file3);
		files.insert(file4);	
		files.print();
		mergeFiles(files);
	}


}
