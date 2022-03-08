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
        StringBuffer s;
        double avg = 0;
        t : for (String i : arr) {
            for (int j = 0; j < i.length(); j++) {
                if (i.charAt(j) == '6') {
                    s = new StringBuffer(i.replaceAll("6", "9"));
                    s.reverse();
                    avg += (Integer.parseInt(s.toString())/(double)arr.length);
                    continue t;
                }
            }
            avg += (Integer.parseInt(i)/(double)arr.length);
        }
        System.out.println(avg);
    }
}
