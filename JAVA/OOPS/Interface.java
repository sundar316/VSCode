package OOPS;

interface Father{
    public int attitude();
}

interface Mother{
    public int love();
}

class Child implements Father,Mother{
    public int attitude(){
        return 100;
    }
    public int love(){
        return 100;
    }
}
public class Interface {
    public static void main(String[] args) {
        Child ob=new Child();
        System.out.print(ob.attitude());
        System.out.print(ob.love());
    }
}
