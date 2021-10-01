package Examly;

import java.util.Scanner;

public class MailValidation {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String s1[]={"com","in","net","org"};
        boolean flag=false;
        for(int i=0;i<s1.length;i++)
        {
            if(s.contains(s1[i]))
                flag=true;
        }
        if(flag)
            System.out.print("Valid email address");
        else
            System.out.print("Invalid email address");
        sc.close();
    }
}
