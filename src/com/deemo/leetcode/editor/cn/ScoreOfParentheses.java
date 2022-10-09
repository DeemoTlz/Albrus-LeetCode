//给定一个平衡括号字符串 S，按下述规则计算该字符串的分数： 
//
// 
// () 得 1 分。 
// AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。 
// (A) 得 2 * A 分，其中 A 是平衡括号字符串。 
// 
//
// 
//
// 示例 1： 
//
// 输入： "()"
//输出： 1
// 
//
// 示例 2： 
//
// 输入： "(())"
//输出： 2
// 
//
// 示例 3： 
//
// 输入： "()()"
//输出： 2
// 
//
// 示例 4： 
//
// 输入： "(()(()))"
//输出： 6
// 
//
// 
//
// 提示： 
//
// 
// S 是平衡括号字符串，且只含有 ( 和 ) 。 
// 2 <= S.length <= 50 
// 
//
// Related Topics 栈 字符串 👍 421 👎 0


package com.deemo.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class ScoreOfParentheses{
    public static void main(String[] args) {
        Solution solution = new ScoreOfParentheses().new Solution();
        System.out.println(solution.scoreOfParentheses("()"));
        System.out.println(solution.scoreOfParentheses("(())"));
        System.out.println(solution.scoreOfParentheses("()()"));
        System.out.println(solution.scoreOfParentheses("(()(()))"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int scoreOfParentheses(String s) {
            Deque<Character> deque = new LinkedList<>();

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    deque.addLast('(');
                } else {
                    Character c = deque.removeLast();
                    if (c == '(') {
                        deque.addLast('1');
                    } else {
                        int sum = c - '0';
                        while ((c = deque.removeLast()) != '(') {
                            sum += c - '0';
                        }
                        deque.addLast((char) ((sum << 1) + '0'));
                    }
                }
            }

            int ans = 0;
            while (!deque.isEmpty()) {
                ans += deque.removeLast() - '0';
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}