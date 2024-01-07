import java.util.Deque;
import java.util.ArrayDeque;

/* -----------------------------------------
   Note: The ArrayDeque is an implementation 
         of the Deque ADT. That is, it is a 
		   double-ended queue. 

		   You can simulate both a Stack and 
		   a regular Queue with this data structure
		   in the following way:

		 Stack: push  ~ addFirst
		        pop   ~ removeFirst
		
		 Queue: enqueue ~ addLast
		        dequeue ~ removeFirst
  ------------------------------------------ */

public class MyBlobs extends Blobs{


	///////////////////////////////////////////////////////////////////////	
	///////////////////////////////////////////////////////////////////////	
	// do NOT change or remove this constructor. We will use it to create 
	// objects when testing your code. If it is removed, we cannot test 
	// your code!
	///////////////////////////////////////////////////////////////////////	
	public MyBlobs(){}
	///////////////////////////////////////////////////////////////////////	
	///////////////////////////////////////////////////////////////////////	


	@Override
	public void blobRecursiveHelper(int row, int col, Deque<Pixel> blobSoFar){

		if(image.getPixel(row, col).visited()){
			return;
		}
		if(!image.getPixel(row, col).hasInk()){
			return;
		}

		image.getPixel(row, col).setVisited(true);
		blobSoFar.addLast(image.getPixel(row, col));

		if (row - 1 >= 0){
			blobRecursiveHelper(row -1, col, blobSoFar);
		}
		if (col + 1 < image.cols){
			blobRecursiveHelper(row, col + 1, blobSoFar);
		}
		if (row + 1 < image.rows){
			blobRecursiveHelper(row + 1, col, blobSoFar);
		}
		if (col - 1 >= 0){
			blobRecursiveHelper(row, col -1, blobSoFar);
		}
	}

	@Override
	public Deque<Pixel> blobIterative(int start_row, int start_col){

		Deque<Pixel> blobList = new ArrayDeque<Pixel>();
		Deque<Pixel> workingList = new ArrayDeque<Pixel>();
		workingList.addFirst(image.getPixel(start_row, start_col));

		while(workingList.size() > 0){
			
			Pixel p = workingList.removeFirst();
			
			if (p.hasInk() && p.visited == false){
				
				p.setVisited(true);
				blobList.addLast(p);

				if (p.row - 1 >= 0){
					workingList.addLast(image.getPixel(p.row -1, p.col));
				}

				if (p.row + 1 < image.rows){
					workingList.addLast(image.getPixel(p.row +1, p.col));
				}

				if (p.col - 1 >= 0){
					workingList.addLast(image.getPixel(p.row, p.col -1));
				}

				if (p.col + 1 < image.cols){
					workingList.addLast(image.getPixel(p.row, p.col +1));
				}
			}
		}
		return blobList;
	}
}
