
import java.util.ArrayList;

/**
 * @author sandeeprv
 * implements the File class required for problem 2.10	(MergingSortedArrays)
 * review comment: naming convention File gets confused with java.io.File; java.nio.file.Files
 * review comment: Files or other noun plurals are used for collections.
 */
public class Files{
	public ArrayList<ArrayList<Integer>> files = new ArrayList<ArrayList<Integer>>();
	
	public Object insert(ArrayList<Integer> file){
		return files.add(file);
	}
	public void print(){
		System.out.println("The files are: ");
		for(ArrayList<Integer> each : files){
			for(Integer ineach: each){
				System.out.print(ineach+" ");					
			}
			System.out.println();
		}
	}
	public int getSize(){
		return files.size();
	}
	/**
	 *  returns the minimum in the file 
	 */
	public Integer getMin(int i){
		if(!files.get(i).isEmpty()){
			return files.get(i).get(0);
		}
		return null;
	}
	/**
	 * removes the minimum in the file 
	 */
	public void removeMin(int i){
		if(!files.get(i).isEmpty()){
			files.get(i).remove(0);
		}
	}
	/**
	 * returns true if all the files are empty false otherwise
	 */
	public boolean isEmpty(){
		for(ArrayList<Integer> each:files){
			if(!each.isEmpty()){
				return false;
			}
		}
		return true;
		
	}
}
