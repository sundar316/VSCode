package Arrays;

import java.util.Scanner;

public class Majority {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int max=0;
        int in=-1;
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            int count=0;
            for(int j=1;j<n;j++)
            {
                if(arr[i]==arr[j])
                    count++;
                if(count>max)
                {
                    max=count;
                    in=i;
                }
            }
        }
        if(max>=(n/2))
            System.out.println("Majority no.: "+arr[in]);
        else
            System.out.println("No Majority");
        sc.close();
    }
}


// import java.util.*;
// class Solution{
//     public static void main(String[] args){
//         Scanner sc=new Scanner(System.in);
//         float buy=sc.nextInt();
//         sc.close();
//         float repair=sc.nextInt();
//         float sell=sc.nextInt();
//         buy=buy+repair;
//         float gain=((sell-buy)/buy)*100;
//         System.out.printf("%.2f",gain);
//     }
// }