//给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。 
//
// 在比较时，字母是依序循环出现的。举个例子： 
//
// 
// 如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a' 
// 
//
// 
//
// 示例 1： 
//
// 
//输入: letters = ["c", "f", "j"]，target = "a"
//输出: "c"
// 
//
// 示例 2: 
//
// 
//输入: letters = ["c","f","j"], target = "c"
//输出: "f"
// 
//
// 示例 3: 
//
// 
//输入: letters = ["c","f","j"], target = "d"
//输出: "f"
// 
//
// 
//
// 提示： 
//
// 
// 2 <= letters.length <= 10⁴ 
// letters[i] 是一个小写字母 
// letters 按非递减顺序排序 
// letters 最少包含两个不同的字母 
// target 是一个小写字母 
// 
// Related Topics 数组 二分查找 👍 153 👎 0


package com.deemo.leetcode.editor.cn;
public class FindSmallestLetterGreaterThanTarget{
    public static void main(String[] args) {
        Solution solution = new FindSmallestLetterGreaterThanTarget().new Solution();
        System.out.println(solution.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'j'));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public char nextGreatestLetter(char[] letters, char target) {
            // 大于等于，细心
            if (target >= letters[letters.length - 1]) {
                return letters[0];
            }

            int low = 0, high = letters.length - 1, mid;
            // 左闭右开
            while (low < high) {
                mid = (high + low) / 2;
                if (letters[mid] > target) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            return letters[low];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}