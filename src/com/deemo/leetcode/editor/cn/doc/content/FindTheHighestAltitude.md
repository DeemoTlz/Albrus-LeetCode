<p>有一个自行车手打算进行一场公路骑行，这条路线总共由&nbsp;<code>n + 1</code>&nbsp;个不同海拔的点组成。自行车手从海拔为 <code>0</code>&nbsp;的点&nbsp;<code>0</code>&nbsp;开始骑行。</p>

<p>给你一个长度为 <code>n</code>&nbsp;的整数数组&nbsp;<code>gain</code>&nbsp;，其中 <code>gain[i]</code>&nbsp;是点 <code>i</code>&nbsp;和点 <code>i + 1</code>&nbsp;的 <strong>净海拔高度差</strong>（<code>0 &lt;= i &lt; n</code>）。请你返回 <strong>最高点的海拔</strong> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<b>输入：</b>gain = [-5,1,5,0,-7]
<b>输出：</b>1
<b>解释：</b>海拔高度依次为 [0,-5,-4,1,1,-6] 。最高海拔为 1 。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<b>输入：</b>gain = [-4,-3,-2,-1,4,3,2]
<b>输出：</b>0
<b>解释：</b>海拔高度依次为 [0,-4,-7,-9,-10,-6,-3,-1] 。最高海拔为 0 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>n == gain.length</code></li> 
 <li><code>1 &lt;= n &lt;= 100</code></li> 
 <li><code>-100 &lt;= gain[i] &lt;= 100</code></li> 
</ul>

<div><div>Related Topics</div><div><li>数组</li><li>前缀和</li></div></div><br><div><li>👍 60</li><li>👎 0</li></div>