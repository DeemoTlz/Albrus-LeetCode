//给定你一个整数数组
// nums 
//
// 我们要将
// nums 数组中的每个元素移动到 A 数组 或者 B 数组中，使得 A 数组和
// B 数组不为空，并且
// average(A) == average(B) 。 
//
// 如果可以完成则返回true ， 否则返回 false 。 
//
// 注意：对于数组
// arr , 
// average(arr) 是
// arr 的所有元素的和除以
// arr 长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,3,4,5,6,7,8]
//输出: true
//解释: 我们可以将数组分割为 [1,4,5,8] 和 [2,3,6,7], 他们的平均值都是4.5。
// 
//
// 示例 2: 
//
// 
//输入: nums = [3,1]
//输出: false
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 30 
// 0 <= nums[i] <= 10⁴ 
// 
//
// Related Topics 位运算 数组 数学 动态规划 状态压缩 👍 232 👎 0


package com.deemo.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SplitArrayWithSameAverage{
    public static void main(String[] args) {
        Solution solution = new SplitArrayWithSameAverage().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean splitArraySameAverage(int[] nums) {
            int n = nums.length, m = n / 2, sum = 0;
            for (int x : nums) sum += x;
            Map<Integer, Set<Integer>> map = new HashMap<>();
            for (int s = 0; s < (1 << m); s++) {
                int tot = 0, cnt = 0;
                for (int i = 0; i < m; i++) {
                    if (((s >> i) & 1) == 1) {
                        tot += nums[i];
                        cnt++;
                    }
                }
                Set<Integer> set = map.getOrDefault(tot, new HashSet<>());
                set.add(cnt);
                map.put(tot, set);
            }
            for (int s = 0; s < (1 << (n - m)); s++) {
                int tot = 0, cnt = 0;
                for (int i = 0; i < (n - m); i++) {
                    if (((s >> i) & 1) == 1) {
                        tot += nums[i + m];
                        cnt++;
                    }
                }
                for (int k = Math.max(1, cnt); k < n; k++) {
                    if (k * sum % n != 0) continue;
                    int t = k * sum / n;
                    if (!map.containsKey(t - tot)) continue;
                    if (!map.get(t - tot).contains(k - cnt)) continue;
                    return true;
                }
            }
            return false;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}