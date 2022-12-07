//给你两个长度可能不等的整数数组 nums1 和 nums2 。两个数组中的所有值都在 1 到 6 之间（包含 1 和 6）。 
//
// 每次操作中，你可以选择 任意 数组中的任意一个整数，将它变成 1 到 6 之间 任意 的值（包含 1 和 6）。 
//
// 请你返回使 nums1 中所有数的和与 nums2 中所有数的和相等的最少操作次数。如果无法使两个数组的和相等，请返回 -1 。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,3,4,5,6], nums2 = [1,1,2,2,2,2]
//输出：3
//解释：你可以通过 3 次操作使 nums1 中所有数的和与 nums2 中所有数的和相等。以下数组下标都从 0 开始。
//- 将 nums2[0] 变为 6 。 nums1 = [1,2,3,4,5,6], nums2 = [6,1,2,2,2,2] 。
//- 将 nums1[5] 变为 1 。 nums1 = [1,2,3,4,5,1], nums2 = [6,1,2,2,2,2] 。
//- 将 nums1[2] 变为 2 。 nums1 = [1,2,2,4,5,1], nums2 = [6,1,2,2,2,2] 。
// 
//
// 示例 2： 
//
// 输入：nums1 = [1,1,1,1,1,1,1], nums2 = [6]
//输出：-1
//解释：没有办法减少 nums1 的和或者增加 nums2 的和使二者相等。
// 
//
// 示例 3： 
//
// 输入：nums1 = [6,6], nums2 = [1]
//输出：3
//解释：你可以通过 3 次操作使 nums1 中所有数的和与 nums2 中所有数的和相等。以下数组下标都从 0 开始。
//- 将 nums1[0] 变为 2 。 nums1 = [2,6], nums2 = [1] 。
//- 将 nums1[1] 变为 2 。 nums1 = [2,2], nums2 = [1] 。
//- 将 nums2[0] 变为 4 。 nums1 = [2,2], nums2 = [4] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 10⁵ 
// 1 <= nums1[i], nums2[i] <= 6 
// 
//
// Related Topics 贪心 数组 哈希表 计数 👍 149 👎 0


package com.deemo.leetcode.editor.cn;
public class EqualSumArraysWithMinimumNumberOfOperations{
    public static void main(String[] args) {
        Solution solution = new EqualSumArraysWithMinimumNumberOfOperations().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // https://leetcode.cn/problems/equal-sum-arrays-with-minimum-number-of-operations/solution/zhua-wa-m-by-muse-77-f2zh/
        public int minOperations(int[] nums1, int[] nums2) {
            int result = 0, l1 = nums1.length, l2 = nums2.length, sum1 = 0, sum2 = 0, diff;
            if (6 * l1 < l2 || 6 * l2 < l1) return -1; // 无法使两个数组的和相等，返回-1
            for (int n1 : nums1) sum1 += n1;
            for (int n2 : nums2) sum2 += n2;
            if ((diff = Math.abs(sum1 - sum2)) == 0) return 0; // 如果两个数组和相等，则不需要操作，返回0
            int[] range = calculate(nums1, nums2, sum1, sum2);
            for (int i = 5; i >= 0; i--) { // 从最大的差值开始对比
                while (range[i] > 0) { // 如果差值range[i]出现的次数不为0
                    result++; // 操作次数加1
                    if (i >= diff) return result; // 如果差值大于等于diff，则操作结束，返回操作数result
                    range[i]--; // 差值range[i]的出现次数减1
                    diff -= i; // 更新diff值
                }
            }
            return -1;
        }

        // 计算每个差值（1~5）出现的次数
        private int[] calculate(int[] nums1, int[] nums2, int sum1, int sum2) {
            int[] bigger = (sum1 < sum2) ? nums2 : nums1;
            int[] smaller = (sum1 < sum2) ? nums1 : nums2;
            int[] range = new int[6]; // index：差值  range[index]：该差值出现的次数
            for (int s : smaller) ++range[6 - s]; // 对于总数较小的数组，要执行增加操作，由于理论上最大值是6，所以最大可以增加"6-s"个数值
            for (int b : bigger) ++range[b - 1]; // 对于总数较大的数组，要执行减法操作，由于理论上最小值是1，所以最大可以减少"b-1"个数值
            return range;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}