package OOPS;

class C{
    static int b=200;
    int c;
    C(int i){
        c=i;
    }
    C(){
    }
    float display(int a){
        return a+c;
    }
}
class Instance {
    static int a=100;
    public static void main(String[] args) {
        C d=new C(a);
        C e=new C();
        e.c=d.c;
        System.out.println(C.b);
        System.out.println(a);
        System.out.println(d.display(a)+" "+e.display(a));

    }
}
