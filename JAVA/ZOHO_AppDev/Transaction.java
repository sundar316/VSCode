public class Transaction {


    public static void book(User user) {
        System.out.println("\nTicket Booking");
        System.out.println("Bus List");
        Buses.list();
        System.out.print("Enter Bus Id: ");
        String id = Login.sc.nextLine();
        Buses bus = Buses.buses.get(Integer.parseInt(id)-1);
        int rows = 1;
        if (bus.bus.equals("Seater"))
            System.out.println("   A B C");
        else
            System.out.println("   A B");
        for (int[] i : bus.avail) {
            System.out.print(rows++ + ") ");
            for (int j : i) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
        System.out.println("note: ");
        System.out.println("0 - Seats Available");

        System.out.print("\nEnter the seat (like: A1,A2) : ");
        String[] input = Login.sc.nextLine().split(",");
        int size = input.length;
        String gender = user.gender;
        for (String i : input) {
            int row = Integer.parseInt(i.charAt(1)+"")-1;
            int col = i.charAt(0)-'A';
            booking(col, row, user, bus, gender);
            if (--size > 0) {
                System.out.print("Enter Name of Co-Traveller: ");
                String name = Login.sc.nextLine();
                System.out.print("Gender [M/F]: ");
                gender = Login.sc.nextLine();
            }
        }
    }

    public static void booking(int col, int row, User user, Buses bus, String Gender) {
        int rows = row;
        if (bus.bus.equals("Seater")) {
            if (row%2 == 0) {
                rows++;
            } else {
                rows--;
            }
            if (bus.avail[rows][col]==0 || Gender.equals(User.arr.get(bus.avail[rows][col]).gender) || User.arr.get(bus.avail[row][col]).id == (User.arr.get(bus.avail[rows][col]).id)){
                if (bus.avail[row][col] == 0) {
                    if (bus.type.equals("AC")) {
                        System.out.println("Your Ticket Amount is : Rs.550/-");
                    } else {
                        System.out.println("Your Ticket Amount is : Rs.450/-");
                    }
                    System.out.println("Press Enter to Continue / 0 to Cancel: ");
                    if (Login.sc.nextLine().equals("0")) {
                        return;
                    }
                    if (bus.type.equals("AC")) {
                        Admin.amount += 550;
                    } else {
                        Admin.amount += 450;
                    }
                    bus.avail[row][col] = user.id;
                    bus.seats--;
                    System.out.println("\nBus Ticket Booked Successfully");
                } else {
                    System.out.println("\n Seat is Already Booked");
                }
            } else {
                System.out.println("\nYou Cannot Able to Book this Seat");
            }
        } else {
            if (row == 2 || row == 5) {
                if (bus.avail[row][col] == 0) {
                    if (bus.type.equals("AC")) {
                        System.out.println("Your Ticket Amount is : Rs.700/-");
                    } else {
                        System.out.println("Your Ticket Amount is : Rs.600/-");
                    }
                    System.out.println("Press Enter to Continue / 0 to Cancel: ");
                    if (Login.sc.nextLine().equals("0")) {
                        return;
                    }
                    if (bus.type.equals("AC")) {
                        Admin.amount += 700;
                    } else {
                        Admin.amount += 600;
                    }
                    bus.seats--;
                    bus.avail[row][col] = user.id;
                    System.out.println("\nBus Ticket Booked Successfully");
                } else {
                    System.out.println("\n Seat is Already Booked");
                }
                return;
            }
            if (row == 0 || row == 3) {
                rows++;
            } else {
                rows--;
            }
            if (bus.avail[rows][col]==0 || Gender.equals(User.arr.get(bus.avail[rows][col]).gender)  || User.arr.get(bus.avail[row][col]).id == (User.arr.get(bus.avail[rows][col]).id)){
                if (bus.avail[row][col] == 0) {
                    if (bus.type.equals("AC")) {
                        System.out.println("Your Ticket Amount is : Rs.700/-");
                    } else {
                        System.out.println("Your Ticket Amount is : Rs.600/-");
                    }
                    System.out.println("Press Enter to Continue / 0 to Cancel: ");
                    if (Login.sc.nextLine().equals("0")) {
                        return;
                    }
                    if (bus.type.equals("AC")) {
                        Admin.amount += 700;
                    } else {
                        Admin.amount += 600;
                    }
                    bus.avail[row][col] = user.id;
                    bus.seats--;
                    System.out.println("\nBus Ticket Booked Successfully");
                } else {
                    System.out.println("\n Seat is Already Booked");
                }
            } else {
                System.out.println("\nYou Cannot Able to Book this Seat");
            }
        }
    }

    public static void cancel(User user) {
        System.out.println("Select the Bus Id to Cancel: ");
        Buses.list();
        System.out.print("\nEnter Id: ");
        String id = Login.sc.nextLine();
        boolean flag = true;
        int m = 0;
        for (int i[] : Buses.buses.get(Integer.parseInt(id)-1).avail) {
            for (int j : i) {
                int n = 0;
                if (j == user.id) {
                    flag = false;
                    Buses.buses.get(Integer.parseInt(id)-1).avail[m][n] = 0;
                }
                n++;
            }
            m++;
        }
        if (flag) {
            System.out.println("No Ticket has been Booked on this Bus");
        }

    }
}
