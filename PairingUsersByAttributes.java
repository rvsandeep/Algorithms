import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
//Problem : 1.11

public class PairingUsersByAttributes {
	
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
		System.out.println("Enter the number of users: ");
		int userNumber  =scan.nextInt();
		System.out.println("Enter number of Attributes: ");
		int attrNumber  =scan.nextInt();
		int userIds[]=new int[userNumber];
		String userAttributes[][] = new String[userNumber][attrNumber];
		for(int i=0;i<userNumber;i++){
			System.out.println("Enter user Id: ");
			userIds[i]=scan.nextInt();
			System.out.println("Enter the attributes: ");
			for (int j = 0; j < attrNumber; j++) {
				System.out.println("Attributes "+i+":");
				userAttributes[i][j] = scan.nextLine();
			}
		}
		pairUsers(userAttributes,userIds);
	}

	/**
	 * 	pairs users based on the user attributes expressed in bitVector
	 */
		private static void pairUsers(String[][] userAttributes, int[] userIds) {
				
//		Pairs is used to map user with same attributes as the other user to pair
		
		Map<String,ArrayList<Integer>> pairs = new LinkedHashMap<String, ArrayList<Integer>>();
		for(int i=0;i<userIds.length;i++){
			String bitVector = getBitVector(userAttributes[i]);
			ArrayList<Integer> list = new ArrayList<Integer>();
			if(pairs.containsKey(bitVector)){
				list = pairs.get(bitVector);
			}
			list.add(userIds[i]);
			pairs.put(bitVector,list);
		}
		ArrayList<Integer> unPaired = new ArrayList<Integer>();
		int count=0;
		for(String each:pairs.keySet()){
			ArrayList<Integer> pair = pairs.get(each);			
			if(pair.size()==1){
				unPaired.add(pair.get(0));
			}else{
				count+=1;
				System.out.println("Pair "+count+":"+pair);
			}
		}
		if(unPaired.size()!=0){
			System.out.println("The unpaired ones are");
		}
		for(Integer each:unPaired){
			System.out.println(""+each);
		}
		System.out.println();
		
	}

	/**
	 * 	returns a string bitVector based on the user attributes 
	 */
	private static String getBitVector(String[] strings) {
		StringBuilder bitVector = new StringBuilder();
		for(String each:strings){
			if(each.equals("yes")){
				bitVector=bitVector.append("1");
			}else{
				bitVector=bitVector.append("0");
			}
		}
		return bitVector.toString();
	}

	/**
	 * provides a some number of dictionary of words
	 */
	private static void testCaseRunner() {
		
		String dictionary[][][] = {{{"yes","no","yes","no","yes","yes"},{"yes","no","yes","no","yes","yes"},{"yes","no","yes","no","yes","no"},{"yes","No","yes","no","yes","no"}},
									{{"yes","No","yes","no","yes","yes"},{"yes","No","yes","no","no","yes"},{"yes","No","yes","no","no","yes"}}
									};
		int userIds[][] = { {123,232,343,454},
							{123,434,354}
							};
		for(int i=0;i<dictionary.length;i++){
			pairUsers(dictionary[i], userIds[i]);
		}
	}


}
