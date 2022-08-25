//给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。 
//
// 整数 a 比整数 b 更接近 x 需要满足： 
//
// 
// |a - x| < |b - x| 或者 
// |a - x| == |b - x| 且 a < b 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [1,2,3,4,5], k = 4, x = 3
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：arr = [1,2,3,4,5], k = 4, x = -1
//输出：[1,2,3,4]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= arr.length 
// 1 <= arr.length <= 10⁴
// 
// arr 按 升序 排列 
// -10⁴ <= arr[i], x <= 10⁴ 
// 
//
// Related Topics 数组 双指针 二分查找 排序 堆（优先队列） 👍 416 👎 0


package com.deemo.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements{
    public static void main(String[] args) {
        Solution solution = new FindKClosestElements().new Solution();
        System.out.println(solution.findClosestElements(new int[]{1,2,3,4,5}, 4, 3));
        System.out.println(solution.findClosestElements(new int[]{1,2,3,4,5}, 4, -1));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            // 中间点，左边比 k 都小、右边大于等于 k
            int right = this.binarySearch(arr, x);
            int left = right - 1;
            int bk = k;

            while (k-- > 0) {
                if (left < 0) {
                    break;
                }
                if (right >= arr.length) {
                    left--;
                } else if (x - arr[left] <= arr[right] - x) {
                    left--;
                } else {
                    right++;
                }
            }

            List<Integer> ans = new ArrayList<>(bk);
            while (bk-- > 0) {
                ans.add(arr[left++ + 1]);
            }
            return ans;
        }

        /**
         * 中间点，左边比 k 都小、右边大于等于 k
         */
        private int binarySearch(int[] arr, int x) {
            int low = 0;
            int high = arr.length - 1;

            while (low < high) {
                int mid = low + high >> 1;
                if (arr[mid] >= x) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            return low;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}