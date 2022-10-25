//给你一个大小为 n x n 的二元矩阵 grid ，其中 1 表示陆地，0 表示水域。 
//
// 岛 是由四面相连的 1 形成的一个最大组，即不会与非组内的任何其他 1 相连。grid 中 恰好存在两座岛 。 
//
// 
// 
// 你可以将任意数量的 0 变为 1 ，以使两座岛连接起来，变成 一座岛 。 
// 
// 
//
// 返回必须翻转的 0 的最小数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[0,1],[1,0]]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [[0,1,0],[0,0,0],[0,0,1]]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// n == grid.length == grid[i].length 
// 2 <= n <= 100 
// grid[i][j] 为 0 或 1 
// grid 中恰有两个岛 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 👍 385 👎 0


package com.deemo.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestBridge{
    public static void main(String[] args) {
        Solution solution = new ShortestBridge().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] grid, coordinates = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}}; // 上、下、右、左四个方向
        Deque<int[]> edges; // 用户存储边缘格子
        public int shortestBridge(int[][] grid) {
            int result = 0;
            boolean findIsland = false; // 只要找到2个岛屿中其中的1个岛屿，就将其设置为true，并结束步骤1中的两层for循环
            edges = new ArrayDeque();
            this.grid = grid;
            /** 步骤1：为其中一个岛屿打标记（val=2），并保存”边界格子“到edges中 */
            for (int i = 0; !findIsland && i < grid.length; i++)
                for (int j = 0; !findIsland && j < grid[0].length; j++)
                    if (findIsland = (grid[i][j] == 1)) markIsland(i, j);

            /** 步骤2：利用边界edges，一层一层扩展岛屿（val=2），直到遇到另一个岛屿（val=1）*/
            while (!edges.isEmpty()) {
                result++; // 扩展层数
                int num = edges.size();
                for (int i = 0; i < num; i++) {
                    int[] edge = edges.removeFirst();
                    for (int[] c : coordinates) { // 向edge的四个方向查看格子编号，并扩展岛屿边界
                        int nex = edge[0] + c[0], ney = edge[1] + c[1];
                        if(isLegal(nex, ney) && grid[nex][ney] == 0) {
                            edges.addLast(new int[]{nex, ney}); // 添加新的边界
                            grid[nex][ney] = 2;
                        }
                        else if (isLegal(nex, ney) && grid[nex][ney] == 1) return result; // 与另一个岛屿相遇，则直接返回result
                    }
                }
            }
            return result;
        }

        public void markIsland(int row, int column) {
            if (!isLegal(row, column) || grid[row][column] == 2) return;
            if (grid[row][column] == 0) {
                grid[row][column] = 2; // 将边界向外扩展1层岛屿（val=2)
                edges.addLast(new int[]{row, column});
                return;
            }
            grid[row][column] = 2; // 为岛屿打标记（val=2）
            for (int[] c : coordinates) markIsland(row + c[0], column + c[1]); // 深度遍历某个格子的四个方向
        }

        public boolean isLegal(int row, int column) {
            return row >= 0 && row < grid.length && column >= 0 && column < grid[0].length;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}