package Samples;

import java.util.Scanner;

public class MaventicVowels {

    /* -------------------------------------------------------------------------- */
    /*                          input : aaafeeeeiiuuutggj                         */
    /*                          output: 333f444422333tggj                         */
    /* -------------------------------------------------------------------------- */

    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String s = sc.nextLine();
        StringBuffer output = new StringBuffer();
        String vow = "aeiouAEIOU";
        int i = -1;

        while (++i < s.length()) {
            int count = 0;
            String temp = s.charAt(i)+"";
            if (vow.contains(temp)) {
                count++;
                for (int j = i+1; j < s.length(); j++) {
                    if (temp.equals(s.charAt(j)+"")) {
                        count++;
                        i++;
                    } else {
                        break;
                    }
                }
                int num = count;
                while (num-- > 0) {
                    output.append(count);
                }
            }
            else {
                output.append(s.charAt(i));
            }
        }
        System.out.println(output);
    }
}
