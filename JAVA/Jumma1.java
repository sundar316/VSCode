import java.util.Scanner;

public class Jumma1 {
    private static Scanner sc=new Scanner(System.in);
    static Boolean isPrime(int n){
        for(int i=2;i<=Math.sqrt(n);i++)
        {
            if(n%i==0)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int n=sc.nextInt();
        int a=0,b=0,c=0;
        for(int i=2;i<n;i++)
        {
            if(isPrime(i) && c%2==0)
            {
                a+=i;
                System.out.print(i+",");
            }
            else if(isPrime(i))
            {
                b+=i;
                System.out.print(i+" ");
            }
            c++;
        }
        System.out.print(Math.abs(a-b));
    }
}
