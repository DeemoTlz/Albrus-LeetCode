//给定一个表示分数加减运算的字符串 expression ，你需要返回一个字符串形式的计算结果。 
//
// 这个结果应该是不可约分的分数，即最简分数。 如果最终结果是一个整数，例如 2，你需要将它转换成分数形式，其分母为 1。所以在上述例子中, 2 应该被转换为
// 2/1。 
//
// 
//
// 示例 1: 
//
// 
//输入: expression = "-1/2+1/2"
//输出: "0/1"
// 
//
// 示例 2: 
//
// 
//输入: expression = "-1/2+1/2+1/3"
//输出: "1/3"
// 
//
// 示例 3: 
//
// 
//输入: expression = "1/3-1/2"
//输出: "-1/6"
// 
//
// 
//
// 提示: 
//
// 
// 输入和输出字符串只包含 '0' 到 '9' 的数字，以及 '/', '+' 和 '-'。 
// 输入和输出分数格式均为 ±分子/分母。如果输入的第一个分数或者输出的分数是正数，则 '+' 会被省略掉。 
// 输入只包含合法的最简分数，每个分数的分子与分母的范围是 [1,10]。 如果分母是1，意味着这个分数实际上是一个整数。 
// 输入的分数个数范围是 [1,10]。 
// 最终结果的分子与分母保证是 32 位整数范围内的有效整数。 
// 
// Related Topics 数学 字符串 模拟 👍 105 👎 0


package com.deemo.leetcode.editor.cn;
public class FractionAdditionAndSubtraction{
    public static void main(String[] args) {
        Solution solution = new FractionAdditionAndSubtraction().new Solution();
        System.out.println(solution.fractionAddition("1/3-1/2"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String fractionAddition(String s) {
            // 每遇到一个分数，直接与 ans 计算，初始 ans 为空的时候，直接赋值给 ans
            String ans = "";

            // 字符处理
            int n = s.length();
            for (int i = 0; i < n; ) {
                int j = i + 1;
                while (j < n && s.charAt(j) != '+' && s.charAt(j) != '-') {
                    j++;
                }
                String num = s.substring(i, j);
                if (num.charAt(0) != '+' && num.charAt(0) != '-') {
                    num = '+' + num;
                }

                // 计算
                ans = "".equals(ans) ? num : this.calc(ans, num);

                // 从下一个 + - 开始
                i = j;
            }

            return ans.charAt(0) == '+' ? ans.substring(1) : ans;
        }

        private String calc(String a, String b) {
            boolean fa = a.charAt(0) == '+', fb = b.charAt(0) == '+';
            // 保证 正数 + 负数，避免 负数 + 正数
            if (!fa && fb) {
                return this.calc(b, a);
            }

            // 解析数字
            Long[] p = this.parse(a), q = this.parse(b);
            long p1 = p[0] * q[1], q1 = q[0] * p[1], r = p[1] * q[1];
            if (fa && fb) {
                // 两个 正数
                long r1 = p1 + q1, c = this.gcd(r1, r);
                return "+" + (r1 / c) + "/" + (r / c);
            } else if (fa) {
                // 一正 一负
                // 有可能是负数
                long r1 = p1 - q1, c = this.gcd(Math.abs(r1), r);
                return (r1 >= 0 ? "+" : "") + (r1 / c) + "/" + (r / c);
            } else {
                // 两个负数
                long r1 = p1 + q1, c = this.gcd(r1, r);
                return "-" + (r1 / c) + "/" + (r / c);
            }
        }

        private Long[] parse(String s) {
            int index = s.indexOf("/");
            // [分子, 分母]
            return new Long[]{Long.valueOf(s.substring(1, index)), Long.valueOf(s.substring(index + 1))};
        }

        /**
         * 最大公约数
         */
        private long gcd(long a, long b) {
            return b == 0 ? a : this.gcd(b, a % b);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}