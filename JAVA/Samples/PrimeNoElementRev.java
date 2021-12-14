package Samples;

import java.util.Scanner;

public class PrimeNoElementRev {
    static boolean isPrime(int n){
        if(n==2)
            return true;
        if(n==0 || n%2==0 || n==1)
            return false;
        for(long i=3;i<=Math.sqrt(n);i+=2)
        {
            if(n%i==0)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String s="";
        for(int i=1;i<n;i++){
            if(isPrime(i)){
               s+=i+" ";
            }
        }
        String[] arr=s.split(" ");
        for(int i=arr.length-1;i>-1;i-=2)
        {
            System.out.print(arr[i]+" ");
        }
        sc.close();
    }
}
