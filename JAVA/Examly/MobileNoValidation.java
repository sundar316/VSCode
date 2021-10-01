package Examly;

import java.util.Scanner;

public class MobileNoValidation {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        if(s.substring(0,3).compareTo("+91")==0 && s.substring(3).length()==10)
            System.out.print("Mobile number Valid");
        else
            System.out.print("Mobile number invalid");
        sc.close();
    }
}
