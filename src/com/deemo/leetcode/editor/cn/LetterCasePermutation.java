//给定一个字符串 s ，通过将字符串 s 中的每个字母转变大小写，我们可以获得一个新的字符串。 
//
// 返回 所有可能得到的字符串集合 。以 任意顺序 返回输出。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "a1b2"
//输出：["a1b2", "a1B2", "A1b2", "A1B2"]
// 
//
// 示例 2: 
//
// 
//输入: s = "3z4"
//输出: ["3z4","3Z4"]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 12 
// s 由小写英文字母、大写英文字母和数字组成 
// 
//
// Related Topics 位运算 字符串 回溯 👍 468 👎 0


package com.deemo.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class LetterCasePermutation{
    public static void main(String[] args) {
        Solution solution = new LetterCasePermutation().new Solution();
        System.out.println(solution.letterCasePermutation("a1b2"));
        System.out.println(solution.letterCasePermutation("3z4"));
        System.out.println(solution.letterCasePermutation("a1b2c3"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> letterCasePermutation(String s) {
            char[] chars = s.toCharArray();
            List<String> ans = new LinkedList<>();
            dfs(chars, 0, ans);

            return ans;
        }

        private void dfs(char[] chars, int index, List<String> ans) {
            if (index == chars.length) {
                ans.add(new String(chars));
                return ;
            }

            dfs(chars, index + 1, ans);
            if (Character.isLetter(chars[index])) {
                chars[index] ^= ' ';
                dfs(chars, index + 1, ans);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}