//神奇字符串 s 仅由 '1' 和 '2' 组成，并需要遵守下面的规则： 
//
// 
// 神奇字符串 s 的神奇之处在于，串联字符串中 '1' 和 '2' 的连续出现次数可以生成该字符串。 
// 
//
// s 的前几个元素是 s = "1221121221221121122……" 。如果将 s 中连续的若干 1 和 2 进行分组，可以得到 "1 22 11 
//2 1 22 1 22 11 2 11 22 ......" 。每组中 1 或者 2 的出现次数分别是 "1 2 2 1 1 2 1 2 2 1 2 2 ...
//..." 。上面的出现次数正是 s 自身。 
//
// 给你一个整数 n ，返回在神奇字符串 s 的前 n 个数字中 1 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 6
//输出：3
//解释：神奇字符串 s 的前 6 个元素是 “122112”，它包含三个 1，因此返回 3 。 
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁵ 
// 
//
// Related Topics 双指针 字符串 👍 147 👎 0


package com.deemo.leetcode.editor.cn;
public class MagicalString{
    public static void main(String[] args) {
        Solution solution = new MagicalString().new Solution();
        System.out.println(solution.magicalString(6));
        System.out.println(solution.magicalString(1));
        System.out.println(solution.magicalString(10));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int magicalString(int n) {
            int[] magic = new int[n + 10];
            magic[0] = 1;

            int p = 1, tail = 1, count = 2, ans = 1, value = 1;
            while (tail < n) {
                value ^= 3;
                while (count-- > 0 && tail < n) {
                    magic[tail++] = value;
                    if (value == 1) {
                        ans++;
                    }
                }
                count = magic[++p];
            }

            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}