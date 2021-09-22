package Samples.Patterns;

import java.util.Scanner;
public class meen {
    public static void main(String[] args) {
        Scanner obj=new Scanner(System.in);
        int n = obj.nextInt();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i>=j)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            for(int j=1;j<n;j++){
                if(i+j>=n-1)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            for(int j=1;j<n;j++){
                if(i>=j)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
        System.out.print("\n");
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                if(i+j<=n-1)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            for(int j=1;j<n;j++){
                if(i<=j)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            for(int j=1;j<n;j++){
                if(i+j<=n-1)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
        System.out.print("\n");
        }
    obj.close();
    }
}
