//我们有一些二维坐标，如 "(1, 3)" 或 "(2, 0.5)"，然后我们移除所有逗号，小数点和空格，得到一个字符串S。返回所有可能的原始字符串到一个列表
//中。 
//
// 原始的坐标表示法不会存在多余的零，所以不会出现类似于"00", "0.0", "0.00", "1.0", "001", "00.01"或一些其他更小的数
//来表示坐标。此外，一个小数点前至少存在一个数，所以也不会出现“.1”形式的数字。 
//
// 最后返回的列表可以是任意顺序的。而且注意返回的两个数字中间（逗号之后）都有一个空格。 
//
// 
//
// 
//示例 1:
//输入: "(123)"
//输出: ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]
// 
//
// 
//示例 2:
//输入: "(00011)"
//输出:  ["(0.001, 1)", "(0, 0.011)"]
//解释: 
//0.0, 00, 0001 或 00.01 是不被允许的。
// 
//
// 
//示例 3:
//输入: "(0123)"
//输出: ["(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 
//3)"]
// 
//
// 
//示例 4:
//输入: "(100)"
//输出: [(10, 0)]
//解释: 
//1.0 是不被允许的。
// 
//
// 
//
// 提示: 
//
// 
// 4 <= S.length <= 12. 
// S[0] = "(", S[S.length - 1] = ")", 且字符串 S 中的其他元素都是数字。 
// 
//
// 
//
// Related Topics 字符串 回溯 👍 131 👎 0


package com.deemo.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class AmbiguousCoordinates{
    public static void main(String[] args) {
        Solution solution = new AmbiguousCoordinates().new Solution();
        System.out.println(solution.ambiguousCoordinates("(123)"));
        System.out.println(solution.ambiguousCoordinates("(00011)"));
        System.out.println(solution.ambiguousCoordinates("(0123)"));
        System.out.println(solution.ambiguousCoordinates("(100)"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> ambiguousCoordinates(String s) {
            List<String> ans = new ArrayList<>();
            s = s.substring(1, s.length() - 1);

            int n = s.length();
            for (int i = 1; i < n; i++) {
                for (String x : this.getNums(s.substring(0, i))) {
                    for (String y : this.getNums(s.substring(i))) {
                        ans.add("(" + x + ", " + y + ")");
                    }
                }
            }

            return ans;
        }

        private List<String> getNums(String num) {
            List<String> nums = new ArrayList<>();

            int n = num.length();
            String left, right;
            for (int i = 1; i <= n; i++) {
                // 整数
                left = num.substring(0, i);
                // 小数
                right = num.substring(i);

                if (left.length() > 1 && left.charAt(0) == '0') {
                    continue;
                }
                if (right.length() > 0 && right.charAt(right.length() - 1) == '0') {
                    continue;
                }

                if (right.isEmpty()) {
                    nums.add(left);
                } else {
                    nums.add(left + "." + right);
                }
            }

            return nums;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}