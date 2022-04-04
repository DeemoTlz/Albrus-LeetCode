//给你一个数组 nums ，请你完成两类查询。
//
// 
// 其中一类查询要求 更新 数组 nums 下标对应的值 
// 另一类查询要求返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元素的 和 ，其中 left <= right 
// 
//
// 实现 NumArray 类： 
//
// 
// NumArray(int[] nums) 用整数数组 nums 初始化对象 
// void update(int index, int val) 将 nums[index] 的值 更新 为 val 
// int sumRange(int left, int right) 返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元
//素的 和 （即，nums[left] + nums[left + 1], ..., nums[right]） 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：
//["NumArray", "sumRange", "update", "sumRange"]
//[[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
//输出：
//[null, 9, null, 8]
//
//解释：
//NumArray numArray = new NumArray([1, 3, 5]);
//numArray.sumRange(0, 2); // 返回 1 + 3 + 5 = 9
//numArray.update(1, 2);   // nums = [1,2,5]
//numArray.sumRange(0, 2); // 返回 1 + 2 + 5 = 8
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// -100 <= nums[i] <= 100 
// 0 <= index < nums.length 
// -100 <= val <= 100 
// 0 <= left <= right < nums.length 
// 调用 update 和 sumRange 方法次数不大于 3 * 10⁴ 
// 
// Related Topics 设计 树状数组 线段树 数组 👍 447 👎 0


package com.deemo.leetcode.editor.cn;
public class RangeSumQueryMutable{
    public static void main(String[] args) {

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class NumArray {
        /**
         * 各个块的和
         */
        private int[] sums;
        /**
         * 块的大小
         */
        private int size;
        /**
         * 数组
         */
        private int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
            int n = nums.length;
            this.size = (int) Math.sqrt(n);
            // 向上取整
            this.sums = new int[(n + size - 1) / size];
            for (int i = 0; i < n; i++) {
                this.sums[i / size] += nums[i];
            }
        }

        public void update(int index, int val) {
            // 更新块的和
            this.sums[index / size] += val - this.nums[index];
            // 更新下标元素
            this.nums[index] = val;
        }

        public int sumRange(int left, int right) {
            int sum = 0;
            // 在同一块时，直接计算
            int b1 = left / size, b2 = right / size;
            if (b1 == b2) {
                for (int i = left; i <= right; i++) {
                    sum += this.nums[i];
                }

                return sum;
            }

            int i1 = left % size, i2 = right % size;
            // 不在同一块时，分三段取（左、中、右）
            // 左块（左边界到左块最右边）
            for (int i = i1; i < size; i++) {
                sum += this.nums[b1 * size + i];
            }

            // 中间（中间块）
            for (int i = b1 + 1; i < b2; i++) {
                sum += this.sums[i];
            }

            // 右边（右块起始到右）
            for (int i = 0; i <= i2; i++) {
                sum += this.nums[b2 * size + i];
            }

            return sum;
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
//leetcode submit region end(Prohibit modification and deletion)

}