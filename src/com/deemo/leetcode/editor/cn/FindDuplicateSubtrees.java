//给定一棵二叉树 root，返回所有重复的子树。 
//
// 对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。 
//
// 如果两棵树具有相同的结构和相同的结点值，则它们是重复的。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,2,3,4,null,2,4,null,null,4]
//输出：[[2,4],[4]] 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [2,1,1]
//输出：[[1]] 
//
// 示例 3： 
//
// 
//
// 
//输入：root = [2,2,2,3,null,3,null]
//输出：[[2,3],[3]] 
//
// 
//
// 提示： 
//
// 
// 树中的结点数在[1,10^4]范围内。 
// -200 <= Node.val <= 200 
// 
//
// Related Topics 树 深度优先搜索 哈希表 二叉树 👍 557 👎 0


package com.deemo.leetcode.editor.cn;

import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class FindDuplicateSubtrees{
    public static void main(String[] args) {
        Solution solution = new FindDuplicateSubtrees().new Solution();
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
        Map<String, Pair<TreeNode, Integer>> seen = new HashMap<>();
        Set<TreeNode> ans = new HashSet<>();
        /** 使用序号简化三元组 */
        int idx = 0;
        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            this.dfs(root);
            return new ArrayList<>(ans);
        }

        /**
         * 给每个不同的子树分配唯一序号
         */
        private int dfs(TreeNode node) {
            if (node == null) {
                return 0;
            }

            int[] tri = {node.val, this.dfs(node.left), this.dfs(node.right)};
            String hash = Arrays.toString(tri);
            int before = idx;
            Pair<TreeNode, Integer> pair = seen.computeIfAbsent(hash, k -> new Pair<>(node, ++idx));
            if (before == idx) {
                // 注意是 pair.getKey() 因为 TreeNode 没有重写 hashcode() equals()
                ans.add(pair.getKey());
            }
            return pair.getValue();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}