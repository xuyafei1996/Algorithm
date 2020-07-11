package Simple;

import java.util.Scanner;

/**������������
 * ����һ���ַ������ж��Ƿ��ʾ��ֵ
 * ������������
 * +100 ����> true
 * -5e2 ����> true
 * -1E-5 ����> true
 * 3.14 ����> true
 * 3.1.2 ����> false
 * 12e ����> false
 * 1a3.4 ����> false
 * +-5 ����> false
 * 12e+5.4 ����> false
 * ��˼·������
 * �ַ���ģʽ��A[.[B]][e|EC]
 * AΪ�������֣��ɼ������ţ����Բ����ڣ���.12=0.12
 * BΪС�����֣����ɼ�������
 * CΪָ�����֣��ɼ�������
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
        //�ж�A�����Ƿ���У�+/-������
        boolean A = IsInteger(ch),B=false,C=false;
        //�ж�B�����Ƿ���ԣ�
        if (index<ch.length && ch[index]=='.'){
            index++;
            B = isUnsignedInteger(ch);
        }
        //�ж�C�����Ƿ����
        if (index<ch.length && (ch[index]=='e'||ch[index]=='E')){
            index++;
            C = IsInteger(ch);
            if (C==false)
                return false;//�����ָ��E����û��ָ������C
        }
        //C�Ǻϸ��(Ҫôû��ָ����Ҫô�кϸ�ָ��)
        //index����ɨ���������ַ��� && (A�ϸ���B�ϲ��ϸ񶼿���, A���ϸ���B����ϸ�)
        //index==ch.length��֤���������ַ�ʱ��return false
        return index==ch.length && (A || B);
    }

    public static boolean IsInteger(char[] ch) {
        if (index<ch.length && (ch[index]=='+'||ch[index]=='-'))
            index++;
        //�жϺ���������Ƿ�����ֵ
        return isUnsignedInteger(ch);
    }

    public static boolean isUnsignedInteger(char[] ch) {
        int start = index;
        while (index<ch.length &&ch[index]>='0'&&ch[index]<='9')
            index++;
        return index>start;
    }
}
