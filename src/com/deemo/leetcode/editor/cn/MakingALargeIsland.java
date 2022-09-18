//给你一个大小为 n x n 二进制矩阵 grid 。最多 只能将一格 0 变成 1 。 
//
// 返回执行此操作后，grid 中最大的岛屿面积是多少？ 
//
// 岛屿 由一组上、下、左、右四个方向相连的 1 形成。 
//
// 
//
// 示例 1: 
//
// 
//输入: grid = [[1, 0], [0, 1]]
//输出: 3
//解释: 将一格0变成1，最终连通两个小岛得到面积为 3 的岛屿。
// 
//
// 示例 2: 
//
// 
//输入: grid = [[1, 1], [1, 0]]
//输出: 4
//解释: 将一格0变成1，岛屿的面积扩大为 4。 
//
// 示例 3: 
//
// 
//输入: grid = [[1, 1], [1, 1]]
//输出: 4
//解释: 没有0可以让我们变成1，面积依然为 4。 
//
// 
//
// 提示： 
//
// 
// n == grid.length 
// n == grid[i].length 
// 1 <= n <= 500 
// grid[i][j] 为 0 或 1 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 241 👎 0


package com.deemo.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MakingALargeIsland{
    public static void main(String[] args) {
        Solution solution = new MakingALargeIsland().new Solution();
        System.out.println(solution.largestIsland(new int[][]{{1}}));
        System.out.println(solution.largestIsland(new int[][]{{0}}));
        System.out.println(solution.largestIsland(new int[][]{{0, 0}, {0, 0}}));
        System.out.println(solution.largestIsland(new int[][]{{0, 0}, {0, 1}}));
        System.out.println(solution.largestIsland(new int[][]{{1, 0}, {0, 1}}));
        System.out.println(solution.largestIsland(new int[][]{{1, 1}, {0, 1}}));
        System.out.println(solution.largestIsland(new int[][]{{1, 1}, {1, 1}}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestIsland(int[][] grid) {
            // 岛屿编号
            int index = 2;
            Map<Integer, Integer> areaMap = new HashMap<>();
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    // 计算未编号的
                    if (grid[i][j] == 1) {
                        areaMap.put(index, this.calculateAreas(index++, grid, i, j));
                    }
                }
            }

            // 全是海洋
            if (areaMap.isEmpty()) {
                return 1;
            }

            // 连接岛屿
            int ans = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    // 获取海洋附近 1 单位的岛屿编号
                    if (grid[i][j] == 0) {
                        Set<Integer> islands = this.getIslands(grid, i, j);
                        ans = Math.max(ans, islands.stream().map(areaMap::get).reduce(Integer::sum).orElse(0) + 1);
                    }
                }
            }

            // 全是岛屿
            return ans == 0 ? areaMap.get(2) : ans;
        }

        private int calculateAreas(int index, int[][] grid, int row, int col) {
            if (!this.isLegal(grid, row, col) || grid[row][col] != 1) {
                return 0;
            }

            grid[row][col] = index;
            return this.calculateAreas(index, grid, row - 1, col)
                    + this.calculateAreas(index, grid, row + 1, col)
                    + this.calculateAreas(index, grid, row, col - 1)
                    + this.calculateAreas(index, grid, row, col + 1) + 1;
        }

        private boolean isLegal(int[][] grid, int row, int col) {
            return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
        }

        private Set<Integer> getIslands(int[][] grid, int row, int col) {
            Set<Integer> islands = new HashSet<>();
            if (this.isLegal(grid, row - 1, col) && grid[row - 1][col] != 0) {
                islands.add(grid[row - 1][col]);
            }
            if (this.isLegal(grid, row + 1, col) && grid[row + 1][col] != 0) {
                islands.add(grid[row + 1][col]);
            }
            if (this.isLegal(grid, row, col - 1) && grid[row][col - 1] != 0) {
                islands.add(grid[row][col - 1]);
            }
            if (this.isLegal(grid, row, col + 1) && grid[row][col + 1] != 0) {
                islands.add(grid[row][col + 1]);
            }

            return islands;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}