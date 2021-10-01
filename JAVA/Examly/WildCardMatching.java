package Examly;

import java.util.Scanner;

public class WildCardMatching {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.next();
        String s2=sc.next();
        boolean flag=false;
        if(s1.length()==s2.length())
        {
            for(int i=0;i<s1.length();i++)
            {
                if(s1.charAt(i)==s2.charAt(i) || s1.charAt(i)=='?' || s2.charAt(i)=='?')
                    flag=true;
            }
        }
        if(flag)
            System.out.print("Yes");
        else
            System.out.print("No");
        sc.close();
    }
}
