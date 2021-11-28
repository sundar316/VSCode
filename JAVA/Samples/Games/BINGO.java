package Samples.Games;

public class BINGO {
    public static void main(String[] args) {
        boolean flag=true;
        int num[]=new int[25];
        for(int i=0;i<25;i++)
            num[i]=i+1;
        while(flag)
        {
            int n=0;
            for(int i=0;i<11;i++)
            {
                for(int j=0;j<11;j++)
                {
                    if(i%2!=0 && j%2!=0)
                    {
                        if(num[n]<10)
                            System.out.print(num[n]+" ");
                        else
                            System.out.print(num[n]);
                        n++;
                    }
                    else if(i%2!=0 && j%2==0)
                        System.out.print("| ");
                    else if(j%2==0)
                        System.out.print("+ ");
                    else
                        System.out.print("- ");
                }
                System.out.println();
            }
            flag=false;
        }
    }
}
