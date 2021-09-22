package Samples;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeFactors {
    static boolean isPrime(long n){
        if(n==2)return true;
        if(n==0 || n%2==0 || n==1)return false;
        for(long i=3;i<=Math.sqrt(n);i+=2){
            if(n%i==0)return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long n = sc.nextLong();sc.close();
        double x = System.currentTimeMillis();
        List<Long> primes=new ArrayList<>();
        for(long i=1;i<=Math.sqrt(n);i++){
            if(n%i==0 && isPrime(i)){
               primes.add(i);
            }
            if(n%i==0 && isPrime(n/i)){
                primes.add(n/i);
            }
        }
        System.out.println(primes.toString());
        System.out.println((System.currentTimeMillis()-x)/100+"s");
        sc.close();
    }
}