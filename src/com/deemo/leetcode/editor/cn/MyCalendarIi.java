//实现一个 MyCalendar 类来存放你的日程安排。如果要添加的时间内不会导致三重预订时，则可以存储这个新的日程安排。 
//
// MyCalendar 有一个 book(int start, int end)方法。它意味着在 start 到 end 时间内增加一个日程安排，注意，这里
//的时间是半开区间，即 [start, end), 实数 x 的范围为， start <= x < end。 
//
// 当三个日程安排有一些时间上的交叉时（例如三个日程安排都在同一时间内），就会产生三重预订。 
//
// 每次调用 MyCalendar.book方法时，如果可以将日程安排成功添加到日历中而不会导致三重预订，返回 true。否则，返回 false 并且不要将该
//日程安排添加到日历中。 
//
// 请按照以下步骤调用MyCalendar 类: MyCalendar cal = new MyCalendar(); MyCalendar.book(
//start, end) 
//
// 
//
// 示例： 
//
// MyCalendar();
//MyCalendar.book(10, 20); // returns true
//MyCalendar.book(50, 60); // returns true
//MyCalendar.book(10, 40); // returns true
//MyCalendar.book(5, 15); // returns false
//MyCalendar.book(5, 10); // returns true
//MyCalendar.book(25, 55); // returns true
//解释： 
//前两个日程安排可以添加至日历中。 第三个日程安排会导致双重预订，但可以添加至日历中。
//第四个日程安排活动（5,15）不能添加至日历中，因为它会导致三重预订。
//第五个日程安排（5,10）可以添加至日历中，因为它未使用已经双重预订的时间10。
//第六个日程安排（25,55）可以添加至日历中，因为时间 [25,40] 将和第三个日程安排双重预订；
//时间 [40,50] 将单独预订，时间 [50,55）将和第二个日程安排双重预订。
// 
//
// 
//
// 提示： 
//
// 
// 每个测试用例，调用 MyCalendar.book 函数最多不超过 1000次。 
// 调用函数 MyCalendar.book(start, end)时， start 和 end 的取值范围为 [0, 10^9]。 
// 
//
// Related Topics 设计 线段树 二分查找 有序集合 👍 199 👎 0


package com.deemo.leetcode.editor.cn;
public class MyCalendarIi{
    public static void main(String[] args) {
        // Solution solution = new MyCalendarIi().new Solution();
        MyCalendarTwo myCalendarTwo = new MyCalendarIi().new MyCalendarTwo();
        System.out.println(myCalendarTwo.book(10, 20));
        System.out.println(myCalendarTwo.book(50, 60));
        System.out.println(myCalendarTwo.book(10, 40));
        System.out.println(myCalendarTwo.book(5, 15));
        System.out.println(myCalendarTwo.book(5, 10));
        System.out.println(myCalendarTwo.book(25, 55));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class MyCalendarTwo {

        public MyCalendarTwo() {

        }

        public boolean book(int start, int end) {
            if (query(node, 0, N, start, end - 1) == 2) {
                return false;
            }

            update(node, 0, N, start, end - 1, 1);
            return true;
        }

        class Node {
            /**
             * 左右孩子节点
             */
            Node left, right;
            /**
             * 节点值和懒惰标记
             */
            int val, add;
        }

        private final int N = (int) 1e9;
        private final Node node = new Node();
        private void update(Node node, int start, int end, int l, int r, int val) {
            if (l <= start && end <= r) {
                node.val += val;
                node.add += val;
                return;
            }

            pushDown(node);
            int mid = (start + end) >> 1;
            if (l <= mid) {
                update(node.left, start, mid, l, r, val);
            }
            if (r > mid) {
                update(node.right, mid + 1, end, l, r, val);
            }
            pushUp(node);
        }

        private int query(Node node, int start, int end, int l, int r) {
            if (l <= start && end <= r) {
                return node.val;
            }
            pushDown(node);

            int mid = (start + end) >> 1, ans = 0;
            if (l <= mid) {
                ans = query(node.left, start, mid, l, r);
            }
            if (r > mid) {
                ans = Math.max(ans, query(node.right, mid + 1, end, l, r));
            }
            return ans;
        }

        private void pushUp(Node node) {
            node.val = Math.max(node.left.val, node.right.val);
        }

        private void pushDown(Node node) {
            if (node.left == null) {
                node.left = new Node();
            }
            if (node.right == null) {
                node.right = new Node();
            }

            if (node.add == 0) {
                return;
            }

            node.left.val += node.add;
            node.right.val += node.add;
            node.left.add += node.add;
            node.right.add += node.add;
            node.add = 0;
        }
    }

    /**
     * Your MyCalendarTwo object will be instantiated and called as such:
     * MyCalendarTwo obj = new MyCalendarTwo();
     * boolean param_1 = obj.book(start,end);
     */
    //leetcode submit region end(Prohibit modification and deletion)

}