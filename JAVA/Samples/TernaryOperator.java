package Samples;

import java.util.*;
public class TernaryOperator {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        int a = obj.nextInt();
        int b = obj.nextInt();
        int c =(a>b)?(a+10):(b+20);
        System.out.println(c);
        obj.close();
    }
}
