package InfyTq;

import java.util.Arrays;
import java.util.Scanner;

public class java_SumOfIntervals {

    /* -------------------------------------------------------------------------- */
    /*                             input : -5,5,1,-2,7                            */
    /*                             output: -7,9,0,20                              */
    /* -------------------------------------------------------------------------- */

    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        String srr[] = sc.nextLine().split(",");
        int arr[] = new int[srr.length];
        for (int i = 0; i < srr.length; i++) {
            arr[i] = Integer.parseInt(srr[i]);
        }

        int temp, j;
        for (int i = 1; i < arr.length; i++) {
            temp = arr[i];
            if (temp >= 0)
                continue;
            j = i - 1;
            while (arr[j] > 0 && j >= 0) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }

        srr[srr.length-1] = "0";
        for (int i = 0; i < arr.length-1; i++) {
            int diff = arr[i+1] - arr[i];
            if (diff < 1) {
                srr[i] = "0";
            }
            else {
                temp = 0;
                for (j = arr[i]+1; j < arr[i+1]; j++) {
                    temp += j;
                }
                srr[i] = Integer.toString(temp);
            }
        }

        System.out.println(Arrays.toString(srr).substring(1, Arrays.toString(srr).length()-4));
    }
}
