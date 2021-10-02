/*
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 */

// @lc code=start
class Solution1 {
    public int reverse(int x) {
        int a=0;
        while(x>0)
        {
            int b=x%10;
            a+=b;
            a*=10;
            x/=10;
        }
        return a;
    }
}
// @lc code=end

