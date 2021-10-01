package Samples;

import java.util.Scanner;

public class SingleDigit {
    private static int Digit(int n)
    {
        int sum=0;
        while(n>10)
        {
            sum+=n%10;
            sum*=10;
            n/=10;
        }
        return sum+n;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        //while(n>10)
            n=Digit(n);
        System.out.print(n);
        sc.close();
    }
}
