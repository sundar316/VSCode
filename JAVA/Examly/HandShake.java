package Examly;

import java.util.Scanner;

class Result {
    static public int handshake(int n) {
        int count=0;
        if(n==0)
            return count;
        while(n>0)
        {
            --n;
            count=count+n;
        }
        return count;
        // return ((n-1)*n)/2; //O(1)
    }
}

public class HandShake {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        for(int i=0;i<N;i++){
            int n=sc.nextInt();
            System.out.println(Result.handshake(n));
        } //O(N)
        sc.close();
    }
}
