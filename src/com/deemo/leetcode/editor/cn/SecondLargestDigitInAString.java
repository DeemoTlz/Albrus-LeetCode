//给你一个混合字符串 s ，请你返回 s 中 第二大 的数字，如果不存在第二大的数字，请你返回 -1 。 
//
// 混合字符串 由小写英文字母和数字组成。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "dfa12321afd"
//输出：2
//解释：出现在 s 中的数字包括 [1, 2, 3] 。第二大的数字是 2 。
// 
//
// 示例 2： 
//
// 
//输入：s = "abc1111"
//输出：-1
//解释：出现在 s 中的数字只包含 [1] 。没有第二大的数字。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 500 
// s 只包含小写英文字母和（或）数字。 
// 
//
// Related Topics 哈希表 字符串 👍 38 👎 0


package com.deemo.leetcode.editor.cn;
public class SecondLargestDigitInAString{
    public static void main(String[] args) {
        Solution solution = new SecondLargestDigitInAString().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int secondHighest(String s) {
            int mask = 0;
            for (int i = 0; i < s.length(); ++i) {
                char c = s.charAt(i);
                if (Character.isDigit(c)) {
                    mask |= 1 << (c - '0');
                }
            }
            for (int i = 9, cnt = 0; i >= 0; --i) {
                if (((mask >> i) & 1) == 1 && ++cnt == 2) {
                    return i;
                }
            }
            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}