package DataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Merge {
    public static void man(String[] args) {
        Integer arr1[] = {1, 3, 5, 7, 9};
        Integer arr2[] = {2, 4, 6, 8, 10};
        Stack<Integer> ls1 = new Stack<>();
        Stack<Integer> ls2 = new Stack<>();
        List<Integer> out = new ArrayList<>();
        for(int i = arr1.length-1; i >= 0; i--) {
                ls1.add(arr1[i]);
        }
        for(int i = arr2.length-1; i >= 0; i--) {
                ls2.add(arr2[i]);
            }
            while (!ls1.empty() && !ls2.empty()) {
                    if (ls1.peek() < ls2.peek()) {
                            out.add(ls1.pop());
                        } else {
                out.add(ls2.pop());
            }
        }
        if (!ls1.empty()) {
                out.addAll(ls1);
            }
            if (!ls2.empty()) {
            out.addAll(ls2);
        }
        System.out.println(out);
    }
    public static void main(String[] args) {
        Integer arr1[] = {1, 3, 5};
        Integer arr2[] = {2, 4, 6, 8, 10};
        // ArrayList<Integer>out=new ArrayList<>();
        int arr[]=new int[arr1.length+arr2.length];
        int i=0,j=0,k=0;
        while(arr1.length > i && arr2.length > j){
            if(arr1[i] < arr2[j]){
                // out.add(arr1[i++]);
                arr[k++]=arr1[i++];
            }else{
                // out.add(arr2[j++]);
                arr[k++]=arr2[j++];
            }
        }
        while(arr1.length > i){
            // out.add(arr1[i++]);
            arr[k++]=arr1[i++];
        }
        while(arr2.length > j){
            // out.add(arr2[j++]);
            arr[k++]=arr2[j++];
        }
        // System.out.println(out);
        System.out.println(Arrays.toString(arr));
    }
}
