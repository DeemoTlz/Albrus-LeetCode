//给你一个字符串 sentence 作为句子并指定检索词为 searchWord ，其中句子由若干用 单个空格 分隔的单词组成。请你检查检索词 
//searchWord 是否为句子 sentence 中任意单词的前缀。 
//
// 如果 searchWord 是某一个单词的前缀，则返回句子 sentence 中该单词所对应的下标（下标从 1 开始）。如果 searchWord 是多个
//单词的前缀，则返回匹配的第一个单词的下标（最小下标）。如果 searchWord 不是任何单词的前缀，则返回 -1 。 
//
// 字符串 s 的 前缀 是 s 的任何前导连续子字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：sentence = "i love eating burger", searchWord = "burg"
//输出：4
//解释："burg" 是 "burger" 的前缀，而 "burger" 是句子中第 4 个单词。 
//
// 示例 2： 
//
// 
//输入：sentence = "this problem is an easy problem", searchWord = "pro"
//输出：2
//解释："pro" 是 "problem" 的前缀，而 "problem" 是句子中第 2 个也是第 6 个单词，但是应该返回最小下标 2 。
// 
//
// 示例 3： 
//
// 
//输入：sentence = "i am tired", searchWord = "you"
//输出：-1
//解释："you" 不是句子中任何单词的前缀。
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= sentence.length <= 100 
// 1 <= searchWord.length <= 10 
// sentence 由小写英文字母和空格组成。 
// searchWord 由小写英文字母组成。 
// 
//
// Related Topics 字符串 字符串匹配 👍 68 👎 0


package com.deemo.leetcode.editor.cn;
public class CheckIfAWordOccursAsAPrefixOfAnyWordInASentence{
    public static void main(String[] args) {
        Solution solution = new CheckIfAWordOccursAsAPrefixOfAnyWordInASentence().new Solution();
        System.out.println(solution.isPrefixOfWord("i love eating burger", "burg"));
        System.out.println(solution.isPrefixOfWord("this problem is an easy problem", "pro"));
        System.out.println(solution.isPrefixOfWord("this problem is an easy problem", "albrus"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int isPrefixOfWord(String sentence, String searchWord) {
            int idx = 0;
            int b = 0;
            int n = sentence.length();

            for (int i = 0; i < n; i++) {
                while (i < n && sentence.charAt(i) != ' ') {
                    i++;
                }

                idx++;
                if (sentence.substring(b, i).startsWith(searchWord)) {
                    return idx;
                }

                b = i + 1;
            }

            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}