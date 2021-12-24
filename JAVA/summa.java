class WorkerDetail{
    int code;
    int salary;
    String name;
    WorkerDetail(int code,int salary,String name){
        this.code=code;
        this.salary=salary;
        this.name=name;
    }
   int hra=(int)(salary);
    void display(){
        System.out.println("Code:"+code);
        System.out.println("Name:"+name);
        System.out.println("Salary:"+salary);
        System.out.println("HRA:"+hra);
    }
}

class OfficerSal extends WorkerDetail{
    OfficerSal(int code, int salary, String name) {
        super(code, salary, name);
    }
    double da=(int)(salary*0.98);
    void DA(){
        System.out.println("DA:"+da);
    }
}

class ManagerSal extends WorkerDetail{

    ManagerSal(int code, int salary, String name) {
        super(code, salary, name);
    }
    double allowance=(int)(salary*0.2);
    void allowance(){
        System.out.println("City Allowance:"+allowance);
    }
}

class Main{
    public static void main(String[] args){
        WorkerDetail wd=new WorkerDetail(101, 10000, "Karthick");
        OfficerSal of=new OfficerSal(101, 10000, "Karthick");
        ManagerSal ms=new ManagerSal(101, 10000, "Karthick");
        wd.display();
        of.DA();
        ms.allowance();
        System.out.println("Gross Salary:"+(wd.salary+wd.hra+of.da+ms.allowance));
    }
}