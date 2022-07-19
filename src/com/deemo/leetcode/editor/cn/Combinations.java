//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
// Related Topics 回溯 👍 1058 👎 0


package com.deemo.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Combinations{
    public static void main(String[] args) {
        Solution solution = new Combinations().new Solution();
        System.out.println(solution.combine(5, 3));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            if (n < k || k < 0) {
                return Collections.emptyList();
            }

            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> back = new ArrayList<>();
            dfs(1, n, k, back, ans);

            return ans;
        }

        private void dfs(int i, int to, int cnt, List<Integer> back, List<List<Integer>> ans) {
            if (cnt == 0) {
                ans.add(new ArrayList<>(back));
                return;
            }

            if (to - i + 1 < cnt) {
                return;
            }

            // 不选
            dfs(i + 1, to, cnt, back, ans);

            // 选
            back.add(i);
            dfs(i + 1, to, cnt - 1, back, ans);
            back.remove(back.size() - 1);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}