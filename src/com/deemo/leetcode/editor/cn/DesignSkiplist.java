//不使用任何库函数，设计一个 跳表 。 
//
// 跳表 是在 O(log(n)) 时间内完成增加、删除、搜索操作的数据结构。跳表相比于树堆与红黑树，其功能与性能相当，并且跳表的代码长度相较下更短，其设计思
//想与链表相似。 
//
// 例如，一个跳表包含 [30, 40, 50, 60, 70, 90] ，然后增加 80、45 到跳表中，以下图的方式操作： 
//
// 
//Artyom Kalinin [CC BY-SA 3.0], via Wikimedia Commons 
//
// 跳表中有很多层，每一层是一个短的链表。在第一层的作用下，增加、删除和搜索操作的时间复杂度不超过 O(n)。跳表的每一个操作的平均时间复杂度是 O(log(
//n))，空间复杂度是 O(n)。 
//
// 了解更多 : https://en.wikipedia.org/wiki/Skip_list 
//
// 在本题中，你的设计应该要包含这些函数： 
//
// 
// bool search(int target) : 返回target是否存在于跳表中。 
// void add(int num): 插入一个元素到跳表。 
// bool erase(int num): 在跳表中删除一个值，如果 num 不存在，直接返回false. 如果存在多个 num ，删除其中任意一个即可。 
//
// 
//
// 注意，跳表中可能存在多个相同的值，你的代码需要处理这种情况。 
//
// 
//
// 示例 1: 
//
// 
//输入
//["Skiplist", "add", "add", "add", "search", "add", "search", "erase", "erase",
// "search"]
//[[], [1], [2], [3], [0], [4], [1], [0], [1], [1]]
//输出
//[null, null, null, null, false, null, true, false, true, false]
//
//解释
//Skiplist skiplist = new Skiplist();
//skiplist.add(1);
//skiplist.add(2);
//skiplist.add(3);
//skiplist.search(0);   // 返回 false
//skiplist.add(4);
//skiplist.search(1);   // 返回 true
//skiplist.erase(0);    // 返回 false，0 不在跳表中
//skiplist.erase(1);    // 返回 true
//skiplist.search(1);   // 返回 false，1 已被擦除
// 
//
// 
//
// 提示: 
//
// 
// 0 <= num, target <= 2 * 10⁴ 
// 调用search, add, erase操作次数不大于 5 * 10⁴ 
// 
// Related Topics 设计 链表 👍 195 👎 0


package com.deemo.leetcode.editor.cn;

import java.util.Random;

public class DesignSkiplist{
    public static void main(String[] args) {
        Skiplist skiplist = new DesignSkiplist().new Skiplist();
        skiplist.add(30);
        skiplist.add(40);
        skiplist.add(45);
        skiplist.add(50);
        skiplist.add(60);
        skiplist.add(70);
        skiplist.add(90);
        System.out.println("=========");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Skiplist {
        int level = 10;
        Random random = new Random();
        // 哨兵节点
        Node he = new Node(-1);

        public Skiplist() {

        }

        public boolean search(int target) {
            Node[] ns = new Node[this.level];
            this.find(target, ns);

            return ns[0].ne[0] != null && ns[0].ne[0].val == target;
        }

        public void add(int num) {
            Node[] ns = new Node[this.level];
            this.find(num, ns);

            Node node = new Node(num);
            for (int i = 0; i < this.level; i++) {
                node.ne[i] = ns[i].ne[i];
                ns[i].ne[i] = node;
                if (random.nextInt(2) == 0) {
                    break;
                }
            }
        }

        public boolean erase(int num) {
            Node[] ns = new Node[this.level];
            find(num, ns);

            // 第 0 层是单链表，第 0 个就能判断是不是有这个元素
            Node node = ns[0].ne[0];
            if (node == null || node.val != num) {
                return false;
            }

            for (int i = 0; i < this.level && ns[i].ne[i] == node; i++) {
                ns[i].ne[i] = ns[i].ne[i].ne[i];
            }
            return true;
        }

        private void find(int t, Node[] ns) {
            Node cur = this.he;

            for (int i = this.level - 1; i >= 0; i--) {
                while (cur.ne[i] != null && cur.ne[i].val < t) {
                    cur = cur.ne[i];
                }
                ns[i] = cur;
            }
        }

        class Node {
            int val;
            Node[] ne = new Node[level];
            Node (int val) {
                this.val = val;
            }
        }
    }

    /**
     * Your Skiplist object will be instantiated and called as such:
     * Skiplist obj = new Skiplist();
     * boolean param_1 = obj.search(target);
     * obj.add(num);
     * boolean param_3 = obj.erase(num);
     */
    //leetcode submit region end(Prohibit modification and deletion)

}