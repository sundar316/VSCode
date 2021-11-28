package Samples.Games;

import java.util.Random;
import java.util.Scanner;

public class OddOrEven {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Odd/Even: ");
        String s=sc.next();
        System.out.print("Enter No. from (1-10): ");
        int n1=sc.nextInt();
        int n=new Random().nextInt(10);
        System.out.print("Me: "+n+"\nYou: "+n1);
        if(s.equals("Odd")&&(n+n1)%2==0)
        {
            System.out.print("\nI Win");
        }
        else
            System.out.print("\nYou Win");
        sc.close();
    }
}
