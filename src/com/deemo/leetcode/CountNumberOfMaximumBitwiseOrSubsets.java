package com.deemo.leetcode;

public class CountNumberOfMaximumBitwiseOrSubsets {
    public static void main(String[] args) {
        Solution solution = new CountNumberOfMaximumBitwiseOrSubsets().new Solution();
        System.out.println(solution.countMaxOrSubsets(new int[]{3,2,1,5}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    // /**
    //  * 暴力
    //  */
    // class Solution {
    //     public int countMaxOrSubsets(int[] nums) {
    //         int n = nums.length;
    //         int max = 0;
    //         // 所有元素都按位或起来一定是最大值
    //         for (int num : nums) {
    //             max |= num;
    //         }
    //
    //         int ans = 0, or;
    //         // 规定 nums 最大长度是16，而子集的特性在于可选可不选，因此可以使用 1 << nums.length 中的 按位 0/1 表示是否选择进行组合子集
    //         for (int mask = 0; mask < (1 << n); mask++) {
    //             or = 0;
    //             for (int i = 0; i < n; i++) {
    //                 if (((mask >> i) & 1) == 1) {
    //                     // 为 1 时表示需要选择
    //                     or |= nums[i];
    //                 }
    //             }
    //
    //             if (or == max) {
    //                 ans++;
    //             }
    //         }
    //
    //         return ans;
    //     }
    // }

    // /**
    //  * DFS
    //  */
    // class Solution {
    //     int ans = 0;
    //
    //     public int countMaxOrSubsets(int[] nums) {
    //         int max = 0;
    //         // 所有元素都按位或起来一定是最大值
    //         for (int num : nums) {
    //             max |= num;
    //         }
    //
    //         // DFS 在每个位置都计算出所有结果（选或不选）
    //         dfs(nums, 0, 0, max);
    //
    //         return ans;
    //     }
    //
    //     private void dfs(int[] nums, int i, int or, int max) {
    //         // 推出递归标识：最后一个元素（等于length是因为上一次递归是最后一个元素）
    //         if (i == nums.length) {
    //             if (or == max) {
    //                 ans++;
    //             }
    //             return;
    //         }
    //
    //         // 不选
    //         dfs(nums, i + 1, or, max);
    //         // 状态恢复，Java不需要
    //         // 选
    //         dfs(nums, i + 1, or | nums[i], max);
    //         // 状态恢复，Java不需要
    //     }
    // }

    /**
     * DFS 优化
     */
    class Solution {
        int ans = 0;

        public int countMaxOrSubsets(int[] nums) {
            int max = 0;
            // 所有元素都按位或起来一定是最大值
            for (int num : nums) {
                max |= num;
            }

            // DFS 在每个位置都计算出所有结果（选或不选）
            dfs(nums, 0, 0, max);

            return ans;
        }

        private void dfs(int[] nums, int i, int or, int max) {
            if (or == max) {
                // 在 DFS 方案上，如果已经得到最大值，那么后续的元素不管选不选，一定都是最大值，直接累计即可（但考虑最坏情况，时间复杂度并没有减少，只是多了一些剪枝）
                ans += 1 << (nums.length - i);
                return;
            }

            // 推出递归标识：最后一个元素（等于length是因为上一次递归是最后一个元素）
            if (i == nums.length) {
                return;
            }

            // 不选
            dfs(nums, i + 1, or, max);
            // 状态恢复，Java不需要
            // 选
            dfs(nums, i + 1, or | nums[i], max);
            // 状态恢复，Java不需要
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
