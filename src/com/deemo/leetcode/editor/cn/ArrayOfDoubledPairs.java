//给定一个长度为偶数的整数数组 arr，只有对 arr 进行重组后可以满足 “对于每个 0 <= i < len(arr) / 2，都有 arr[2 * i 
//+ 1] = 2 * arr[2 * i]” 时，返回 true；否则，返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [3,1,3,6]
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：arr = [2,1,2,6]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：arr = [4,-2,2,-4]
//输出：true
//解释：可以用 [-2,-4] 和 [2,4] 这两组组成 [-2,-4,2,4] 或是 [2,4,-2,-4]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= arr.length <= 3 * 10⁴ 
// arr.length 是偶数 
// -10⁵ <= arr[i] <= 10⁵ 
// 
// Related Topics 贪心 数组 哈希表 排序 👍 138 👎 0


package com.deemo.leetcode.editor.cn;

import java.util.*;

public class ArrayOfDoubledPairs{
    public static void main(String[] args) {
        Solution solution = new ArrayOfDoubledPairs().new Solution();
        solution.canReorderDoubled(new int[]{4, -2, 2, -4});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canReorderDoubled(int[] arr) {
            if (arr.length % 2 != 0) {
                return false;
            }

            Map<Integer, Integer> cnt = new HashMap<>();
            for (int i : arr) {
                cnt.put(i, cnt.getOrDefault(i, 0) + 1);
            }
            if (cnt.getOrDefault(0, 0) % 2 != 0) {
                return false;
            }

            List<Integer> vls = new ArrayList<>(cnt.keySet());
            vls.sort(Comparator.comparingInt(Math::abs));

            for (Integer vl : vls) {
                if (cnt.get(vl) == 0) {
                    continue;
                }

                // 小的数更多，说明匹配不上（x > 2x）
                if (cnt.get(vl) > cnt.getOrDefault(2 * vl, 0)) {
                    return false;
                }

                cnt.put(2 * vl, cnt.get(2 * vl) - cnt.get(vl));
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}