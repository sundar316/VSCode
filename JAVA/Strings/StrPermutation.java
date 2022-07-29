package Strings;

import java.util.Scanner;

// class Permutation {
//     static Scanner sc = new Scanner(System.in);
// 	static boolean flag = true;
// 	public static void main(String[] args) {
// 		String str = sc.nextLine();
// 		String str1 = sc.nextLine();
// 		int n = str.length();
// 		Permutation permutation = new Permutation();
// 		permutation.permute(str, 0, n-1, str1);
// 		if (flag) {
// 			System.out.println("no");
// 		}
// 	}
// 	private void permute(String str, int l, int r, String str1) {
// 		if (l == r) {
// 			if (str.equals(str1)) {
// 				System.out.println("yes");
// 				flag = false;
// 			}
// 		}
// 		else {
// 			for (int i = l; i <= r; i++) {
// 				str = swap(str,l,i);
// 				permute(str, l+1, r, str1);
// 				str = swap(str,l,i);
// 			}
// 		}
// 	}
// 	public String swap(String a, int i, int j) {
// 		char temp;
// 		char[] charArray = a.toCharArray();
// 		temp = charArray[i] ;
// 		charArray[i] = charArray[j];
// 		charArray[j] = temp;
// 		return String.valueOf(charArray);
// 	}

// }

class LIS {
	static Scanner sc = new Scanner(System.in);
	static int max_ref;
	static int _lis(int arr[], int n) {
		if (n == 1)
			return 1;
		int res, max_ending_here = 1;
		for (int i = 1; i < n; i++) {
			res = _lis(arr, i);
			if (arr[i - 1] < arr[n - 1]
				&& res + 1 > max_ending_here)
				max_ending_here = res + 1;
		}
		if (max_ref < max_ending_here)
			max_ref = max_ending_here;
		return max_ending_here;
	}
	static int lis(int arr[], int n) {
		max_ref = 1;
		_lis(arr, n);
		return max_ref;
	}
	public static void main(String args[]) {
		int m = sc.nextInt();
		int arr[] = new int[m];
		for (int i = 0; i < m; i++) {
			arr[i] = sc.nextInt();
		}
		int n = arr.length;
		System.out.println(lis(arr, n));
	}
}
