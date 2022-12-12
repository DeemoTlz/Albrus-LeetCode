//一个字符串的 美丽值 定义为：出现频率最高字符与出现频率最低字符的出现次数之差。 
//
// 
// 比方说，"abaacc" 的美丽值为 3 - 1 = 2 。 
// 
//
// 给你一个字符串 s ，请你返回它所有子字符串的 美丽值 之和。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aabcb"
//输出：5
//解释：美丽值不为零的字符串包括 ["aab","aabc","aabcb","abcb","bcb"] ，每一个字符串的美丽值都为 1 。 
//
// 示例 2： 
//
// 
//输入：s = "aabcbaa"
//输出：17
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 500 
// s 只包含小写英文字母。 
// 
//
// Related Topics 哈希表 字符串 计数 👍 59 👎 0


package com.deemo.leetcode.editor.cn;
public class SumOfBeautyOfAllSubstrings{
    public static void main(String[] args) {
        Solution solution = new SumOfBeautyOfAllSubstrings().new Solution();
        System.out.println(solution.beautySum("aabcb"));
        System.out.println(solution.beautySum("aabcbaa"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int beautySum(String s) {
            int ans = 0;
            int n = s.length();
            for (int i = 0; i < n; i++) {
                int[] cnt = new int[26];
                int max = 0;
                for (int j = i; j < n; j++) {
                    cnt[s.charAt(j) - 'a']++;
                    max = Math.max(max, cnt[s.charAt(j) - 'a']);

                    int min = n;
                    for (int k = 0; k < 26; k++) {
                        if (cnt[k] > 0) {
                            min = Math.min(min, cnt[k]);
                        }
                    }
                    ans += (max - min);
                }
            }

            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}