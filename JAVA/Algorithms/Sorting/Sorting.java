package Algorithms.Sorting;

import java.util.Arrays;
import java.util.Scanner;

import Arrays.Array;

class Sorting {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Integer[] arr=Array.arr();
        System.out.println("Before sorting: "+Arrays.toString(arr));
        System.out.print("1. Bubble Sorting\n2. Selection Sorting\n3. Insertion Sorting\nEnter No.: ");
        int n=sc.nextInt();
        long S=System.nanoTime();
        if(n==1)
            arr=BubbleSort.sort(arr);
        else if(n==2)
            arr=SelectionSorting.sort(arr);
        else
            arr=InsertionSort.sort(arr);
        long E=System.nanoTime();
        System.out.print("After sorting:  "+Arrays.toString(arr)+"\nExecution Time: "+(float)(E-S)/1000000+" S");
        sc.close();
    }
}
