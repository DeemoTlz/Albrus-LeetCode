//给定一个正整数数组 nums和整数 k ，请找出该数组内乘积小于 k 的连续的子数组的个数。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [10,5,2,6], k = 100
//输出: 8
//解释: 8 个乘积小于 100 的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
//需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,2,3], k = 0
//输出: 0 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// 1 <= nums[i] <= 1000 
// 0 <= k <= 10⁶ 
// 
//
// 
//
// 注意：本题与主站 713 题相同：https://leetcode-cn.com/problems/subarray-product-less-than-
//k/ 
// Related Topics 数组 滑动窗口 👍 59 👎 0

  
package com.deemo.leetcode.editor.cn;
public class ZVAVXX{
    public static void main(String[] args) {
        Solution solution = new ZVAVXX().new Solution();
        System.out.println(solution.numSubarrayProductLessThanK(new int[]{1, 1, 1}, 1));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            if (k <= 1) {
                return 0;
            }
            int ans = 0, left = 0, sum = 1;
            for (int right = 0; right < nums.length; right++) {
                sum *= nums[right];

                while (sum >= k && left < nums.length) {
                    sum /= nums[left++];
                }
                // 连续数组，以 right 为切入点，不断向左延伸（例如[1,2,3,4]，right(4)为切入点，则包含有：[4], [4,3], [4,3,2], [4,3,2,1]）
                ans += right - left + 1;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}