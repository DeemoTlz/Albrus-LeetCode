//给定一个整数数组 nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。 
//
// 
//
// 示例 1： 
//
// 
//输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
//输出： True
//说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。 
//
// 示例 2: 
//
// 
//输入: nums = [1,2,3,4], k = 3
//输出: false 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= len(nums) <= 16 
// 0 < nums[i] < 10000 
// 每个元素的频率在 [1,4] 范围内 
// 
//
// Related Topics 位运算 记忆化搜索 数组 动态规划 回溯 状态压缩 👍 798 👎 0


package com.deemo.leetcode.editor.cn;

import java.util.Arrays;

public class PartitionToKEqualSumSubsets{
    public static void main(String[] args) {
        Solution solution = new PartitionToKEqualSumSubsets().new Solution();
        System.out.println(solution.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
        System.out.println(solution.canPartitionKSubsets(new int[]{4, 3, 2, 1}, 3));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] used;
        public boolean canPartitionKSubsets(int[] nums, int k) {
            int n = nums.length;
            int sum = Arrays.stream(nums).sum();
            if (sum % k != 0) {
                return false;
            }

            int target = sum / k;
            Arrays.sort(nums);
            if (nums[n - 1] > target) {
                return false;
            }

            this.used = new int[n];
            return divideGroups(nums, n - 1, 0, target, k);
        }

        private boolean divideGroups(int[] nums, int start, int curr, int target, int k) {
            if (k == 1) {
                // 最后一组不需要再进行匹配了
                return true;
            }
            if (curr == target) {
                return this.divideGroups(nums, nums.length - 1, 0, target, k - 1);
            }

            for (int i = start; i >= 0; i--) {
                if (this.used[i] == 1 || curr + nums[i] > target) {
                    continue;
                }
                // 标记
                used[i] = 1;
                if (this.divideGroups(nums,i - 1, curr + nums[i], target, k)) {
                    return true;
                }
                // 撤销回溯
                used[i] = 0;
                // 剪枝，相同区间直接跳过递归
                while (i > 0 && nums[i - 1] == nums[i]) {
                    i--;
                }
            }

            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}