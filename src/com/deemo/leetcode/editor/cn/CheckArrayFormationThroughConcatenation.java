//给你一个整数数组 arr ，数组中的每个整数 互不相同 。另有一个由整数数组构成的数组 pieces，其中的整数也 互不相同 。请你以 任意顺序 连接 
//pieces 中的数组以形成 arr 。但是，不允许 对每个数组 pieces[i] 中的整数重新排序。 
//
// 如果可以连接 pieces 中的数组形成 arr ，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [15,88], pieces = [[88],[15]]
//输出：true
//解释：依次连接 [15] 和 [88]
// 
//
// 示例 2： 
//
// 
//输入：arr = [49,18,16], pieces = [[16,18,49]]
//输出：false
//解释：即便数字相符，也不能重新排列 pieces[0]
// 
//
// 示例 3： 
//
// 
//输入：arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
//输出：true
//解释：依次连接 [91]、[4,64] 和 [78] 
//
// 
//
// 提示： 
//
// 
// 1 <= pieces.length <= arr.length <= 100 
// sum(pieces[i].length) == arr.length 
// 1 <= pieces[i].length <= arr.length 
// 1 <= arr[i], pieces[i][j] <= 100 
// arr 中的整数 互不相同 
// pieces 中的整数 互不相同（也就是说，如果将 pieces 扁平化成一维数组，数组中的所有整数互不相同） 
// 
//
// Related Topics 数组 哈希表 👍 118 👎 0


package com.deemo.leetcode.editor.cn;
public class CheckArrayFormationThroughConcatenation{
    public static void main(String[] args) {
         Solution solution = new CheckArrayFormationThroughConcatenation().new Solution();
        System.out.println(solution.canFormArray(new int[]{15, 88}, new int[][]{{88}, {15}}));
        System.out.println(solution.canFormArray(new int[]{49, 18, 16}, new int[][]{{16, 18, 49}}));
        System.out.println(solution.canFormArray(new int[]{91, 4, 64, 78}, new int[][]{{78}, {4, 64}, {91}}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canFormArray(int[] arr, int[][] pieces) {
            int n = arr.length, m = pieces.length;

            // 1 <= pieces.length <= arr.length <= 100
            int[] hash = new int[110];
            for (int i = 0; i < m; i++) {
                hash[pieces[i][0]] = i;
            }

            for (int i = 0; i < n; ) {
                int[] piece = pieces[hash[arr[i]]];

                int len = piece.length;
                for (int j = 0; j < piece.length; j++) {
                    if (arr[i + j] != piece[j]) {
                        return false;
                    }
                }
                i += len;
            }

            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}