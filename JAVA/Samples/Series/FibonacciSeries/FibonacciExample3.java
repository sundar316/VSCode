package Samples.Series.FibonacciSeries;

import java.util.Scanner;

public class FibonacciExample3 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt(),
        num1=1,num2=1,num3;
        System.out.print(num1+" "+num2);
        for(int i=2;i<n;i++)
        {
            num3=num1+num2;
            System.out.print(" "+num3);
            num1=num2;
            num2=num3;
        }
        sc.close();
    }
}