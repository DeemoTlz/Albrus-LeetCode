//给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
//输出：6
//解释：[1,1,1,0,0,1,1,1,1,1,1]
//粗体数字从 0 翻转到 1，最长的子数组长度为 6。 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
//输出：10
//解释：[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
//粗体数字从 0 翻转到 1，最长的子数组长度为 10。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// nums[i] 不是 0 就是 1 
// 0 <= k <= nums.length 
// 
// Related Topics 数组 二分查找 前缀和 滑动窗口 👍 394 👎 0


package com.deemo.leetcode.editor.cn;
public class MaxConsecutiveOnesIii{
    public static void main(String[] args) {
        Solution solution = new MaxConsecutiveOnesIii().new Solution();
        System.out.println(solution.longestOnes(new int[]{0, 0, 0, 0}, 0));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 与 [2024]考试的最大困扰度 相同，就不写注释了
         */
        public int longestOnes(int[] nums, int k) {
            return this.longestOnes(nums, k, 0);
        }

        private int longestOnes(int[] nums, int k, int i) {
            int ans = 0, n = nums.length;

            for (int left = 0, right = 0, sum = 0; right < n; right++) {
                if (nums[right] == i) {
                    sum++;
                }

                while (sum > k) {
                    if (nums[left] == i) {
                        sum--;
                    }
                    left++;
                }

                ans = Math.max(ans, right - left + 1);
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}