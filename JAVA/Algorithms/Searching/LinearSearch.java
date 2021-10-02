package Algorithms.Searching;


import java.util.Arrays;
import java.util.Scanner;

import Arrays.Array;

public class LinearSearch extends Array{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Integer[] arr=arr();
        System.out.println(Arrays.toString(arr));
        int n=sc.nextInt();
        sc.close();
        if(Search(arr,n))
            System.out.print("No. is in the array");
        else
            System.out.print("No. is not in the array");
    }
    public static boolean Search(Integer[] arr,int n) {
        int i=0;
        for(i=0;i<arr.length;i++)
        {
            if(n==arr[i])
            {
                return true;
            }
        }
        return false;
    }
}
