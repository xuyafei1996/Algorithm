package Simple;

import java.util.Scanner;

/**【问题描述】
 * 输入一个字符串，判断是否表示数值
 * 【测试用例】
 * +100 ——> true
 * -5e2 ——> true
 * -1E-5 ——> true
 * 3.14 ——> true
 * 3.1.2 ——> false
 * 12e ——> false
 * 1a3.4 ——> false
 * +-5 ——> false
 * 12e+5.4 ——> false
 * 【思路分析】
 * 字符串模式：A[.[B]][e|EC]
 * A为整数部分，可加正负号，可以不存在，如.12=0.12
 * B为小数部分，不可加正负号
 * C为指数部分，可加正负号
 * */
public class JudgeNum {
    public static int index = 0;
    public static void main(String[] args) {
        while (true){
            char[] ch = new Scanner(System.in).nextLine().trim().toCharArray();
            System.out.println(judge(ch));
            index = 0;
        }
    }

    private static boolean judge(char[] ch) {
        if (ch==null||ch.length==0)
            return false;
        //判断A部分是否可行：+/-加数字
        boolean A = IsInteger(ch),B=false,C=false;
        //判断B部分是否可以：
        if (index<ch.length && ch[index]=='.'){
            index++;
            B = isUnsignedInteger(ch);
        }
        //判断C部分是否可以
        if (index<ch.length && (ch[index]=='e'||ch[index]=='E')){
            index++;
            C = IsInteger(ch);
            if (C==false)
                return false;//如果有指数E，但没有指数部分C
        }
        //C是合格的(要么没有指数，要么有合格指数)
        //index必须扫描完整个字符串 && (A合格则B合不合格都可以, A不合格则B必须合格)
        //index==ch.length保证遇到特殊字符时，return false
        return index==ch.length && (A || B);
    }

    public static boolean IsInteger(char[] ch) {
        if (index<ch.length && (ch[index]=='+'||ch[index]=='-'))
            index++;
        //判断后面的数据是否是数值
        return isUnsignedInteger(ch);
    }

    public static boolean isUnsignedInteger(char[] ch) {
        int start = index;
        while (index<ch.length &&ch[index]>='0'&&ch[index]<='9')
            index++;
        return index>start;
    }
}
