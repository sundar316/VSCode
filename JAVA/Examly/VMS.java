package Examly;

import java.util.HashSet;
import java.util.Scanner;

public class VMS {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int M[]=new int[m];
        int k=sc.nextInt();
        int K[]=new int[k];
        HashSet<Integer> HS=new HashSet<>();
        for(int i=0;i<m;i++)
            M[i]=sc.nextInt();
        for(int i=0;i<k;i++)
            K[i]=sc.nextInt();
        int count=0;
        int loop=0;
        for(int i:M)
        {
            HS.add(i);
            for(int j:K)
            {
                if(loop<K.length)
                {
                    HS.add(j);
                    loop++;
                }
                if(i==j)
                    count++;
            }
        }

        System.out.print(count+" "+(n-HS.size()));
        sc.close();
    }
}
