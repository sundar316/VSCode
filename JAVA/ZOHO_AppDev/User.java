package ZOHO_AppDev;

import java.util.*;

public class User {

    int id;
    String name;
    String pass;
    String age;
    String gender;
    int amount;

    static int ids = 1;

    User (String name, String pass, String age, String gender) {
        this.id = ids++;
        this.name = name;
        this.pass = pass;
        this.age = age;
        this.gender = gender;
    }

    static List<User> arr = new ArrayList<>();

    static {
        arr.add(new User("aaa", "111", "25", "F"));
        arr.add(new User("bbb", "111", "61", "M"));
        arr.add(new User("ccc", "111", "22", "M"));
        arr.add(new User("ddd", "111", "36", "F"));
    }

    public static void userSignup() {
        System.out.println("\nUser Sign Up");
        System.out.print("Enter Name:");
        String name = Login.sc.nextLine();
        System.out.print("Enter Password:");
        String pass = Login.sc.nextLine();
        System.out.print("Enter Age:");
        String age = Login.sc.nextLine();
        System.out.print("Enter Gender:");
        String gender = Login.sc.nextLine();

        arr.add(new User(name, pass, age, gender));
        System.out.println("\nSign Up Successfully");
        System.out.print("Press Enter to Continue...");
        Login.sc.nextLine();
    }

    public static void user() {
        System.out.println("\nUser Login");
        System.out.print("Enter Name:");
        String name = Login.sc.nextLine();
        System.out.print("Enter Password:");
        String pass = Login.sc.nextLine();
        boolean flag = true;
        for (User i : arr) {
            if (i.name.equals(name) && i.pass.equals(pass)) {
                flag = false;
                login(i);
            }
        }
        if (flag) {
            System.out.println("Username / Password is Wrong");
        }
    }

    public static void login(User user) {
        t : while (true) {
            System.out.println("\nHello User " + user.name);
            System.out.println("1. Booking Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. Bus List");
            System.out.println("4. Exit");
            System.out.print("Enter Choice: ");
            String choice = Login.sc.nextLine();
            switch (choice) {
                case "1":
                    Transaction.book(user);
                    break;
                case "2":
                    Transaction.cancel(user);
                    break;
                case "3":
                    Buses.list();
                    break;
                case "4":
                    break t;
                default:
                    System.out.println("Invalid Input");
            }
        }
    }
}
