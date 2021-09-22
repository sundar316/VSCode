package Samples.Regex;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Regex_abcd {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String C1="(([bd]*[ac]){2})*[bd]*";
        String C2="(([ac]*[bd]){2})*[ac]*";
        String I=sc.next();
        sc.close();
        boolean matches=Pattern.matches(C1,I)&&Pattern.matches(C2,I);
        if(matches)
            System.out.print("Even");
        else
            System.out.print("Odd");
    }
}
