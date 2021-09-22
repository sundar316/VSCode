package Samples.Patterns;

import java.util.Scanner;
public class No{
    public static void main(String ar[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.close();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i+j==n+1 || i+j==n-3 || i+2==j || i==j+2)
                {
                    System.out.print("* ");

                }
                else
                {
                    System.out.print("  ");
                }
            }
            System.out.printf("  ");
            for(int j=0;j<n;j++)
            {
                if(i+j==n+1 || i+j==n-3 || i+2==j || i==j+2)
                {
                    System.out.print("* ");

                }
                else
                {
                    System.out.print("  ");
                }
            }
            System.out.printf("  ");
            for(int j=0;j<n;j++)
            {
                if(j==0 || j==n-1 || ((i==j || i+j==n-1) && i<=n/2))
                {
                    System.out.print("* ");

                }
                else
                {
                    System.out.print("  ");
                }
            }
            System.out.printf("  ");
            for(int j=0;j<n;j++)
            {
                if(i==0 || j==0 || j==n-1 || i==n/2 || i==n-1)
                {
                    System.out.print("* ");

                }
                else
                {
                    System.out.print("  ");
                }
            }
            System.out.printf("  ");
            for(int j=0;j<n;j++)
            {
                if(j==0 || j==n-1 || i==n-1)
                {
                    System.out.print("* ");

                }
                else
                {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}