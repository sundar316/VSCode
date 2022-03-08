package InfyTq;

import java.util.Arrays;
import java.util.Scanner;

public class py_NextSmallIntNotInArr {

    private static boolean isAvailable(int n, int[] nrr, int i, int temp, int count, int ind) {
        if (i >= 0) {
            if (n == 0) {
                return true;
            }
            if (n >= nrr[i]) {
                n -= nrr[i];
                if (isAvailable(n, nrr, i, temp, count, ind)) return true;
            } else {
                if (isAvailable(n, nrr, --i, temp, count, ind)) return true;
            }
        }
        if (count < nrr.length) {
            if (isAvailable(temp, nrr, --ind, temp, count++, ind)) return true;
        }
        return false;
    }

    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String arr[] = sc.nextLine().split(" ");
        int nrr[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nrr[i] = Integer.parseInt(arr[i]);
        }

        Arrays.sort(nrr);
        for (int i = nrr[nrr.length-1]+1; i < nrr[nrr.length-1]*2; i++) {
            if (isAvailable(i, nrr, nrr.length-1, i, 1, nrr.length-1)) {
                // System.out.println(i);
                continue;
            } else {
                System.out.println(i);
                break;
            }
        }

    }
}
