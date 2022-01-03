package ATM;

import java.util.Scanner;

public class User {
    static String uname[]={"user1", "user2", "user3", "user4"};
    static int pass[]={1234, 4321, 5678, 8765};
    static int bamount[]={10000, 20000, 5000, 2000};
    static User us;

    private static Scanner sc=new Scanner(System.in);
    public void user(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        while(true)
        {
            System.out.println("~~~~~~~~~~USER~~~~~~~~~~\n");
            System.out.print("Enter Username: ");
            String name=sc.nextLine();
            System.out.print("Enter Password: ");
            int pas=sc.nextInt();
            sc.nextLine();
            System.out.println();
            try{
                boolean flag=false;
                int i;
                for(i=0;i<=uname.length;i++)
                {
                    if(uname[i].trim().equals(name) && pass[i]==pas)
                    {
                        flag=true;
                        break;
                    }
                }
                if(flag)
                {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.print("!!! Welcome User !!!\n");
                    us=new User();
                    us.logged(i);
                    break;
                }
            }
            catch(Exception e)
            {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Enter Correct Username or Password.");
                System.out.println();
                sc.nextLine();
            }
        }
    }

    public void logged(int user){
        t:while(true)
        {
            System.out.print("\n1.Balance\n2.Withdrawal\n3.Exit\nEnter Choice: ");
            int choice=sc.nextInt();
            sc.nextLine();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            switch(choice)
            {
                case 1:
                    System.out.println("Balance: "+bamount[user]);
                    break;
                case 2:
                    us.withdrawal(user);
                    break;
                case 3:
                    break t;
                default:
                    System.out.println("Invalid Input");
            }
        }
    }

    public void withdrawal(int user){
        while(true)
        {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.print("Enter Amount to Withdraw: ");
            int amount=sc.nextInt();
            int temp=amount;
            boolean flag=true;
            if(amount%100==0 && amount<=10000 && amount<=bamount[user])
            {
                flag=false;
                int a=0, b=0, c=0, d=0;
                while(amount>0)
                {
                    if(amount>=2000)
                    {
                        a++;
                        amount-=2000;
                        if(a>Admin.amount[0])
                        {
                            flag=true;
                            break;
                        }
                    }
                    else if(amount>=500)
                    {
                        b++;
                        amount-=500;
                        if(b>Admin.amount[1])
                        {
                            flag=true;
                            break;
                        }
                    }
                    else if(amount>=200)
                    {
                        c++;
                        amount-=200;
                        if(c>Admin.amount[2])
                        {
                            flag=true;
                            break;
                        }
                    }
                    else if(amount>=100)
                    {
                        d++;
                        amount-=100;
                        if(d>Admin.amount[3])
                        {
                            flag=true;
                            break;
                        }
                    }
                }
            }
            if(flag)
            {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Enter Correct Denomination");
                break;
            }
            else
            {
                while(temp>0)
                {
                    if(temp>=2000)
                    {
                        temp-=2000;
                        bamount[user]-=2000;
                        Admin.amount[0]--;
                    }
                    else if(temp>=500)
                    {
                        amount-=500;
                        bamount[user]-=500;
                        Admin.amount[1]--;
                    }
                    else if(temp>=200)
                    {
                        temp-=200;
                        bamount[user]-=200;
                        Admin.amount[2]--;
                    }
                    else if(temp>=100)
                    {
                        temp-=100;
                        bamount[user]-=100;
                        Admin.amount[3]--;
                    }
                }
                System.out.println("Withdraw Successfully");
                break;
            }
        }
    }
}
