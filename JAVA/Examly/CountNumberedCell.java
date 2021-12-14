package Examly;

import java.util.Scanner;

public class CountNumberedCell {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] arr=new int[n][n];
        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                arr[i][j]=sc.nextInt();
                if(arr[i][j]!=20)
                    count++;
            }
        }
        System.out.print(count);

        // printing 2d array
        // for(int row[]:arr)
        // {
        //     System.out.println(Arrays.toString(row));
        // }
        sc.close();
    }
}
