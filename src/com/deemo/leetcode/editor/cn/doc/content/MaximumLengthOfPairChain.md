<p>给出&nbsp;<code>n</code>&nbsp;个数对。&nbsp;在每一个数对中，第一个数字总是比第二个数字小。</p>

<p>现在，我们定义一种跟随关系，当且仅当&nbsp;<code>b &lt; c</code>&nbsp;时，数对<code>(c, d)</code>&nbsp;才可以跟在&nbsp;<code>(a, b)</code>&nbsp;后面。我们用这种形式来构造一个数对链。</p>

<p>给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。</p>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>

<pre>
<strong>输入：</strong>[[1,2], [2,3], [3,4]]
<strong>输出：</strong>2
<strong>解释：</strong>最长的数对链是 [1,2] -&gt; [3,4]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li>给出数对的个数在&nbsp;<code>[1, 1000]</code> 范围内。</li> 
</ul>

<div><div>Related Topics</div><div><li>贪心</li><li>数组</li><li>动态规划</li><li>排序</li></div></div><br><div><li>👍 287</li><li>👎 0</li></div>