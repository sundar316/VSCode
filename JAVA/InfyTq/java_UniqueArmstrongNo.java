package InfyTq;

import java.util.Scanner;
import java.util.TreeSet;

public class java_UniqueArmstrongNo
{
    /* -------------------------------------------------------------------------- */
    /*                          input  : 15,3,1,70,53,71                          */
    /*                          output : 153,370,371                              */
    /* -------------------------------------------------------------------------- */

    private static boolean isArmstrong(String str)
    {
        int n = Integer.parseInt(str);
        int temp = 0;
        while (n > 0)
        {
            temp += Math.pow((n % 10) , str.length());
            n /= 10;
        }
        // System.out.println(temp);
        if (str.equals(temp+""))
            return true;
        return false;
    }

    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args)
    {
        TreeSet<Integer> arms = new TreeSet<>();
        String arr[] = sc.nextLine().split(",");
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = i+1; j < arr.length; j++)
            {
                if (isArmstrong(arr[i]+arr[j]))
                {
                    arms.add(Integer.parseInt(arr[i]+arr[j]));
                }
            }
        }
        int j = 0;
        for (Integer i : arms)
        {
            if (j++ == arms.size()-1)
                System.out.print(i);
            else
                System.out.print(i+",");
        }
    }
}
