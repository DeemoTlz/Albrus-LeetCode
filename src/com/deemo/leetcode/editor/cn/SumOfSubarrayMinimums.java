//给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。 
//
// 由于答案可能很大，因此 返回答案模 10^9 + 7 。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [3,1,2,4]
//输出：17
//解释：
//子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。 
//最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。 
//
// 示例 2： 
//
// 
//输入：arr = [11,81,94,43,3]
//输出：444
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 3 * 10⁴ 
// 1 <= arr[i] <= 3 * 10⁴ 
// 
//
// 
//
// Related Topics 栈 数组 动态规划 单调栈 👍 553 👎 0


package com.deemo.leetcode.editor.cn;
public class SumOfSubarrayMinimums{
    public static void main(String[] args) {
        Solution solution = new SumOfSubarrayMinimums().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int sumSubarrayMins(int[] arr) {
            long result = 0;
            int[] stack = new int[arr.length]; // 使用数组结构模拟堆栈，里面存储arr数组的下标，为了便于计算“管辖区域”的跨度
            int head = 0, tail = head, mod = (int) (1e9 + 7); // 配合模拟堆栈的head指针和tail指针
            for (int i = 0; i <= arr.length; i++) {
                int num = (i == arr.length) ? 0 : arr[i]; // 如果arr数组遍历到最后一个元素，则还需要模拟结尾元素0，为了让stack中元素都出栈
                while (head != tail && arr[stack[tail - 1]] > num) {
                    int n = stack[--tail]; // 待计算数字arr[n]的【数组下标】
                    int h = (head != tail) ? stack[tail - 1] : -1; // arr[n]的“辐射区域”head头的【数组下标】（开区间）
                    int t = i; // arr[n]的“辐射区域”tail尾的【数组下标】（开区间）
                    result = (result + (long) (n - h) * (t - n) * arr[n]) % mod;
                }
                stack[tail++] = i;
            }
            return (int) result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}