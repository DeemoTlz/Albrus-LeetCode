//给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。 
//
// 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。 
//
// 给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。 
//
// 
//
// 示例： 
//
// 
//输入：[[1,2], [2,3], [3,4]]
//输出：2
//解释：最长的数对链是 [1,2] -> [3,4]
// 
//
// 
//
// 提示： 
//
// 
// 给出数对的个数在 [1, 1000] 范围内。 
// 
//
// Related Topics 贪心 数组 动态规划 排序 👍 287 👎 0


package com.deemo.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumLengthOfPairChain{
    public static void main(String[] args) {
        Solution solution = new MaximumLengthOfPairChain().new Solution();
        System.out.println(solution.findLongestChain(new int[][]{{1,2}, {2,3}, {3,4}}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 动态规划
         */
        public int findLongestChain2(int[][] pairs) {
            int n = pairs.length;
            Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));
            int[] dp = new int[n];
            Arrays.fill(dp, 1);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (pairs[j][1] < pairs[i][0]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }

            return dp[n - 1];
        }

        /**
         * <a href="https://leetcode.cn/problems/maximum-length-of-pair-chain/solution/by-muse-77-nyv6/">贪心</a>
         */
        public int findLongestChain(int[][] pairs) {
            int result = 0;
            int cur = Integer.MIN_VALUE;
            // 按尾元素排序
            Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));

            for (int[] pair : pairs) {
                if (cur < pair[0]) {
                    cur = pair[1];
                    result++;
                }
            }

            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}