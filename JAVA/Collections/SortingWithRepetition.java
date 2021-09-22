package Collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

class SortingWithRepetition {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        HashSet<Integer> set=new HashSet<>();
        HashSet<Integer> set1=new HashSet<>();
        HashMap<Integer,Integer> M=new HashMap<>();
        List<Integer> L=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
            set.add(arr[i]);
        }
        for(int i:set)
        {
            int count=0;
            for(int j:arr)
            {
                if(i==j)
                {
                    count++;
                }
            }
            M.put(i,count);
        }
        for(int i:M.values())
            set1.add(i);
        for(int i:set1)
        {
            for(int j:set)
            {
                if(M.get(j)==i)
                {
                    for(int k=0;k<i;k++)
                        L.add(j);
                }
            }
        }
        System.out.print(L);
        sc.close();
    }
}