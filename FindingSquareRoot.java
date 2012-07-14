
//Implement a fast integer square root function that takes in a 32 bit unsigned integer
//and returns another 32-bit unsigned integer .

import java.util.Scanner;

public class FindingSquareRoot {

    public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	System.out.println("Enter an integer(32 bit unsigned) to find its square root");
	Long number = scan.nextLong();
	int root = findSquareRoot(number,0,65535);
	if(root!=-1){
	    System.out.println("Square root of the given number is : "+ root);
	}else{
	    System.out.println("Given number is not a perfect square");
	}
    }
    private static int findSquareRoot(Long number,int lowerRange,int upperRange) {
	if(lowerRange<=upperRange){
	    int mid = lowerRange +( (upperRange-lowerRange)/2);
	    Long square = new Long(mid * mid);
	    if(square.equals(number)){
		return mid;
	    }else if(square<number){
		lowerRange = mid+1;
	    }else{
		upperRange = mid-1;
	    }
	    return(findSquareRoot(number,lowerRange,upperRange));
	}
	return -1;
    }

}
