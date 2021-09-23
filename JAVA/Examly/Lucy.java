package Examly;

import java.util.ArrayList;
import java.util.Scanner;

public class Lucy {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer> L=new ArrayList<>();
        for(int i=0;i<n;i++)
            L.add(sc.nextInt());
        int a=sc.nextInt();
        ArrayList<Integer> L1=new ArrayList<>();
        for(int i=0;i<a;i++)
            L1.add(sc.nextInt());
        int count=0;
        for(int i:L)
        {
            if(L1.contains(i))
                count++;
        }
        if(count==L1.size())
            System.out.print("Yes");
        else
            System.out.print("No");
        sc.close();
    }
}
