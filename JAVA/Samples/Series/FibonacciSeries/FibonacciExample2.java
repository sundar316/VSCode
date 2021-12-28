package Samples.Series.FibonacciSeries;

import java.util.Scanner;

public class FibonacciExample2 {

    static int Fibonacci(int n){
        if(n<=1)
            return n;
        return Fibonacci(n-1)+Fibonacci(n-2);
    } 
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=1;i<n;i++)
            System.out.print(Fibonacci(i)+" ");
        sc.close();
    }
}
