package Samples;

import java.util.Random;

public class PasswordGenerator {
    static String pass(){
        Random R=new Random();
        char[] num={'0','1','2','3','4','5','6','7','8','9'};
        char[] alp={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        char[] ALP={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        char[] symbol={'!','@','$','&','#','?'};
        String s="";
        int nn=R.nextInt(26);
        s=s+ALP[nn];
        int nn1=R.nextInt(26);
        s=s+alp[nn1];
        int q=0;
        while(s.length()<=8)
        {
            int n0=R.nextInt(5);
            switch(n0)
            {
                case 1:
                    int n=R.nextInt(26);
                    s=s+alp[n];
                    break;
                case 2:
                    int n1=R.nextInt(26);
                    s=s+ALP[n1];
                    break;
                case 3:
                    int n2=R.nextInt(10);
                    s=s+num[n2];
                    break;
                default:
                    if(q!=1)
                    {
                    int n3=R.nextInt(6);
                    s=s+symbol[n3];
                    q=1;
                    break;
                    }
            }
        }
        return s;
   }
    public static void main(String[] args) {
        for(int i=0;i<10;i++)
            System.out.println(pass());
    }
}