package Samples.Palindrome;

import java.util.Scanner;

class ReverseInteger {
    static int A=new Scanner(System.in).nextInt();
    public static void main(String[] args) {
        if(new IsPalindrome().ans(A))
            System.out.println("No. is Palindrome");
        else
            System.out.println("No. is not Palindrome");
        new IsPalindrome().extracted(A);
    }
}
class IsPalindrome{
    Boolean ans(int A){
        int a=A,ANS=0;
        while(a>0)
        {
            int remainder = extracted(a);
            ANS = extracted2(ANS, remainder);
            a=a/10;
        }
        System.out.println(ANS);
        if(A==ANS)
            return true;
        else
            return false;
    }

    private int extracted2(int ANS, int remainder) {
        ANS=ANS*10+remainder;
        return ANS;
    }

    int extracted(int a) {
        int remainder=a%10;
        return remainder;
    }
}
