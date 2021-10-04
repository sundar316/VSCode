package Examly;

import java.util.Scanner;

class ModInverse{
    static int findValue(int a,int b){
        for(int i=1;i<b;i++)
        {
            int n=0;
            int temp=b*i;
            for(int j=1;j<=temp;j++)
            {
                n=a*j;
                if(n==temp+1)
                    return j;
            }
        }
        return -1;
    }
}

public class WinterChallenge {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        System.out.print(ModInverse.findValue(a,b));
        sc.close();
    }
}
