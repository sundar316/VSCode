package TCS;

import java.util.Scanner;

public class SuperMarket {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String S=sc.next();
        int a=1;
        for(int i=0;i<S.length();i++)
        {
            char C=S.charAt(i);
            String ch=C+"";
            a=a*(Integer.parseInt(ch));
        }
        System.out.print(a);
        sc.close();
    }
}

