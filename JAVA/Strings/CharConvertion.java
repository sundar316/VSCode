package Strings;

import java.util.Scanner;

public class CharConvertion {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String S=sc.next();
        Character[] C=new Character[S.length()];
        int count=0;
        for(int i=0;i<S.length();i++)
        {
            C[i]=S.charAt(i);
            if(C[i].equals('?'))
                count++;
        }
        for(int i=0;i<count;i++)
        {
            for(int j=0;j<C.length;j++)
            {
                if(C[j].equals('?'))
                    C[j]='1';
                System.out.print(C[j]);
            }
            System.out.println();
        }
        sc.close();
    }
}
