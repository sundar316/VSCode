package Strings;

import java.util.Scanner;

public class Split {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String[] arr=s.split(" ");
        for(String i:arr)
            System.out.print(i+"+");
        sc.close();
    }
}
