//给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。 
//
// 请返回层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,7,0,7,-8,null,null]
//输出：2
//解释：
//第 1 层各元素之和为 1，
//第 2 层各元素之和为 7 + 0 = 7，
//第 3 层各元素之和为 7 + -8 = -1，
//所以我们返回第 2 层的层号，它的层内元素之和最大。
// 
//
// 示例 2： 
//
// 
//输入：root = [989,null,10250,98693,-89388,null,null,null,-32127]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在
// [1, 10⁴]范围内
// 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 69 👎 0


package com.deemo.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSumOfABinaryTree{
    public static void main(String[] args) {
        Solution solution = new MaximumLevelSumOfABinaryTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    class Solution {
        public int maxLevelSum(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            int idx;
            // 注意最小值的取定，因为存在负数
            int level = 0, ans = Integer.MIN_VALUE;
            int tempLevel = 0, tempAns;
            TreeNode node;
            while (!queue.isEmpty()) {
                tempLevel++;
                idx = queue.size();
                tempAns = 0;
                for (int i = 0; i < idx; i++) {
                    node = queue.poll();
                    tempAns += node.val;

                    if (node.left != null) {
                        queue.offer(node.left);
                    };
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }

                if (tempAns > ans) {
                    level = tempLevel;
                    ans = tempAns;
                }
            }
            return level;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}