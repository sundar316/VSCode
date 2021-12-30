package OOPS.Inheritance;

import java.util.Scanner;

class WorkerDetail{
    int employeeCode;
    int basicSalary;
    String name;

    public void setDetails(int employeeCode, int basicSalary, String name){
        this.employeeCode=employeeCode;
        this.basicSalary=basicSalary;
        this.name=name;
    }
    public void display(){
        System.out.println("Code:"+employeeCode);
        System.out.println("Name:"+name);
        System.out.println("Salary:"+basicSalary);
        System.out.println("HRA:"+hra(basicSalary));
    }

    public double hra(int basicSalary){
        double hra=basicSalary*0.6;
        return hra;
    }
}

class OfficerSal extends WorkerDetail{
    public double da(int basicSalary){
        double da=basicSalary*0.98;
        return da;
    }
}

class ManagerSal extends OfficerSal{
    public double ca(int basicSalary){
        double ca=basicSalary*0.2;
        return ca;
    }
    public double grossPay(int basicSalary){
        double cs=basicSalary+hra(basicSalary)+da(basicSalary)+ca(basicSalary);
        return cs;
    }
}

public class Inheritance5 {
    private static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        ManagerSal ms=new ManagerSal();
        int employeeCode=sc.nextInt();
        sc.nextLine();
        String name=sc.nextLine();
        int basicSalary=sc.nextInt();
        ms.setDetails(employeeCode, basicSalary, name);
        ms.display();
        System.out.println("DA:"+ms.da(basicSalary));
        System.out.println("City Allowance:"+ms.ca(basicSalary));
        System.out.println("Gross Salary:"+ms.grossPay(basicSalary));
    }
}
