package Examly;

import java.util.Scanner;

class NumberTypeClass{
    public static int findType(int n){
        int sum=0;
        for(int i=1;i<n;i++){
            if(n%i==0)
                sum+=i;
        }
        if(sum==n)
            return 0;
        if(sum<n)
            return 1;
        return -1;
    }
}
public class BestProgrammer {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int n1=NumberTypeClass.findType(n);
        if(n1==-1)
            System.out.print(n+" is a abundant number");
        else if(n1==1)
            System.out.print(n+" is a deficient number");
        else
            System.out.print(n+" is a perfect number");
        sc.close();
    }
}
