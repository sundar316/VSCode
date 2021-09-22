package Examly;

import java.util.Scanner;

public class Marriage {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        for(int i:arr)
        {
            int count=0;
            for(int j=0;j<n;j++)
            {
                if(i==arr[j])
                    count++;
            }
            if(count<2)
                System.out.print(i+" ");
        }
        sc.close();
    }
}
