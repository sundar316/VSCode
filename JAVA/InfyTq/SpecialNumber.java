package InfyTq;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpecialNumber
{
    /*
        input  : 2340567
        output : 56
    */
    private static List<String> factors(int n)
    {
        List<String> fact = new ArrayList<>();
        for (int i = 1; i <= n; i++)
        {
            if (n % i == 0)
            {
                fact.add(Integer.toString(i));
            }
        }
        return fact;
    }

    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args)
    {
        String input = sc.nextLine();
        char arr[] = input.toCharArray();
        String str;
        int count;
        int max = 0;
        int output = 0;
        List<String> fact = new ArrayList<>();
        for (int i = 0; i < arr.length-1; i++)
        {
            str = "";
            str += arr[i] +""+ arr[i+1];
            // System.out.println(str);
            fact = factors(Integer.parseInt(str));
            // System.out.println(fact);
            count = 0;
            for (String j : fact)
            {
                if (input.contains(j))
                    count++;
            }
            if (max <= count)
            {
                if (max == count)
                {
                    if (output < Integer.parseInt(str))
                    {
                        output = Integer.parseInt(str);
                    }
                }
                else
                {
                    max = count;
                    output = Integer.parseInt(str);
                }
            }
            // System.out.println(count);
        }
        System.out.println(output);
    }
}
