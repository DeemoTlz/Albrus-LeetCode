//在一个 n x n 的矩阵 grid 中，除了在数组 mines 中给出的元素为 0，其他每个元素都为 1。mines[i] = [xi, yi]表示 
//grid[xi][yi] == 0 
//
// 返回 grid 中包含 1 的最大的 轴对齐 加号标志的阶数 。如果未找到加号标志，则返回 0 。 
//
// 一个 k 阶由 1 组成的 “轴对称”加号标志 具有中心网格 grid[r][c] == 1 ，以及4个从中心向上、向下、向左、向右延伸，长度为 k-1，
//由 1 组成的臂。注意，只有加号标志的所有网格要求为 1 ，别的网格可能为 0 也可能为 1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: n = 5, mines = [[4, 2]]
//输出: 2
//解释: 在上面的网格中，最大加号标志的阶只能是2。一个标志已在图中标出。
// 
//
// 示例 2： 
//
// 
//
// 
//输入: n = 1, mines = [[0, 0]]
//输出: 0
//解释: 没有加号标志，返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 500 
// 1 <= mines.length <= 5000 
// 0 <= xi, yi < n 
// 每一对 (xi, yi) 都 不重复 
// 
//
// Related Topics 数组 动态规划 👍 186 👎 0


package com.deemo.leetcode.editor.cn;

import java.util.Arrays;

public class LargestPlusSign{
    public static void main(String[] args) {
        Solution solution = new LargestPlusSign().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int orderOfLargestPlusSign(int n, int[][] mines) {
            int[][] g = new int[n + 10][n + 10];
            for (int i = 1; i <= n; i++) {
                Arrays.fill(g[i], 1);
            }
            for (int[] mine : mines) {
                g[mine[0] + 1][mine[1] + 1] = 0;
            }

            // 四个方向 下
            int[][] a = new int[n + 10][n + 10];
            // 右
            int[][] b = new int[n + 10][n + 10];
            // 上
            int[][] c = new int[n + 10][n + 10];
            // 左
            int[][] d = new int[n + 10][n + 10];

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (g[i][j] == 1) {
                        a[i][j] = a[i - 1][j] + 1;
                        b[i][j] = b[i][j - 1] + 1;
                    }
                    // 其实就是倒序，从右下角，上面的是从左上角开始，所以即：n, n - 1, n - 2...1
                    if (g[n + 1 - i][n + 1 - j] == 1) {
                        c[n + 1 - i][n + 1 - j] = c[n + 2 - i][n + 1 - j] + 1;
                        d[n + 1 - i][n + 1 - j] = d[n + 1 - i][n + 2 - j] + 1;
                    }
                }
            }

            int ans = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    ans = Math.max(ans, Math.min(Math.min(a[i][j], b[i][j]), Math.min(c[i][j], d[i][j])));
                }
            }

            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}