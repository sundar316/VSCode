package Interview;

import java.util.*;

public class PreSmallerEle {

	/*
	input:2, 1, 4, 9, 7, 8
	output:-1, -1, 1, 4, 4, 7
	*/

  	static private Scanner sc = new Scanner(System.in);
	static List<Integer> list = new ArrayList<>();
	public static void main (String[] args) {
		String str[] = sc.nextLine().replace(" ","").split(",");
		int arr[] = new int[str.length];
		for (int i = 0; i < str.length; i++) {
			arr[i] = Integer.valueOf(str[i]);
		}
		pevValue(arr);
		System.out.println(list);
    }

	private static void pevValue(int[] arr) {
		Stack<Integer> stack= new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			while (!stack.empty() && arr[i] < stack.peek()) {
				stack.pop();
			}
			if (stack.empty()) {
				list.add(-1);
			} else if (arr[i] > stack.peek()) {
				list.add(stack.peek());
			}
			stack.add(arr[i]);
		}
	}
}