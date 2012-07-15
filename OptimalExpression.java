
// 	Find an optimal solution for the expression 
// 	input : 5-3*4+6 => (5-3)*(4-6)
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author sandeeprv
 */
public class OptimalExpression {

	/**
	 * Main method of the class
	 */
	public static void main(String[] args) {
		Scanner scan  = new Scanner(System.in);
		String expression =new String(scan.nextLine());
		int numberOfOperators = countOperators(expression);
		System.out.println(getResult(expression,numberOfOperators));
	}

	/**
	 * returns the number of operators in the expression
	 */
	private static int countOperators(String expression) {
		int count = 0;
		for (int i = 0; i < expression.length(); i++) {
			if(isOperator(expression.charAt(i))){
				count++;
			}
		}
		return count;
	}

	
	/**
	 * 
	 * returns true if operator, false otherwise
	 */
	private static boolean isOperator(char c) {
		if(c=='+' || c== '-' || c== '*'){
			return true;
		}
		return false;
	}
	//result is the final expression
	public static String result = null;
	
	/**
	 * prints the final optimal expression
	 */
	private static String getResult(String expression, int numberOfOperators) {
		ArrayList<Integer> listOfValues = new ArrayList<Integer>();
		// getValues returns a list of all possible values on solving the expression in all possible ways
		listOfValues = getValues(expression,listOfValues); 
		//ofMaximum returns the index of the maximum of the list
		int index = ofMaximum(listOfValues); 
		int value = listOfValues.get(index);
		// assigns the result to the expression at the index
		assignResult(expression,0,numberOfOperators,index,0);
		return "" + result + " = "+ value ;
	}

	/**
	 * returns maximum of the list
	 */
	private static int ofMaximum(ArrayList<Integer> listOfValues) {
		int indexOfMaximum =0;
		for (int i=0;i<listOfValues.size();i++) {
			if (listOfValues.get(i)>listOfValues.get(indexOfMaximum)) {
				indexOfMaximum = i;
			}
		}
		return indexOfMaximum;
	}
	
	/**
	 * returns a list of all possible values by solving the expression
	 */
	private static ArrayList<Integer> getValues(String expression,ArrayList<Integer> listOfValues) {
		//isOperand returns true if the expression is an operand this is the final single operand in recurive call 
		if (isOperand(expression)) {
			int res = Integer.parseInt(expression);
			listOfValues.add(res);
			return listOfValues;
		}
		// Computing operations using all the  operators
		for (int j = 0; j < expression.length(); j++) {
			char character = expression.charAt(j);
			if(isOperator(character)){
				int result=0;
				//Check to see if its unary operator
				if(j==0 || isOperator(expression.charAt(j-1))){
					continue;
				}
				//get the previous and next operand to solve operator
				int a = getPreviousOperand(expression,j);
				int b = getNextOperand(expression,j);
				// Solve the expression using the operator i.e character 
				result = solve(a,character,b);
				String delStr = ""+ a + character + b;
				// Replace the expression with result by solving the expression
				String newexpression = expression.replace(delStr,""+result);
				//calling recursively to solve the expression further
				getValues(newexpression,listOfValues);
			}
		}
		//returning final list of values
		return listOfValues;
	}
	
	
	private static boolean isOperand(String expression) {
		for(int i=1 ;i<expression.length();i++){
			if(isOperator(expression.charAt(i))&& !isOperator(expression.charAt(i-1))){
				return false;
			}
		}
		return true;
	}

	private static int getNextOperand(String expression, int index) {
		StringBuilder operand = new StringBuilder();
		operand.append(expression.charAt(index+1)); 
		for(int i = index+2;i<expression.length();i++){
			//Break case is when another operator is encountered the operand is returned
			if(isOperator(expression.charAt(i))){
				break;
			}
			operand.append(expression.charAt(i)); 
		}
		String opr =operand.toString();
		// returning the integer value of the string
		return Integer.parseInt(opr);
	}

	private static int getPreviousOperand(String expression,int index){
		StringBuilder operand  =new StringBuilder();
		for(int i = index-1;i>=0 ;i--){
			if(isOperator(expression.charAt(i))){
				//if unary operator consider to be an operand 
				if(i==0 || isOperator(expression.charAt(i-1))){
					operand.append(expression.charAt(i)); 
				}
				break;
			}
			operand.append(expression.charAt(i)); 
		}
		// reversing since the operand is appended reverse way
		operand = operand.reverse();
		String opr = operand.toString();
		return Integer.parseInt(opr);
	}

	private static int solve(int a, char character, int b){
		switch (character) {
		case '+':
			return a+b;
		case '-':
			return a-b;
		case '*':
			return a*b;
		default:
			System.out.println(character + "Invalid operands used");
			System.exit(0);
		}
		return 0;
	}

	
	/**
	 *	Enum paranthesis is requird to define the state of paranthesis in the expression
	 */
	public enum Paranthesis{
	    START,END
	};
	// returns previous expression from the index mentioned
	private static String getPreviousExpression(String expression,int index){
		Paranthesis state=Paranthesis.END;
		StringBuilder operand  =new StringBuilder();
		for(int i = index-1;i>=0 ;i--){
			// to get the entire expression enclosed in parans
			if(expression.charAt(i)==')'){
				state=Paranthesis.START;
			}else if(expression.charAt(i)=='('){
				state=Paranthesis.END;
				operand.append(expression.charAt(i)); 
				break;
			}
			if(isOperator(expression.charAt(i)) &&(state!=Paranthesis.START)){
				if(i==0 || isOperator(expression.charAt(i-1))){
					operand.append(expression.charAt(i)); 
				}
				break;
			}
			operand.append(expression.charAt(i)); 
		}
		// reversing since the expression is appended reverse way
		operand = operand.reverse();
		String correctOperand = operand.toString();
		return correctOperand;
	}
	// similarly returns next expression
	private static String getNextExpression(String expression, int index) {
		Paranthesis state=Paranthesis.END;
		StringBuilder operand = new StringBuilder();
		if(expression.charAt(index+1)=='('){
			state=Paranthesis.START;
		}
		operand.append(expression.charAt(index+1)); 
		for(int i = index+2;i<expression.length();i++){
			if(expression.charAt(i)==')'){
				state=Paranthesis.END;
				operand.append(expression.charAt(i));
				break;
			}
			if(isOperator(expression.charAt(i)) &&(state!=Paranthesis.START)){
				break;
			}
			operand.append(expression.charAt(i)); 
		}
		String opr =operand.toString();
		return opr;
	}

	/**
	 * assigns field result to the expression by generating all possible expressions till the index provided
	 */
	private static String assignResult(String expression,int noOfParanthesis,int noOfOperators,int index,int count) {
		// return case for the recursive call
		if (noOfParanthesis==noOfOperators-1) {
			return null;
		}
		
		Paranthesis state = Paranthesis.END;
		for (int j = 0; j < expression.length(); j++) {
			char character = expression.charAt(j);
			if(character=='('){
				state=Paranthesis.START;
			}else if(character==')'){
				state=Paranthesis.END;
			}
			if(isOperator(character) && (state!=Paranthesis.START)){
				if(j==0 || isOperator(expression.charAt(j-1))){
					String delStr = ""+expression.charAt(j)+ getNextOperand(expression,j);
					expression = expression.replace(delStr,"("+delStr+")");
					noOfParanthesis = noOfParanthesis + 1;
				}
				if(count==index && result != null)
					break;
				// get previous and next expression to form a new expression with the character operator
				String a = getPreviousExpression(expression,j);
				String b = getNextExpression(expression,j);
				String newStr = "("+a+character+b+")";
				String delStr = ""+ a + character + b;
				//replace the previous and next with the new expression string and del the old one
				String newexpression = expression.replace(delStr,newStr);
				//count keeps count of the number of expression generated and assigns when the it is the required one
				if (count==index){
					result = newexpression;
				}
				//call recursively to generate all possible expressions
				assignResult(newexpression,noOfParanthesis + 1, noOfOperators ,index , count);
				count +=1;
			}
			
		}
		return null;
		
	}
	
}
