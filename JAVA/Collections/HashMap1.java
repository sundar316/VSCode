package Collections;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HashMap1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        HashMap<Integer,String> A=new HashMap<>();
        A.put(0, "Zero");
        A.put(1, "One");
        A.put(2, "Two");
        A.put(3, "Three");
        A.put(4, "Four");
        A.put(5, "Five");
        A.put(6, "Six");
        A.put(7, "Seven");
        A.put(8, "Eight");
        A.put(9, "Nine");
        A.put(10, "Ten");
        try{
            System.out.println(A.get(sc.nextInt()));
            sc.close();
        }
        catch(NullPointerException e){
            System.out.println("Enter 0 to 10");
        }
        catch(InputMismatchException e){
            System.out.println("Enter Number");
        }
    }
}
