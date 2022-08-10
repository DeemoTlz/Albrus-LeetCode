//求解一个给定的方程，将x以字符串 "x=#value" 的形式返回。该方程仅包含 '+' ， '-' 操作，变量 x 和其对应系数。 
//
// 如果方程没有解，请返回 "No solution" 。如果方程有无限解，则返回 “Infinite solutions” 。 
//
// 题目保证，如果方程中只有一个解，则 'x' 的值是一个整数。 
//
// 
//
// 示例 1： 
//
// 
//输入: equation = "x+5-3+x=6+x-2"
//输出: "x=2"
// 
//
// 示例 2: 
//
// 
//输入: equation = "x=x"
//输出: "Infinite solutions"
// 
//
// 示例 3: 
//
// 
//输入: equation = "2x=x"
//输出: "x=0"
// 
//
// 
//
// 提示: 
//
// 
// 3 <= equation.length <= 1000 
// equation 只有一个 '='. 
// equation 方程由整数组成，其绝对值在 [0, 100] 范围内，不含前导零和变量 'x' 。 
// 
//
// Related Topics 数学 字符串 模拟 👍 160 👎 0


package com.deemo.leetcode.editor.cn;
public class SolveTheEquation{
    public static void main(String[] args) {
        Solution solution = new SolveTheEquation().new Solution();
        System.out.println(solution.solveEquation("x+5-3+x=6+x-2"));
        System.out.println(solution.solveEquation("x=x"));
        System.out.println(solution.solveEquation("2x=x"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String solveEquation(String equation) {
            // x 的系数
            int x = 0;
            // 整数
            int num = 0;
            // 操作符
            int op = 1;

            char[] chars = equation.toCharArray();
            int length = chars.length;
            for (int i = 0; i < length; ) {
                if (chars[i] == '+') {
                    op = 1;
                    i++;
                } else if (chars[i] == '-') {
                    op = -1;
                    i++;
                } else if (chars[i] == '=') {
                    // 反转方程式
                    x *= -1;
                    num *= -1;
                    i++;
                    // 还原为+
                    op = 1;
                } else {
                    // 取连续段
                    int j = i;
                    while (j < length && chars[j] != '+' && chars[j] != '-' && chars[j] != '=') {
                        j++;
                    }
                    if (chars[j - 1] == 'x') {
                        // 区分是 x 还是 nx
                        x += (i < j - 1 ? Integer.parseInt(equation.substring(i, j - 1)) : 1) * op;
                    } else {
                        num += Integer.parseInt(equation.substring(i, j)) * op;
                    }
                    i = j;
                }
            }

            if (x == 0) {
                return num == 0 ? "Infinite solutions" : "No solution";
            }

            // 去了一次 - ，需要还原
            return "x=" + (num / -x);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}