package LeetCode;

public class RomanToInt {

/*
    input : MDCCCLXXXIV
    output: 1884
*/
    public static void main(String[] args) {
        System.out.println(romanToInt("MDCCCLXXXIV"));
    }
    public static int romanToInt(String s) {
        int n = s.length();
        int res = 0;
        while (n-- > 0) {
            int temp = n-1;
            if (s.charAt(n) == 'I') res += 1;
            else if (s.charAt(n) == 'V') {
                if (n > 0 && s.charAt(temp) == 'I') {
                    res += 4;
                    n--;
                } else {
                    res += 5;
                }
            }
            else if (s.charAt(n) == 'X') {
                if (n > 0 && s.charAt(temp) == 'I') {
                    res += 9;
                    n--;
                } else {
                    res += 10;
                }
            }
            else if (s.charAt(n) == 'L') {
                if (n > 0 && s.charAt(temp) == 'X') {
                    res += 40;
                    n--;
                } else {
                    res += 50;
                }
            }
            else if (s.charAt(n) == 'C') {
                if (n > 0 && s.charAt(temp) == 'X') {
                    res += 90;
                    n--;
                } else {
                    res += 100;
                }
            }
            else if (s.charAt(n) == 'D') {
                if (n > 0 && s.charAt(temp) == 'C') {
                    res += 400;
                    n--;
                } else {
                    res += 500;
                }
            }
            else {
                if (n > 0 && s.charAt(temp) == 'C') {
                    res += 900;
                    n--;
                } else {
                    res += 1000;
                }
            }
        }
        return res;
    }
}
