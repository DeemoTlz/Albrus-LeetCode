//给你一个整数 n ，统计并返回各位数字都不同的数字 x 的个数，其中 0 <= x < 10ⁿ 。
//
//
//
//
// 示例 1：
//
//
//输入：n = 2
//输出：91
//解释：答案应为除去 11、22、33、44、55、66、77、88、99 外，在 0 ≤ x < 100 范围内的所有数字。
//
//
// 示例 2：
//
//
//输入：n = 0
//输出：1
//
//
//
//
//
//
// 提示：
//
//
// 0 <= n <= 8
//
// Related Topics 数学 动态规划 回溯 👍 255 👎 0


package com.deemo.leetcode.editor.cn;
public class CountNumbersWithUniqueDigits{
    public static void main(String[] args) {
        Solution solution = new CountNumbersWithUniqueDigits().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countNumbersWithUniqueDigits(int n) {
            if (n == 0) {
                return 1;
            }

            int ans = 10, cur;
            for (int i = 2, last = 9; i <= n; i++) {
                cur = last * (10 - i + 1);
                ans += cur;
                last = cur;
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}