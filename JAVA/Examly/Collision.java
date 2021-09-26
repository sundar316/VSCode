package Examly;

import java.util.Scanner;

public class Collision {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();
        int[][] arr=new int[N][M];
        int a=0;
        for(int i=0;i<N;i++)
        {
            int count=0;
            for(int j=0;j<M;j++)
            {
                arr[i][j]=sc.nextInt();
                if(arr[i][j]==1)
                {
                    count++;
                }
            }
            if(count>1)
                a+=(count*(count-1))/2;
        }

        System.out.print(a);
        sc.close();
    }
}
