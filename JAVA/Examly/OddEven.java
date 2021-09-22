package Examly;

import java.util.Scanner;

public class OddEven {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int even=0;
        int odd=0;
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            String s1=c+"";
            int n=Integer.parseInt(s1);
            if(n%2==0)
                even=even+n;
            else
                odd=odd+n;
        }
        System.out.print(odd+" ");
        sc.close();
    }
}
