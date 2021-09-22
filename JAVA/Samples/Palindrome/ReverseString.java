package Samples.Palindrome;

import java.util.Scanner;

class ReverseString1{
    char[] reverseString1(String s){
        char S[]=new char[s.length()];
        int j=0;
        for(int i=s.length()-1;i>-1;i--){
            S[j]=s.charAt(i);
            j++;
        }
        return S;
    }
}
class Palindrome{
    Palindrome(String s){
        int a=s.length();
        boolean flag=false;
        int j=s.length()-1;
        for(int i=0;i<a/2;i++){
            if(s.charAt(i)==s.charAt(j))
                flag=true;
            else
                flag=false;
            j--;
        }
        if(flag)
            System.out.println("Is Palindrome: YES");
        else
            System.out.println("Is Palindrome: NO");
    }
}
class ReverseString {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        ReverseString1 a=new ReverseString1();
        System.out.println(a.reverseString1(s));
        new Palindrome(s);
        sc.close();
    }
}
