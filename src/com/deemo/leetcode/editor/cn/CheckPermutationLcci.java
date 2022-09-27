//给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。 
//
// 示例 1： 
//
// 输入: s1 = "abc", s2 = "bca"
//输出: true 
// 
//
// 示例 2： 
//
// 输入: s1 = "abc", s2 = "bad"
//输出: false
// 
//
// 说明： 
//
// 
// 0 <= len(s1) <= 100 
// 0 <= len(s2) <= 100 
// 
//
// Related Topics 哈希表 字符串 排序 👍 129 👎 0


package com.deemo.leetcode.editor.cn;
public class CheckPermutationLcci{
    public static void main(String[] args) {
         Solution solution = new CheckPermutationLcci().new Solution();
        System.out.println(solution.CheckPermutation("abc", "cba"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean CheckPermutation2(String s1, String s2) {
            if (s1.length() != s2.length()) {
                return false;
            }
            int[] table = new int[128];
            for (int i = 0; i < s1.length(); i++) {
                table[s1.charAt(i)]++;
            }
            for (int i = 0; i < s2.length(); i++) {
                table[s2.charAt(i)]--;
                if (table[s2.charAt(i)] < 0) {
                    return false;
                }
            }
            return true;
        }
        public boolean CheckPermutation(String s1, String s2) {
            if (s1.length() != s2.length()) {
                return false;
            }
            int[] table = new int[128];
            int cnt = 0;
            for (int i = 0; i < s1.length(); i++) {
                if (++table[s1.charAt(i)] == 1) {
                    cnt++;
                }
                if (--table[s2.charAt(i)] == 0) {
                    cnt--;
                }
            }
            return cnt == 0;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}