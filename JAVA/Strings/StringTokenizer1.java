package Strings;

import java.util.StringTokenizer;
public class StringTokenizer1 {
    public static void main(String[] args) {
        String str="HellopHowparepyou";
        StringTokenizer st=new StringTokenizer(str,"p");
        while(st.hasMoreTokens()){
            System.out.print(st.nextToken()+" ");
        }
    }
}
