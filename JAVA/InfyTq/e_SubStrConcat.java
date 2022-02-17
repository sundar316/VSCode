package InfyTq;

import java.util.Scanner;

public class e_SubStrConcat
{

    /* -------------------------------------------------------------------------- */
    /*                               input  : Raines                              */
    /*                                        Bowls                               */
    /*                                        2                                   */
    /*                               output : RaBoinwless                         */
    /* -------------------------------------------------------------------------- */


    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args)
    {
        String instr1 = sc.nextLine();
        String instr2 = sc.nextLine();
        int innum = sc.nextInt();
        if (innum > instr1.length() || innum > instr2.length())
        {
            System.out.println(instr1+instr2);
            return;
        }
        String res = "";
        // while (innum <= instr1.length() || innum <= instr2.length())
        int i = 0, a = 0, b = 0;
        boolean ch1 = true, ch2 = true;
        for (i = 0; (i < instr1.length() && innum <= instr1.substring(i).length()) || (i < instr2.length() && innum <= instr2.substring(i).length()); i += innum)
        {
            if (innum <= instr1.substring(i).length())
            {
                res += instr1.substring(i, i+innum);
                a = i;
            }
            else if (ch1)
            {
                res += instr1.substring(a+innum);
                ch1 = false;
            }
            if (innum <= instr2.substring(i).length())
            {
                res += instr2.substring(i, i+innum);
                b = i;
            }
            else if (ch2)
            {
                res += instr2.substring(b+innum);
                ch2 = false;
            }
        }
        if (ch1)
        {
            res += instr1.substring(a+innum);
        }
        if (ch2)
        {
            res += instr2.substring(b+innum);
        }
        System.out.println(res);
    }
}
