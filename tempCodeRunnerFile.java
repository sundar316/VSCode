import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner (System.in);
        int n=sc.nextInt();
        if(n==0)
            System.out.println("*\n*");
        else
        {
            for(int i=0;i<=n;i++)
            {
                int a=i*2-1;
                int b=(a/2)+1;
                int c=1;
                boolean flag=true;
                for(int j=0;j<=n*2;j++)
                {
                    if(j==0)
                        System.out.print("*");
                    if(a>0)
                        System.out.print(c);
                    if(i!=0 && j==n*2)
                        System.out.print("*");
                    if(b>c && flag)
                        c++;
                    else
                    {
                        c--;
                        flag=false;
                    }
                    a--;
                }
                System.out.println();
            }

            for(int i=n-1;i>=0;i--)
            {
                int a=i*2-1;
                int b=(a/2)+1;
                int c=1;
                boolean flag=true;
                for(int j=0;j<=n*2;j++)
                {
                    if(j==0)
                        System.out.print("*");
                    if(a>0)
                        System.out.print(c);
                    if(i!=0 && j==n*2)
                        System.out.print("*");
                    if(b>c && flag)
                        c++;
                    else
                    {
                        c--;
                        flag=false;
                    }
                    a--;
                }
                System.out.println();
            }
        }
        sc.close();
    }
}