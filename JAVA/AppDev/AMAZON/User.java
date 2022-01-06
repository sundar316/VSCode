package AppDev.AMAZON;

import java.util.ArrayList;
import java.util.List;

public class User {

    String userName;
    int pin;

    static List<User> uList =new ArrayList<>();

    User(String userName, int pin) {
        this.userName=userName;
        this.pin=pin;
    }

    User(){}

    public void user() {
        t:while (true) {
            System.out.print("\033[H\033[2J");
            System.out.print("""
                            ~~~~~~~~~~USER~~~~~~~~~~

                            1. New User
                            2. Existing User
                            3. Exit

                            Enter Your Choice:""");
            int choice=Login.sc.nextInt();
            Login.sc.nextLine();
            switch (choice) {
                case 1:
                    newLogin();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    System.out.print("\033[H\033[2J");
                    break t;
                default:
                    System.out.print("\033[H\033[2J");
                    System.out.print("Invalid Input\nPress Enter to Continue...");
                    Login.sc.nextLine();
                    break;
            }
        }
    }

    public void newLogin() {
        System.out.print("\033[H\033[2J");
        System.out.println("~~~~~~~~~~USER-SIGNING-UP~~~~~~~~~~\n");
        System.out.print("Enter User Name: ");
        String uname=Login.sc.nextLine();
        for(User i:User.uList)
        {
            if(uname.equals(i.userName))
            {
                System.out.print("\033[H\033[2J");
                System.out.println("User Name is Already Exists");
                System.out.print("Press Enter to Continue...");
                Login.sc.nextLine();
                return;
            }
        }
        System.out.print("\nEnter New Pin: ");
        int pin=Login.sc.nextInt();
        System.out.print("\nEnter Confirm Pin: ");
        int cpin=Login.sc.nextInt();
        Login.sc.nextLine();
        if(pin==cpin)
        {
            uList.add(new User(uname, pin));
            System.out.print("\033[H\033[2J");
            System.out.println("Sign Up Successfully\n");
            System.out.println("~~~~Thank You for creating an Amazon User Account :) ~~~~\n");
            System.out.print("Press Enter to Continue...");
            Login.sc.nextLine();
            return;
        }
        else
        {
            System.out.print("\033[H\033[2J");
            System.out.println("Pin Mismatch");
            System.out.print("Press Enter to Continue...");
            Login.sc.nextLine();
            return;
        }
    }

    public void login() {
        System.out.print("\033[H\033[2J");
        System.out.println("~~~~~~~~~~USER-SIGNING-IN~~~~~~~~~~\n");
        System.out.print("Enter User Name: ");
        String uname=Login.sc.nextLine();
        int j=0;
        boolean flag=true;
        for(User i:User.uList)
        {
            if(uname.equals(i.userName))
            {
                flag=false;
                break;
            }
            j++;
        }
        if(flag)
        {
            System.out.print("\033[H\033[2J");
            System.out.println("User Name is Doesn't Exists");
            System.out.print("Press Enter to Continue...");
            Login.sc.nextLine();
            return;
        }
        System.out.print("\nEnter Pin: ");
        int pin=Login.sc.nextInt();
        Login.sc.nextLine();
        if(pin==User.uList.get(j).pin)
        {
            logged(j);
            return;
        }
        else
        {
            System.out.print("\033[H\033[2J");
            System.out.println("Pin Mismatch");
            System.out.print("Press Enter to Continue...");
            Login.sc.nextLine();
            return;
        }
    }

    public void logged(int user) {
        t:while (true)
        {
            System.out.print("\033[H\033[2J");
            System.out.print("""
                            ~~~~~~~~~~WELCOME-USER~~~~~~~~~~

                            1. Search / Buy Product
                            2. Cart
                            3. Ordered Products
                            4. Returned Products
                            5. Wallet Amount
                            6. Change Pin
                            7. Exit

                            Enter Your Choice:""");
            int choice=Login.sc.nextInt();
            Login.sc.nextLine();
            switch (choice)
            {
                case 1:
                    search();
                    break;
                case 2:
                    // cart();
                    break;
                case 3:
                    // orderedList();
                    break;
                case 4:
                    // returnedList();
                    break;
                case 5:
                    // walletAmount();
                    break;
                case 6:
                    pinChange(user);
                    break;
                case 7:
                    System.out.print("\033[H\033[2J");
                    break t;
                default:
                    System.out.print("\033[H\033[2J");
                    System.out.print("Invalid Input\nPress Enter to Continue...");
                    Login.sc.nextLine();
                    break;
            }
        }
    }

    public void search() {
        while(true)
        {
            System.out.print("\033[H\033[2J");
            System.out.println("~~~~~~~~~~SEARCH~~~~~~~~~~\n");
            System.out.print("Enter Product Name: ");
            String item=Login.sc.nextLine();
            boolean flag=true;
            for(Product i:Product.plist)
            {
                if(i.productName.equals(item))
                {
                    flag=false;
                    
                }
            }
            if(flag)
            {
                System.out.println("\nProduct is not available.");
                System.out.print("Press Enter to Continue...");
                Login.sc.nextLine();
                return;
            }
            else
            {
                System.out.print("Press Enter to Continue...");
                Login.sc.nextLine();
            }
        }
    }

    public void walletAmount() {
        
    }

    public void pinChange(int sindex) {
        System.out.print("\033[H\033[2J");
        System.out.print("Enter new Pin: ");
        int pin=Login.sc.nextInt();
        System.out.print("\nEnter Confirm pin: ");
        int pin1=Login.sc.nextInt();
        Login.sc.nextLine();
        if(pin==pin1)
        {
            uList.get(sindex).pin=pin;
            System.out.print("\nPin Changed Successfully (Press Enter to Continue...)");
            Login.sc.nextLine();
        }
        else
        {
            System.out.println("\nPin Mismatch");
            System.out.print("Press Enter to Continue...");
            Login.sc.nextLine();
        }
    }

}
