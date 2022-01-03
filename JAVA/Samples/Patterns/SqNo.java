package Samples.Patterns;

import java.util.Scanner;

public class SqNo {
    private static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int n=sc.nextInt();
        int size=n*2-1;
        int start=0;
        int end=size-1;
        int arr[][]=new int[size][size];
        while(n!=0)
        {
            for(int i=start;i<=end;i++)
            {
                for(int j=start;j<=end;j++)
                {
                    if(i==start || i==end || j==start ||j==end)
                        arr[i][j]=n;
                }
            }
            start++;
            end--;
            n--;
        }

        for(int[] i:arr)
        {
            for(int j:i)
            {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
