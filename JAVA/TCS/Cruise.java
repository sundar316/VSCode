package TCS;

import java.util.Arrays;
import java.util.Scanner;

public class Cruise {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        int[] E=new int[T],L=new int[T],a=new int[T];
        for(int i=0;i<T;i++)
            E[i]=sc.nextInt();
        for(int i=0;i<T;i++)
            L[i]=sc.nextInt();
        a[0]=E[0]-L[0];
        for(int i=1;i<T;i++)
            a[i]=a[i-1]+E[i]-L[i];
        Arrays.sort(a);
        System.out.print(a[T-1]);
        sc.close();
    }
}
