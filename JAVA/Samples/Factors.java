package Samples;

import java.util.HashSet;
import java.util.Scanner;

public class Factors {
    static void isFactor(int n){
        HashSet<Integer> L=new HashSet<>();
        L.add(1);
        for(int i=2;i<=Math.sqrt(n);i++)
        {
            if(n%i==0)
            {
                L.add(i);
                L.add(n/i);
            }
        }
        L.add(n);
        System.out.println(L);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        isFactor(n);
        sc.close();
    }
}
