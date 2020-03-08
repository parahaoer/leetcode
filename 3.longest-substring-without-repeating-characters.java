import java.util.*;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        Set<Character> set = new HashSet();
        int front=0, rear = 0;
        int res = 0;
        while(front < len) {
            if(! set.contains(s.charAt(front))) {
                set.add(s.charAt(front++));
            } else {
                set.remove(s.charAt(rear++));
            }
            res = Math.max(res, front-rear);
        }
        return res;
    }
}
// @lc code=end

