package InfyTq;

import java.util.Arrays;
import java.util.Scanner;

public class py_SortedStrIndDiff
{

    /* -------------------------------------------------------------------------- */
    /*                             input  : gt4r22w7e                             */
    /*                             output : eqrtw2:153                            */
    /* -------------------------------------------------------------------------- */

    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args)
    {
        String val = sc.nextLine();
        char str[] = val.toCharArray();
        Arrays.sort(str);
        // System.out.println(Arrays.toString(str));
        int n = 0;
        String temp = "";
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (char c : str)
        {
            try
            {
                int no = Integer.parseInt(c+"");
                if (no < min)
                    min = no;
                if (no > max)
                    max = no;
                n += no;
            }
            catch (Exception e)
            {
                temp += c;
            }
        }
        // System.out.println(temp);
        int p = 0, q = 0, r = 0, s = 0;
        boolean t = true, u = true, v = true, w =true;
        for (int i = 0; i < str.length; i++)
        {
            if (temp.charAt(0) == val.charAt(i) && t)
            {
                p = i;
                t = false;
            }
            if (temp.charAt(temp.length()-1) == val.charAt(i) && u)
            {
                q = i;
                u = false;
            }
            if (Integer.toString(min).charAt(0) == val.charAt(i) && v)
            {
                r = i;
                v = false;
            }
            if (Integer.toString(max).charAt(0) == val.charAt(i) && w)
            {
                s = i;
                w = false;
            }
        }
        int diff1 = Math.abs(p-q);
        int diff2 = Math.abs(r-s);
        // System.out.println(r+""+s);
        System.out.println(temp + diff1 + ":"+n+""+diff2);
    }
}
