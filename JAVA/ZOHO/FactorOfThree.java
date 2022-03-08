package ZOHO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FactorOfThree {

    static List<Integer[]> res = new ArrayList<>();

    private static void swap(Integer[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static void permutations(Integer[] arr, int l) {
        if (l == arr.length-1) {
            res.add(arr);
        } else {
            for (int i = l; i < arr.length; i++) {
                swap(arr, i, l);
                permutations(arr, l+1);
                swap(arr, i, l);
            }
        }
    }

    private static boolean isDivisible(Integer[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            if ((arr[i] + arr[i+1]) % 3 == 0) {
                return true;
            }
        }
        return false;
    }

    private static boolean result(List<Integer[]> res1) {
        for (Integer[] integers : res1) {
            if (!isDivisible(integers)) {
                return false;
            }
        }
        return true;
    }

    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Integer arr[] = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            permutations(arr, 0);
            System.out.println(result(res) ? "Yes" : "No");
        }
    }
}
