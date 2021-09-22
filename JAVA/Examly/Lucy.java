package Examly;

import java.util.Scanner;

public class Lucy {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        int a=sc.nextInt();
        boolean flag=false;
        for(int i:arr)
            if(a==i)
            {
                flag=true;
                break;
            }
        if(flag)
            System.out.print("Yes");
        else
            System.out.print("No");
        sc.close();
    }
}
