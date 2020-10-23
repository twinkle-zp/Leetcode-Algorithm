package 简单;

import javax.management.remote.rmi._RMIConnection_Stub;

public class 最长公共前缀 {
    public String longestCommonPrefix(String[] strs) {
        /*
        编写一个函数来查找字符串数组中的最长公共前缀。

        如果不存在公共前缀，返回空字符串 ""。

        示例 1:

        输入: ["flower","flow","flight"]
        输出: "fl"
        示例 2:

        输入: ["dog","racecar","car"]
        输出: ""
        解释: 输入不存在公共前缀。
        说明:

        所有输入只包含小写字母 a-z 。

         */
        if (strs.length==0){
            return "";
        }
        int i = 0;    //从String数组中的每个元素的第一个字符开始比较
        StringBuilder sb = new StringBuilder("");
        while (true) {
            String tamp = "";
            for (int j = 0; j < strs.length; j++) {
                if (i < strs[j].length()) {
                    if (tamp == "") {     //放入第一个字符
                        tamp = String.valueOf(strs[j].charAt(i));
                    } else {
                        if (!tamp.equals(String.valueOf(strs[j].charAt(i)))) {    //相同位置的元素不相同，则最大公共前缀已找到。
                            return sb.toString();
                        }
                    }
                }
                else {
                    return sb.toString();
                }

            }
            sb.append(tamp);
            i += 1;
        }
    }

    public static void main(String[] args) {
        最长公共前缀 z = new 最长公共前缀();
        String[] strs ={};
        System.out.println(z.longestCommonPrefix(strs));
    }
}
