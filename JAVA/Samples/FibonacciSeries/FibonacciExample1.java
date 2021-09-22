package Samples.FibonacciSeries;

import java.util.Scanner;

public class FibonacciExample1{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        sc.close();
        int arr[]=new int[a];
        for(int i=0;i<a;i++)
        {
            if(i==0 || i==1)
            {
                arr[0]=0;
                arr[1]=1;
                continue;
            }
            arr[i]=arr[i-2]+arr[i-1];
        }
        for(int i=0;i<a;i++)
            System.out.print(arr[i]+" ");
    }
}