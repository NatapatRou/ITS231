public class Intro2JavaNForLoop
{
    public static void makeMultTable(int M) // pass
    {
        System.out.printf("X\t%d\n", M);
        for (int i = 1, num = M; i <= 12; i++)
        {
            System.out.printf("%d\t%d\n", i, num);
            num = num + M;
        }
    }

    public static void deductK(int M, int k) // pass
    {
        for (int i = 0; M - (k * i) > 0; i++)
        {
            System.out.printf("%d ", M - (k * i));
        }
        System.out.println("");
    }

    public static void makeUpwardRightTriangle(int w) // pass
    {
        for (int i = 0; i < w; i++) // rows
        {
            for (int j = 0; j <= i; j++) // columns
            {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    public static void makeDownwardRightTriangle(int w) // pass
    {
        for (int i = w; i > 0; i--) // rows
        {
            for (int j = 1; j <= i; j++) // columns 
            // not use j = 0 and j <= (i - 1) because don't want to do an arithmatic
            {
                System.out.print("*");
            }
            System.out.println("");
        }

    }
    
    public static void makeUpwardIsosceles(int w) // pass
    {
        int column = (w * 2) + 1;
        for (int i = w; i >= 0; i--) // w + 1
        {
            for (int j = 0; j <= column; j++) // (w * 2)+ 1
            {
                if (j >= i && (column - j) > i) 
                {
                    System.out.print("*");
                    // System.out.print(j);
                }
                else
                {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        System.out.println("Exercise 5 makeUpwardIsosceles(4)");
        System.out.println("Your answer is ");
        makeUpwardIsosceles(4);
        System.out.println("The Correct answer is ");   
        System.out.println("    *\n   ***\n  *****\n *******\n*********\n");  

    }
}
