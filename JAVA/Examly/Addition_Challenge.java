package Examly;

import java.util.Scanner;

class AdditionChallenge{
    static int findSum(int n){
        int sum=0;
        for(int i=20;i<=20+n;i++)
        {
            sum+=i;
        }
        return sum;
    }
}

public class Addition_Challenge {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.print(AdditionChallenge.findSum(n));
        sc.close();
    }
}
