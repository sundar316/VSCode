package OOPS;

abstract class Transport{
    int tax=10;
    public int fuel()
    {
        return 1;
    }
    public abstract int apple();
}
class Bus extends Transport{
    @Override
    public int fuel()
    {
        return 1;
    }
    public int apple()
    {
        return 1;
    }
}
class Car extends Transport{
    public int fuel(){
        return 200+tax;
    }
    public int apple()
    {
        return 1;
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
