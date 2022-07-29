package Samples;
import java.util.*;
// import java.util.ArrayList;
// // import java.util.Collections;
// // import java.util.HashMap;
// // import java.util.Map;
// import java.util.List;
// import java.util.Scanner;

// public class AllInOne {

//     private static Scanner sc = new Scanner(System.in);
//     // public static void main(String[] args) {
//     //     if (sc.nextInt() % 2 == 0) {
//     //         System.out.println("Even");
//     //     } else {
//     //         System.out.println("Odd");
//     //     }
//     // }


//     private static List<Integer> arr = new ArrayList<>();
//     private static boolean isPrime(int n) {
//         if (n == 2) {
//             return true;
//         }
//         for (int i = 2; i <= Math.sqrt(n); i++) {
//             if (n % i == 0) {
//                 return false;
//             }
//         }
//         return true;
//     }
//     public static void main(String[] args) {
//         int n = sc.nextInt();
//         int i = 2;
//         while (arr.size() < n) {
//             if (isPrime(i)) {
//                 arr.add(i);
//             }
//             i++;
//         }
//         System.out.println(arr);
//     }
// }

// public class AllInOne {

//     public static int findRoomNo(int a1[],int a2[],int a3[],int n) {
//         int b[] = new int[n];
//         for (int i = 0; i < b.length; i++) {
//             b[i] = a1[i] + a2[i] +a3[i];
//         }
//         int j = 0, t = 0;
//         for (int i = 0 ; i < n; i++) {
//             if (j == 3) {
//                 j = 0;
//             }
//             if (j == 0) {
//                 t += a1[(b[i]-1)%n];
//             }
//             if (j == 1) {
//                 t += a2[(b[i]-1)%n];
//             }
//             if (j == 2) {
//                 t += a3[(b[i]-1)%n];
//             }
//             j++;
//         }
//         return t;
//     }

//     public static void main(String[] args) {
//         System.out.println(Arrays.toString(args));
//         int a1[] = {1,2,3,4,5};
//         int a2[] = {1,2,3,4,5};
//         int a3[] = {1,2,3,4,5};
//         // System.out.println(findRoomNo(a1,a2,a3,5));
//         List<Integer> li = new ArrayList<>();
//     }
// }

// class ATM{
//     private int balance = 10000;
//     public void setBalance(int balance){
//         this.balance = balance;
//     }
//     public int getBalance(){
//         return balance;
//     }
// }

// class User{
//     public static void main(String[] args) {
//         ATM a = new ATM();
//         System.out.println(a.getBalance());
//         a.setBalance(5000);
//         System.out.println(a.getBalance());
//     }
//}

public class AllInOne{
    public static void main(String[] args) {
        System.out.println("Hello");
    }
}

