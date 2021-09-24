package Examly;

import java.util.Scanner;

public class BiPattern {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==n-1)
                    System.out.print("*");
                else if(i+j==n-1)
                    System.out.print("*");
                else if(i+j<n-1)
                    System.out.print("b");
                else if(i+j>n-1)
                    System.out.print("i");
            }
            for(int j=1;j<n;j++)
            {
                if(i==n-1)
                    System.out.print("*");
                else if(i==j)
                    System.out.print("*");
                else if(i<j)
                    System.out.print("b");
                else if(i>j)
                    System.out.print("i");
            }
            System.out.println();
        }
        sc.close();
    }
}
