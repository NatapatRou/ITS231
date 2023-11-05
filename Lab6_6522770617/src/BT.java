/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

public class BT<T>{

	int size;
	BTNode<T> root = null;

	BT() {
		root = null;
		size = 0;
	}

	BT(T data) {
		this(new BTNode<T>(data));
	}

	BT(BTNode<T> root) {
		this.root = root;
		size = 1;
	}

	BT(BTNode<T> root, BT<T> Lsubtree, BT<T> Rsubtree) {
		this.root = root;
		root.left = Lsubtree.root;
		root.right = Rsubtree.root;
		size = Lsubtree.size + Rsubtree.size + 1;
	}

	int findHeight() {
		return findHeight(root);
	}

	int findHeight(BTNode<T> root) {
		// Exercise 1 ////////////////
		if (root == null) {
		// Replace the following statement with your code.
			return 0;
		} else if (isLeaf(root)) {
		// Replace the following statement with your code.
			return 1;
		} else {	
		// Replace the following statement with your code.
			int lheight = findHeight(root.left);
			int rheight = findHeight(root.right);
			
			
			if (lheight > rheight)
			{
				//System.out.println("LeftH: " + lheight);
				return 1 + lheight;
				
			}
			else
			{
//				System.out.println("RightH: " + rheight);
				return 1 + rheight;
				
			}
		}		
	}

	boolean isLeaf(BTNode<T> root) {
		if (root != null && root.left == null && root.right == null) {
			return true;
		} 
		else {
			return false;
		}
	}

	boolean isBalanced() {
		return isBalanced(root);
	}

	boolean isBalanced(BTNode<T> root) {
		if (root == null) {
			return true;
		}
		int LH = findHeight(root.left);
		int RH = findHeight(root.right);
		int B = Math.abs(LH - RH);
		
		if (B <= 1) {
			return (isBalanced(root.left) && isBalanced(root.right));
		} 
		else {
			return false;
		}
	}

	/* Inorder traversal from the root */
	public void inorder() {
		inorder(root);
	}

	/* Inorder traversal from a subtree */
	protected void inorder(BTNode<T> root) {
		// Exercise 2 (a) Complete this method
		if (root != null)
		{	
			if (isLeaf(root))
			{
				System.out.print(root.element + " ");
			}
			else
			{
				inorder(root.left);
				System.out.print(root.element + " ");
				inorder(root.right);
			}
		}
		
	}

	/* Postorder traversal from the root */
	public void postorder() {
		postorder(root);
	}

	/* Postorder traversal from a subtree */
	protected void postorder(BTNode<T> root) {
		// Exercise 2 (b) Complete this method
		if (root != null)
		{
			if (isLeaf(root))
			{
				System.out.print(root.element + " ");
			}
			else
			{
				postorder(root.left);
				postorder(root.right);
				System.out.print(root.element + " ");
			}
		}
	}

	/* Preorder traversal from the root */
	public void preorder() {
		preorder(root);
	}

	/* Preorder traversal from a subtree */
	protected void preorder(BTNode<T> root) {
	    if (root != null) {
	       if (isLeaf(root)) {
	    	   System.out.print(root.element + " ");
	       } 
	       else {
	    	   System.out.print(root.element + " ");
	    	   preorder(root.left);
	    	   preorder(root.right);
	       }
	    }
	}

	void PrintDFT() {
		// Exercise 3 ////////////////
		Stack<BTNode<T>> S = new Stack<BTNode<T>>();
		S.push(root);
		//insert your code here
		BTNode<T> temp;
		while (!S.isEmpty())
		{
			temp = S.pop();
			System.out.print(temp.element + " ");
			if (!isLeaf(temp))
			{
				S.push(temp.right);
				S.push(temp.left);
			}
		}
		
	}

	void PrintBFT() {
		// Exercise 4 ////////////////
		Queue<BTNode<T>> Q = new Queue<BTNode<T>>();
		Q.enqueue(root);
		//insert your code here
		BTNode<T> temp;
		while (!Q.isEmpty())
		{
			temp = Q.dequeue();
			System.out.print(temp.element + " ");
			
			if (!isLeaf(temp))
			{
				Q.enqueue(temp.left);
				Q.enqueue(temp.right);
			}
		}
		
	}

	static boolean hasHigherPriority(String sign1, String sign2) {
		if (sign2.equals("("))
			return true;
		else if (sign1.equals("*") && sign2.equals("+"))
			return true;
		else if (sign1.equals("*") && sign2.equals("-"))
			return true;
		else if (sign1.equals("/") && sign2.equals("+"))
			return true;
		else if (sign1.equals("/") && sign2.equals("-"))
			return true;
		else if (sign1.equals("%") && sign2.equals("+"))
			return true;
		else if (sign1.equals("%") && sign2.equals("-"))
			return true;
		else
			return false;

	}

	// Exercise 5 ///////////////////////////////////////////////
	public static boolean isOperator(String item)
	{ 
		if (item.equals("+") || item.equals("-") || item.equals("*") || item.equals("/") || item.equals("%"))
			return true;
		else
			return false;
	}
     

 
    public static BT<String> makeExpressionTree(String [] infixArr)
	{   
		Stack<BT<String>> BTStack = new Stack<BT<String>>();
        Stack<BTNode<String>> parent = new Stack<BTNode<String>>(); //for keeping parent nodes
        String item;
        int i=0;
        while(i!=infixArr.length){
        	item = infixArr[i]; //read item from array 
        	// Case 1: if item it is an open parenthesis
        	if (item.equals("(")) {
        		//add your code here
                BTNode<String> open = new BTNode<String>(item);
                parent.push(open);
        	} 
        	else if (isOperator(item)){
        		BTNode<String> temp = new BTNode<String>(item);
        		if (parent.isEmpty()) { // stack is empty
        			// add your code here
                    parent.push(temp);
        		}
        		else {// stack is not empty
              
        			if(hasHigherPriority(item, parent.peek().element)) {  
        				// add your code here
            	        parent.push(temp);	
        			}
        			else {
        				// add your code here
                        BTNode<String> root = parent.pop();
                        BT<String> Rsubtree = BTStack.pop();
                        BT<String> Lsubtree = BTStack.pop();
                        BT<String> newBT = new BT<String>(root, Lsubtree, Rsubtree);
                        BTStack.push(newBT);
                        parent.push(temp);
        			}
        		}
        	}
        	// Case3: if item is a close parenthesis  
        	else if (item.equals(")")) {
        		while (parent.peek().element.equals("(") == false) {
        			BTNode<String> root = parent.pop();
        			BT<String> Rsubtree = BTStack.pop();
        			BT<String> Lsubtree = BTStack.pop();
        			BT<String> newBT = new BT<String>(root, Lsubtree, Rsubtree);
        			BTStack.push(newBT);
        		}
        		parent.pop();
        	}
        	else {// Case 4: it is not an operator
        		BT<String> newTree = new BT<String>(item);
        		// add your code here
                BTStack.push(newTree);
        	}
        	i++;
        }
        while (!parent.isEmpty()) {
        	BTNode<String> root = parent.pop();
        	BT<String> Rsubtree = BTStack.pop();
        	BT<String> Lsubtree = BTStack.pop();
        	BT<String> newBT = new BT<String>(root, Lsubtree, Rsubtree);
        	// add your code here
            BTStack.push(newBT);
        }
        return BTStack.pop();
    }
}
