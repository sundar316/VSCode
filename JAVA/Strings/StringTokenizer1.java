package Strings;

import java.util.StringTokenizer;

public class StringTokenizer1 {

    public static void main(String[] args) {
        String s="Hello How are you";
        StringTokenizer st=new StringTokenizer(s," ");
        while(st.hasMoreElements())
            System.out.println(st.nextElement());

        System.out.println();

        String[] arr=s.split(" ");
        for (String i : arr) {
            System.out.println(i);
        }
    }
}
