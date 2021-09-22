package Samples.Regex;

// import java.util.Scanner;
// import java.util.regex.Pattern;
// class Regex{
//     public static void main(String[] args) {
//         Scanner sc=new Scanner(System.in);
//         String n=sc.nextLine();
//         if(Pattern.matches("^[A-Z]{5}[0-9]{4}[A-Z]{1}", n))
//         {
//             System.out.println(n + ":PANCARD");
//         }
//         else if(Pattern.matches ("^[A-Z]{3}[0-9]{7}",n)){
//             System.out.println(n + ":Voter Id");
//         }
//         else
//             System.out.println("none of the above");
//     }
// }


// import java.util.*;
// class Regex{
//     int a=10;
//     public static void main(String[] args) {
//         Regex y=new Regex();
//         Integer a=15;
//         Scanner scanner=new Scanner(System.in);
//         String r=scanner.nextLine();
//         scanner.close();
//         System.out.println(a);
//         System.out.printf("%s",r);
//     }
// }

import java.util.*;
import java.util.regex.*;

public class Regex{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while(testCases-->0)
        {
			String line = in.nextLine();
          	Matcher m = Pattern.compile("<(.+)>(([^<>]+))</\\1>").matcher(line);
            if (!m.find())
            {
                System.out.println("None");
                continue;
            }
            m.reset();
            while (m.find())
            {
                System.out.println(m.group(2));
            }
            in.close();
		}
	}
}



