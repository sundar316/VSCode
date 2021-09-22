package Examly;

import java.util.Scanner;

public class TotalExpense {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int amt=sc.nextInt();
        int n=sc.nextInt();
        if(n<50)
        {
            float T=amt*n;
            System.out.printf("%.2f",T);
        }
        else if(n>=50&&n<=100)
        {
            float T=amt*n;
            System.out.printf("%.2f",(T-T*0.1));
        }
        else if(n>=101&&n<=200)
        {
            float T=amt*n;
            System.out.printf("%.2f",(T-T*0.2));
        }
        else if(n>=201&&n<=400)
        {
            float T=amt*n;
            System.out.printf("%.2f",(T-T*0.3));
        }
        else if(n>=401&&n<=500)
        {
            float T=amt*n;
            System.out.printf("%.2f",(T-T*0.4));
        }
        else if(n>500)
        {
            float T=amt*n;
            System.out.printf("%.2f",(T-T*0.5));
        }
        sc.close();
    }
}
