
//Problem: 1.14
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
* @author sandeeprangam
*	finds the word that occurs most number of times in the given text
*/
public class SearchForMajority {
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
		System.out.println("Enter the text");
		String text = new String(scan.nextLine());
		
		findMajority(text);
	}

	/**
	 * 	replaces all punctuation signs with nothing and splits the text to list
	 */
	private static void findMajority(String text) {
		text = text.replaceAll("[^(a-zA-Z)&&(\\S)]", "");
		text = text.trim();
		String words[] = text.split(" ");
		wordCount(words);
	}

	
	/**
	 * 	Counts the word and maintains an hash map with key being the word and value being the count
	 * 	finally prints the word with the highest count
	 */
	private static void wordCount(String[] words) {
		Map<String,Integer> wordCount = new LinkedHashMap<String,Integer>();
		int MaxOccurance=0;
		String MaxOccuringWord=null;
		for(String each:words){
			int count=1;
			if(wordCount.containsKey(each.toLowerCase())){
				count = wordCount.get(each.toLowerCase())+1;
				if(count>MaxOccurance){
					MaxOccurance=count;
					MaxOccuringWord=each.toLowerCase();
				}
			}
			wordCount.put(each.toLowerCase(),count);
		}
		System.out.println("The word that appears in majority is \" "+MaxOccuringWord+" \" occuring "+ MaxOccurance+" times");
		return;
	}

	/**
	 * provides a some number of dictionary of words
	 */
	private static void testCaseRunner() {
		
		String text[] =
	{"The web browser is arguably the most important piece of software on your computer. You spend much of your time online inside a browser: when you search, chat, email, shop, bank, read the news, and watch videos online, you often do all this using a browser.",
	"Chrome has many useful features built in, including automatic full-page translation and access to thousands of apps, extensions, and themes from the Chrome Web Store. Learn more about Chrome's most-loved features.",
	};
		for(int i=1;i<text.length;i++){
			findMajority(text[i]);
		}
	}


}
