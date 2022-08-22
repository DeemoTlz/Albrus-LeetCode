//给你一棵二叉树的根节点 root ，请你构造一个下标从 0 开始、大小为 m x n 的字符串矩阵 res ，用以表示树的 格式化布局 。构造此格式化布局矩
//阵需要遵循以下规则： 
//
// 
// 树的 高度 为 height ，矩阵的行数 m 应该等于 height + 1 。 
// 矩阵的列数 n 应该等于 2ʰᵉⁱᵍʰᵗ⁺¹ - 1 。 
// 根节点 需要放置在 顶行 的 正中间 ，对应位置为 res[0][(n-1)/2] 。 
// 对于放置在矩阵中的每个节点，设对应位置为 res[r][c] ，将其左子节点放置在 res[r+1][c-2ʰᵉⁱᵍʰᵗ⁻ʳ⁻¹] ，右子节点放置在 
//res[r+1][c+2ʰᵉⁱᵍʰᵗ⁻ʳ⁻¹] 。 
// 继续这一过程，直到树中的所有节点都妥善放置。 
// 任意空单元格都应该包含空字符串 "" 。 
// 
//
// 返回构造得到的矩阵 res 。 
//
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2]
//输出：
//[["","1",""],
// ["2","",""]]
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,3,null,4]
//输出：
//[["","","","1","","",""],
// ["","2","","","","3",""],
// ["","","4","","","",""]]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数在范围 [1, 2¹⁰] 内 
// -99 <= Node.val <= 99 
// 树的深度在范围 [1, 10] 内 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 184 👎 0


package com.deemo.leetcode.editor.cn;

import java.util.*;

public class PrintBinaryTree{
    public static void main(String[] args) {
        Solution solution = new PrintBinaryTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public List<List<String>> printTree(TreeNode root) {
            int height = this.height(root);
            int m = height + 1;
            int n = (1 << m) - 1;

            List<List<String>> ans = new ArrayList<>(m);
            List<String> row;
            for (int i = 0; i < m; i++) {
                row = new ArrayList<>(n);
                for (int j = 0; j < n; j++) {
                    row.add("");
                }
                ans.add(row);
            }

            this.dfs(ans, root, 0, (n - 1) / 2, height);

            return ans;
        }

        private int height(TreeNode root) {
            int h = 0;
            if (root.left != null) {
                h = Math.max(h, this.height(root.left) + 1);
            }
            if (root.right != null) {
                h = Math.max(h, this.height(root.right) + 1);
            }

            return h;
        }

        private void dfs(List<List<String>> ans, TreeNode root, int r, int c, int height) {
            ans.get(r).set(c, root.val + "");
            if (root.left != null) {
                this.dfs(ans, root.left, r + 1, c - (1 << (height - r - 1)), height);
            }
            if (root.right != null) {
                this.dfs(ans, root.right, r + 1, c + (1 << (height - r - 1)), height);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}