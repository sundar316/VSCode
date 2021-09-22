package Collections;

import java.util.*;
public class ArrayList1 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<n;i++)
            list.add(sc.nextInt());
        int n1=sc.nextInt();
        for(int i=0;i<n1;i++)
        {
            String s=sc.next();
            if(s.compareTo("Insert")==0)
            {
                int p=sc.nextInt();
                int q=sc.nextInt();
                list.add(p,q);
            }
            else
            {
                int p=sc.nextInt();
                list.remove(p);
            }
            for(int j=0;j<list.size();j++)
                System.out.print(list.get(j)+" ");
            System.out.println();
        }
        sc.close();
    }
}

