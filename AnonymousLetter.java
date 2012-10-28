import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
//1.10: Anonymous Letter 
//Review comment: read map-reduce paradigm


public class AnonymousLetter {

	public static void main(String args[]){
//		User Input or just use the testCases
		int choice;
		Scanner scan =  new Scanner(System.in);
		System.out.println("Enter choice : \n1:To use Test Cases 2: To give input");
		choice = scan.nextInt();
		switch (choice) {
		case 1:
			testCaserunner();
			break;
		case 2:
			userInput();
		default:
			break;
		}
	}

	private static void userInput() {
		Scanner scan = new  Scanner(System.in);
		String anonymousLetter  = new String();
		String textFromMagazine = new String();
		System.out.println("Enter a text ");
		anonymousLetter= scan.nextLine();
		System.out.println("Enter a text ");
		textFromMagazine = scan.nextLine();
		tryToWrite(anonymousLetter, textFromMagazine);
	}

	/**
	 * this method tries to write text2 using the words in text1 and prints if it is possible or not
	 * 	Maintains a map of characters and their count of text1 and see's if it is sufficient to write text2 
	 */
	
	private static void tryToWrite(String text1, String text2) {
		Map<Character,Integer> frequencyCountOftext1 = new LinkedHashMap<Character,Integer>();
		Map<Character,Integer> frequencyCountOftext2 = new LinkedHashMap<Character,Integer>();
		frequencyCountOftext1 = findFrequency(text1.toCharArray());
		frequencyCountOftext2 = findFrequency(text2.toCharArray());
		
		boolean canItBeWritten = compareFrequency(frequencyCountOftext1,frequencyCountOftext2); 
		
		if(canItBeWritten){
			System.out.println("The letter \"" + text1 + "\" can be written using the magazine text \" "+text2+"\"");
		}else{
			System.out.println("The letter \"" + text1 + "\" can NOT be written using the magazine text \" "+text2+"\"");	
		}
		
		
	}

	/**
	 *  returns a frequency count map of the characters in the text argument
	 */
	private static Map<Character, Integer> findFrequency(char[] text2) {
		Map<Character, Integer> frequencyCount= new LinkedHashMap<Character,Integer>();
		for (int i = 0; i < text2.length; i++) {
			if(frequencyCount.containsKey(text2[i])){
				int increment  = frequencyCount.get(text2[i])+1;
				frequencyCount.put(text2[i], increment);
			}else{
				frequencyCount.put(text2[i], 1);
			}
		}		
		return frequencyCount;
	}

	/**
	 *  Compares the frequency count map of text1 and text2
	 *  returns true if the character count to write text2 is sufficient using the character count in text1
	 *  returns false otherwise
	 */
	private static boolean compareFrequency(
			Map<Character, Integer> frequencyCountOftext1,
			Map<Character, Integer> frequencyCountOftext2) {
		
		for(char each : frequencyCountOftext1.keySet()){
			if(!frequencyCountOftext2.containsKey(each)){
				return false;
			}else if (frequencyCountOftext1.get(each)>frequencyCountOftext2.get(each)){
				return false;
			}
		}
		return true;
	}

	private static void testCaserunner() {
		String letter[] = {"Can i write","Can you write from it","try a letter","try this text to write the letter","ok one last one"};
		for (int i = 0; i < letter.length-1; i++) {
			tryToWrite(letter[i],letter[i+1]);
		}
	}


}

