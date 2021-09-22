package Samples;

import java.util.Scanner;

public class FileName {
    static String checkExtension(String[] s){
        if(s[1].length()>4)
            return "error";
        return s[1];
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String[] S=s.split(".");
        System.out.print(checkExtension(S));
        sc.close();
    }
}
