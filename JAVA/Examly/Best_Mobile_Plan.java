package Examly;

import java.util.Scanner;

class BestMobilePlan{
    static void printPlanDetail(int a,int b,int c){
        float t=0,t1=0;
        int temp=a;
        temp-=100;
        if(temp<0)
            temp=0;
        t=(float)((temp*25)+(b*15)+(c*20))/100;
        a-=250;
        if(a<0)
            a=0;
        t1=(float)((a*45)+(b*35)+(c*25))/100;
        if(t==t1)
        {
            System.out.printf("Plan A costs %.2f",t);
            System.out.printf("\nPlan B costs %.2f",t1);
            System.out.print("\nPlan A and B are the same price");
        }
        else if(t>t1)
        {
            System.out.printf("Plan A costs %.2f",t);
            System.out.printf("\nPlan B costs %.2f",t1);
            System.out.printf("\nPlan B is cheapest");
        }
        else
        {
            System.out.printf("Plan A costs %.2f",t);
            System.out.printf("\nPlan B costs %.2f",t1);
            System.out.printf("\nPlan A is cheapest");
        }
    }
}

public class Best_Mobile_Plan {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        BestMobilePlan.printPlanDetail(a,b,c);
        sc.close();
    }
}
