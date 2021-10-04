package Examly;

import java.util.Scanner;

class NiceNumber{
    public static int findType(int n){
        int count=0;
        for(int i=1;i<=n;i++){
            if(n%i==0)
                count++;
        }
        if(count==4)
            return 1;
        return 0;
    }
}

public class Nice_Number {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        if(NiceNumber.findType(n)==1)
            System.out.print(n+" is a nice number");
        else
            System.out.print(n+" is not a nice number");
        sc.close();
    }
}
