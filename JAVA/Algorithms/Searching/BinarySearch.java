package Algorithms.Searching;

import java.util.Arrays;
import java.util.Scanner;

import Arrays.Array;
import Algorithms.Sorting.*;

public class BinarySearch extends Array{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Integer arr[]=arr();
        arr=BubbleSort.sort(arr);
        System.out.println(Arrays.toString(arr));
        int n=sc.nextInt();
        sc.close();
        int l=0,r=arr.length-1;
        while(l<=r)
        {
            int mid=(l+r)/2;
            if(n==arr[mid])
            {
                System.out.print("Index: "+mid);
                break;
            }
            else if(arr[mid]>n)
                r=mid-1;
            else
                l=mid+1;
        }
        if(l>r)
            System.out.print("Not Found");
    }
}
