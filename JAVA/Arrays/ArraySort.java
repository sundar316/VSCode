package Arrays;

// Java program to Sort square of the numbers
// of the array
import java.util.*;
class ArraySort {
    // Function to sort an square array
    public static void sortSquares(int arr[])
    {
        int n = arr.length;
        // First convert each array elements
        // into its square
        for (int i = 0; i < n; i++)
            arr[i] = arr[i] * arr[i];
        // Sort an array using "inbuild sort function"
        // in Arrays class.
        Arrays.sort(arr);
    }
    // Driver program to test above function
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[] =new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        System.out.println("Before sort ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        sortSquares(arr);
        System.out.println("");
        System.out.println("After Sort ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        sc.close();
    }
}