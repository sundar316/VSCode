package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class twoDsort {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a[][]={{5,4,3,2,1},{5,4,3,2,1},{5,4,3,2,1}};
        for(int i=0;i<a.length;i++)
        {
            Arrays.sort(a[i]);
            System.out.println(Arrays.toString(a[i]));
        }
        sc.close();
    }
}
