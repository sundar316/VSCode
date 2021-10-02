package LeetCodes;

import java.util.HashSet;

/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        HashSet<Character> HS=new HashSet<>();
        for(int i=0;i<s.length();i++)
        {
            HS.add(s.charAt(i));
        }
        System.out.print(HS);
        if((HS.size()*2)!=(s.length()))
            return true;
        return false;
    }
}
// @lc code=end

