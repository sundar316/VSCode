package AppDev.VEHICLE_RENTAL_SYSTEM;

import java.util.ArrayList;
import java.util.List;

public class Transactions
{
    Vehicle vehicle;
    Admin admin;
    User user;
    String status;
    double a, b, c, d, e, amount;
    String name, vehicleName;

    Transactions (Vehicle vehicle, Admin admin, User user)
    {
        this.vehicle = vehicle;
        this.admin = admin;
        this.user = user;
        this.status = "Rented";
        a = 0;
        b = 0;
        c = 0;
        d = 0;
        e = 0;
        amount = 0;
        name = user.name;
        vehicleName = vehicle.name;
    }

    Transactions () {}

    static List<Transactions> tList = new ArrayList<>();

    public void transact(Admin admin)
    {
        System.out.print("\033[H\033[2J");
        System.out.println("~~~~~~~~~~RENT-VEHICLE~~~~~~~~~~\n");
        System.out.print("Enter User's Username: ");
        String userName = Login.sc.nextLine();
        found :
        {
            for (User i : User.uList)
            {
                if (i.userName.equalsIgnoreCase(userName))
                {
                    System.out.print("\nEnter Vehicle's Number Plate: ");
                    String numberPlate = Login.sc.nextLine();
                    found1 :
                    {
                        for (Vehicle j : Vehicle.vList)
                        {
                            if (j.numberPlate.equals(numberPlate))
                            {
                                if (j.isAvailable && j.isServiced)
                                {
                                    if ((i.amt > i.securityDepositAmtBike && j.type.equals("BIKE")) || (i.amt > i.securityDepositAmtCar && j.type.equals("CAR")))
                                    {
                                        if ((i.borrow[0] == 1 && j.type.equals("BIKE")) || (i.borrow[1] == 1 && j.type.equals("CAR")))
                                        {
                                            System.out.println("\nTransaction Failed\nUser can Rent at most 1 Car and 1 Bike");
                                            System.out.print("Press Enter to Continue...");
                                            Login.sc.nextLine();
                                        }
                                        else
                                        {
                                            tList.add(new Transactions(j, admin, i));
                                            if (j.type.equals("Bike"))
                                                i.borrow[0] = 1;
                                            else
                                                i.borrow[1] = 1;
                                            j.isAvailable = false;
                                            j.tenure++;
                                            j.borrowedCount++;
                                            System.out.println("\nRent Per Day: Rs."+j.rentPerDay);
                                            System.out.println("\nVehicle has been Rented to User");
                                            System.out.println("Pay the Amount on Return");
                                            System.out.print("Press Enter to Continue...");
                                            Login.sc.nextLine();
                                        }
                                    }
                                    else
                                    {
                                        System.out.println("\nTransaction Failed\nDue to Low Security Deposit Amount");
                                        System.out.print("Press Enter to Continue...");
                                        Login.sc.nextLine();
                                    }
                                }
                                else
                                {
                                    System.out.println("\nEntered Vehicle is Currently not Available");
                                    System.out.print("Press Enter to Continue...");
                                    Login.sc.nextLine();
                                }
                                break found1;
                            }
                        }
                        System.out.println("\nEntered Vehicle's Number Plate is not Available");
                        System.out.print("Press Enter to Continue...");
                        Login.sc.nextLine();
                    }
                    break found;
                }
            }
            System.out.println("\nEntered Username is not Available");
            System.out.print("Press Enter to Continue...");
            Login.sc.nextLine();
        }
    }

    public void extend(User user)
    {
        System.out.print("\033[H\033[2J");
        System.out.println("~~~~~~~~~~~EXTEND-TENURE-OF-RENTED-VEHICLE~~~~~~~~~~\n");
        System.out.print("\nEnter Vehicle's Number Plate: ");
        String numberPlate = Login.sc.nextLine();
        found :
        {
            for (Transactions i : tList)
            {
                if (i.user.name.equals(user.name) && i.vehicle.numberPlate.equals(numberPlate))
                {
                    if (i.vehicle.tenure < 3)
                    {
                        i.vehicle.tenure++;
                        System.out.println("\nTenure of the Rented Vehicle Extended for 1 day");
                        System.out.print("Press Enter to Continue...");
                        Login.sc.nextLine();
                    }
                    else
                    {
                        System.out.println("\nTenure of the Rented Vehicle Cannot Exceed more than 2 days,\nReturn a Vehicle");
                        System.out.print("Press Enter to Continue...");
                        Login.sc.nextLine();
                    }
                    break found;
                }
            }
            System.out.println("\nEntered Vehicle was not Rented by You");
            System.out.print("Press Enter to Continue...");
            Login.sc.nextLine();
        }
    }

    public void returns(Admin admin)
    {
        System.out.print("\033[H\033[2J");
        System.out.println("~~~~~~~~~~RETURN-VEHICLE~~~~~~~~~~\n");
        System.out.print("Enter User's Username: ");
        String userName = Login.sc.nextLine();
        System.out.print("\nEnter Vehicle's Number Plate: ");
        String numberPlate = Login.sc.nextLine();
        found :
        {
            for (Transactions i : tList)
            {
                if (i.user.userName.equals(userName) && i.vehicle.numberPlate.equals(numberPlate) && i.status.equals("Rented"))
                {
                    i.amount = i.vehicle.tenure * i.vehicle.rentPerDay;
                    i.a = i.amount;
                    System.out.print("\nTotal Kilometers Traveled: ");
                    int run = Login.sc.nextInt();
                    i.vehicle.totKms += run;
                    i.vehicle.serviceKms -= run;
                    if (i.vehicle.serviceKms <= 0)
                    {
                        i.vehicle.isServiced = false;
                        i.vehicle.isAvailable = false;
                    }
                    Login.sc.nextLine();
                    if (run / i.vehicle.tenure > 500)
                    {
                        i.b = i.amount * 0.15;
                        i.amount += i.b;
                    }
                    System.out.print("\nCar Damages LOW(a), MEDIUM(b), HIGH(c), NOTHING(d): ");
                    String damage = Login.sc.nextLine();
                    if (damage.equalsIgnoreCase("a"))
                    {
                        i.c = i.amount * 0.2;
                        i.amount += i.c;
                    }
                    else if (damage.equalsIgnoreCase("b"))
                    {
                        i.d = i.amount * 0.5;
                        i.amount += i.d;
                    }
                    else if (damage.equalsIgnoreCase("c"))
                    {
                        i.e = i.amount * 0.75;
                        i.amount += i.e;
                    }
                    i.vehicle.tenure = 0;
                    i.vehicle.isAvailable = true;
                    i.status = "Returned";

                    System.out.print("\033[H\033[2J");
                    System.out.println("\t      >>>Total Bill<<<\n");
                    System.out.printf("%-36s%s\n","Rented By: ", i.name.toUpperCase());
                    System.out.printf("%-36s%s\n\n","Rented Vehicle's Name: ", i.vehicleName.toUpperCase().toUpperCase());
                    System.out.printf("%-36s%s%s\n", "Rented Amount: ", "Rs.", i.a);
                    if (i.b != 0)
                        System.out.printf("%-36s%s%s\n", "Traveled more than 500km per Day: ", "Rs.", i.b);
                    if (damage.equals("a"))
                        System.out.printf("%-36s%s%s\n", "Fine Amount for Small Car Damages: ", "Rs.", i.c);
                    if (damage.equals("b"))
                        System.out.printf("%-36s%s%s\n", "Fine Amount for Partial Car Damages: ", "Rs.", i.d);
                    if (damage.equals("c"))
                        System.out.printf("%-36s%s%s\n", "Fine Amount for Heavy Car Damages: ", "Rs.", i.e);
                    System.out.printf("%-36s%s%s\n", "Total Bill Amount: ", "Rs.", i.amount);
                    System.out.println("\n\t      !!!Thank You!!!\n\n(Pay Bill Amount in User Page)");
                    System.out.print("Press Enter to Continue...");
                    Login.sc.nextLine();
                    break found;
                }
            }
            System.out.println("\nEntered Username is not Rented the Entered Vehicle");
            System.out.print("Press Enter to Continue...");
            Login.sc.nextLine();
        }
    }

    public void report()
    {
        
    }

    public void transactions(User user)
    {
        
    }

}
