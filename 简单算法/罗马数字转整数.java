public class 罗马数字转整数 {
    public int romanToInt(String s) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int num = 0;
        for (int i = 0;i < s.length();i++){
            StringBuilder sb = new StringBuilder();
            char c = s.charAt(i);
            if(i + 1 < s.length()){   //向后多读一位
                char next = s.charAt(i + 1);
                sb.append(c);
                sb.append(next);
            }
            for (int j = 0;j < symbols.length;j++){
                int tamp = 0;
                if (symbols[j].equals(String.valueOf(c))){
                    tamp = values[j];
                }
                if (symbols[j].equals(sb.toString())){     //判断两位字符组成的字符串是否在列表中
                    i += 1;
                    tamp = values[j];
                    num += tamp;
                    break;
                }
                num += tamp;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        罗马数字转整数 l = new 罗马数字转整数();
        System.out.println(l.romanToInt("MCMXCIV"));
    }
}
