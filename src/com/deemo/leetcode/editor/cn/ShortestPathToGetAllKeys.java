//给定一个二维网格 grid ，其中： 
//
// 
// '.' 代表一个空房间 
// '#' 代表一堵 
// '@' 是起点 
// 小写字母代表钥匙 
// 大写字母代表锁 
// 
//
// 我们从起点开始出发，一次移动是指向四个基本方向之一行走一个单位空间。我们不能在网格外面行走，也无法穿过一堵墙。如果途经一个钥匙，我们就把它捡起来。除非我们
//手里有对应的钥匙，否则无法通过锁。 
//
// 假设 k 为 钥匙/锁 的个数，且满足 1 <= k <= 6，字母表中的前 k 个字母在网格中都有自己对应的一个小写和一个大写字母。换言之，每个锁有唯一
//对应的钥匙，每个钥匙也有唯一对应的锁。另外，代表钥匙和锁的字母互为大小写并按字母顺序排列。 
//
// 返回获取所有钥匙所需要的移动的最少次数。如果无法获取所有钥匙，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = ["@.a.#","###.#","b.A.B"]
//输出：8
//解释：目标是获得所有钥匙，而不是打开所有锁。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：grid = ["@..aA","..B#.","....b"]
//输出：6
// 
//
// 示例 3: 
// 
// 
//输入: grid = ["@Aa"]
//输出: -1 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 30 
// grid[i][j] 只含有 '.', '#', '@', 'a'-'f' 以及 'A'-'F' 
// 钥匙的数目范围是 [1, 6] 
// 每个钥匙都对应一个 不同 的字母 
// 每个钥匙正好打开一个对应的锁 
// 
//
// Related Topics 位运算 广度优先搜索 数组 矩阵 👍 218 👎 0


package com.deemo.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class ShortestPathToGetAllKeys{
    public static void main(String[] args) {
        Solution solution = new ShortestPathToGetAllKeys().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // https://leetcode.cn/problems/shortest-path-to-get-all-keys/solution/by-ac_oier-5gxc/
        public int shortestPathAllKeys(String[] g) {
            int N = 35, K = 10, INF = 0x3f3f3f3f;
            int[][][] dist = new int[N][N][1 << K];
            int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

            int n = g.length, m = g[0].length(), cnt = 0;
            Deque<int[]> d = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    Arrays.fill(dist[i][j], INF);
                    char c = g[i].charAt(j);
                    if (c == '@') {
                        d.addLast(new int[]{i, j, 0});
                        dist[i][j][0] = 0;
                    } else if (c >= 'a' && c <= 'z') cnt++;
                }
            }
            while (!d.isEmpty()) {
                int[] info = d.pollFirst();
                int x = info[0], y = info[1], cur = info[2], step = dist[x][y][cur];
                for (int[] di : dirs) {
                    int nx = x + di[0], ny = y + di[1];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    char c = g[nx].charAt(ny);
                    if (c == '#') continue;
                    if ((c >= 'A' && c <= 'Z') && (cur >> (c - 'A') & 1) == 0) continue;
                    int ncur = cur;
                    if (c >= 'a' && c <= 'z') ncur |= 1 << (c - 'a');
                    if (ncur == (1 << cnt) - 1) return step + 1;
                    if (step + 1 >= dist[nx][ny][ncur]) continue;
                    dist[nx][ny][ncur] = step + 1;
                    d.addLast(new int[]{nx, ny, ncur});
                }
            }
            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}