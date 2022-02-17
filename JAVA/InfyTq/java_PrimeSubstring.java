package InfyTq;

import java.util.Scanner;

public class java_PrimeSubstring
{

    /* -------------------------------------------------------------------------- */
    /*                                input : 60678                               */
    /*                                output: 67                                  */
    /* -------------------------------------------------------------------------- */

    public static boolean isPrime(int n)
    {
        if (n < 2)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++)
        {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args)
    {
        String s = sc.nextLine();
        int max = -1;
        int n = s.length();
        for (int i = 1; i < Math.pow(2, n); i++)
        {
            String temp = "";
            int val = n - Integer.toBinaryString(i).length();
            while (val-- > 0)
            {
                temp += "0";
            }
            temp += Integer.toBinaryString(i);
            String res = "";
            for (int j = 0; j < n; j++)
            {
                if (temp.charAt(j) == '1')
                {
                    res += s.charAt(j);
                }
            }
            if (res.charAt(0) == '0')
                continue;
            if (isPrime(Integer.parseInt(res)))
            {
                max = Integer.parseInt(res) > max ? Integer.parseInt(res) : max;
            }
        }
        System.out.println(max);
    }
}
