//有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，
//5，7，9，15，21。 
//
// 示例 1: 
//
// 输入: k = 5
//
//输出: 9
// 
//
// Related Topics 哈希表 数学 动态规划 堆（优先队列） 👍 190 👎 0


package com.deemo.leetcode.editor.cn;
public class GetKthMagicNumberLcci{
    public static void main(String[] args) {
         Solution solution = new GetKthMagicNumberLcci().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int getKthMagicNumber(int k) {
            int[] ans = new int[k];
            // 配速 3 5 7
            int index1 = 0, index2 = 0, index3 = 0;
            ans[0] = 1;
            for (int i = 1; i < k; i++) {
                int min = Math.min(3 * ans[index1], Math.min(5 * ans[index2], 7 * ans[index3]));
                if (min == 3 * ans[index1]) index1++;
                if (min == 5 * ans[index2]) index2++;
                if (min == 7 * ans[index3]) index3++;

                ans[i] = min;
            }

            return ans[k - 1];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}