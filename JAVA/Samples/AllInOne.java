package Samples;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AllInOne {

    private static Scanner sc = new Scanner(System.in);
    // public static void main(String[] args) {
    //     if (sc.nextInt() % 2 == 0) {
    //         System.out.println("Even");
    //     } else {
    //         System.out.println("Odd");
    //     }
    // }


    private static List<Integer> arr = new ArrayList<>();
    private static boolean isPrime(int n) {
        if (n == 2) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int n = sc.nextInt();
        int i = 2;
        while (arr.size() < n) {
            if (isPrime(i)) {
                arr.add(i);
            }
            i++;
        }
        System.out.println(arr);
    }
}
