package InfyTq;

import java.util.Scanner;
import java.util.TreeMap;

public class zBitEncoding
{

    /*
        input  : ABC123+
        output : QUJDMTIzKw
     */

    private static String val = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
    private static TreeMap<Integer, Character> map = new TreeMap<>();
    static
    {
        for (int i = 0; i < val.length(); i++)
        {
            map.put(i, val.charAt(i));
        }
        // System.out.println(map);
    }

    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args)
    {
        String str = sc.nextLine();
        String temp = "";
        for (int i = 0; i < str.length(); i++)
        {
            if (!zBitEncoding.val.contains(str.charAt(i)+""))
            {
                System.out.println(-1);
                return;
            }
            else
            {
                int val = 8 - Integer.toBinaryString(str.charAt(i)).length();
                while (val-- > 0)
                {
                    temp += "0";
                }
                temp += Integer.toBinaryString(str.charAt(i));
            }
        }
        while (temp.length() % 6 != 0)
        {
            temp += "0";
        }
        // System.out.println(temp.length());
        // System.out.println(temp);
        for (int i = 0; i < temp.length(); i += 6)
        {
            String stm = temp.substring(i, i+6);
            int num = Integer.parseInt(stm, 2);
            System.out.print(map.get(num));
        }
    }
}
