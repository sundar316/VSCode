package InfyTq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class MLargestNoFrom2Arr
{
    /*
        input  : 101,101,610,447,389
                 610,4,101,4,101
        output : 447,610
                 101,610
    */
    private static int singleDigit(int n)
    {
        while (n > 10)
        {
            int temp = n % 10;
            n /= 10;
            n += temp;
        }
        return n;
    }

    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args)
    {
        String arr1[] = sc.nextLine().split(",");
        String arr2[] = sc.nextLine().split(",");
        int arr3[] = new int[arr1.length];
        int arr4[] = new int[arr2.length];
        for (int i = 0; i < arr1.length; i++)
        {
            arr3[i] = Integer.parseInt(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++)
        {
            arr4[i] = Integer.parseInt(arr2[i]);
        }
        Arrays.sort(arr3);
        Arrays.sort(arr4);
        // System.out.println(Arrays.toString(arr1)+"\n"+Arrays.toString(arr2));
        TreeSet<String> set1 = new TreeSet<>(Arrays.asList(arr1));
        TreeSet<String> set2 = new TreeSet<>(Arrays.asList(arr2));
        // System.out.println(set1+"\n"+set2);
        List<String> com = new ArrayList<>();
        int m = 0;
        for (String i : set1)
        {
            for (String j : set2)
            {
                if (i.equals(j))
                {
                    com.add(i);
                }
            }
        }
        Collections.sort(com);
        if (com.get(0).equals("0"))
        {
            System.out.println("-1");
            return;
        }
        else
        {
            if (com.get(0).length() > 1)
                m = singleDigit(Integer.parseInt(com.get(0)));
            else
                m = Integer.parseInt(com.get(0));
        }
        int temp = m;
        while (temp > 0)
        {
            if (temp == 1)
                System.out.print(arr3[arr3.length - temp]);
            else
                System.out.print(arr3[arr3.length - temp]+",");
            temp--;
        }
        System.out.println();
        while (m > 0)
        {
            if (m == 1)
                System.out.print(arr4[arr4.length - m]);
            else
                System.out.print(arr4[arr4.length - m]+",");
            m--;
        }
    }
}
