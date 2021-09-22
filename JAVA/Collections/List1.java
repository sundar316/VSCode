package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class List1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        List<Integer> A=new ArrayList<>();
        int n=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            A.add(i,sc.nextInt());
        }
        Collections.sort(A);
        for(int i=0;i<A.size();i++)
            System.out.print(A.get(i)+" ");
        System.out.println();
        System.out.println(A);
        for(int i:A)
            System.out.print(i+" ");
        sc.close();
    }
}

