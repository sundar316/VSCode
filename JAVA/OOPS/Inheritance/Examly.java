package OOPS.Inheritance;

import java.util.Scanner;

class Person{
}

class Student extends Person{
    String firstName;
    String lastName;
    int id;
    int[] scores;

    Student(String firstName, String lastName, int id, int[] scores){
        this.firstName=firstName;
        this.lastName=lastName;
        this.id=id;
        this.scores=scores;
    }
    public char calculate(int avg){
        if(90<=avg && avg<=100)
            return 'O';
        if(80<=avg && avg<90)
            return 'E';
        if(70<=avg && avg<80)
            return 'A';
        if(55<=avg && avg<70)
            return 'P';
        if(40<=avg && avg<45)
            return 'D';
        else
            return 'T';
    }
    public void display(){
        System.out.println("Name:"+firstName+" "+lastName);
        System.out.println("ID:"+id);
        int avg=0;
        for(int i=0;i<scores.length;i++)
        {
            avg+=scores[i];
        }
        System.out.println("Grade:"+calculate(avg/scores.length));
    }
}

public class Examly {
    private static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        String firstName=sc.nextLine();
        String lastName=sc.nextLine();
        int id=sc.nextInt();
        int n=sc.nextInt();
        int[] scores=new int[n];
        for(int i=0;i<n;i++)
        {
            scores[i]=sc.nextInt();
        }
        Student s=new Student(firstName, lastName, id, scores);
        s.display();
    }
}
