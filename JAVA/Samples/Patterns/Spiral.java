package Samples.Patterns;

import java.util.Scanner;

public class Spiral {
    private static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int n=sc.nextInt();
        int a=1;
        int arr[][]=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n-i;j++)
            {
                arr[i][j]=a++;
            }
            for(int j=i+1;j<=n-1-i;j++)
            {
                arr[j][n-1-i]=a++;
            }
            for(int j=n-i-2;j>=i;j--)
            {
                arr[n-1-i][j]=a++;
            }
            for(int j=n-i-2;j>=i+1;j--)
            {
                arr[j][i]=a++;
            }
        }
        for(int[] i:arr)
        {
            for(int j:i)
            {
                if(j>9)
                    System.out.print(j+" ");
                else
                    System.out.print(j+"  ");
            }
            System.out.println();
        }
    }
}
