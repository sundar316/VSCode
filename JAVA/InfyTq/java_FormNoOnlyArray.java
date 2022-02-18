package InfyTq;

import java.util.Scanner;

public class java_FormNoOnlyArray {

    /* -------------------------------------------------------------------------- */
    /*                           input : mo3s,123m,4tq5                           */
    /*                                   13,3,45                                  */
    /*                           output: 3,NA,45                                  */
    /*                                   mos,NA,tq                                */
    /* -------------------------------------------------------------------------- */

    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String arr[] = sc.nextLine().split(",");
        String nrr[] = sc.nextLine().split(",");
        String outarr[][] = new String[2][arr.length];
        int in = 0;

        t : for (String i : arr) {
            String num = "";
            String str = "";
            for (int j = 0; j < i.length(); j++) {
                try {
                    Integer.parseInt(i.charAt(j)+"");
                    num += i.charAt(j);
                } catch (Exception e) {
                    str += i.charAt(j);
                    continue;
                }
            }
            for (String k : nrr) {
                if (k.contains(num)) {
                    outarr[0][in] = num;
                    outarr[1][in] = str;
                    in++;
                    continue t;
                }
            }
            outarr[0][in] = "NA";
            outarr[1][in] = "NA";
            in++;
        }

        for (String[] strings : outarr) {
            for (int i = 0; i < strings.length; i++) {
                if (i == strings.length-1) {
                    System.out.print(strings[i]);
                } else {
                    System.out.print(strings[i]+",");
                }
            }
            System.out.println();
        }
    }
}
