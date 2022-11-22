//一个正整数如果能被 a 或 b 整除，那么它是神奇的。 
//
// 给定三个整数 n , a , b ，返回第 n 个神奇的数字。因为答案可能很大，所以返回答案 对 10⁹ + 7 取模 后的值。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：n = 1, a = 2, b = 3
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：n = 4, a = 2, b = 3
//输出：6
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁹ 
// 2 <= a, b <= 4 * 10⁴ 
// 
//
// 
//
// Related Topics 数学 二分查找 👍 184 👎 0


package com.deemo.leetcode.editor.cn;
public class NthMagicalNumber{
    public static void main(String[] args) {
        Solution solution = new NthMagicalNumber().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private static final long MOD = (long) 1e9 + 7;

        public int nthMagicalNumber(int n, int a, int b) {
            long lcm = a / gcd(a, b) * b;
            long left = 0, right = (long) Math.max(a, b) * n; // 开区间 (left, right)
            while (left + 1 < right) { // 开区间不为空
                long mid = left + (right - left) / 2;
                if (mid / a + mid / b - mid / lcm >= n)
                    right = mid; // 范围缩小到 (left, mid)
                else
                    left = mid; // 范围缩小到 (mid, right)
            }
            return (int) (right % MOD);
        }

        private int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}