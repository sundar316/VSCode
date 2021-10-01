package Examly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MoveNegativeElement {
    public static void main(String[] args) {
        int arr[]={-1,2,3,-4,5,-6};
        int n=arr.length;
        List<Integer> arr1=new ArrayList<>();
        List<Integer> arr2=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(arr[i]>0)
            {
                arr1.add(arr[i]);
            }
            else
            {
                arr2.add(arr[i]);
            }
        }
        for(int i=0;i<arr1.size();i++)
            arr[i]=arr1.get(i);
        int j=arr1.size();
        for(int i=0;i<arr2.size();i++)
        {
            arr[j]=arr2.get(i);
            j++;
        }
        System.out.print(Arrays.toString(arr));
    }
}
