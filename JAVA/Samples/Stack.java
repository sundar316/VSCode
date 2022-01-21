package Samples;

import java.util.ArrayList;
import java.util.Scanner;

class Stack
{
    ArrayList<Integer> l = new ArrayList<>();
    public  void push(int a)
    {
        l.add(a);
    }
    public  int pop()
    {
        int n = l.get(l.size()-1);
        l.remove(l.size()-1);
        return n;
    }
    public ArrayList<Integer> getStack()
    {
        return l;
    }
    public int top()
    {
        return l.get(l.size()-1);
    }
}

class MainClass
{
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args)
    {
        int option = 0;
        Stack s = new Stack();
        do
        {
            System.out.println("\n----------------------");
            System.out.println(" 1- push ");
            System.out.println(" 2- pop ");
            System.out.println(" 3- get stack");
            System.out.println(" 4- top");
            System.out.println(" 5- exit");
            option  = sc.nextInt();
            switch(option)
            {
                case 1:
                    s.push(sc.nextInt());
                    break;
                case 2:
                    System.out.println(s.pop());
                    break;
                case 3:
                    ArrayList<Integer> m = s.getStack();
                    for(int i = m.size()-1; i >= 0; i--)
                    {
                        System.out.print(m.get(i));
                    }
                    break;
                case 4:
                    System.out.print(s.top());
                    break;
                case 5:
                    break;
            }
        }
        while(option != 5);
        System.out.print("Finish");
    }
}
