package Simple;

import java.util.Scanner;

/**【问题描述】
 * 正则表达式'.'可匹配一个字符；'*'匹配一个字符多次(含0次)，输入一个字符和模式，判断是否匹配。
 * 如aaa和a.a匹配，也和ab*ac*a匹配
 * 【思路分析】
 * 接受字符串str 和 模式Model
 * 如果str的pos1处和Model的pos2处字符相同  或  Str的pos1处非空和Model的pos2处为'.'————>则同时后移一位
 * 如果model的pos2+1处不为'*'————>str的pos1处和Model的pos2处字符相同，则同时后移一位
 *                          ————>str的pos1处和Model的pos2处字符相同，则return false
 * 如果model的pos2+1处为'*'  ————>str的pos1处和Model的pos2处字符相同，
 * */
public class MatchModel {
    public static void main(String[] args) {
        char[] str = new Scanner(System.in).nextLine().toCharArray();
        char[] pattern = new Scanner(System.in).nextLine().toCharArray();
        System.out.println(match(str,pattern));;
    }
    public static boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        return ismatch(str, 0, pattern, 0);
    }
    public static boolean ismatch(char[] str, int i, char[] pattern, int j){
        if(j==pattern.length) //pattern到了末尾
            return i==str.length; //i必须也到末尾才为true,否则为false
        // 当前位匹配，则比较下一位
        if((i!=str.length && str[i]==pattern[j] )|| (pattern[j]=='.' && i!=str.length))
            return ismatch(str,i+1,pattern,j+1);
        if(j+1 < pattern.length && pattern[j+1]=='*' ){ // j+1不越界，且下一位置为*
            if((i!=str.length && str[i]==pattern[j]) ||( pattern[j]=='.' && i!=str.length))// 当前位能匹配上
                //分别把*看做1,0,n
                return ismatch(str,i,pattern,j+2) || ismatch(str,i+1,pattern,j+2) || ismatch(str,i+1,pattern,j);
            else // 当前位匹配不上，就把*看做0
                return ismatch(str,i,pattern,j+2);
        }

        return false;
    }
}
