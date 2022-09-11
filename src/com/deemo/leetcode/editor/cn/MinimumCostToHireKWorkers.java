//有 n 名工人。 给定两个数组 quality 和 wage ，其中，quality[i] 表示第 i 名工人的工作质量，其最低期望工资为 wage[i] 
//。 
//
// 现在我们想雇佣 k 名工人组成一个工资组。在雇佣 一组 k 名工人时，我们必须按照下述规则向他们支付工资： 
//
// 
// 对工资组中的每名工人，应当按其工作质量与同组其他工人的工作质量的比例来支付工资。 
// 工资组中的每名工人至少应当得到他们的最低期望工资。 
// 
//
// 给定整数 k ，返回 组成满足上述条件的付费群体所需的最小金额 。在实际答案的 10⁻⁵ 以内的答案将被接受。。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入： quality = [10,20,5], wage = [70,50,30], k = 2
//输出： 105.00000
//解释： 我们向 0 号工人支付 70，向 2 号工人支付 35。 
//
// 示例 2： 
//
// 
//输入： quality = [3,1,10,10,1], wage = [4,8,2,2,7], k = 3
//输出： 30.66667
//解释： 我们向 0 号工人支付 4，向 2 号和 3 号分别支付 13.33333。 
//
// 
//
// 提示： 
//
// 
// n == quality.length == wage.length 
// 1 <= k <= n <= 10⁴ 
// 1 <= quality[i], wage[i] <= 10⁴ 
// 
//
// Related Topics 贪心 数组 排序 堆（优先队列） 👍 227 👎 0


package com.deemo.leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class MinimumCostToHireKWorkers{
    public static void main(String[] args) {
        Solution solution = new MinimumCostToHireKWorkers().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
            int n = quality.length;

            // 每单位工作质量的薪资 r 从小到大排序
            Integer[] h = IntStream.range(0, n).boxed().toArray(Integer[]::new);
            // 除法 转 乘法
            Arrays.sort(h, (a, b) -> quality[b] * wage[a] - quality[a] * wage[b]);

            int sumQ = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
            for (int i = 0; i < k; i++) {
                pq.offer(quality[h[i]]);
                sumQ += quality[h[i]];
            }

            // h 中按 r 从小到大排序，按第 k 个人的等级发工资，k 之前的人可以拿到更高的薪资，是可以任意选择的
            double ans = sumQ * ((double) wage[h[k - 1]] / quality[h[k - 1]]);
            for (int i = k; i < n; i++) {
                int q = quality[h[i]];
                // 动态求解
                if (q < pq.peek()) {
                    sumQ -= pq.poll() - q;
                    pq.offer(q);
                    // 按当前 i 的人算工资
                    ans = Math.min(ans, sumQ * ((double)wage[h[i]] / q));
                }
            }

            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}