//给定一个由不同正整数的组成的非空数组 nums ，考虑下面的图： 
//
// 
// 有 nums.length 个节点，按从 nums[0] 到 nums[nums.length - 1] 标记； 
// 只有当 nums[i] 和 nums[j] 共用一个大于 1 的公因数时，nums[i] 和 nums[j]之间才有一条边。 
// 
//
// 返回 图中最大连通组件的大小 。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//
// 
//输入：nums = [4,6,15,35]
//输出：4
// 
//
// 示例 2： 
//
// 
//
// 
//输入：nums = [20,50,9,63]
//输出：2
// 
//
// 示例 3： 
//
// 
//
// 
//输入：nums = [2,3,6,7,4,12,21,39]
//输出：8
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// 1 <= nums[i] <= 10⁵ 
// nums 中所有值都 不同 
// 
//
// Related Topics 并查集 数组 数学 👍 123 👎 0


package com.deemo.leetcode.editor.cn;

import java.util.Arrays;

public class LargestComponentSizeByCommonFactor{
    public static void main(String[] args) {
        Solution solution = new LargestComponentSizeByCommonFactor().new Solution();
        System.out.println(solution.largestComponentSize(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestComponentSize(int[] nums) {
            int m = Arrays.stream(nums).max().getAsInt();
            UnionFind unionFind = new UnionFind(m + 1);

            for (int num : nums) {
                for (int i = 2; i <= num / i; i++) {
                    if (num % i == 0) {
                        unionFind.union(num, i);
                        if (num / i != i) {
                            unionFind.union(num, num / i);
                        }
                    }
                }
            }

            int[] counts = new int[m + 1];
            int ans = 0, root;
            for (int num : nums) {
                root = unionFind.find(num);
                counts[root]++;
                ans = Math.max(ans, counts[root]);
            }
            return ans;
        }

        private class UnionFind {
            int[] parent;
            /**
             * 树的高度
             */
            int[] rank;
            public UnionFind(int m) {
                this.parent = new int[m];
                for (int i = 0; i < m; i++) {
                    this.parent[i] = i;
                }
                this.rank = new int[m];
            }

            public void union(int x, int y) {
                int rootx = this.find(x);
                int rooty = this.find(y);

                if (rootx != rooty) {
                    if (rank[rootx] > rank[rooty]) {
                        parent[rooty] = rootx;
                    } else if (rank[rootx] < rank[rooty]) {
                        parent[rootx] = rooty;
                    } else {
                        parent[rooty] = rootx;
                        rank[rootx]++;
                    }
                }
            }

            public int find(int x) {
                return parent[x] == x ? x : find(parent[x]);
            }
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}