package Algorithms.Sorting;

public class InsertionSort {

    public static Integer[] sort(Integer[] arr){
        for(int i=1,j;i<arr.length;i++)
        {
            int temp=arr[i];
            for(j=i-1;j>-1 && arr[j]>temp;j--)
                arr[j+1]=arr[j];
            arr[j+1]=temp;
        }
        return arr;
    }
}