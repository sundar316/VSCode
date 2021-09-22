package Examly;

import java.util.Scanner;
class CES{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String S=sc.next();
        int count=0;
        for(int i=0;i<S.length()-1;i++)
        {
            if(S.charAt(i)=='C')
            {
                if(S.charAt(i+1)=='C' || S.charAt(i+1)=='S' || S.charAt(i+1)=='E')
                    count++;
            }
            else if(S.charAt(i)=='E')
            {
                if(S.charAt(i+1)=='E' || S.charAt(i+1)=='S')
                    count++;
            }
            else if(S.charAt(i)=='S')
            {
                if(S.charAt(i+1)=='S')
                    count++;
            }
        }
        if(count==S.length()-1)
            System.out.print("Yes");
        else
            System.out.print("No");
        sc.close();
    }
}