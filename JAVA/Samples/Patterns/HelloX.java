package Samples.Patterns;

public class HelloX {
    public static void main(String[] args) {
        String hiString = "Hello";
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                if(i==j || i+j==4)
                    System.out.print(hiString.charAt(i));
                else
                    System.out.print("  ");
            }
            System.out.print("\n");
        }
    }
}
