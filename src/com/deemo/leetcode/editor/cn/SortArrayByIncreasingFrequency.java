//给你一个整数数组 nums ，请你将数组按照每个值的频率 升序 排序。如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。 
//
// 请你返回排序后的数组。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,1,2,2,2,3]
//输出：[3,1,1,2,2,2]
//解释：'3' 频率为 1，'1' 频率为 2，'2' 频率为 3 。
// 
//
// 示例 2： 
//
// 输入：nums = [2,3,1,3,2]
//输出：[1,3,3,2,2]
//解释：'2' 和 '3' 频率都为 2 ，所以它们之间按照数值本身降序排序。
// 
//
// 示例 3： 
//
// 输入：nums = [-1,1,-6,4,5,-6,1,4,1]
//输出：[5,-1,4,4,-6,-6,1,1,1] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// -100 <= nums[i] <= 100 
// 
//
// Related Topics 数组 哈希表 排序 👍 110 👎 0


package com.deemo.leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

public class SortArrayByIncreasingFrequency{
    public static void main(String[] args) {
         Solution solution = new SortArrayByIncreasingFrequency().new Solution();
        System.out.println(Arrays.toString(solution.frequencySort(new int[]{1, 1, 2, 2, 2, 3})));
        System.out.println(Arrays.toString(solution.frequencySort(new int[]{2, 3, 1, 3, 2})));
        System.out.println(Arrays.toString(solution.frequencySort(new int[]{-1, 1, -6, 4, 5, -6, 1, 4, 1})));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] frequencySort(int[] nums) {
            Map<Integer, Integer> counts = new HashMap<>();
            for (int num : nums) {
                counts.put(num, counts.getOrDefault(num, 0) + 1);
            }

            List<int[]> list = counts.entrySet().stream()
                    .map(c -> new int[]{c.getKey(), c.getValue()})
                    .sorted((a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1])
                    .collect(Collectors.toList());
            int[] ans = new int[nums.length];
            int idx = 0;
            for (int[] ints : list) {
                while (ints[1]-- > 0) {
                    ans[idx++] = ints[0];
                }
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}