package Examly;

import java.util.Scanner;

public class FullIsland {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] arr=new int[n][n];
        int I=0,J=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                arr[i][j]=sc.nextInt();
                if(arr[i][j]==1)
                {
                    I=i;
                    J=j;
                }
            }
        }
        System.out.println();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if((i==I && j==J+1) || (i==I+1 && j==J) || (i==I && j==J-1) || (i==I-1 && j==J))
                {
                    arr[i][j]=0;
                }
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        sc.close();
    }
}
