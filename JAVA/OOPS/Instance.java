package OOPS;

class Child{
    static int b=200;
    int c;
    Child(int i){
        c=i;
    }
    Child(){
    }
    float display(int a){
        return a+c;
    }
}
class Instance {
    static int a=100;
    public static void main(String[] args) {
        Child d=new Child(a);
        Child e=new Child();
        e.c=d.c;
        System.out.println(Child.b);
        System.out.println(a);
        System.out.println(d.display(a)+" "+e.display(a));

    }
}
