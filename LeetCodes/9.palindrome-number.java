/*
 * @lc app=leetcode id=9 lang=java
 *
 * [9] Palindrome Number
 */

// @lc code=start
class Solution3 {
    public boolean isPalindrome(int x) {
        String a=x+"";
        int j=a.length()-1;
        for(int i=0;i<a.length()/2;i++)
        {
            if(a.charAt(i)!=a.charAt(j))
                return false;
            j--;
        }
        return true;
    }
}
// @lc code=end

