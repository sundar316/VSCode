package InfyTq;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_UniqueWordFromSentence
{

    /* -------------------------------------------------------------------------- */
    /*  input  : God sees the sees people,god is great great,people sees the god  */
    /*  output : god sees the people                                              */
    /*           God is great                                                     */
    /*           X                                                                */
    /* -------------------------------------------------------------------------- */

    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args)
    {
        List<String> words = new ArrayList<>();
        List<String> uniqueWords = new ArrayList<>();
        String arr[] = sc.nextLine().split(",");
        int count;
        for (String i : arr)
        {
            words.clear();
            String wrd[] = i.split(" ");
            count = 0;
            for (String j : wrd)
            {
                if (!uniqueWords.contains(j))
                {
                    uniqueWords.add(j);
                    words.add(j);
                    count++;
                }
            }
            if (words.size() == 0)
            {
                System.out.println("X");
                return;
            }
            if (count == wrd.length)
            {
                System.out.println(-1);
                return;
            }
            for (String k : words)
            {
                System.out.print(k+" ");
            }
            System.out.println();
        }
    }
}
