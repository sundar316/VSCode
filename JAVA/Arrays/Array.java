package Arrays;

import java.util.HashSet;
import java.util.Random;

public class Array {
    public static Integer[] arr()
    {
        Random r=new Random();
        HashSet<Integer> Arr=new HashSet<>();
        while(Arr.size()<11)
        {
            int n=(int)(Math.random()*12);
            Arr.add(n);
        }
        Integer arr[]=Arr.toArray(new Integer[Arr.size()]);
        for(int i=arr.length-1;i>0;i--)
        {
            int j=r.nextInt(i+1);
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
        return arr;
    }
}
