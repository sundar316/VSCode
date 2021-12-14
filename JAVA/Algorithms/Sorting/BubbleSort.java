package Algorithms.Sorting;

public class BubbleSort {
    public static Integer[] sort(Integer[] arr)
    {
        int n=arr.length;
        for(int i=0;i<n-1;i++)
        {
            boolean flag=true;
            for(int j=0;j<n-1-i;j++)
            {
                if(arr[j]<arr[j+1])
                {
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    flag=false;
                }
            }
            if(flag)
                break;
        }
        return arr;
    }

    public static int[] sort(int[] arr)
    {
        int n=arr.length;
        for(int i=0;i<n-1;i++)
        {
            boolean flag=true;
            for(int j=0;j<n-1-i;j++)
            {
                if(arr[j]>arr[j+1])
                {
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    flag=false;
                }
            }
            if(flag)
                break;
        }
        return arr;
    }
}