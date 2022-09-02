//给定一个二叉树的
// root ，返回 最长的路径的长度 ，这个路径中的 每个节点具有相同值 。 这条路径可以经过也可以不经过根节点。 
//
// 两个节点之间的路径长度 由它们之间的边数表示。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：root = [5,4,5,1,1,5]
//输出：2
// 
//
// 示例 2: 
//
// 
//
// 
//输入：root = [1,4,5,4,4,5]
//输出：2
// 
//
// 
//
// 提示: 
//
// 
// 树的节点数的范围是
// [0, 10⁴] 
// -1000 <= Node.val <= 1000 
// 树的深度将不超过 1000 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 626 👎 0


package com.deemo.leetcode.editor.cn;
public class LongestUnivaluePath{
    public static void main(String[] args) {
        Solution solution = new LongestUnivaluePath().new Solution();
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
        int ans = 0;
        public int longestUnivaluePath(TreeNode root) {
            if (root == null) {
                return 0;
            }

            // 重点是单向、非根节点不能既向左右向右
            dfs(root);
            return ans;
        }

        public int dfs(TreeNode node) {
            int left = 0, right = 0;

            if (node.left != null) {
                left = dfs(node.left);
                // 重点，不相等时要清零
                left = node.val == node.left.val ? ++left : 0;
            }

            if (node.right != null) {
                right = dfs(node.right);
                // 重点，不相等时要清零
                right = node.val == node.right.val ? ++right : 0;
            }

            ans = Math.max(ans, left + right);
            // 返回单向最大的边数
            return Math.max(left, right);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}