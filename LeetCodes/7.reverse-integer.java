/*
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 */

// @lc code=start
class Solution1 {
    public int reverse(int x) {
        String s=x+"";
        boolean flag=false;
        int b=0;
        for(int i=s.length()-1;i>-1;i--)
        {
            if(s.charAt(0)=='-')
            {
                flag=true;
                break;
            }
            int a=Integer.parseInt(s.charAt(i)+"");
            a*=10;
        }
    }
}
// @lc code=end

