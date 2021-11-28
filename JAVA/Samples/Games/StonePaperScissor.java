package Samples.Games;

import java.util.Random;
import java.util.Scanner;

class Items{
    public static String random(String[] arr)
    {
        int rnd=new Random().nextInt(arr.length);
        return arr[rnd];
    }
}
class Function{
    public static String function(String C,String U)
    {
        if(C.equals(U))
            return "Draw";
        if((C.equals("stone") && U.equals("paper"))||(C.equals("paper") && U.equals("scissor"))||(C.equals("scissor") && U.equals("stone")))
            return "You Win";
        return "I Win";
    }
}

public class StonePaperScissor {
    static String[] arr={"stone","paper","scissor"};
    static int count=0,count1=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Stone/Paper/Scissor/Exit: ");
        while(sc.hasNext())
        {
        String item=sc.next().toLowerCase();
        if(item.equals("exit"))
        {
            sc.close();
            break;
        }
        else if(item.contains(arr[0])||item.contains(arr[1])||item.contains(arr[2]))
        {
            String value=Items.random(arr);
            System.out.println("I: "+value+"\tU: "+item+"\n"+Function.function(value,item));
            if(Function.function(value,item).equals("You Win"))
                count++;
            else if(Function.function(value,item).equals("I Win"))
                count1++;
            System.out.print("My Score: "+count1+"\tUr Score: "+count+"\nEnter Stone/Paper/Scissor/Exit: ");
        }
        else
        {
            System.out.print("Enter Correct Word.\nEnter Stone/Paper/Scissor/Exit: ");
            continue;
        }
        }
    }
}