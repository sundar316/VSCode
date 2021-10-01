package Examly;

import java.util.Scanner;

public class NumberChallenge {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int count1=0,count0=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='1')
                count1++;
            else
                count0++;
        }
        if(count1==1 || count0==1)
            System.out.print("Yes");
        else
            System.out.print("No");
        sc.close();
    }
}
