package Virtusa;

import java.util.Scanner;

public class NumRev {


    /*
        input : 123
        output: 321
    */

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        StringBuffer s = new StringBuffer(sc.nextLine());
        s.reverse();
        String str = s.toString();
        int n = 0;
        if (str.charAt(str.length()-1) == '-') {
            n = Integer.parseInt(str.substring(0, s.length()-1));
            n *= -1;
        } else {
            n = Integer.parseInt(str.toString());
        }
        System.out.println(n);
    }

}
