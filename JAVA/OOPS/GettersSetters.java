package OOPS;

class Set{
    private int a;
    private int b;
    public void setValue(int a,int b){
        this.a=a;
        this.b=b;
    }
    public int getValueA(){
        return a;
    }
    public int getValueB(){
        return b;
    }
}

public class GettersSetters {
    public static void main(String[] args) {
        Set ob=new Set();
        ob.setValue(10, 20);
        System.out.println(ob.getValueA());
        System.out.println(ob.getValueB());
    }
}