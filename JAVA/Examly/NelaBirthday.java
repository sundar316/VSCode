package Examly;

import java.util.Scanner;

public class NelaBirthday {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int acount=0,bcount=0;
        for(int j=0;j<s.length();j++)
        {
            if(s.charAt(j)=='a')
                acount++;
            else
                bcount++;
        }
        if(acount>bcount)
            System.out.print(bcount);
        else
            System.out.print(acount);
        sc.close();
    }
}
