    public String longestPalindrome(String s) {
    if (s == null || s.length() < 1) return "";
    int start = 0, end = 0;     //回文子串的下标
    for (int i = 0; i < s.length(); i++) {     //从一个字符开始遍历字符串
        int len1 = expandAroundCenter(s, i, i);    //以第i字符为中心
        int len2 = expandAroundCenter(s, i, i + 1);   //以第i，i+1之间为中心
        int len = Math.max(len1, len2);  //取两个中最大的长度
        if (len > end - start) {      //更新下标
            start = i - (len - 1) / 2;
            end = i + len / 2;
        }
    }
    return s.substring(start, end + 1);
}

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;    //回文子串的左右下标
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {    //判断是否回文
            L--;
            R++;
        }
        return R - L - 1;
    }
