/**
 * The {@code Stack<T>} class represents a generic stack data structure
 * implemented using a singly linked list. It provides methods for push, pop,
 * peek, copy, printing, binary conversion, and more.
 *
 * @param <T> The type of elements stored in the stack.
 */
class Stack<T> {

	private SList<T> list = new SList<T>();

	/**
	 * Constructs an empty stack.
	 */
	Stack() {
	}

	/**
	 * Pushes an element onto the top of the stack.
	 *
	 * @param element The element to be pushed onto the stack.
	 */
	void push(T element) {// Exercise 1a
		list.addFirst(element);
	}

	/**
	 * Removes and returns the element at the top of the stack.
	 *
	 * @return The element removed from the top of the stack.
	 */
	T pop() {// Exercise 1b
		Node<T> tmp = list.first;
		return list.removeFirst();
		
		
	}

	/**
	 * Retrieves the element at the top of the stack without removing it.
	 *
	 * @return The element at the top of the stack.
	 */
	T peek() {// Exercise 1c
		Node<T> tmp = list.first;
		return tmp.element;
	}

	/**
	 * Checks if the stack is empty.
	 *
	 * @return {@code true} if the stack is empty, {@code false} otherwise.
	 */
	boolean isEmpty() {
		return list.isEmpty();
	}

	/**
	 * Creates and returns a copy of the stack.
	 *
	 * @return A copy of the stack.
	 */
	Stack<T> copyStack() {
		Stack<T> rvStack = reverseStack();
		return rvStack.reverseStack();
	}

	/**
	 * Prints the elements of the stack vertically.
	 */
	void printVertical() {
		SListExtension.printVertical(list);
	}

	/**
	 * Converts an integer to binary representation and prints it.
	 *
	 * @param x The integer to be converted to binary.
	 */
	static void binaryConversion(int x) {// Exercise 2
		Stack<Integer> answer = new Stack<Integer>();
		// Write your code here
		if (x == 0)
		{
			answer.push(0);
		}
		else
		{
			while (x != 0)
			{
				answer.push(x % 2);
				x = x / 2;
			}
		}
		
		answer.list.printHorizontal();
	}

	/**
	 * Reverses the order of elements in the stack.
	 *
	 * @return A new stack with the reversed order of elements.
	 */
	Stack<T> reverseStack() {// Exercise 3
		Stack <T> tmp = new Stack <T>();
		Stack <T> reverse = new Stack <T>();
		
		while (!this.isEmpty())
		{
			T val = this.pop();
			tmp.push(val);
			reverse.push(val);		
		}
		
		while (!tmp.isEmpty())
		{
			this.push(tmp.pop());
		}
		return reverse;
	}

	/**
	 * Checks if a given string is a palindrome (case-insensitive).
	 *
	 * @param word The string to be checked for palindrome.
	 * @return {@code true} if the string is a palindrome, {@code false} otherwise.
	 */
	static boolean isPalindrome(String word) {// Exercise 4
		Stack <Character> initial = new Stack <Character>();
		word = word.toLowerCase();
		int length = word.length();
		for (int i = 0; i < length; i++)
		{
			initial.push(word.charAt(i));
		}
		Stack <Character> revInitial = initial.reverseStack();
		
		int size = initial.list.getSize();
		for (int i = 0; i < size; i++)
		{
			if (initial.pop() != revInitial.pop())
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks if a string represents an integer.
	 *
	 * @param s The string to be checked.
	 * @return {@code true} if the string represents an integer, {@code false}
	 *         otherwise.
	 */
	public static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	/**
	 * Evaluates a postfix expression and returns the result.
	 *
	 * @param input The postfix expression as an array of strings.
	 * @return The result of evaluating the postfix expression.
	 */
	public static Integer evalPostfix(String[] input) {// Exercise 5
		Stack<Integer> S = new Stack<Integer>();
		// Write your code here
		int iplength = input.length;
		for (int i = 0; i < iplength; i++)
		{
			if (isInteger(input[i]))
			{
				S.push(Integer.parseInt(input[i]));
			}
			else
			{
				int a = S.pop();
				int b = S.pop();
				String opt = input[i];
				
				if (opt == "*")
				{
					S.push(b * a);
				}
			
				else if (opt == "/")
				{
					S.push(b / a);
				}
				else if (opt == "+")
				{
					S.push(b + a);
				}
				else if (opt == "-")
				{
					S.push(b - a);
				}
				else if (opt == "%")
				{
					S.push(b % a);
				}
			
			}
		
		}
		return S.peek();
	}
}
