//给定数组 nums 和一个整数 k 。我们将给定的数组 nums 分成 最多 k 个相邻的非空子数组 。 分数 由每个子数组内的平均值的总和构成。 
//
// 注意我们必须使用 nums 数组中的每一个数进行分组，并且分数不一定需要是整数。 
//
// 返回我们所能得到的最大 分数 是多少。答案误差在 10⁻⁶ 内被视为是正确的。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [9,1,2,3,9], k = 3
//输出: 20.00000
//解释: 
//nums 的最优分组是[9], [1, 2, 3], [9]. 得到的分数是 9 + (1 + 2 + 3) / 3 + 9 = 20. 
//我们也可以把 nums 分成[9, 1], [2], [3, 9]. 
//这样的分组得到的分数为 5 + 2 + 6 = 13, 但不是最大值.
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,2,3,4,5,6,7], k = 4
//输出: 20.50000
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 100 
// 1 <= nums[i] <= 10⁴ 
// 1 <= k <= nums.length 
// 
//
// Related Topics 数组 动态规划 前缀和 👍 325 👎 0


package com.deemo.leetcode.editor.cn;
public class LargestSumOfAverages{
    public static void main(String[] args) {
        Solution solution = new LargestSumOfAverages().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double largestSumOfAverages(int[] nums, int m) {
            int n = nums.length;
            double[] sum = new double[n + 10];
            for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + nums[i - 1];
            double[][] f = new double[n + 10][m + 10];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= Math.min(i, m); j++) {
                    if (j == 1) {
                        f[i][1] = sum[i] / i;
                    } else {
                        for (int k = 2; k <= i; k++) {
                            f[i][j] = Math.max(f[i][j], f[k - 1][j - 1] + (sum[i] - sum[k - 1]) / (i - k + 1));
                        }
                    }
                }
            }
            return f[n][m];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}