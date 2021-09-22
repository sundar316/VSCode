package Examly;

import java.util.Scanner;

public class Stock {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        sc.close();
        int max=-1;
        int buy=arr[0];
        for(int i=0;i<n-1;i++)
        {
            int a=arr[i+1]-buy;
            if(a<0)
                buy=arr[i];
            if(a>max)
                max=a;
        }
        System.out.println(max);
    }
}
