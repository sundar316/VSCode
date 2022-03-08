package Samples.Patterns;

import java.util.Scanner;

public class HOPattern {

    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        for (int i = 1; i < n*4; i++) {
            int k = 1;
            for (int j = 1; j < n*4-i; j++, k++) {
                System.out.print("  ");
            }
            for (int j = 1; j < i*2; j++, k++) {
                if (i <= n*2) {
                    if ((i+k)%2 == 0)
                        System.out.print("H ");
                    else
                        System.out.print("O ");
                } else {
                    if (i%2 == 0)
                        System.out.print("O ");
                    else {
                        System.out.print("H ");
                    }
                }
            }
            System.out.println();
        }
    }
}
