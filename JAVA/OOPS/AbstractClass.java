package OOPS;

abstract class Transport{
    int tax=10;
    public abstract int fuel();
}
class Bus extends Transport{
    public int fuel(){
        return 300+tax;
    }
}
class Car extends Transport{
    public int fuel(){
        return 200+tax;
    }
}

public class AbstractClass {
    public static void main(String[] args) {
        Bus a=new Bus();
        Car b=new Car();
        System.out.println("Bus"+a.fuel());
        System.out.println("Car"+b.fuel());
    }
}
