package LeetCode;

import java.util.Arrays;

public class RemDupliFrSortArr {

    /*
        input : [0,0,1,1,1,2,2,3,3,4]
        output: 5, [0,1,2,3,4,_,_,_,_,_]
    */
    public static void main(String[] args) {
        int arr[] = {0,0,1,1,1,2,2,3,3,4};
        int temp = 0;
        boolean flag = true;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i-1] == arr[i]) {
                if (flag) {
                    temp = i;
                    flag = false;
                    continue;
                }
            } else {
                flag = true;
                arr[temp] = arr[i];
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
