package Examly;

import java.util.Scanner;

public class CaptionContest {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s1=sc.next();
        String s2=sc.next();
        int min=0,mins1=0,mins2=0,max=0;
        for(int i=0;i<s1.length();i++)
        {
            if(s1.charAt(i)=='?')
                mins1++;
            if(s2.charAt(i)=='?')
                mins2++;
            if(s1.charAt(i)!=s2.charAt(i) || (s1.charAt(i)=='?' && s2.charAt(i)=='?'))
                max++;
        }
        if(mins1>mins2)
            min=mins2;
        else
            min=mins1;
        if(s1.equals(s2))
            min=0;
        System.out.print(min+" "+max);
        sc.close();
    }
}
