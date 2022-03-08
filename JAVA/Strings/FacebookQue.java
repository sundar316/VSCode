package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class FacebookQue {

/*
Given a string as input, return the list of all the patterns possible:
  '1' : ['A', 'B', 'C'],
  '2' : ['D', 'E'],
  '12': ['X']
  '3' : ['P', 'Q']
Example if input is '123', then output should be [ADP, ADQ, AEP, AEQ, BDP, BDQ, BEP, BEQ, CDP, CDQ, CEP, CEQ, XP, XQ]
*/

    static TreeMap<String, List<String>> map = new TreeMap<>();

    static {
        map.put("1", new ArrayList<>(Arrays.asList("A", "B", "C")));
        map.put("2", new ArrayList<>(Arrays.asList("D", "E")));
        map.put("12", new ArrayList<>(Arrays.asList("X")));
        map.put("3", new ArrayList<>(Arrays.asList("P", "Q")));
    }

    private static String[] split (String res) {
        return res.split("\\[|\\]|, ");
    }

    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String str = sc.nextLine();
        int len = 1;
        do {
            String res = "";
            for (int i = 0, j = len; i < str.length() && j <= str.length(); i++, j++) {
                if (map.get(str.substring(i, j)) == null) {
                    continue;
                }
                
                res += map.get(str.substring(i, j));
            }
            System.out.println(Arrays.toString(split(res)));
        } while (++len <= str.length());
    }
}
