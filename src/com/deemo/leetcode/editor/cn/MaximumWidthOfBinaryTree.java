//给你一棵二叉树的根节点 root ，返回树的 最大宽度 。 
//
// 树的 最大宽度 是所有层中最大的 宽度 。 
//
// 
// 
// 每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。将这个二叉树视作与满二叉树结构相同，两端点间会出现一些延伸到这一层的 
//null 节点，这些 null 节点也计入长度。 
// 
// 
//
// 题目数据保证答案将会在 32 位 带符号整数范围内。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,3,2,5,3,null,9]
//输出：4
//解释：最大宽度出现在树的第 3 层，宽度为 4 (5,3,null,9) 。
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,3,2,5,null,null,9,6,null,7]
//输出：7
//解释：最大宽度出现在树的第 4 层，宽度为 7 (6,null,null,null,null,null,7) 。
// 
//
// 示例 3： 
// 
// 
//输入：root = [1,3,2,5]
//输出：2
//解释：最大宽度出现在树的第 2 层，宽度为 2 (3,2) 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是 [1, 3000] 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 473 👎 0


package com.deemo.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfBinaryTree{
    public static void main(String[] args) {
        Solution solution = new MaximumWidthOfBinaryTree().new Solution();
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
        public int widthOfBinaryTree(TreeNode root) {
            int ans = 0;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(new TreeNode(1, root.left, root.right));
            while (!queue.isEmpty()) {
                int size = queue.size(), start = -1, end = -1;
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.poll();
                    // 记录头和尾巴
                    end = poll.val;
                    if (start == -1) {
                        start = poll.val;
                    }
                    if (poll.left != null) {
                        queue.offer(new TreeNode(poll.val * 2, poll.left.left, poll.left.right));
                    }
                    if (poll.right != null) {
                        queue.offer(new TreeNode(poll.val * 2 + 1, poll.right.left, poll.right.right));
                    }
                    ans = Math.max(end - start + 1, ans);
                }
            }

            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}