package Examly;

import java.util.Arrays;
import java.util.Scanner;

public class Trolly {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        for(int i=0;i<n-1;i++)
        {
            for(int j=i;j<n;j++)
            {
                if(arr[i]==0 && arr[j]!=0)
                {
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
                if(arr[i]==0 && arr[j]==0)
                {
                    for(int k=j;k<n;k++)
                    {
                        if(arr[k]!=0)
                        {
                            int temp=arr[k];
                            arr[k]=arr[j];
                            arr[j]=temp;
                        }
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        sc.close();
    }
}
