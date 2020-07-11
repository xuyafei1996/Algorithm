package Simple;

import java.util.Scanner;

/**������������
 * ������ʽ'.'��ƥ��һ���ַ���'*'ƥ��һ���ַ����(��0��)������һ���ַ���ģʽ���ж��Ƿ�ƥ�䡣
 * ��aaa��a.aƥ�䣬Ҳ��ab*ac*aƥ��
 * ��˼·������
 * �����ַ���str �� ģʽModel
 * ���str��pos1����Model��pos2���ַ���ͬ  ��  Str��pos1���ǿպ�Model��pos2��Ϊ'.'��������>��ͬʱ����һλ
 * ���model��pos2+1����Ϊ'*'��������>str��pos1����Model��pos2���ַ���ͬ����ͬʱ����һλ
 *                          ��������>str��pos1����Model��pos2���ַ���ͬ����return false
 * ���model��pos2+1��Ϊ'*'  ��������>str��pos1����Model��pos2���ַ���ͬ��
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
        if(j==pattern.length) //pattern����ĩβ
            return i==str.length; //i����Ҳ��ĩβ��Ϊtrue,����Ϊfalse
        // ��ǰλƥ�䣬��Ƚ���һλ
        if((i!=str.length && str[i]==pattern[j] )|| (pattern[j]=='.' && i!=str.length))
            return ismatch(str,i+1,pattern,j+1);
        if(j+1 < pattern.length && pattern[j+1]=='*' ){ // j+1��Խ�磬����һλ��Ϊ*
            if((i!=str.length && str[i]==pattern[j]) ||( pattern[j]=='.' && i!=str.length))// ��ǰλ��ƥ����
                //�ֱ��*����1,0,n
                return ismatch(str,i,pattern,j+2) || ismatch(str,i+1,pattern,j+2) || ismatch(str,i+1,pattern,j);
            else // ��ǰλƥ�䲻�ϣ��Ͱ�*����0
                return ismatch(str,i,pattern,j+2);
        }

        return false;
    }
}
