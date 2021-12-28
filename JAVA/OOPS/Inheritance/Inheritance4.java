package OOPS.Inheritance;

import java.util.Scanner;

class Event{
    protected String name;
    protected String detail;
    protected String type;
    protected String organiserName;

    Event(String name, String detail, String type, String organiserName){
        this.name=name;
        this.detail=detail;
        this.type=type;
        this.organiserName=organiserName;
    }

    public void display(){
        System.out.print(name+" "+detail+" "+type+" "+organiserName);
    }
}

class Exhibition extends Event{
    private int noOfStalls;

    Exhibition(String name, String detail, String type, String organiserName, int noOfStalls){
        super(name, detail, type, organiserName);
        this.noOfStalls=noOfStalls;
    }

    public int getNoOfStalls() {
        return noOfStalls;
    }

    public void display(){
        System.out.print(name+" "+detail+" "+type+" "+organiserName+" "+noOfStalls);
    }
}

class StageEvent extends Exhibition{
    private int noOfSeats;

    StageEvent(String name, String detail, String type, String organiserName, int noOfStalls, int noOfSeats){
        super(name, detail, type, organiserName, noOfStalls);
        this.noOfSeats=noOfSeats;
    }

    public void display(){
        System.out.print(name+" "+detail+" "+type+" "+organiserName+" "+getNoOfStalls()+" "+noOfSeats);
    }
}

public class Inheritance4 {
    private static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int n=sc.nextInt();
        sc.nextLine();
        Event se;
        if(n==0)
        {
            String s=sc.nextLine();
            String arr[]=s.split(",");
            se=new Event(arr[0], arr[1], arr[2], arr[3]);
            se.display();
        }
        else if(n==1)
        {
            String s=sc.nextLine();
            String arr[]=s.split(",");
            se=new Exhibition(arr[0], arr[1], arr[2], arr[3], Integer.parseInt(arr[4]));
            se.display();
        }
        else if(n==2)
        {
            String s=sc.nextLine();
            String arr[]=s.split(",");
            se=new StageEvent(arr[0], arr[1], arr[2], arr[3], Integer.parseInt(arr[4]), Integer.parseInt(arr[5]));
            se.display();
        }
        else
        {
            System.out.print("Invalid Input");
        }
    }
}
