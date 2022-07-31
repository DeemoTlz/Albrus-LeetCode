<p>给定一个由不同正整数的组成的非空数组&nbsp;<code>nums</code> ，考虑下面的图：</p>

<ul> 
 <li>有&nbsp;<code>nums.length</code>&nbsp;个节点，按从&nbsp;<code>nums[0]</code>&nbsp;到&nbsp;<code>nums[nums.length - 1]</code>&nbsp;标记；</li> 
 <li>只有当&nbsp;<code>nums[i]</code>&nbsp;和&nbsp;<code>nums[j]</code>&nbsp;共用一个大于 1 的公因数时，<code>nums[i]</code>&nbsp;和&nbsp;<code>nums[j]</code>之间才有一条边。</li> 
</ul>

<p>返回 <em>图中最大连通组件的大小</em> 。</p>

<p>&nbsp;</p>

<ol> 
</ol>

<p><strong>示例 1：</strong></p>

<p><img src="https://assets.leetcode.com/uploads/2018/12/01/ex1.png" style="height: 97px; width: 500px;" /></p>

<pre>
<strong>输入：</strong>nums = [4,6,15,35]
<strong>输出：</strong>4
</pre>

<p><strong>示例 2：</strong></p>

<p><img src="https://assets.leetcode.com/uploads/2018/12/01/ex2.png" style="height: 85px; width: 500px;" /></p>

<pre>
<strong>输入：</strong>nums = [20,50,9,63]
<strong>输出：</strong>2
</pre>

<p><strong>示例 3：</strong></p>

<p><img src="https://assets.leetcode.com/uploads/2018/12/01/ex3.png" style="height: 260px; width: 500px;" /></p>

<pre>
<strong>输入：</strong>nums = [2,3,6,7,4,12,21,39]
<strong>输出：</strong>8
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 2 * 10<sup>4</sup></code></li> 
 <li><code>1 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li> 
 <li><code>nums</code>&nbsp;中所有值都 <strong>不同</strong></li> 
</ul>

<div><div>Related Topics</div><div><li>并查集</li><li>数组</li><li>数学</li></div></div><br><div><li>👍 123</li><li>👎 0</li></div>