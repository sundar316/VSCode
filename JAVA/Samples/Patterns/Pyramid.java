package Samples.Patterns;

import java.util.Scanner;

public class Pyramid{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        //for downward pyramid
        for(int i=0;i<n;i++)
        {
            if(n%2!=0)
            {
                //for left side pyramid
                for(int j=0;j<n;j++)
                {
                    if(((i+j)%2==0 && i<=j))
                        System.out.print("* ");
                    else
                        System.out.print("  ");
                }
                //for right side pyramid
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
                //for left side pyramid
                for(int j=1;j<n;j++)
                {
                    if(((i+j)%2!=0 && i<=j))
                        System.out.print("* ");
                    else
                        System.out.print("  ");
                }
                //for right side pyramid
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

/*****************************************************************************/

        //for upward pyramid
        for(int i=1;i<n;i++)
        {
            if(n%2==0)
            {
                //for left side pyramid
                for(int j=0;j<n;j++)
                {
                    if(((i+j)%2!=0 && i+j>=n-1))
                        System.out.print("* ");
                    else
                        System.out.print("  ");
                }
                //for right side pyramid
                for(int j=1;j<n;j++)
                {
                    if((i+j)%2==0 && i>=j)
                        System.out.print("* ");
                    else
                        System.out.print("  ");
                }
            }
            else
            {
                //for left side pyramid
                for(int j=0;j<n;j++)
                {
                    if(((i+j)%2==0 && i+j>=n-1))
                        System.out.print("* ");
                    else
                        System.out.print("  ");
                }
                //for right side pyramid
                for(int j=1;j<n;j++)
                {
                    if((i+j)%2==0 && i>=j)
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