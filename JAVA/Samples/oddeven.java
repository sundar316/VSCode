package Samples;

import java.util.Scanner;

public class oddeven {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String a=sc.nextLine();
        sc.close();
        int b=a.length();
        if(a.charAt(b-1)=='2' || a.charAt(b-1)=='4' || a.charAt(b-1)=='6' || a.charAt(b-1)=='8' || a.charAt(b-1)=='0')
            System.out.println("Even");
        else
            System.out.println("Odd");
    }
}
