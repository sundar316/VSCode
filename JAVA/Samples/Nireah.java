package Samples;

import java.util.*;

public class Nireah {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<a;i++){
            arr.add(sc.nextInt());
            //System.out.println(arr);
        }
        arr.add(2,10);
        arr.clear();
        System.out.println(arr);
        //for(int i=0;i<a;i++)
        sc.close();
    }
}
