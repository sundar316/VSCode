package Samples;
public class hello {
    public static void main(String[] args) {
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                if(j==0||j==4||i==2)
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print(" ");
                }
            }
            System.out.print("  ");
            for(int j=0;j<5;j++)
            {
                if(j==0||i==2||i==0||i==4)
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print(" ");
                }
            }
            System.out.print("  ");
            for(int j=0;j<5;j++)
            {
                if(j==0||i==4)
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print(" ");
                }
            }
            System.out.print("  ");
            for(int j=0;j<5;j++)
            {
                if(j==0||i==4)
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print(" ");
                }
            }
            System.out.print("  ");
            for(int j=0;j<5;j++)
            {
                if(j==0||j==4||i==0||i==4)
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
