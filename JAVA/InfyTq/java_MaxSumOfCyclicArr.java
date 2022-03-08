package InfyTq;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class java_MaxSumOfCyclicArr {

    /* -------------------------------------------------------------------------- */
    /*                         input : 8,-8,9,-9,10,-11,12                        */
    /*                         output: 22                                         */
    /* -------------------------------------------------------------------------- */

    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        List<Integer> sum = new ArrayList<>();
        String str[] = sc.nextLine().split(",");
        int dec = (int)Math.pow(2, str.length);
        while (--dec > 0) {
            String bin = "";
            while (Integer.toBinaryString(dec).length()+bin.length() < str.length) {
                bin += "0";
            }
            bin += Integer.toBinaryString(dec);
            int count = 0;
            char temp = bin.charAt(0);
            for (char i : bin.toCharArray()) {
                if (i != temp) {
                    count++;
                    temp = i;
                }
            }
            if (count >= 3) {
                continue;
            }
            // System.out.println(bin);
            int som = 0;
            for (int i = 0; i < bin.length(); i++) {
                if (bin.charAt(i) == '1') {
                    som += Integer.parseInt(str[i]);
                }
            }
            sum.add(som);
        }
        // System.out.println(sum);
        System.out.println(Collections.max(sum));
    }
}
