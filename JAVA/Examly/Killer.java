package Examly;

import java.util.ArrayList;
import java.util.Scanner;

public class Killer {
    // public static ArrayList<Integer> Killers(ArrayList<Integer> l){
    // }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer> l=new ArrayList<>();
        if(n%2==0)
        {
            for(int i=1;i<=n;i+=2)
            {
                l.add(i);
            }
        }
        else
        {
            for(int i=3;i<=n;i+=2)
            {
                l.add(i);
            }
        }
        System.out.println();
        sc.close();
    }
}
