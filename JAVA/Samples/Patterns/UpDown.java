package Samples.Patterns;

import java.util.Scanner;

public class UpDown {
    private static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int n=sc.nextInt();
        int c;
        if(n%2==0)
            c=n/2;
        else
            c=n/2+1;
        int start=0;
        int end=n-1;
        int a=1;
        int arr[][]=new int[n][n];
        while(c!=0)
        {
            for(int i=start;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(i==start || i==end)
                    {
                        arr[i][j]=a++;
                    }
                }
            }
            start++;
            end--;
            c--;
        }

        for(int[] i:arr)
        {
            for(int j:i)
            {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
