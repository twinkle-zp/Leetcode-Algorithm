public class 回文数 {
    public boolean isPalindrome(int x) {
        /*
        判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

        示例 1:

        输入: 121
        输出: true
        示例 2:

        输入: -121
        输出: false
        解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
        示例 3:

        输入: 10
        输出: false
        解释: 从右向左读, 为 01 。因此它不是一个回文数。
         */
        if (x < 0)    //有负号不是回文
            return false;
        if (x >= 0 && x <= 9)    //只有个位数，是回文
            return true;
        String str = String.valueOf(x);
        int lenth = str.length();
        int count = 0;
        int j = 0;
        for (int i = lenth - 1;i >= lenth/2;i--){    //循环一半
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            j += 1;
        }
        return true;

    }

    public static void main(String[] args) {
        回文数 h = new 回文数();
        System.out.println(h.isPalindrome(1223221));
    }
}
