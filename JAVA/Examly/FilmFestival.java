package Examly;

import java.util.Scanner;

public class FilmFestival {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] L=new int[n];
        int[] R=new int[n];
        for(int i=0;i<n;i++)
            L[i]=sc.nextInt();
        for(int i=0;i<n;i++)
            R[i]=sc.nextInt();
        int max=0;
        boolean flag=false;
        int RI=0;
        for(int i=0;i<n;i++)
        {
            int O=L[i]*R[i];
            if(O>=max)
            {
                int RMax=0;
                if(O==max && R[i]>=RMax)
                {
                    if(R[i]==RMax)
                    {
                        System.out.print(RI);
                        break;
                    }
                    RMax=R[i];
                    RI=i;
                    flag=true;
                }
                max=O;
            }
        }
        if(flag)
        {
            System.out.print(RI);
        }

        sc.close();
    }
}
