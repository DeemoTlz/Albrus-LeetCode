//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 7249 👎 0


package com.deemo.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters{
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int right = 0, ans = 0;

        /*Set<Character> occ = new HashSet<>();
        for (int left = 0; left < s.length(); left++) {
            // 移除首字符
            if (left != 0) {
                occ.remove(s.charAt(left - 1));
            }
            while (right < s.length() && !occ.contains(s.charAt(right))) {
                occ.add(s.charAt(right));
                ans = Math.max(ans, right++ - left + 1);
            }
        }*/

        Map<Character, Integer> map = new HashMap<>();
        char c;
        int start = 0;
        for (int left = 0; left < s.length(); left++) {
            c = s.charAt(left);

            if (map.containsKey(c)) {
                // map.get(c) + 1 从重复字符的下一个开始计数
                start = Math.max(start, map.get(c) + 1);
            }

            ans = Math.max(ans, left - start + 1);
            map.put(c, left);
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}