public class Recursion {
 
	static int subsum(int n) {
		//Ex1. Complete the content of this method 
        if (n == 1)
        {
        	return 1;
        }
        return (int) (n*(Math.pow(-1, n+1))) + subsum(n-1);
        
        
    }
    
	static int sumDigit(int n) {
		//Ex2. Complete the content of this method 
        if (n == 0)
        {
        	return 0;
        }
        else
        {
        	return n%10 + sumDigit(n / 10);
        }
        
    }
    
	public static void main(String[] args) {
          

    
          
                 System.out.println("Calculating subsum(10):");
                 System.out.println("Your answer is "+subsum(10));
                 System.out.println("The correct answer is -5");


 
                 System.out.println("sumDigit(123456789)");
                 System.out.println("Your answer is "+ sumDigit(123456789));
                 System.out.println("The correct answer is 45");

	}
    
}