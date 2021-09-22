package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class HashSet1{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String S=sc.nextLine();
        HashSet<Character> C=new HashSet<>();
        for(int i=0;i<S.length();i++)
        {
            C.add(S.charAt(i));
        }
        for(char i:C)
            System.out.print(i);

        List<Character> L=new ArrayList<>(C);
        Collections.sort(L);
        System.out.println("\n"+L+" "+L.size());
        sc.close();
    }
}