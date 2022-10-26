//给你一个整数数组 nums 和一个整数 k ，找出 nums 中和至少为 k 的 最短非空子数组 ，并返回该子数组的长度。如果不存在这样的 子数组 ，返回 
//-1 。 
//
// 子数组 是数组中 连续 的一部分。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1], k = 1
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2], k = 4
//输出：-1
// 
//
// 示例 3： 
//
// 
//输入：nums = [2,-1,2], k = 3
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁵ <= nums[i] <= 10⁵ 
// 1 <= k <= 10⁹ 
// 
//
// Related Topics 队列 数组 二分查找 前缀和 滑动窗口 单调队列 堆（优先队列） 👍 567 👎 0


package com.deemo.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ShortestSubarrayWithSumAtLeastK{
    public static void main(String[] args) {
        Solution solution = new ShortestSubarrayWithSumAtLeastK().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int N = 200010;
        int[] tr = new int[N], sum = new int[N];
        int n, m, ans;
        int lowbit(int x) {
            return x & -x;
        }
        void update(int val, int loc) {
            for (int i = val; i < m; i += lowbit(i)) tr[i] = Math.max(tr[i], loc);
        }
        int query(int x) {
            int ans = -1;
            for (int i = x; i > 0; i -= lowbit(i)) ans = Math.max(ans, tr[i]);
            return ans;
        }
        int getIdx(List<Long> list, long x) {
            int l = 0, r = list.size() - 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (list.get(mid) >= x) r = mid;
                else l = mid + 1;
            }
            return r + 1;
        }
        public int shortestSubarray(int[] nums, int k) {
            n = nums.length; m = 2 * n + 10; ans = n + 10;
            Arrays.fill(tr, -1);
            long[] temp = new long[m];
            List<Long> list = new ArrayList<>();
            list.add(0L);
            for (int i = 1; i <= 2 * n + 1; i++) {
                if (i <= n) temp[i] = temp[i - 1] + nums[i - 1];
                else temp[i] = temp[i - (n + 1)] + k;
                list.add(temp[i]);
            }
            Collections.sort(list);
            for (int i = 0; i <= 2 * n + 1; i++) sum[i] = getIdx(list, temp[i]);
            update(sum[n + 1], 0);
            for (int i = 1; i <= n; i++) {
                int j = query(sum[i]);
                if (j != -1) ans = Math.min(ans, i - j);
                update(sum[n + 1 + i], i);
            }
            return ans == n + 10 ? -1 : ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}