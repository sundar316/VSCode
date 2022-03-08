package Samples.Patterns;

import java.util.Scanner;

public class Brackets {

    /* -------------------------------------------------------------------------- */
    /*                                input : a(2(b)2(c))                         */
    /*                                output: abbcc                               */
    /* -------------------------------------------------------------------------- */

    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String arr[] = sc.nextLine().split("\\(");
        StringBuffer res = new StringBuffer();
        int index = arr.length-1;
        // for (int i = arr.length-1; i >= 0; i--) {
            String temp = arr[index];
            for (int j = 0; j < temp.length(); j++) {
                if (temp.charAt(j) == ')') {
                    index--;
                    String temp1 = arr[index];
                    for (int k = arr[index].length()-1; k >= 0; k--) {
                        if (Character.isDigit(temp1.charAt(k))) {
                            int num = temp1.charAt(k)-48;
                            while (--num > 0) {
                                res.append(res.toString());
                            }
                        } else if (temp1.charAt(k) == ')') {
                            break;
                        } else {
                            String p = res.toString();
                            res.delete(0, res.length());
                            res.append(temp1.charAt(k)+p);
                        }
                    }
                } else {
                    res.append(temp.charAt(j));
                }
            }
        // }
        System.out.println(res);
    }
}
