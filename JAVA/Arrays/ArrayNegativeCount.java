package Arrays;

import java.util.*;

public class ArrayNegativeCount {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        int count=0;
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum=arr[j]+sum;
                if(sum<0){
                    count++;
                }
            }
        }
        System.out.println(count);
        sc.close();
    }
}
