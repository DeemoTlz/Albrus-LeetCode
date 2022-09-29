//字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。 
//
// 示例1: 
//
//  输入：s1 = "waterbottle", s2 = "erbottlewat"
// 输出：True
// 
//
// 示例2: 
//
//  输入：s1 = "aa", s2 = "aba"
// 输出：False
// 
//
// 
// 
//
// 提示： 
//
// 
// 字符串长度在[0, 100000]范围内。 
// 
//
// 说明: 
//
// 
// 你能只调用一次检查子串的方法吗？ 
// 
//
// Related Topics 字符串 字符串匹配 👍 195 👎 0


package com.deemo.leetcode.editor.cn;
public class StringRotationLcci{
    public static void main(String[] args) {
         Solution solution = new StringRotationLcci().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isFlipedString(String s1, String s2) {
            // 更简单的：s1 + s2 contains s2 ?
            int n = s1.length();
            if (n != s2.length()) {
                return false;
            }
            if (n == 0) {
                return true;
            }

            for (int i = 0; i < n; i++) {
                boolean flag = true;
                for (int j = 0; j < n; j++) {
                    if (s1.charAt((i + j) % n) != s2.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return true;
                }
            }


            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}