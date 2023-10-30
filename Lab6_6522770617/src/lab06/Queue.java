package lab06;

/**
 * A generic queue implementation using a singly linked list.
 *
 * @param <T> the type of elements stored in the queue
 */
public class Queue<T> {
	/** The underlying singly linked list for the queue. */
	SList<T> list = new SList<T>();

	/** Default constructor to initialize an empty queue. */
	Queue() {
	}

	/**
	 * Enqueues an element into the queue.
	 *
	 * @param element the element to enqueue
	 */
	void enqueue(T element) {
		list.addLast(element);
		// Exercise 1a
	}

	/**
	 * Dequeues an element from the queue.
	 *
	 * @return the dequeued element
	 */
	T dequeue() {
		return list.removeFirst(); // Exercise 1b
	}

	/**
	 * Gets the element at the front of the queue without removing it.
	 *
	 * @return the element at the front of the queue
	 */
	T queuefront() {
		return  list.first.element; // Exercise 1c
	}

	/**
	 * Gets the element at the rear of the queue without removing it.
	 *
	 * @return the element at the rear of the queue
	 */
	T queuerear() {
		return list.last.element; // Exercise 1d
	}

	/**
	 * Checks if the queue is empty.
	 *
	 * @return true if the queue is empty, false otherwise
	 */
	boolean isEmpty() {
		return list.isEmpty();
	}

	/**
	 * Creates a copy of this queue.
	 *
	 * @return a new queue containing the same elements as this queue
	 */
	Queue<T> copyQueue() { // Exercise 2
		Queue<T> Q2 = new Queue<T>();
		// Add your code here
		int length = this.list.getSize();
		T tempElement;
		for (int i = 0; i < length; i++)
		{
			tempElement = this.dequeue();
			Q2.enqueue(tempElement);
			this.enqueue(tempElement);
		}
		return Q2;
//		int length = this.list.getSize();
//		for (int i = 0; i < length; i++)
//		{	
//			tempElement = this.dequeue();
//			tmp.enqueue(tempElement);
//			Q2.enqueue(tempElement);
//			
//		}
//		for (int i = 0; i < length; i++)
//		{
//			this.enqueue(tmp.dequeue());
//		}
//		return Q2;
	}

	/**
	 * Checks if this queue is identical to another queue in terms of content and
	 * sequence.
	 *
	 * @param Q2 the queue to compare with
	 * @return true if the queues are identical, false otherwise
	 */
	boolean isIdentical(Queue<T> Q2) {
		// Exercise 3
		int qTwoLength = Q2.list.getSize();
		int thisLength = this.list.getSize();
		if (qTwoLength != thisLength)
		{
			return false;
		}
		for (int i = 0; i < thisLength; i++)
		{
			T tmp1 = Q2.dequeue();
			T tmp2 = this.dequeue();
			this.enqueue(tmp2);
			
			if (tmp1 != tmp2)
			{
				return false;
			}
		}
	return true;
		
	}

	/**
	 * Prints the elements of the queue horizontally. Handles potential
	 * 
	 */
	void printHorizontal() {
		Node<T> walker = list.first;
		while (walker != null) {
			System.out.print(walker.element + " ");
			walker = walker.next;
		}

	}

}