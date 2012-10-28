/**
 * @author sandeeprv
 *	implements the Pair class required by Problem:2.10 (MergingSortedArrays)
 */
public class Pair{
    private int first;
    private int second;

    public Pair(int first, int second) {
        super();
        this.first = first;
        this.second = second;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }
    /**
     * 	compare the two pair return true if the object passed as argument is greater
     * 
     * 	A pair is greater if the individual value of the  file is greater ,
     * 	if values are equal then second in the input is greater
     */
    public int compareTo(Pair pair){
    	if(this.first == pair.first){
    		return pair.second-this.second;
    	}else{
    		return pair.first-this.first;
    	}    	
    }
    public void print(){
    	System.out.println("Value: "+ this.first+" File: "+this.getSecond());
    }
}
