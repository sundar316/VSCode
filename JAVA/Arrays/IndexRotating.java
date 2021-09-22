package Arrays;

import java.util.Scanner;
public class IndexRotating
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the total no. of array values: ");
        int a=sc.nextInt();
        int arr[]=new int[100];
        System.out.print("Enter the array values: ");
        for(int i=0;i<a;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.print("Enter the no to change: ");
        int b=sc.nextInt();
        for(int i=0;i<b;i++)
        {
            int temp=arr[0];
            for(int j=0;j<a;j++)
            {
                arr[j]=arr[j+1];
            }
            arr[a-1]=temp;
        }
        System.out.print("After Rotating: ");
        for(int i=0;i<a;i++)
            System.out.print(+arr[i]+" ");
    sc.close();
    }
}