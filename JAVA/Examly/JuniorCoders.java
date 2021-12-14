package Examly;

import java.util.Scanner;

public class JuniorCoders {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        String s1=sc.next();
        if(s1.length()>s.length())
            System.out.println("No");
        else
        {
            if(s.substring((s.length()-1)-(s.length()-1)) .equals(s1))
                System.out.print("Yes");
            else
                System.out.print("No");
        }
        sc.close();
    }
}
