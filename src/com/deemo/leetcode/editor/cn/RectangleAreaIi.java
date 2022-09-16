//我们给出了一个（轴对齐的）二维矩形列表 rectangles 。 对于 rectangle[i] = [x1, y1, x2, y2]，其中（x1，y1）是
//矩形 i 左下角的坐标，
// (xi1, yi1) 是该矩形 左下角 的坐标，
// (xi2, yi2) 是该矩形 右上角 的坐标。 
//
// 计算平面中所有 rectangles 所覆盖的 总面积 。任何被两个或多个矩形覆盖的区域应只计算 一次 。 
//
// 返回 总面积 。因为答案可能太大，返回
// 10⁹ + 7 的 模 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：rectangles = [[0,0,2,2],[1,0,2,3],[1,0,3,1]]
//输出：6
//解释：如图所示，三个矩形覆盖了总面积为6的区域。
//从(1,1)到(2,2)，绿色矩形和红色矩形重叠。
//从(1,0)到(2,3)，三个矩形都重叠。
// 
//
// 示例 2： 
//
// 
//输入：rectangles = [[0,0,1000000000,1000000000]]
//输出：49
//解释：答案是 10¹⁸ 对 (10⁹ + 7) 取模的结果， 即 49 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= rectangles.length <= 200 
// rectanges[i].length = 4
// 
// 0 <= xi1, yi1, xi2, yi2 <= 10⁹ 
// 矩形叠加覆盖后的总面积不会超越 2^63 - 1 ，这意味着可以用一个 64 位有符号整数来保存面积结果。 
// 
//
// Related Topics 线段树 数组 有序集合 扫描线 👍 206 👎 0


package com.deemo.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RectangleAreaIi{
    public static void main(String[] args) {
         Solution solution = new RectangleAreaIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int MOD = (int)1e9+7;
        public int rectangleArea(int[][] rectangles) {
            //将所有矩形的x坐标存到list中
            List<Integer> list = new ArrayList<>();
            for(int[] info : rectangles){
                list.add(info[0]);
                list.add(info[2]);
            }
            //对list中x坐标从此小到大排序
            Collections.sort(list);
            long ans = 0;
            //每次取出两个相邻x坐标
            for(int i = 1; i <list.size(); i++){
                //令相邻x坐标距离为len，如果len=0跳过循环
                int a = list.get(i-1), b = list.get(i), len = b -a;
                if(len == 0) continue;
                //定义lines存储能够覆盖(x1,x2)的y坐标对（y1,y2）
                List<int[]> lines = new ArrayList<>();
                for(int[] info: rectangles){
                    if(info[0] <= a && info[2] >= b){//当矩形覆盖当前x区间，则将y坐标记录下来
                        lines.add(new int[]{info[1], info[3]});
                    }
                }
                //对所有的y坐标对，按照y1,y2,从小到大排序
                Collections.sort(lines, (l1, l2)->{
                    return l1[0] != l2[0] ? l1[0] - l2[0] : l1[1] - l2[1];
                });
                //定义tot存储当前x区间下，y区间的并集，l，r为上一个y区间端点
                long tot = 0, l = -1, r = -1;
                for(int[] cur: lines){//每次取出一对y区间
                    if(cur[0] > r){//如果和上次的区间不相交，则将上次区间计入总和，同时更新l,r
                        tot += r - l;
                        l = cur[0];
                        r = cur[1];
                    }else if(cur[1] > r){//如果和上次区间相交，则只更新r
                        r = cur[1];
                    }
                }
                tot += r - l;//将最后一个区间求和
                ans += tot * len;//面积为区间长度乘以高度和
                ans %= MOD;
            }
            return (int)ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}