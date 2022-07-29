package Arrays;

import java.util.*;

public class TwoPairsWithSameAvg {

    /*
    input : 5
            4 2 3 4 2
    output: yes
    */
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 1; i < n; i++) {
            if (isAvg(arr, i)) {
                System.out.println("yes");
                return;
            }
        }
        System.out.println("no");
    }

    private static boolean isAvg(int[] arr, int i) {
        int sum1 = 0;
        int sum2 = 0;
        for (int j = 0; j < i; j++) {
            sum1 += arr[j];
        }
        for (int j = i; j < arr.length; j++) {
            sum2 += arr[j];
        }
        if (sum1/i == sum2/(arr.length-i)) {
            return true;
        }
        return false;
    }
}