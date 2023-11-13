package Lab08;

/**
 * The `Heap` class represents a simple heap data structure.
 * A heap is a specialized tree-based data structure that satisfies the heap property.
 * In this implementation, the heap is represented as an array.
 * The class provides methods for insertion, deletion, and heap sort.
 *
 */
public class Heap {
	
	/** The current number of elements in the heap. */
	int load = 0;
	
	/** The array representing the heap. */
	int[] hArray = new int[100];

	/**
     * Constructs an empty heap.
     */
	Heap() {
	}

	/**
     * Performs the reheapUp operation to maintain the heap property after insertion.
     *
     * @param currentIndex The index of the current element.
     */
	void reheapUp(int currentIndex) {
		 // Exercise 1
		//  add your code here 
		if (currentIndex > 0) // check if current is not root.
		{
			int parentIndex = (int)Math.floor((currentIndex - 1) / 2); // find parent index
			if (hArray[parentIndex] < hArray[currentIndex]) // compare current and parent if parent < current then swap.
			{
				swap(hArray, parentIndex, currentIndex); // swap
				reheapUp(parentIndex); // means currentIndex = parentIndex; Do it until parent > current
			}
			
		}
	}

	/**
     * Inserts a new element into the heap and performs the necessary reheapUp operation.
     *
     * @param data The data to be inserted into the heap.
     */
	void insert(int data) {
		// Exercise 2
		// add your code here 
		hArray[load] = data; // add data to last current data.
		load++;
		reheapUp((load - 1)); // reheapup data
		
	}

	 /**
     * Performs the reheapDown operation to maintain the heap property after deletion.
     *
     * @param currentIndex The index of the current element.
     */
	void reheapDown(int currentIndex) {
		// Exercise 3
		// add your code here 
		int lastIndex = load - 1;
		if ((2 * currentIndex) + 1 <= lastIndex) //check for what XD?
		{
			int largeNodeIndex;
			int leftChildIndex = (2 * currentIndex) + 1; // index of leftchild.
			int rightChildIndex = (2 * currentIndex) + 2; // index of rightchild.
			
			if (rightChildIndex > lastIndex) // check is right child index exist?
			{
				largeNodeIndex = leftChildIndex;
			}
			else if (hArray[rightChildIndex] > hArray[leftChildIndex]) // if both left and right exist compare it's value and which have most value will be large node. in this case is right > left
			{
				largeNodeIndex = rightChildIndex;
			}
			else // left > right
			{
				largeNodeIndex = leftChildIndex;
			}
			if (hArray[currentIndex] < hArray[largeNodeIndex]) // compare value of current(parent) to value of large node(left/right) if current < large, swap and do it recursively until current !< large.
			{
				swap(hArray, largeNodeIndex, currentIndex);
				reheapDown(largeNodeIndex);
			}
		}
			
	}

	/**
     * Deletes the root element of the heap and performs the necessary reheapDown operation.
     *
     * @return The value of the root element that was deleted.
     */
	int deleteRoot() {
		// Exercise 4
		// add your code here 
		int temp = hArray[0];
		if (load - 1 >= 0) // check if we have more than 1 node (have other node which is not root)
		{
			hArray[0] = hArray[load - 1]; // replace root with last node
			hArray[load - 1] = 0; // delete last node
			load--; // update load
			reheapDown(0); // repeat it until it restructure
		}
		return temp;
	}

	/**
     * Sorts the heap in ascending order.
     */
	void makeHeapSort() {
		// Exercise 5
		// add your code here 
		while (load > 0)
		{
			int deletedRoot = deleteRoot();
			System.out.print(deletedRoot + " ");
		}
	}

	/**
     * Finds the level of a given node in the heap.
     *
     * @param nodeIndex The index of the node.
     * @return The level of the node in the heap.
     */
	int findLevel(int nodeindex) {
		int parent = (nodeindex - 1) / 2;
		int level = 0;

		if (parent > 0)
			level++;

		while (parent > 0) {
			parent = (parent - 1) / 2;
			level++;
		}
		return level;
	}

	/**
     * Swaps two elements in the heap array.
     *
     * @param A The heap array.
     * @param ind1 The index of the first element to be swapped.
     * @param ind2 The index of the second element to be swapped.
     */
	void swap(int[] A, int ind1, int ind2) {
		int temp = A[ind1];
		A[ind1] = A[ind2];
		A[ind2] = temp;
	}

	/**
     * Prints the elements of the heap array.
     */
	void printHeapArray() {
		for (int i = 0; i < load; i++)
			System.out.print(hArray[i] + " ");
		System.out.println();
	}

}