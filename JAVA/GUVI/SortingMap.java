package GUVI;

import java.util.HashMap;
import java.util.Scanner;

public class SortingMap {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        HashMap<Integer,String> HM=new HashMap<>();
        int n=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            String name=sc.next();
            int salary=sc.nextInt();
            HM.put(salary, name);
        }
        System.out.print(HM);
        sc.close();
    }
}
