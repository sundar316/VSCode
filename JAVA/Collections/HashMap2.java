package Collections;

import java.util.HashMap;
import java.util.Scanner;

class Map1{
    HashMap<String,Integer> a;
    Map1(HashMap<String, Integer> A){
        a=A;
    }
    HashMap<String,Integer> MapAdd(HashMap<String,Integer> M,int n,Scanner sc){
        for(int i=0;i<n;i++)
        {
            M.put(sc.next(),sc.nextInt());
        }
        return M;
    }
    String display(Scanner sc){
        try{
            return Integer.toString(a.get(sc.next()));}
        catch(NullPointerException e){
            return "NULL";
        }
    }
}
class HashMap2{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        HashMap<String,Integer> A=new HashMap<>();
        Map1 map=new Map1(A);
        HashMap<String,Integer> d=map.MapAdd(A,n,sc);
        new Map1(d);
        System.out.println(map.display(sc));
        sc.close();
    }
}
