package Samples;

// import java.util.Random;
// import java.util.UUID;

// class B
// {
//     public static String generateRandomPassword(int len) {
//         String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk"
//         +"lmnopqrstuvwxyz!@#$%&";
//         Random rnd = new Random();
//         StringBuilder sb = new StringBuilder(len);
//         for (int i = 0; i < len; i++)
//             sb.append(chars.charAt(rnd.nextInt(chars.length())));
//         return sb.toString();
//     }
//     public static void main(String[] args)
//     {
//         String id = UUID.randomUUID().toString();
//         System.out.println(id);
//         String id1 = UUID.randomUUID().toString();
//         System.out.println(id1);
//         System.out.println(generateRandomPassword(10));
//     }
// }

// import java.util.*;
// class Solution
// {
// 	public static String encode(String message)
//     {
//         HashMap<String, Integer> ch = new HashMap<>();
//         String s = "";
// 		for (int i = 0; i < message.length(); i++)
//         {
//             if (ch.keySet().contains(message.charAt(i)+""))
//             {
//                 Integer a = ch.get(message.charAt(i)+"");
//                 ch.put(message.charAt(i)+"", a+1);
//             }
//             else
//                 ch.put(message.charAt(i)+"", 1);
//         }
//         for (String i : ch.keySet())
//             s += i+ch.get(i);
//         return s;
// 	}
//     public static void main(String[] args) {
//         System.out.println(encode("aaabbcc"));
//     }
// }


// class Solution
// {
//     public static String removeVowels(String str)
//     {
//         String s = "";
//         for (char i : str.toCharArray())
//         {
//             if ((i == 'a' && i == 'e' && i == 'i' && i == 'o' && i == 'u') && (i == 'A' && i == 'E' && i == 'I' && i == 'O' && i == 'U'))
//                 continue;
//             s += i+"";
//         }
//         return s;
//     }
//     public static void main(String[] args) {
//         System.out.println(removeVowels("BEc"));
//     }
// }

// class Solution
// {
//     public static String leftRotate(String str, int d)
//     {
//         // Write you code here.
//         StringBuffer s = new StringBuffer();
//         int c = d % str.length();
//         s.append(str.substring(c));
//        	s.append(str.substring(0, c));
//         return s.toString();
//     }

//     public static String rightRotate(String str, int d)
//     {
//         // Write you code here.
//         StringBuffer s = new StringBuffer();
//         int c = d % str.length();
//         s.append(str.substring(str.length()-c));
//        	s.append(str.substring(0, str.length()-c));
//         return s.toString();
//     }

//     public static void main(String[] args)
//     {
//         System.out.println(leftRotate("hello", 2));
//         System.out.println(rightRotate("hello", 2));
//     }
// }


// Infytq
// public class Samples
// {
//     private static Scanner sc = new Scanner(System.in);
//     public static void main(String[] args)
//     {
//         String keys[] = sc.nextLine().split(" ");
//         String values[] = sc.nextLine().split(",");
//         HashMap<String, String> set = new HashMap<>();
//         t : for (int i = 0; i < keys.length; i++)
//         {
//             if (set.keySet().contains(keys[i]))
//             {
//                 if (set.get(keys[i]).equals(values[i]))
//                 {
//                     continue;
//                 }
//                 else
//                 {
//                     set.put(keys[i], "");
//                 }
//             }
//             else
//             {
//                 for (int j = 0; j < values.length; j++)
//                 {
//                     if (i != j && values[j].equals(values[i]) && !keys[j].equals(keys[i]))
//                         continue t;
//                 }
//                 set.put(keys[i], values[i]);
//             }
//         }
//         for (String i : set.keySet())
//         {
//             if (!set.get(i).equals(""))
//                 System.out.print(i);
//         }
//     }
// }

//infytq2

// class Samples
// {
//     public static void main(String[] args)
//     {
//         String s = "50678";
//         int n = s.length();
//         String no = "";
//         for (int i = 0; i < n; i++)
//         {
//             no+="1";
//         }
//         int num = Integer.parseInt(no, 2);
//         System.out.println(num);
//         for (int i = 1; i <= num; i++)
//         {
//             System.out.println(Integer.toBinaryString(i));
//         }
//     }
// }


// public class Samples {

//     public static void main(String[] args) {
//         int n=8;
//         int t=0,e=0,c=0;
//         while(e<=n){
//             e+=2;
//             c++;
//         }
//         System.out.println(c);
//     }
// }

