package InfyTq;

import java.util.HashMap;
import java.util.Scanner;

public class java_StrArrCmpWithChArr
{
    /* -------------------------------------------------------------------------- */
    /*                              input  : dbabbca                              */
    /*                                       bat,ball,rat,bat,bat,car,rat         */
    /*                              output : ac                                   */
    /* -------------------------------------------------------------------------- */

    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args)
    {
        char keys[] = sc.nextLine().toCharArray();
        String values[] = sc.nextLine().split(",");
        HashMap<Character, String> set = new HashMap<>();
        t : for (int i = 0; i < keys.length; i++)
        {
            if (set.keySet().contains(keys[i]))
            {
                if (set.get(keys[i]).equals(values[i]))
                {
                    continue;
                }
                else
                {
                    set.put(keys[i], "");
                }
            }
            else
            {
                for (int j = 0; j < values.length; j++)
                {
                    if (i != j && values[j].equals(values[i]) && keys[j] != keys[i])
                        continue t;
                }
                set.put(keys[i], values[i]);
            }
        }
        for (char i : set.keySet())
        {
            if (!set.get(i).equals(""))
                System.out.print(i);
        }
    }
}
