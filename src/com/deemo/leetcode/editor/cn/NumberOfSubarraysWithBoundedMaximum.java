//给你一个整数数组 nums 和两个整数：left 及 right 。找出 nums 中连续、非空且其中最大元素在范围 [left, right] 内的子数组
//，并返回满足条件的子数组的个数。 
//
// 生成的测试用例保证结果符合 32-bit 整数范围。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,1,4,3], left = 2, right = 3
//输出：3
//解释：满足条件的三个子数组：[2], [2, 1], [3]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,9,2,5,6], left = 2, right = 8
//输出：7
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁹ 
// 0 <= left <= right <= 10⁹ 
// 
//
// Related Topics 数组 双指针 👍 294 👎 0


package com.deemo.leetcode.editor.cn;
public class NumberOfSubarraysWithBoundedMaximum{
    public static void main(String[] args) {
        Solution solution = new NumberOfSubarraysWithBoundedMaximum().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSubarrayBoundedMax(int[] nums, int left, int right) {
            int n = nums.length;
            int ans = 0;
            for (int i = 0, j = -1, k = -1; i < n; i++) {
                if (nums[i] > right) {
                    k = i;
                } else {
                    // 理解左端点、右端点
                    if (nums[i] < left) {
                        if (j > k) {
                            ans += j - k;
                        }
                    } else {
                        ans += i - k;
                        j = i;
                    }
                }
            }

            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}