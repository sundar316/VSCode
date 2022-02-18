package InfyTq;

import java.util.Scanner;

public class java_IntReplace {


    /* -------------------------------------------------------------------------- */
    /*                            input : 43,66,225,76                            */
    /*                            output: 116.0                                   */
    /* -------------------------------------------------------------------------- */

    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String arr[] = sc.nextLine().split(",");
        String str = "";
        t : for (String i : arr) {
            for (int j = 0; j < i.length(); j++) {
                if (i.charAt(j) == '6') {
                    str += i.replace('6', '9')+",";
                    continue t;
                }
            }
            str += i+",";
        }
        String out[] = str.split(",");
        for (int i = 0; i < out.length; i++) {
            StringBuffer s = new StringBuffer(out[i]);
            out[i] = s.reverse().toString();
        }


        int n = 0;
        for (String i : out) {
            n += Integer.parseInt(i);
        }
        System.out.printf("%.2f", (float)(n/out.length));
    }
}
