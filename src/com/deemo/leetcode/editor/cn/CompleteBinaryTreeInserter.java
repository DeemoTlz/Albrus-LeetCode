//完全二叉树 是每一层（除最后一层外）都是完全填充（即，节点数达到最大）的，并且所有的节点都尽可能地集中在左侧。 
//
// 设计一种算法，将一个新节点插入到一个完整的二叉树中，并在插入后保持其完整。 
//
// 实现 CBTInserter 类: 
//
// 
// CBTInserter(TreeNode root) 使用头节点为 root 的给定树初始化该数据结构； 
// CBTInserter.insert(int v) 向树中插入一个值为 Node.val == val的新节点 TreeNode。使树保持完全二叉树的状态
//，并返回插入节点 TreeNode 的父节点的值； 
// CBTInserter.get_root() 将返回树的头节点。 
// 
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
//输入
//["CBTInserter", "insert", "insert", "get_root"]
//[[[1, 2]], [3], [4], []]
//输出
//[null, 1, 2, [1, 2, 3, 4]]
//
//解释
//CBTInserter cBTInserter = new CBTInserter([1, 2]);
//cBTInserter.insert(3);  // 返回 1
//cBTInserter.insert(4);  // 返回 2
//cBTInserter.get_root(); // 返回 [1, 2, 3, 4] 
//
// 
//
// 提示： 
//
// 
// 树中节点数量范围为 [1, 1000] 
// 0 <= Node.val <= 5000 
// root 是完全二叉树 
// 0 <= val <= 5000 
// 每个测试用例最多调用 insert 和 get_root 操作 10⁴ 次 
// 
// Related Topics 树 广度优先搜索 设计 二叉树 👍 129 👎 0


package com.deemo.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CompleteBinaryTreeInserter {
    public static void main(String[] args) {
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

    /**
     * FROM sanye
     */
    class CBTInserter {
        List<TreeNode> list = new ArrayList<>();
        int idx;

        public CBTInserter(TreeNode root) {
            list.add(root);
            int cur = 0;
            TreeNode node;
            while (cur < list.size()) {
                node = list.get(cur);
                if (node.left != null) {
                    list.add(node.left);
                }
                if (node.right != null) {
                    list.add(node.right);
                }
                cur++;
            }
        }

        public int insert(int val) {
            TreeNode node = list.get(idx);
            while (node.left != null && node.right != null) {
                node = list.get(++idx);
            }

            if (node.left == null) {
                node.left = new TreeNode(val);
                list.add(node.left);
            } else {
                node.right = new TreeNode(val);
                list.add(node.right);
            }
            return node.val;
        }

        public TreeNode get_root() {
            return list.get(0);
        }
    }

    /**
     * FROM ALBRUS
     */
    /*class CBTInserter {
        TreeNode root;

        public CBTInserter(TreeNode root) {
            this.root = root;
        }

        public int insert(int val) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            TreeNode node;
            for (;;) {
                node = queue.poll();
                if (node.left == null) {
                    node.left = new TreeNode(val);
                    return node.val;
                }
                if (node.right == null) {
                    node.right = new TreeNode(val);
                    return node.val;
                }

                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        public TreeNode get_root() {
            return root;
        }
    }*/

    /**
     * Your CBTInserter object will be instantiated and called as such:
     * CBTInserter obj = new CBTInserter(root);
     * int param_1 = obj.insert(val);
     * TreeNode param_2 = obj.get_root();
     */
    //leetcode submit region end(Prohibit modification and deletion)

}