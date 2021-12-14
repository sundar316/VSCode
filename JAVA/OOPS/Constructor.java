package OOPS;

import java.util.Scanner;

class Cons {
    String name;
    int roll_no;
    int mark;
    Cons(String name,int roll_no,int mark){
        this.name=name;
        this.roll_no=roll_no;
        this.mark=mark;
    }
    Cons(){}
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Cons[] con=new Cons[5];
        for(int i=0;i<5;i++)
        {
            con[i]=new Cons();
            System.out.print("Name : ");
            con[i].name=sc.next();
            System.out.print("Roll No. : ");
            con[i].roll_no=sc.nextInt();
            System.out.print("Mark : ");
            con[i].mark=sc.nextInt();
            System.out.println();
        }
        System.out.println("\n");
        for(int i=0;i<4;i++)
        {
            boolean flag=true;
            for(int j=0;j<4-i;j++)
            {
                if(con[j].mark<con[j+1].mark)
                {
                    Cons temp=con[j];
                    con[j]=con[j+1];
                    con[j+1]=temp;
                    flag=false;
                }
                if(con[j].mark==con[j+1].mark&&con[j].name.compareTo(con[j+1].name)>0)
                {
                    Cons temp=con[j];
                    con[j]=con[j+1];
                    con[j+1]=temp;
                    flag=false;
                }
                if(con[j].name.compareTo(con[j+1].name)==0 && con[j].roll_no>con[j+1].roll_no)
                {
                    Cons temp=con[j];
                    con[j]=con[j+1];
                    con[j+1]=temp;
                    flag=false;
                }
            }
            if(flag)
                break;
        }

        for(int i=0;i<5;i++)
        {
            System.out.println(i+1+" :-->");
            System.out.println("Name : "+con[i].name);
            System.out.println("Roll No. : "+con[i].roll_no);
            System.out.println("Mark : "+con[i].mark);
            System.out.println();
        }
        sc.close();
    }
}
