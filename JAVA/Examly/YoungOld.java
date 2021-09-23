package Examly;

import java.util.Scanner;

public class YoungOld {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        boolean flag=false;
        if(n<0)
            System.out.print("Invalid Input");
        else
        {
            int[] arr=new int[n];
            for(int i=0;i<n;i++)
            {
                arr[i]=sc.nextInt();
                if(arr[i]<0)
                {
                    flag=true;
                    System.out.print("Invalid Input");
                    break;
                }
            }
            if(!flag)
            {
                int max=arr[0],min=arr[0];
                for(int i=1;i<n;i++)
                {
                    if(arr[i]>max)
                        max=arr[i];
                    if(arr[i]<min)
                        min=arr[i];
                }
                System.out.print(min+" "+max);
            }
        }
        sc.close();
    }
}
