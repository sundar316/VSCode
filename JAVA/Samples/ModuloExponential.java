package Samples;

public class ModuloExponential {
    static int pow(int a,int b,int c){
        int d=a;
        String s=Integer.toBinaryString(b);
        for(int i=1;i<s.length();i++)
        {
            if(s.charAt(i)=='0')
            {
                d=(d*d)%c;
            }
            else
            {
                d=(d*d)%c;
                d=(d*a)%c;
            }
        }
        return d;
    }
    public static void main(String[] args) {
        System.out.print(pow(17,100,23));
    }
}
