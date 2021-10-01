package Examly;

import java.util.Scanner;

public class CasperAtTheCarnival {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String s[]=new String[n];
        for(int i=0;i<n;i++)
        {
            s[i]=sc.next();
        }
        boolean flag=true;
        if(n<2 || s[n-1].equals("cookie"))
            flag=false;
        else
        {
            for(int i=0;i<n-1;i++)
            {
                if(s[i].equals(s[i+1]) && s[i].equals("cookie"))
                {
                    flag=false;
                    break;
                }
            }
        }
        if(flag)
            System.out.print("Yes");
        else
            System.out.print("No");
        sc.close();
    }
}
