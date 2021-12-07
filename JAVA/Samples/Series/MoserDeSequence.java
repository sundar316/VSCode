package Samples.Series;

import java.util.Scanner;

public class MoserDeSequence {
    static void isThere(int n){
        String str=Integer.toBinaryString(n);
        String s="";
        for(int i=1;i<str.length();i+=2)
        {
            if(str.charAt(i)=='0')
                s+=(str.charAt(i-1)+"");
            else
            {
                System.out.print("Not in the series.");
                return;
            }
        }
        System.out.print("Position at: "+Integer.parseInt(s,2));
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        isThere(n);
        sc.close();
    }
}
