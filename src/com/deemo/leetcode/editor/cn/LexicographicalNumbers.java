//给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。 
//
// 你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 13
//输出：[1,10,11,12,13,2,3,4,5,6,7,8,9]
// 
//
// 示例 2： 
//
// 
//输入：n = 2
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 5 * 10⁴ 
// 
// Related Topics 深度优先搜索 字典树 👍 251 👎 0

  
package com.deemo.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers{
    public static void main(String[] args) {
        Solution solution = new LexicographicalNumbers().new Solution();
        System.out.println(solution.lexicalOrder(133));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        List<Integer> list;

        public List<Integer> lexicalOrder(int n) {
            list = new ArrayList<>(n);

            /*for (int i = 1; i < 10; i++) {
                dfs(i, n);
            }*/
            dfs(0, 1, n);
            return list;
        }

        private void dfs(int i, int n) {
            if (i > n) {
                return;
            }

            list.add(i);
            for (int j = 0; j < 10; j++) {
                dfs(i * 10 + j, n);
            }
        }

        private void dfs(int base, int start, int n) {
            if (base > n) {
                return;
            }

            int num;
            for (int i = start; i < 10; i++) {
                num = base + i;
                if (num > n) {
                    return;
                }

                list.add(num);
                dfs(num * 10, 0, n);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}