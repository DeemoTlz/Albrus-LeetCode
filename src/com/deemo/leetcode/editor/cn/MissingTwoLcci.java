//给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？ 
//
// 以任意顺序返回这两个数字均可。 
//
// 示例 1: 
//
// 输入: [1]
//输出: [2,3] 
//
// 示例 2: 
//
// 输入: [2,3]
//输出: [1,4] 
//
// 提示： 
//
// 
// nums.length <= 30000 
// 
//
// Related Topics 位运算 数组 哈希表 👍 189 👎 0


package com.deemo.leetcode.editor.cn;
public class MissingTwoLcci{
    public static void main(String[] args) {
         Solution solution = new MissingTwoLcci().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] missingTwo(int[] nums) {
            int totalLength = nums.length + 2;
            int totalSum = ((totalLength + 1) * totalLength) >> 1;
            for (int num : nums) totalSum -= num;
            int missingHalf = totalSum >> 1;
            int missingHalfSum = ((missingHalf + 1) * missingHalf) >> 1;
            for (int num : nums)
                if (num <= missingHalf)
                    missingHalfSum -= num;
            return new int[] {missingHalfSum, totalSum - missingHalfSum};
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}