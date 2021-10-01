package Samples.Patterns;

import java.util.Scanner;

public class Pyramid{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            if(n%2!=0)
            {
                for(int j=0;j<n;j++)
                {
                    if(((i+j)%2==0 && i<=j))
                        System.out.print("* ");
                    else
                        System.out.print("  ");
                }
                for(int j=1;j<n;j++)
                {
                    if((i+j)%2==0 && i+j<=n-1)
                        System.out.print("* ");
                    else
                        System.out.print("  ");
                }
            }
            else
            {
                for(int j=1;j<n;j++)
                {
                    if(((i+j)%2!=0 && i<=j))
                        System.out.print("* ");
                    else
                        System.out.print("  ");
                }
                for(int j=0;j<n;j++)
                    {
                        if((i+j)%2!=0 && i+j<=n-1)
                            System.out.print("* ");
                        else
                            System.out.print("  ");
                    }
            }
            System.out.println();
        }
        sc.close();
    }
}