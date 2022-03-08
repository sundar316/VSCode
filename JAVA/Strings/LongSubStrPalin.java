package Strings;

import java.util.Scanner;

// method 1

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Scanner;

// public class LongSubStrPalin {

//     private static Scanner sc = new Scanner(System.in);
    // static List<String> res = new ArrayList<>();
    // public static void main(String[] args) {
    //     String input = sc.nextLine();
    //     long n = input.length();
    //     for (long i = 2; i <= n; i++) {
    //         long val = (long)Math.pow(2, i)-1;
    //         while (Math.pow(2, n) > val) {
    //             String temp = "";
    //             long len = n - Long.toBinaryString(val).length();
    //             while (len-- > 0) {
    //                 temp += "0";
    //             }
    //             temp += Long.toBinaryString(val);
    //             // System.out.println(temp);
    //             check(temp, input, n);
    //             val *= 2;
    //         }
    //         // System.out.println();
    //     }
    //     if (res.size() == 0) {
    //         System.out.println(-1);
    //         return;
    //     }
    //     System.out.println(res.get(res.size()-1));
    // }

    // private static boolean check(String bin, String input, Long n) {
    //     String temp = "";
    //     for (int i = 0; i < n; i++) {
    //         if (bin.charAt(i) == '1') {
    //             temp += input.charAt(i);
    //         }
    //     }
    //     for (int i = 0; i <= temp.length() / 2; i++) {
    //         if (temp.charAt(i) != temp.charAt(temp.length()-1-i)) {
    //             return false;
    //         }
    //     }
    //     res.add(temp);
    //     return true;
    // }
// }

// method 2

public class LongSubStrPalin {

    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
    }
}

