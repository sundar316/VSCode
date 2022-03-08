import java.util.Scanner;

public class Login {

    static Scanner sc = new Scanner(System.in);
    public static void main (String[] args) {
        while (true) {
            System.out.println();
            System.out.println("1. User Login");
            System.out.println("2. User SignUp");
            System.out.println("3. Admin Login");
            System.out.print("Enter Choice: ");
            int n= sc.nextInt();
            sc.nextLine();
            switch (n) {
                case 1:
                    User.user();
                    break;
                case 2:
                    User.userSignup();
                    break;
                case 3:
                    Admin.adminLogin();
                    break;
                default:
                    System.out.println("Enter Correct Input");
            }
        }
    }
}
