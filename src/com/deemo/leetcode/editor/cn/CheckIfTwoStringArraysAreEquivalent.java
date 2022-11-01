//给你两个字符串数组 word1 和 word2 。如果两个数组表示的字符串相同，返回 true ；否则，返回 false 。 
//
// 数组表示的字符串 是由数组中的所有元素 按顺序 连接形成的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：word1 = ["ab", "c"], word2 = ["a", "bc"]
//输出：true
//解释：
//word1 表示的字符串为 "ab" + "c" -> "abc"
//word2 表示的字符串为 "a" + "bc" -> "abc"
//两个字符串相同，返回 true 
//
// 示例 2： 
//
// 
//输入：word1 = ["a", "cb"], word2 = ["ab", "c"]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word1.length, word2.length <= 10³ 
// 1 <= word1[i].length, word2[i].length <= 10³ 
// 1 <= sum(word1[i].length), sum(word2[i].length) <= 10³ 
// word1[i] 和 word2[i] 由小写字母组成 
// 
//
// Related Topics 数组 字符串 👍 74 👎 0


package com.deemo.leetcode.editor.cn;
public class CheckIfTwoStringArraysAreEquivalent{
    public static void main(String[] args) {
        Solution solution = new CheckIfTwoStringArraysAreEquivalent().new Solution();
        System.out.println(solution.arrayStringsAreEqual(new String[]{"ab", "c"}, new String[]{"a", "bc"}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
            int m = word1.length, n = word2.length;
            // 第 n 个单词
            int p = 0, q = 0;
            // 每个单词的第 n 个字符
            int i = 0, j = 0;
            while (p < m && q < n) {
                String w1 = word1[p];
                String w2 = word2[q];

                if (w1.charAt(i++) != w2.charAt(j++)) {
                    return false;
                }

                if (i == w1.length()) {
                    ++p;
                    i = 0;
                }
                if (j == w2.length()) {
                    ++q;
                    j = 0;
                }
            }

            return p == m && q == n;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}