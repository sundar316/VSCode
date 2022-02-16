package InfyTq;

import java.util.Scanner;

public class HackWithInfy
{
    public static boolean isPrime(int n)
    {
        if (n < 2)
            return false;
        for (int i = 2; i <= (int)Math.sqrt(n); i++)
        {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static int factors(int n)
    {
        int  count = 0;
        for (int i = 1; i <= n; i++)
        {
            if (n % i == 0)
                count++;
        }
        return count;
    }

    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args)
    {
        String str = sc.nextLine();
        String[] arr = str.split(" ");
        boolean flag = false;
        int n = 0;
        for (String string : arr)
        {
            try
            {
                n += Integer.parseInt(string.charAt(string.length()-1)+"");
                flag = true;
            }
            catch (Exception e)
            {
                continue;
            }
        }
        if (flag)
        {
            String rar = Integer.toString(n);
            String temp = "";
            for (int i = rar.length()-1; i >= 0; i--)
                temp += rar.charAt(i);
            if (isPrime(n))
            {
                System.out.println(n);
            }
            else if (isPrime(Integer.parseInt(temp)))
            {
                System.out.println(n);
            }
            else
            {
                System.out.println(factors(Integer.parseInt(temp)));
            }
        }
        else
            System.out.println(-1);
    }
}
