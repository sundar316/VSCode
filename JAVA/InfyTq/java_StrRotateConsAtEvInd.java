package InfyTq;

import java.util.Scanner;

public class java_StrRotateConsAtEvInd {

    /* -------------------------------------------------------------------------- */
    /*                                  input : 4                                 */
    /*                                          Knowledge,3                       */
    /*                                          Education,1                       */
    /*                                          Elephant,5                        */
    /*                                          Building,2                        */
    /*                                  output: gl,hn,gkl                         */
    /* -------------------------------------------------------------------------- */


    private static String rotate(String str, int n) {
        str = str.substring(str.length()-n) + str.substring(0, str.length()-n);
        return str;
    }

    private static void sorted(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                if (arr[j].length() == arr[j+1].length()) {
                    if (arr[j].charAt(0) > arr[j+1].charAt(0)) {
                        String temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                    }
                }
                if (arr[j].length() > arr[j+1].length()) {
                    String temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        String out[] = new String[n];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String temp = "";
            String[] arr = sc.nextLine().split(",");
            String rotate = rotate(arr[0], Integer.parseInt(arr[1]));
            // System.out.println(rotate);
            for (int j = 0; j < rotate.length(); j++) {
                if (!("AEIOUaeiou").contains(rotate.charAt(j)+"") && j%2 != 0) {
                    temp += rotate.charAt(j);
                }
            }
            out[i] = temp;
        }
        int flag = 0;
        for (String i : out) {
            if (i.equals("")) {
                continue;
            }
            flag++;
        }
        if (flag == 0) {
            System.out.println(-1);
            return;
        }
        sorted(out);

        for (int i = 0; i < out.length; i++) {
            if (!out[i].equals("")) {
                if (i == out.length-1)
                    System.out.print(out[i]);
                else
                    System.out.print(out[i]+",");
            }
        }
    }
}
