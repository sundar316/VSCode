package Examly;

import java.util.*;
public class FilmFestival {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] movie=new int[n];
        int[] rating=new int[n];
        int rate=0;
        int max=0,index=0;
        for(int i=0;i<n;i++)
            movie[i]=sc.nextInt();
        for(int i=0;i<n;i++)
            rating[i]=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            if(rating[i]*movie[i]>max)
            {
                rate=rating[i];
                max=rating[i]*movie[i];
            }
            else if(rating[i]*movie[i]==max)
            {
                if(rating[i]>rate)
                {
                    index=i;
                }
                if(rating[i]==rate)
                {
                    continue;
                }
            }
        }
        System.out.print(index+1);
        sc.close();
    }
}