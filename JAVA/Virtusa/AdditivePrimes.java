package Virtusa;

import java.util.Scanner;

public class AdditivePrimes {

    /*
        input : 7
                2 4 6 11 12 18 7
        output: 2 11 7
    */

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        String res = "";
        for (int i : arr) {
            if (isPrime(i)) {
                if (i > 9) {
                    int k = i;
                    int m = 0;
                    while (k > 0) {
                        m += (k%10);
                        k /= 10;
                    }
                    if (isPrime(m)) {
                        res += i + " ";
                    }
                } else {
                    res += i + " ";
                }
            }
        }
        System.out.println(res);
    }
}
