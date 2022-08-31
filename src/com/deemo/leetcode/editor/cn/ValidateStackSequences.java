//给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时
//，返回 true；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
//输出：true
//解释：我们可以按以下顺序执行：
//push(1), push(2), push(3), push(4), pop() -> 4,
//push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
// 
//
// 示例 2： 
//
// 
//输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
//输出：false
//解释：1 不能在 2 之前弹出。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= pushed.length <= 1000 
// 0 <= pushed[i] <= 1000 
// pushed 的所有元素 互不相同 
// popped.length == pushed.length 
// popped 是 pushed 的一个排列 
// 
//
// Related Topics 栈 数组 模拟 👍 324 👎 0


package com.deemo.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class ValidateStackSequences{
    public static void main(String[] args) {
        Solution solution = new ValidateStackSequences().new Solution();
        System.out.println(solution.validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,5,3,2,1}));
        System.out.println(solution.validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,5,3,1,2}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Deque<Integer> queue = new LinkedList<>();
            int idx = 0;
            for (int i : pushed) {
                queue.offerLast(i);

                while (!queue.isEmpty() && queue.peekLast() == popped[idx]) {
                    queue.pollLast();
                    idx++;
                }
            }

            return queue.isEmpty();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}