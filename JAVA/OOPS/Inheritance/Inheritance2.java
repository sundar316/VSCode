package OOPS.Inheritance;
import java.util.Scanner;

class Person{
    private String name;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void display(){
        System.out.println("Name:"+getName());
    }
}

class Staff extends Person{
    private int staffID;

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }
    public int getStaffID() {
        return staffID;
    }

    public void display(){
        super.display();
        System.out.println("Staff ID:"+getStaffID());
    }
}

class TemporaryStaff extends Staff{
    private int days;
    private int hours;

    public void setDays(int days) {
        this.days = days;
    }
    public int getDays() {
        return days;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
    public int getHours() {
        return hours;
    }

    public void display(){
        super.display();
        System.out.println("No. of Days:"+getDays());
        System.out.println("No. of Hours Worked:"+getHours());
        int salary=days*hours*50;
        System.out.println("Total Salary:"+salary);
    }
}

public class Inheritance2 extends TemporaryStaff{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        TemporaryStaff ts=new TemporaryStaff();

        ts.setName(sc.nextLine());
        ts.setStaffID(sc.nextInt());
        ts.setDays(sc.nextInt());
        ts.setHours(sc.nextInt());

        ts.display();
        sc.close();
    }
}
