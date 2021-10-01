package Examly;

import java.util.Scanner;

public class CamelCase {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String arr[]=s.split(" ");
        for(int i=0;i<arr.length;i++)
        {
            String a=arr[i];
            String b=a.charAt(0)+"";
            System.out.print(b.toUpperCase()+a.substring(1));
        }
        sc.close();
    }
}
