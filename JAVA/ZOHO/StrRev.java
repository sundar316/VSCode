package ZOHO;

import java.util.Scanner;

// Given a string, we have to reverse the string without changing the position of punctuations and spaces.
// Sample: house no : 123@ cbe
// Output: ebc32 1o : nes@ uoh

public class StrRev {

    static private Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String input = sc.nextLine();
        StringBuffer str = new StringBuffer(input);
        StringBuffer output = new StringBuffer();
        str.reverse();
        for (int i = 0, j = 0; i < input.length(); i++) {
            if ((input.charAt(i) >= 65 && input.charAt(i) <= 90) || (input.charAt(i) >= 97 && input.charAt(i) <= 122) || (input.charAt(i) >= 48 && input.charAt(i) <= 57)) {
                if ((str.charAt(j) >= 65 && str.charAt(j) <= 90) || (str.charAt(j) >= 97 && str.charAt(j) <= 122) || (str.charAt(j) >= 48 && str.charAt(j) <= 57)) {
                    output.append(str.charAt(j));
                    j++;
                } else {
                    j++;
                    i--;
                }
            } else {
                output.append(input.charAt(i));
            }
        }
        System.out.println(output);
    }
}
