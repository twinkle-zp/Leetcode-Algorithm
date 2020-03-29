/*
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
class Solution {
public:
int lengthOfLongestSubstring(string s) {
	int len = 0;        //记录最长子串长度
	vector<char> temp;     //记录当前无重复的最长子串
	int flag = 0;
	temp.push_back(s[0]);
	if (s.size() == 1)
	{
		return 1;
	}
	for (int i = 1; i < s.size(); i++)
	{
		for (int k = i; k < s.size(); k++)
		{
			for (int j = 0; j < temp.size(); j++)
			{
				if (temp[j] == s[k])       //有相同元素
				{
					if (temp.size() > len)
					{
						len = temp.size();   //更新最大长度
					}
					temp.clear();
					temp.push_back(s[i]);   //重新开始找
					flag = 1;
					break;
				}
				if ((j == (temp.size() - 1)) && (temp[j] != s[k]))  //temp遍历到最后没有找到相同元素
				{
					temp.push_back(s[k]);
					if (temp.size() > len)
					{
						len = temp.size();
					}
					break;   //此处若不跳出那么因为temp中元素增加导致会继续循环
				}
			}
			if (flag == 1)
			{
				flag = 0;
				break;
			}	
		}

	}
	return len;
}
};
