import java.util.Scanner;

class TicketBooking{
    private String stageEvent;
    private String customer;
    private int noOfSeats;

    TicketBooking(String stageEvent,String customer,int noOfSeats){
        this.stageEvent=stageEvent;
        this.customer=customer;
        this.noOfSeats=noOfSeats;
    }

    public void makePayment(Double amount){

    }

    public void makePayment(Double amount, String walletNumber){

    }

    public void makePayment(String name, Double amount, String creditCard, String ccv){

    }
}

class Customer extends TicketBooking{
    Customer(String stageEvent,String customer,int noOfSeats){
        super(stageEvent, customer, noOfSeats);
    }
}

class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String details=sc.nextLine();
        String arr[]=details.split(",");
        Customer c=new Customer(arr[0], arr[1], Integer.parseInt(arr[2]));
        int choice=sc.nextInt();
        if(choice==1)
        {
            c.makePayment(sc.nextDouble());
        }
        else if(choice==2)
        {
            c.makePayment(sc.nextDouble(), sc.next());
        }
        else if(choice==3)
        {
            c.makePayment(sc.next(), sc.nextDouble(), sc.next(), sc.next());
        }
        else
        {
            System.out.print("Invalid Choice");
        }
        sc.close();
    }
}