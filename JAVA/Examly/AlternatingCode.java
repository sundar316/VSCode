package Examly;

import java.util.HashSet;
import java.util.Scanner;

public class AlternatingCode {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        HashSet<Character> HS=new HashSet<>();
        for(int i=0;i<s.length();i++)
            HS.add(s.charAt(i));
        if(HS.size()==2)
            System.out.print("Yes");
        else
            System.out.print("No");
        sc.close();
    }
}