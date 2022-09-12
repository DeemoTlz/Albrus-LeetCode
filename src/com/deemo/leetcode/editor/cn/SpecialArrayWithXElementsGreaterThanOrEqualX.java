//给你一个非负整数数组 nums 。如果存在一个数 x ，使得 nums 中恰好有 x 个元素 大于或者等于 x ，那么就称 nums 是一个 特殊数组 ，而
// x 是该数组的 特征值 。 
//
// 注意： x 不必 是 nums 的中的元素。 
//
// 如果数组 nums 是一个 特殊数组 ，请返回它的特征值 x 。否则，返回 -1 。可以证明的是，如果 nums 是特殊数组，那么其特征值 x 是 唯一的
// 。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,5]
//输出：2
//解释：有 2 个元素（3 和 5）大于或等于 2 。
// 
//
// 示例 2： 
//
// 输入：nums = [0,0]
//输出：-1
//解释：没有满足题目要求的特殊数组，故而也不存在特征值 x 。
//如果 x = 0，应该有 0 个元素 >= x，但实际有 2 个。
//如果 x = 1，应该有 1 个元素 >= x，但实际有 0 个。
//如果 x = 2，应该有 2 个元素 >= x，但实际有 0 个。
//x 不能取更大的值，因为 nums 中只有两个元素。 
//
// 示例 3： 
//
// 输入：nums = [0,4,3,0,4]
//输出：3
//解释：有 3 个元素大于或等于 3 。
// 
//
// 示例 4： 
//
// 输入：nums = [3,6,7,7,0]
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 1000 
// 
//
// Related Topics 数组 二分查找 排序 👍 144 👎 0


package com.deemo.leetcode.editor.cn;

import java.util.Arrays;

public class SpecialArrayWithXElementsGreaterThanOrEqualX{
    public static void main(String[] args) {
        Solution solution = new SpecialArrayWithXElementsGreaterThanOrEqualX().new Solution();
        System.out.println(solution.specialArray(new int[]{3, 5}));
        System.out.println(solution.specialArray(new int[]{0, 0}));
        System.out.println(solution.specialArray(new int[]{0, 4, 3, 0 ,4}));
        System.out.println(solution.specialArray(new int[]{3, 6, 7, 7, 0}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int specialArray(int[] nums) {
            Arrays.sort(nums);

            int n = nums.length;
            if (nums[0] >= n) {
                return n;
            }

            for (int i = 1; i < n; i++) {
                if (nums[n - i] >= i && nums[n - i - 1] < i) {
                    return i;
                }
            }
            return -1;
        }

        public int specialArray2(int[] nums) {
            Arrays.sort(nums);

            int n = nums.length;
            if (nums[0] >= n) {
                return n;
            }

            int l = 1, r = n - 1;
            while (l < r) {
                int mid = (l + r) >> 1;
                if (nums[n - mid] >= mid && nums[n - mid - 1] < mid) {
                    return mid;
                } else if (nums[n - mid] < mid) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
                if (l >= r - 1) {
                    if (nums[n - l] >= l && nums[n - l - 1] < l) {
                        return l;
                    }
                    if (nums[n - r] >= r && nums[n - r - 1] < r) {
                        return r;
                    }
                    break;
                }
            }
            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}