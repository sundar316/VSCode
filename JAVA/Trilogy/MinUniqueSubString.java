package Trilogy;

//method 1

// import java.util.ArrayList;
// import java.util.List;

// public class MinUniqueSubString {
//     public static void main(String[] args) {
//         String str = "aaabcc";
//         String res = "";
//         List<String> li = new ArrayList<>();
//         for (int i = 0; i < str.length(); i++) {
//             if (!res.contains(str.charAt(i)+"")) {
//                 res += str.charAt(i);
//             }
//         }
//         int len = res.length();
//         for (int i = 0; i < str.length()-len; i++) {
//             for (int j = len+i; j <= str.length(); j++) {
//                 String val = str.substring(i, j);
//                 int l = 0;
//                 for (int k = 0; k < val.length() && l < res.length(); k++) {
//                     if (val.charAt(k) == res.charAt(l)) {
//                         l++;
//                     }
//                 }
//                 if (res.length() == l) {
//                     li.add(val);
//                 }
//             }
//         }
//         String sml = li.get(0);
//         for (int i = 1; i < li.size(); i++) {
//             if (sml.length() > li.get(i).length()) {
//                 sml = li.get(i);
//             }
//         }
//         System.out.println(sml);
//     }
// }

// method 2

public class MinUniqueSubString {

    public static void main(String[] args) {
        String str = "aabcdd";
        String uni = "";
        for (int i = 0; i < str.length(); i++) {
            if (!uni.contains(str.charAt(i)+"")) uni += str.charAt(i);
        }
        int siz = uni.length();
    }
}
