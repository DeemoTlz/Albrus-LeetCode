//给你一个正整数数组 nums，请你帮忙从该数组中找出能满足下面要求的 最长 前缀，并返回该前缀的长度： 
//
// 
// 从前缀中 恰好删除一个 元素后，剩下每个数字的出现次数都相同。 
// 
//
// 如果删除这个元素后没有剩余元素存在，仍可认为每个数字都具有相同的出现次数（也就是 0 次）。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,2,1,1,5,3,3,5]
//输出：7
//解释：对于长度为 7 的子数组 [2,2,1,1,5,3,3]，如果我们从中删去 nums[4] = 5，就可以得到 [2,2,1,1,3,3]，里面每个数
//字都出现了两次。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1,1,2,2,2,3,3,3,4,4,4,5]
//输出：13
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 
//
// Related Topics 数组 哈希表 👍 163 👎 0


package com.deemo.leetcode.editor.cn;

import java.util.Arrays;

public class MaximumEqualFrequency{
    public static void main(String[] args) {
        Solution solution = new MaximumEqualFrequency().new Solution();
        // 7
        System.out.println(solution.maxEqualFreq(new int[]{2,2,1,1,5,3,3,5}));
        // 13
        System.out.println(solution.maxEqualFreq(new int[]{1,1,1,2,2,2,3,3,3,4,4,4,5}));
        // 13
        System.out.println(solution.maxEqualFreq(new int[]{1,1,1,2,2,2,3,3,3,4,4,4,4}));
        // 6
        System.out.println(solution.maxEqualFreq(new int[]{1,1,1,1,1,1}));
        // 8
        System.out.println(solution.maxEqualFreq(new int[]{10,2,8,9,3,8,1,5,2,3,7,6}));
        // 5
        System.out.println(solution.maxEqualFreq(new int[]{1,1,1,2,2,2}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] cnt = new int[100010];
        int[] sum = new int[100010];
        public int maxEqualFreq(int[] nums) {
            Arrays.fill(cnt, 0); Arrays.fill(sum, 0);
            int n = nums.length, max = 0, ans = 0;
            for (int i = 0; i < n; i++) {
                int t = nums[i], cur = ++cnt[t], len = i + 1;
                sum[cur]++;
                // sum[cur - 1]--;
                max = Math.max(max, cur);
                if (max == 1) ans = len;
                if (max * sum[max] + 1 == len) ans = len;
                if ((max - 1) * (sum[max - 1]) + 1 == len) ans = len;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}