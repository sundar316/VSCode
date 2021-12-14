package Samples;

import java.util.Scanner;

public class Recreation {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        sc.close();
        int min=m;
        if(m>n)
            min=n;
        while(min!=0)
        {
            if(m%min==0 && n%min==0)
            {
                System.out.println(min);
                break;
            }
            min--;
        }
    }
}
