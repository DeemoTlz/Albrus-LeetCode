//对于某些非负整数 k ，如果交换 s1 中两个字母的位置恰好 k 次，能够使结果字符串等于 s2 ，则认为字符串 s1 和 s2 的 相似度为 k 。 
//
// 给你两个字母异位词 s1 和 s2 ，返回 s1 和 s2 的相似度 k 的最小值。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "ab", s2 = "ba"
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：s1 = "abc", s2 = "bca"
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length <= 20 
// s2.length == s1.length 
// s1 和 s2 只包含集合 {'a', 'b', 'c', 'd', 'e', 'f'} 中的小写字母 
// s2 是 s1 的一个字母异位词 
// 
//
// Related Topics 广度优先搜索 字符串 👍 235 👎 0


package com.deemo.leetcode.editor.cn;
public class KSimilarStrings{
    public static void main(String[] args) {
         Solution solution = new KSimilarStrings().new Solution();
         System.out.println(solution.kSimilarity("ab", "ba"));
         System.out.println(solution.kSimilarity("abc", "bca"));
         System.out.println(solution.kSimilarity("bccaba", "abacbc"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int ans = Integer.MAX_VALUE;
        public int kSimilarity(String s1, String s2) {
            ans = Integer.MAX_VALUE;
            return this.execute(s1.toCharArray(), s2.toCharArray(), 0, 0);
        }

        private int execute(char[] s1, char[] s2, int start, int curr) {
            // 结束条件
            if (curr > ans) {
                return ans;
            }
            if (start == s1.length - 1) {
                return ans = curr;
            }

            // 递归、回溯
            for (int i = start; i < s1.length; i++) {
                if (s1[i] != s2[i]) {
                    for (int j = i + 1; j < s2.length; j++) {
                        if (s2[j] == s1[i] && s2[j] != s1[j]) {
                            this.swap(s2, i, j);
                            this.execute(s1, s2, i + 1, curr + 1);
                            this.swap(s2, i, j);

                            // 如果 s1 和 s2 的 i 位与 j 位互为相等，那么就是最优交换
                            if (s2[i] == s1[j]) {
                                break;
                            }
                        }
                    }

                    // 里面都回溯遍历完、这里直接返回结果，否则递归出去，ans == curr 恒为 0
                    return ans;
                }
            }

            // 这里仍然取最小值，防止两个相同的字符串
            return ans = curr;
        }

        private void swap(char[] s, int i, int j) {
            char c = s[i];
            s[i] = s[j];
            s[j] = c;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}