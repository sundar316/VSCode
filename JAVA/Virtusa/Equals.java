package Virtusa;

import java.util.Scanner;

public class Equals {

    /*
        input : 2 2 3
                3
        output: 2 - 2 + 3
    */

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int res = sc.nextInt();
        if (a + b + c == res) {
            System.out.println(a + " + " + b + " + " + c);
        } else if (a - b - c == res) {
            System.out.println(a + " - " + b + " - " + c);
        } else if (a + b - c == res) {
            System.out.println(a + " + " + b + " - " + c);
        } else if (a - b + c == res) {
            System.out.println(a + " - " + b + " + " + c);
        } else if (a * b * c == res) {
            System.out.println(a + " * " + b + " * " + c);
        } else if (a * b + c == res) {
            System.out.println(a + " * " + b + " + " + c);
        } else if (a + b * c == res) {
            System.out.println(a + " + " + b + " * " + c);
        } else if (a * b - c == res) {
            System.out.println(a + " * " + b + " - " + c);
        } else if (a - b * c == res) {
            System.out.println(a + " - " + b + " * " + c);
        } else if (a / b / c == res) {
            System.out.println(a + " / " + b + " / " + c);
        } else if (a / b + c == res) {
            System.out.println(a + " / " + b + " + " + c);
        } else if (a + b / c == res) {
            System.out.println(a + " + " + b + " / " + c);
        } else if (a / b - c == res) {
            System.out.println(a + " / " + b + " - " + c);
        } else if (a - b / c == res) {
            System.out.println(a + " - " + b + " / " + c);
        } else if (a * b / c == res) {
            System.out.println(a + " * " + b + " / " + c);
        } else if (a / b * c == res) {
            System.out.println(a + " / " + b + " * " + c);
        }
    }
}
