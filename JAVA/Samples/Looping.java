package Samples;

import java.util.*;
public class Looping {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            for(int j=1;j<=n;j++)
            {
                int c=a+((j*j)*b);
                System.out.print(c);
            }
        }
        in.close();
    }
}
