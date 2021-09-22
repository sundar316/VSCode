package Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayList2 {
    public static void main(String[] args) {
        char[] arr={'h','e','l','l','o'};
        String s="hello";
        List<Character> n=new ArrayList<>();
        for(int i=0;i<s.length();i++)
            System.out.println(s.charAt(i));
        for(char i:arr)
        {
            n.add(i);
        }
        Arrays.sort(arr);
        Collections.reverse(n);
        System.out.println(n);
        System.out.println(arr);
    }
}



