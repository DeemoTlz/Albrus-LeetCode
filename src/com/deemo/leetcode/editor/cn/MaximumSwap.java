//给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。 
//
// 示例 1 : 
//
// 
//输入: 2736
//输出: 7236
//解释: 交换数字2和数字7。
// 
//
// 示例 2 : 
//
// 
//输入: 9973
//输出: 9973
//解释: 不需要交换。
// 
//
// 注意: 
//
// 
// 给定数字的范围是 [0, 10⁸] 
// 
//
// Related Topics 贪心 数学 👍 347 👎 0


package com.deemo.leetcode.editor.cn;
public class MaximumSwap{
    public static void main(String[] args) {
        Solution solution = new MaximumSwap().new Solution();
        System.out.println(solution.maximumSwap(2736));
        System.out.println(solution.maximumSwap(9973));
        System.out.println(solution.maximumSwap(22341345));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumSwap(int num) {
            char[] chars = Integer.toString(num).toCharArray();
            int n = chars.length;
            int[] maxIndexes = new int[n];
            maxIndexes[n - 1] = n - 1;
            for (int i = n - 2; i >= 0; i--) {
                maxIndexes[i] = chars[i] > chars[maxIndexes[i + 1]] ? i : maxIndexes[i + 1];
            }

            for (int i = 0; i < n; i++) {
                if (chars[i] != chars[maxIndexes[i]]) {
                    char temp = chars[i];
                    chars[i] = chars[maxIndexes[i]];
                    chars[maxIndexes[i]] = temp;
                    break;
                }
            }

            return Integer.parseInt(new String(chars));
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}