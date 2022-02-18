package Arrays;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class StrArrToIntArr {

    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int arr[] = Stream.of(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println(Arrays.toString(arr));
    }
}
