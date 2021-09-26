package Examly;

import java.util.Scanner;

public class HighestValueNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] arr=new int[n][n];
        int max=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                arr[i][j]=sc.nextInt();
                if(arr[i][j]!=20)
                {
                    if(max<arr[i][j])
                    {
                        max=arr[i][j];
                    }
                }
            }
        }
        System.out.print(max);
        sc.close();
    }
}
