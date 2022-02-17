package InfyTq;

import java.util.Scanner;

public class d_MinSwapReq
{

    /* -------------------------------------------------------------------------- */
    /*                              input  : A,B,A,B,A                            */
    /*                              output : 1                                    */
    /* -------------------------------------------------------------------------- */
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args)
    {
        String[] arr = sc.nextLine().split(",");
        int count = 0;
        int min = Integer.MAX_VALUE;
        for (String i : arr)
        {
            if (i.equals("A"))
            {
                count++;
            }
        }
        if (count == arr.length)
        {
            System.out.println(-1);
            return;
        }
        int val = (int)Math.pow(2, count) - 1;
        while (Math.pow(2, arr.length)-1 >= val)
        {
            String temp = "";
            int test = arr.length - Integer.toBinaryString(val).length();
            while (test-- > 0)
            {
                temp += "0";
            }
            temp += Integer.toBinaryString(val);
            // System.out.println(temp);
            int a = 0;
            for (int i = 0; i < arr.length; i++)
            {
                if (arr[i].equals("A"))
                {
                    if (temp.charAt(i) == '0')
                    {
                        a++;
                    }
                }
                else
                {
                    if (temp.charAt(i) == '1')
                    {
                        a++;
                    }
                }
                // System.out.print(a);
            }
            // System.out.println();
            if (min > a/2)
            {
                min = a/2;
                if (min == 1)
                    break;
            }
            val *= 2;
        }
        if (min == 0)
        {
            System.out.println(-1);
            return;
        }
        System.out.println(min);
    }
}
