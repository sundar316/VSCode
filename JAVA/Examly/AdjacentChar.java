package Examly;

import java.util.ArrayList;
import java.util.Scanner;

public class AdjacentChar {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        ArrayList<Character> arr=new ArrayList<>();
        for(int i=0;i<s.length();i++)
            arr.add(s.charAt(i));
        for(int i=0;i<arr.size()-1;i++)
        {
            System.out.print(arr.get(i));
            if(arr.get(i)==arr.get(i+1))
                System.out.print("*");
        }
        System.out.print(arr.get(arr.size()-1));
        sc.close();
    }
}
