<p>给定四个整数&nbsp;<code>sx</code>&nbsp;,&nbsp;<code>sy</code>&nbsp;，<code>tx</code>&nbsp;和&nbsp;<code>ty</code>，如果通过一系列的<strong>转换</strong>可以从起点&nbsp;<code>(sx, sy)</code>&nbsp;到达终点&nbsp;<code>(tx, ty)</code>，则返回 <code>true</code>，否则返回&nbsp;<code>false</code>。</p>

<p>从点&nbsp;<code>(x, y)</code>&nbsp;可以<strong>转换</strong>到&nbsp;<code>(x, x+y)</code>&nbsp; 或者&nbsp;<code>(x+y, y)</code>。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> sx = 1, sy = 1, tx = 3, ty = 5
<strong>输出:</strong> true
<strong>解释:
</strong>可以通过以下一系列<strong>转换</strong>从起点转换到终点：
(1, 1) -&gt; (1, 2)
(1, 2) -&gt; (3, 2)
(3, 2) -&gt; (3, 5)
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> sx = 1, sy = 1, tx = 2, ty = 2 
<strong>输出:</strong> false
</pre>

<p><strong>示例 3:</strong></p>

<pre>
<strong>输入:</strong> sx = 1, sy = 1, tx = 1, ty = 1 
<strong>输出:</strong> true
</pre>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul>
	<li><code>1 &lt;= sx, sy, tx, ty &lt;= 10<sup>9</sup></code></li>
</ul>
<div><div>Related Topics</div><div><li>数学</li></div></div><br><div><li>👍 156</li><li>👎 0</li></div>