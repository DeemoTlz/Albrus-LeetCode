//给出一个字符串数组 words 组成的一本英语词典。返回 words 中最长的一个单词，该单词是由 words 词典中其他单词逐步添加一个字母组成。 
//
// 若其中有多个可行的答案，则返回答案中字典序最小的单词。若无答案，则返回空字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["w","wo","wor","worl", "world"]
//输出："world"
//解释： 单词"world"可由"w", "wo", "wor", 和 "worl"逐步添加一个字母组成。
// 
//
// 示例 2： 
//
// 
//输入：words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
//输出："apple"
//解释："apply" 和 "apple" 都能由词典中的单词组成。但是 "apple" 的字典序小于 "apply" 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 1000 
// 1 <= words[i].length <= 30 
// 所有输入的字符串 words[i] 都只包含小写字母。 
// 
// Related Topics 字典树 数组 哈希表 字符串 排序 👍 280 👎 0


package com.deemo.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestWordInDictionary{
    public static void main(String[] args) {
        Solution solution = new LongestWordInDictionary().new Solution();
        System.out.println(solution.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestWord(String[] words) {
            // 先排序
            Arrays.sort(words, (a, b) -> {
                if (a.length() == b.length()) {
                    // 题目中说长度相同时返回字典序小的字符串，因此这里使用 b.compareTo(a)，后续循环遍历时便可以不再判断长度
                    return b.compareTo(a);
                }

                return a.length() - b.length();
            });

            String longest = "";
            Set<String> suffix = new HashSet<>();
            suffix.add("");
            for (String word : words) {
                if (suffix.contains(word.substring(0, word.length() - 1))) {
                    suffix.add(word);
                    // 前面已排序，因此符合条件时无需再判断
                    // if (longest.length() < word.length()) {
                        longest = word;
                    // }
                }
            }

            return longest;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}