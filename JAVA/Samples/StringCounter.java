package Samples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class StringCounter {
    static List<String> count(List<String> list) {
        HashSet<String> HS=new HashSet<>();
        for(String i:list)
        {
            HS.add(i);
        }
        List<String> result=new ArrayList<>();
        for (String i : HS)
        {
            int count=0;
            for (String s1 : list)
            {
                if (i.equals(s1))
                {
                    count++;
                }
            }
            result.add(i+" "+count);
        }
        Collections.sort(result);
        return result;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<String> list=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            list.add(sc.next());
        }
        for(String i:count(list))
        {
            System.out.println(i);
        }
        sc.close();
    }
}
