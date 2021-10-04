package Examly;

import java.util.Scanner;

public class RightTriangleOfDots {
    static int find(int n){
        int sum=0;
        for(int i=1;i<=n;i++){
            sum+=i;
            if(sum>n)
                break;
            if(sum==n)
                return 1;
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc=new  Scanner(System.in);
        int n=sc.nextInt();
        if(find(n)==1)
            System.out.print("Yes");
        else
            System.out.print("No");
        sc.close();
    }
}
