package OOPS.Inheritance;

import java.util.Scanner;

class SilverStall{
    private int cost;

    SilverStall(String name, String detail, String owner, int cost){
        this.cost=cost;
    }

    public int getCost() {
        return cost;
    }

    public void display(){
        System.out.print(cost);
    }
}

class GoldStall extends SilverStall{
    private int tvSet;

    GoldStall(String name, String detail, String owner, int cost, int tvSet){
        super(name, detail, owner, cost);
        this.tvSet=tvSet;
    }

    public int getTvSet() {
        return tvSet;
    }

    public void display(){
        System.out.print(getCost()+(tvSet*100));
    }
}

class PlatinumStall extends GoldStall{
    private int projector;

    PlatinumStall(String name, String detail, String owner, int cost, int tvSet, int projector){
        super(name, detail, owner, cost, tvSet);
        this.projector=projector;
    }

    public void display(){
        System.out.print(getCost()+(getTvSet()*100)+(projector*500));
    }
}

public class Inheritance3 {
    private static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int n=sc.nextInt();
        SilverStall ss;
        if(n==1)
        {
            ss=new SilverStall(sc.next(), sc.next(), sc.next(), sc.nextInt());
            ss.display();
        }
        else if(n==2)
        {
            ss=new GoldStall(sc.next(), sc.next(), sc.next(), sc.nextInt(), sc.nextInt());
            ss.display();
        }
        else if(n==3)
        {
            ss=new PlatinumStall(sc.next(), sc.next(), sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt());
            ss.display();
        }
        else
        {
            System.out.println("Invalid Input");
        }
    }
}
