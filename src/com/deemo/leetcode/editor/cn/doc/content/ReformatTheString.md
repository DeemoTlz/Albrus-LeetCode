<p>给你一个混合了数字和字母的字符串 <code>s</code>，其中的字母均为小写英文字母。</p>

<p>请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。</p>

<p>请你返回 <strong>重新格式化后</strong> 的字符串；如果无法按要求重新格式化，则返回一个 <strong>空字符串</strong> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>s = "a0b1c2"
<strong>输出：</strong>"0a1b2c"
<strong>解释：</strong>"0a1b2c" 中任意两个相邻字符的类型都不同。 "a0b1c2", "0a1b2c", "0c2a1b" 也是满足题目要求的答案。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>s = "leetcode"
<strong>输出：</strong>""
<strong>解释：</strong>"leetcode" 中只有字母，所以无法满足重新格式化的条件。
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>s = "1229857369"
<strong>输出：</strong>""
<strong>解释：</strong>"1229857369" 中只有数字，所以无法满足重新格式化的条件。
</pre>

<p><strong>示例 4：</strong></p>

<pre><strong>输入：</strong>s = "covid2019"
<strong>输出：</strong>"c2o0v1i9d"
</pre>

<p><strong>示例 5：</strong></p>

<pre><strong>输入：</strong>s = "ab123"
<strong>输出：</strong>"1a2b3"
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= s.length &lt;= 500</code></li> 
 <li><code>s</code> 仅由小写英文字母和/或数字组成。</li> 
</ul>

<div><div>Related Topics</div><div><li>字符串</li></div></div><br><div><li>👍 75</li><li>👎 0</li></div>