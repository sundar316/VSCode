package Virtusa;

import java.util.Scanner;

public class UniqueString {


    /*
        input : malayalam
        output: maly
    */

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String str = sc.nextLine();
        String res = "";
        for (int i = 0; i < str.length(); i++) {
            if (!res.contains(str.charAt(i)+"")) {
                res += str.charAt(i);
            }
        }
        System.out.println(res);
    }
}
