<p>给你两个长度可能不等的整数数组&nbsp;<code>nums1</code> 和&nbsp;<code>nums2</code>&nbsp;。两个数组中的所有值都在&nbsp;<code>1</code>&nbsp;到&nbsp;<code>6</code>&nbsp;之间（包含&nbsp;<code>1</code>&nbsp;和&nbsp;<code>6</code>）。</p>

<p>每次操作中，你可以选择 <strong>任意</strong>&nbsp;数组中的任意一个整数，将它变成 <code>1</code>&nbsp;到 <code>6</code>&nbsp;之间 <strong>任意</strong>&nbsp;的值（包含 <code>1</code>&nbsp;和 <code><span style="">6</span></code>）。</p>

<p>请你返回使 <code>nums1</code>&nbsp;中所有数的和与&nbsp;<code>nums2</code>&nbsp;中所有数的和相等的最少操作次数。如果无法使两个数组的和相等，请返回 <code>-1</code>&nbsp;。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><b>输入：</b>nums1 = [1,2,3,4,5,6], nums2 = [1,1,2,2,2,2]
<b>输出：</b>3
<b>解释：</b>你可以通过 3 次操作使 nums1 中所有数的和与 nums2 中所有数的和相等。以下数组下标都从 0 开始。
- 将 nums2[0] 变为 6 。 nums1 = [1,2,3,4,5,6], nums2 = [<strong>6</strong>,1,2,2,2,2] 。
- 将 nums1[5] 变为 1 。 nums1 = [1,2,3,4,5,<strong>1</strong>], nums2 = [6,1,2,2,2,2] 。
- 将 nums1[2] 变为 2 。 nums1 = [1,2,<strong>2</strong>,4,5,1], nums2 = [6,1,2,2,2,2] 。
</pre>

<p><strong>示例 2：</strong></p>

<pre><b>输入：</b>nums1 = [1,1,1,1,1,1,1], nums2 = [6]
<b>输出：</b>-1
<b>解释：</b>没有办法减少 nums1 的和或者增加 nums2 的和使二者相等。
</pre>

<p><strong>示例 3：</strong></p>

<pre><b>输入：</b>nums1 = [6,6], nums2 = [1]
<b>输出：</b>3
<b>解释：</b>你可以通过 3 次操作使 nums1 中所有数的和与 nums2 中所有数的和相等。以下数组下标都从 0 开始。
- 将 nums1[0] 变为 2 。 nums1 = [<strong>2</strong>,6], nums2 = [1] 。
- 将 nums1[1] 变为 2 。 nums1 = [2,<strong>2</strong>], nums2 = [1] 。
- 将 nums2[0] 变为 4 。 nums1 = [2,2], nums2 = [<strong>4</strong>] 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= nums1.length, nums2.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>1 &lt;= nums1[i], nums2[i] &lt;= 6</code></li> 
</ul>

<div><div>Related Topics</div><div><li>贪心</li><li>数组</li><li>哈希表</li><li>计数</li></div></div><br><div><li>👍 149</li><li>👎 0</li></div>