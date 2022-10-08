//给定两个大小相等的数组 nums1 和 nums2，nums1 相对于 nums2 的优势可以用满足 nums1[i] > nums2[i] 的索引 i 的
//数目来描述。 
//
// 返回 nums1 的任意排列，使其相对于 nums2 的优势最大化。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [2,7,11,15], nums2 = [1,10,4,11]
//输出：[2,11,7,15]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [12,24,8,32], nums2 = [13,25,32,11]
//输出：[24,32,8,12]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length <= 10⁵ 
// nums2.length == nums1.length 
// 0 <= nums1[i], nums2[i] <= 10⁹ 
// 
//
// Related Topics 贪心 数组 双指针 排序 👍 318 👎 0


package com.deemo.leetcode.editor.cn;

import java.util.Arrays;
import java.util.stream.IntStream;

public class AdvantageShuffle{
    public static void main(String[] args) {
         Solution solution = new AdvantageShuffle().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] advantageCount(int[] nums1, int[] nums2) {
            int n = nums1.length;
            Arrays.sort(nums1);

            Integer[] idxArray = IntStream.range(0, n).boxed().toArray(Integer[]::new);
            Arrays.sort(idxArray, (o1, o2) -> nums2[o2] - nums2[o1]);
            int left = 0, right = n - 1;
            for (int i = 0; i < n; i++) {
                if (nums2[idxArray[i]] < nums1[right]) {
                    nums2[idxArray[i]] = nums1[right--];
                } else {
                    nums2[idxArray[i]] = nums1[left++];
                }
            }

            return nums2;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}