//你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。 
//
// 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。 
//
// 示例 1: 
//
// 
//输入: 二叉树: [1,2,3,4]
//       1
//     /   \
//    2     3
//   /    
//  4     
//
//输出: "1(2(4))(3)"
//
//解释: 原本将是“1(2(4)())(3())”，
//在你省略所有不必要的空括号对之后，
//它将是“1(2(4))(3)”。
// 
//
// 示例 2: 
//
// 
//输入: 二叉树: [1,2,3,null,4]
//       1
//     /   \
//    2     3
//     \  
//      4 
//
//输出: "1(2()(4))(3)"
//
//解释: 和第一个示例相似，
//除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。
// 
// Related Topics 树 深度优先搜索 字符串 二叉树 👍 297 👎 0


package com.deemo.leetcode;

import java.util.*;

public class ConstructStringFromBinaryTree{
    public static void main(String[] args) {
        Solution solution = new ConstructStringFromBinaryTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
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
        /**
         * 递归
         */
        // public String tree2str(TreeNode root) {
        //     if (root == null) {
        //         return "";
        //     }
        //
        //     // 都为空，返回值
        //     if (root.left == null && root.right == null) {
        //         return Integer.toString(root.val);
        //     }
        //
        //     // 前有都为空，此处判断后一个是否为空，如果后一个为空，则前一个一定不为空
        //     if (root.right == null) {
        //         return root.val + "(" + tree2str(root.left) + ")";
        //     }
        //     // 到此，left 和 right 一定不为空
        //     return root.val + "(" + tree2str(root.left) + ")" + "(" + tree2str(root.right) + ")";
        // }

        /**
         * 迭代
         * 使用栈，因为需要前后添加括号，因此一个元素需要入栈出栈两次，可以使用 Set 集合记录该节点是第几次出栈
         */
        public String tree2str(TreeNode root) {
            if (root == null) {
                return "";
            }

            StringBuilder sb = new StringBuilder();
            // 使用队列模拟栈
            Deque<TreeNode> stack = new ArrayDeque<>();
            Set<TreeNode> visited = new HashSet<>();

            // 将根元素添加到顶部
            stack.push(root);

            TreeNode peek;
            while (!stack.isEmpty()) {
                peek = stack.peek();

                if (visited.add(peek)) {
                    // 添加成功，说明第一次遇到，可以前序遍历
                    sb.append("(").append(peek.val);

                    // 都为空，返回值
                    if (peek.left == null && peek.right != null) {
                        sb.append("()");
                    }

                    // 因为 push 是将元素添加到队首，因此先放 right 再放 left
                    if (peek.right != null) {
                        stack.push(peek.right);
                    }
                    if (peek.left != null) {
                        stack.push(peek.left);
                    }
                } else {
                    // 添加失败，说明之前已经有了，需要将该元素移除
                    sb.append(")");
                    stack.pop();
                }
            }

            // 移除根元素的前后括号
            return sb.substring(1, sb.length() - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}