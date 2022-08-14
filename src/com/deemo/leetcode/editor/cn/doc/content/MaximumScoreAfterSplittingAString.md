<p>给你一个由若干 0 和 1 组成的字符串 <code>s</code> ，请你计算并返回将该字符串分割成两个 <strong>非空</strong> 子字符串（即&nbsp;<strong>左</strong> 子字符串和 <strong>右</strong> 子字符串）所能获得的最大得分。</p>

<p>「分割字符串的得分」为 <strong>左</strong> 子字符串中 <strong>0</strong> 的数量加上 <strong>右</strong> 子字符串中 <strong>1</strong> 的数量。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>s = "011101"
<strong>输出：</strong>5 
<strong>解释：</strong>
将字符串 s 划分为两个非空子字符串的可行方案有：
左子字符串 = "0" 且 右子字符串 = "11101"，得分 = 1 + 4 = 5 
左子字符串 = "01" 且 右子字符串 = "1101"，得分 = 1 + 3 = 4 
左子字符串 = "011" 且 右子字符串 = "101"，得分 = 1 + 2 = 3 
左子字符串 = "0111" 且 右子字符串 = "01"，得分 = 1 + 1 = 2 
左子字符串 = "01110" 且 右子字符串 = "1"，得分 = 2 + 1 = 3
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>s = "00111"
<strong>输出：</strong>5
<strong>解释：</strong>当 左子字符串 = "00" 且 右子字符串 = "111" 时，我们得到最大得分 = 2 + 3 = 5
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>s = "1111"
<strong>输出：</strong>3
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>2 &lt;= s.length &lt;= 500</code></li> 
 <li>字符串 <code>s</code> 仅由字符 <code>'0'</code> 和 <code>'1'</code> 组成。</li> 
</ul>

<div><div>Related Topics</div><div><li>字符串</li></div></div><br><div><li>👍 65</li><li>👎 0</li></div>