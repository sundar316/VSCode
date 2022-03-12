package ZOHO_AppDev;

public class Admin {

    static int amount = 0;

    public static void adminLogin() {
        System.out.println("\nAdmin Login");
        System.out.print("Admin Name:");
        String name = Login.sc.nextLine();
        System.out.print("Admin Pass:");
        String pass = Login.sc.nextLine();
        if (name.equals("admin") && pass.equals("1234")) {
            login();
        } else {
            System.out.println("Entered Name/Password is Wrong");
        }
    }

    public static void login(){
        t : while (true) {
            System.out.println("\nHello Admin");
            System.out.println("1. Bus List");
            System.out.println("2. Summary");
            System.out.println("3. Exit");
            System.out.print("Enter Choice: ");
            String choice = Login.sc.nextLine();
            switch (choice) {
                case "1":
                    Buses.list();
                    break;
                case "2":
                    summary();
                    break;
                case "3":
                    break t;
                default:
                    System.out.println("Invalid Input");
            }
        }
    }

    public static void summary() {
        String arr1[] = {"A", "B", "C"};
        String arr2[] = {"1", "2", "3", "4", "5", "6"};
        System.out.println("\nTotal Fare Collected: "+amount);
        System.out.println("Bus Details\n");
        for (Buses i : Buses.buses) {
            System.out.println("Name of the Bus: "+i.bus+" "+i.type);
            System.out.println("Seat Details: ");
            int count = 0;
            int m = 0;
            System.out.print("Seats: ");
            for (int j[] : i.avail) {
                int n = 0;
                for (int k : j) {
                    if (k != 0) {
                        count++;
                        System.out.print(arr1[n]+arr2[m]+", ");
                    }
                    n++;
                }
                m++;
            }
            System.out.println("\nNumber of Seats Filled: "+count+"\n");
        }
    }

}
