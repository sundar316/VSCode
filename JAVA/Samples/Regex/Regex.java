package Samples.Regex;

import java.util.Scanner;
import java.util.regex.Pattern;
class Regex{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String n=sc.nextLine();
        if(Pattern.matches("^([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\." +
        "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\." +
        "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\." +
        "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])$", n))
        {
            System.out.println(n + ":PANCARD");
        }
        else if(Pattern.matches ("^[A-Z]{3}[0-9]{7}",n)){
            System.out.println(n + ":Voter Id");
        }
        else
            System.out.println("none of the above");
        sc.close();
    }
}



// import java.util.*;
// import java.util.regex.*;

// public class Regex{
// 	public static void main(String[] args){
// 		Scanner in = new Scanner(System.in);
// 		int testCases = Integer.parseInt(in.nextLine());
// 		while(testCases-->0)
//         {
// 			String line = in.nextLine();
//           	Matcher m = Pattern.compile("<(.+)>(([^<>]+))</\\1>").matcher(line);
//             if (!m.find())
//             {
//                 System.out.println("None");
//                 continue;
//             }
//             m.reset();
//             while (m.find())
//             {
//                 System.out.println(m.group(2));
//             }
//             in.close();
// 		}
// 	}
// }



