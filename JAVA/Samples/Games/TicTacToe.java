package Samples.Games;

import java.util.Scanner;
public class TicTacToe {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String con="y";
        while(con.equals("y"))
        {
            int n=0,val=0,loop=9;
            int a=0,b=0;
            int arr[]=new int[9];
            String arr1[]={"  ","  ","  ","  ","  ","  ","  ","  ","  ","  "};
            t:while(loop>=0)
            {
                int k=1;
                System.out.println("\n TIC TAC TOE");

                /* -------------------------------------------------------------------------- */
                /*                              pattern printing                              */
                /* -------------------------------------------------------------------------- */

                for(int i=0;i<7;i++)
                {
                    for(int j=0;j<7;j++)
                    {
                        if(i%2==0)
                        {
                            if(j%2==0)
                                System.out.print("+ ");
                            else
                                System.out.print("- ");
                        }
                        else
                        {
                            if(j%2==0)
                                System.out.print("| ");
                            else
                            {
                                if(n==0)
                                    System.out.print("  ");
                                else
                                {
                                    if(val%2!=0)
                                    {
                                        if(i==a && j==b)
                                        {
                                            arr1[n]="X ";
                                            System.out.print(arr1[n]);
                                            k++;
                                        }
                                        else
                                        {
                                            System.out.print(arr1[k]);
                                            k++;
                                        }
                                    }
                                    else
                                    {
                                        if(i==a && j==b)
                                        {
                                            arr1[n]="O ";
                                            System.out.print(arr1[n]);
                                            k++;
                                        }
                                        else
                                        {
                                            System.out.print(arr1[k]);
                                            k++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    System.out.println();
                }

                /* -------------------------------------------------------------------------- */
                /*                                result blocks                               */
                /* -------------------------------------------------------------------------- */

                if((((arr1[1].equals(arr1[2]) && arr1[1].equals(arr1[3])) && (arr1[1].equals("X ")||arr1[1].equals("O ")))
                ||((arr1[4].equals(arr1[5]) && arr1[4].equals(arr1[6])) && (arr1[4].equals("X ")||arr1[4].equals("O ")))
                ||((arr1[7].equals(arr1[8]) && arr1[7].equals(arr1[9])) && (arr1[7].equals("X ")||arr1[7].equals("O ")))))
                {
                    if(val%2!=0)
                    {
                        System.out.print("    X wins");
                        break;
                    }
                    else
                    {
                        System.out.print("    O wins");
                        break;
                    }
                }
                if(((arr1[1].equals(arr1[5]) && arr1[1].equals(arr1[9])) && (arr1[1].equals("X ")||arr1[1].equals("O ")))
                ||((arr1[3].equals(arr1[5]) && arr1[3].equals(arr1[7])) && (arr1[3].equals("X ")||arr1[3].equals("O "))))
                {
                    if(val%2!=0)
                    {
                        System.out.print("    X wins");
                        break;
                    }
                    else
                    {
                        System.out.print("    O wins");
                        break;
                    }
                }
                if(((arr1[1].equals(arr1[4]) && arr1[1].equals(arr1[7])) && (arr1[1].equals("X ")||arr1[1].equals("O ")))
                ||((arr1[2].equals(arr1[5]) && arr1[2].equals(arr1[8])) && (arr1[2].equals("X ")||arr1[2].equals("O ")))
                ||((arr1[3].equals(arr1[6]) && arr1[3].equals(arr1[9])) && (arr1[3].equals("X ")||arr1[3].equals("O "))))
                {
                    if(val%2!=0)
                    {
                        System.out.print("    X wins");
                        break;
                    }
                    else
                    {
                        System.out.print("    O wins");
                        break;
                    }
                }

                /* -------------------------------------------------------------------------- */
                /*                                 user input                                 */
                /* -------------------------------------------------------------------------- */

                if(loop==0)
                {
                    System.out.print("  Draw");
                    break;
                }
                if(val%2==0)
                    System.out.print("Enter position value Player X \n1 2 3\n4 5 6\n7 8 9\nexit: ");
                else
                    System.out.print("Enter position value Player O \n1 2 3\n4 5 6\n7 8 9\nexit: ");
                String nn=sc.next().toLowerCase();
                if(nn.equals("exit"))
                    break t;
                n=Integer.parseInt(nn);
                if(n<1 || n>9)
                {
                    System.out.println("Enter position value correctly");
                    continue;
                }
                boolean flag=true;
                for(int i:arr)
                {
                    if(i==n)
                    {
                        System.out.println("Entered position value is Repeating");
                        flag=false;
                        break;
                    }
                }
                arr[val]=n;

                /* -------------------------------------------------------------------------- */
                /*                               position finder                              */
                /* -------------------------------------------------------------------------- */

                switch(n)
                {
                    case 1:
                            a=1;
                            b=1;
                            break;
                    case 2:
                            a=1;
                            b=3;
                            break;
                    case 3:
                            a=1;
                            b=5;
                            break;
                    case 4:
                            a=3;
                            b=1;
                            break;
                    case 5:
                            a=3;
                            b=3;
                            break;
                    case 6:
                            a=3;
                            b=5;
                            break;
                    case 7:
                            a=5;
                            b=1;
                            break;
                    case 8:
                            a=5;
                            b=3;
                            break;
                    case 9:
                            a=5;
                            b=5;
                            break;
                }
                if(flag)
                {
                    val++;
                    loop--;
                }
            }
            System.out.print("\nContinue (y/n): ");
            con=sc.next().toLowerCase();
        }
        sc.close();
    }
}
