//给定整数 n 和 k，返回 [1, n] 中字典序第 k 小的数字。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 13, k = 2
//输出: 10
//解释: 字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
// 
//
// 示例 2: 
//
// 
//输入: n = 1, k = 1
//输出: 1
// 
//
// 
//
// 提示: 
//
// 
// 1 <= k <= n <= 10⁹ 
// 
// Related Topics 字典树 👍 416 👎 0


package com.deemo.leetcode;
public class KThSmallestInLexicographicalOrder{
    public static void main(String[] args) {
        Solution solution = new KThSmallestInLexicographicalOrder().new Solution();
        System.out.println(solution.findKthNumber(10, 3));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthNumber(int n, int k) {
            // 起始从 1xx 前缀开始找
            int curr = 1;
            // k 表示第几个，按 层级前缀 找每一级下有多少个
            while (k > 1) {
                // 找 curr 前缀层级下有多少个
                int steps = this.getSteps(curr, n);
                if (steps < k) {
                    // curr 前缀的个数比 k 小，因此不在当前前缀下，继续向后找下一个前缀
                    k -= steps;
                    // 此处 curr++ 是 1-9 的前缀包含所有数字
                    curr++;
                } else {
                    // 在这个前缀里面，一级一级往下找
                    curr *= 10;
                    k--;
                }
            }

            return curr;
        }

        /**
         * 获取 curr 前缀下在 [1, n] 中总共有多少个
         */
        private int getSteps(int curr, int n) {
            int steps = 0;
            long first = curr;
            long last = curr;

            while (first <= n) {
                steps += Math.min(last, n) - first + 1;
                first = first * 10;
                last = last * 10 + 9;
            }

            return steps;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}