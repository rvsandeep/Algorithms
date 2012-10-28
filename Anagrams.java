import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

//	1.8 :  Finding Anagrams in the given dictionary. 
// use java generics from JDK 1.6
/**
 * @author sandeeprv 
 */
//	Anagrams are words that can be formed from other words
//	Ex :The word "words" can be formed using the word "sword"
public class Anagrams{

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
		System.out.println("Enter the number of words in dictionary");
		int number  =scan.nextInt();
		String dictionary[] = new String[number];
		for(int i=0;i<number;i++){
			dictionary[i] = scan.nextLine();
		}
		printAnagramsIn(dictionary);
		
	}

	/**
	 * provides a some number of dictionary of words
	 */
	private static void testCaseRunner() {
		
		String dictionary[][] = {{"abc","cde","asfs","cba","edcs","name"},{"name","mane","string","trings","embe"}};
		for(int i=0;i<dictionary.length;i++){
			printAnagramsIn(dictionary[i]);
		}
	}

	/**
	 * Prints the set of anagrams found the give dictionary
	 * 
	 * logic is  sorting the characters in the given word and hashing them to the word.
	 * Data Structure: Hash[sortedChars] = word
	 */
	private static void printAnagramsIn(String[] dictionary) {
		System.out.print("Dictionary : [" );//+ dictionary);
		for(String each : dictionary){
			System.out.print(each+" ");
		}
		System.out.println("]");
		Map<String,ArrayList<String>> map = new LinkedHashMap<String, ArrayList<String>>();
		//review comment: naming convention: dictionary contains 'word' not 'each'
		for(String each : dictionary){
			char[] sortedWord =each.toCharArray();
			Arrays.sort(sortedWord);
			String sortedString = new String(sortedWord);
			ArrayList<String> list = new ArrayList<String>();
			if(map.keySet().contains(sortedString)){
				list =map.get(sortedString);
			}
			list.add(each);
			map.put(sortedString,list);
		}
		int i =1 ;
		for(String each : map.keySet()){
			if(map.get(each).size()!=1){
				System.out.println("Anagrams "+i+":"+map.get(each));
				i++;
			}
		}
	}
}
