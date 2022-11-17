//给定字符串 s 和字符串数组 words, 返回 words[i] 中是s的子序列的单词个数 。 
//
// 字符串的 子序列 是从原始字符串中生成的新字符串，可以从中删去一些字符(可以是none)，而不改变其余字符的相对顺序。 
//
// 
// 例如， “ace” 是 “abcde” 的子序列。 
// 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcde", words = ["a","bb","acd","ace"]
//输出: 3
//解释: 有三个是 s 的子序列的单词: "a", "acd", "ace"。
// 
//
// Example 2: 
//
// 
//输入: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 5 * 10⁴ 
// 1 <= words.length <= 5000 
// 1 <= words[i].length <= 50 
// words[i]和 s 都只由小写字母组成。 
// 
//
//
// Related Topics 字典树 哈希表 字符串 排序 👍 326 👎 0


package com.deemo.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberOfMatchingSubsequences{
    public static void main(String[] args) {
        Solution solution = new NumberOfMatchingSubsequences().new Solution();
        System.out.println(solution.numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numMatchingSubseq(String s, String[] words) {
            List<Integer>[] marks = new ArrayList[26];
            char[] chars = s.toCharArray();

            // 预处理 原字符串 所有字符的位置
            List<Integer> mark;
            for (int i = 0; i < chars.length; i++) {
                if ((mark = marks[chars[i] - 'a']) == null) {
                    mark = new ArrayList<>();
                    marks[chars[i] - 'a'] = mark;
                }
                mark.add(i);
            }

            int ans = words.length;
            for (String word : words) {
                int compareIndex = -1, index;
                for (int i = 0; i < word.length(); i++) {
                    mark = marks[word.charAt(i) - 'a'];
                    if (mark == null || (index = this.findCharIndex(compareIndex, mark)) <= compareIndex) {
                        ans--;
                        break;
                    }
                    compareIndex = index;
                }
            }

            return ans;
        }

        /*private int findCharIndex(int compareIndex, List<Integer> mark) {
            for (Integer m : mark) {
                if (m > compareIndex) {
                    return m;
                }
            }

            return -1;
        }*/

        // 折半查找
        private int findCharIndex(int compareIndex, List<Integer> list) {
            int head = 0, tail = list.size() - 1, mid;
            while (head < tail) {
                mid = head + (tail - head) / 2;
                if (list.get(mid) > compareIndex) tail = mid;
                else head = ++mid;
            }
            return list.get(head);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}