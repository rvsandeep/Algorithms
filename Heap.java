// 	used by Problem 2.10 MergingSortedArrays and 2.11 ApproximateSort 
// Review comment: use coding convention (in preferences) supported by IDE.
// Review comments: use generics in method signatures
//

public class Heap{
	private static final int CAPACITY = 2;
	private int size;            // Number of elements in heap
	private Pair[] heap;     // The heap array
	
	public Heap()
	   {
	      size = 0;
	      heap = new Pair[CAPACITY];
	   }
	
	/**
	  * Construct the binary heap given the Files.
	  * Review comment: wrong abstraction
	  */
	public Heap(Files files){
		size = files.getSize();
	    heap = new Pair[size+1];
	    for(int i=0;i<size;i++){
	    	Pair pair =new Pair(files.getMin(i),i+1);
	    	heap[i+1] = pair; //we do not use 0 index
	    }
	    buildHeap();
	} 
	/**
	 *   runs at O(size)
	 */
	private void buildHeap(){
		for (int k = size/2; k > 0; k--){
	         percolatingDown(k);
	    }
	}
	
	/**
	 * 	places the item in its suitable position by comparing with its children
	 */
	private void percolatingDown(int k){
		Pair tmp = heap[k];
		int child;
		for(; 2*k <= size; k = child){
			child = 2*k;

	        if(child != size && heap[child].compareTo(heap[child + 1]) < 0)
	        	child++;

	         if(tmp.compareTo(heap[child]) < 0)
	        	 heap[k] = heap[child];
	         else
	        	 break;
	    }
		heap[k] = tmp;
	}
	/**
	  * Deletes the top item
	 * @return 
	  */
	public  Pair deleteMin(Files files) throws RuntimeException{
		if (size == 0) throw new RuntimeException();
	    Pair min = heap[1];
//	    for debugging
//	    System.out.print("Deleted: ");min.print();
	    files.removeMin(heap[1].getSecond()-1);
	    if(files.getMin(min.getSecond()-1)!=null){
	    	Pair pair = new Pair(files.getMin(min.getSecond()-1),min.getSecond());
//	    	System.out.print("New pair added: ");pair.print();
	    	heap[1] = pair;
	    }else{
	    	heap[1]=heap[size--];
	    }
    	percolatingDown(1);
	    return min;
	}
	/**
	 * Deletes the top item
	 * review comment: implicit throws RTE...
	 */
	public Pair deleteMin() throws RuntimeException{
		if (size == 0) throw new RuntimeException();
		Pair min = heap[1];
		heap[1] = heap[size--];
		percolatingDown(1);
		return min;
	}

	/**
	 * Inserts a new item
	 */
	public void insert(Pair x){
		if(size == heap.length - 1) doubleSize();

		//Insert a new item to the end of the array
		int pos = ++size;

		//Percolate up
		for(; pos > 1 && x.compareTo(heap[pos/2])> 0; pos = pos/2 )
			heap[pos] = heap[pos/2];

		heap[pos] = x;
		/*
		System.out.println("Heap till now: ");
		
		for(int i=1;i<size+1;i++){
			System.out.print(heap[i].getFirst()+" ");
		}
		System.out.println();
*/   }
	private void doubleSize(){
		Pair[] old = heap;
		heap = new Pair[heap.length * 2];
		System.arraycopy(old, 1, heap, 1, size);
	}

	public int size(){
		return this.size;
	}
}
