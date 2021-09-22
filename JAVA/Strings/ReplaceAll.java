package Strings;

public class ReplaceAll {
    public static void main(String[] args) {
        String name="Sundar";
        String str="X";
        str=str.replaceAll("X","XXXXXXXXXX");
        str=str.replaceAll("X",name+"\n");
        System.out.println(str);
    }
}

