package Simple;

import java.util.Scanner;

/*
����: ��Ч���ֵ�ģʽ������:1)A[.[B]][e|EC]  2).B[e|EC]; ����,A��C��������B��������
��A�Ļ�,��û��B������
û��A�Ļ�, ������B

 * +100 ����> true
 * -5e2 ����> true
 * -1E-5 ����> true
 * 3.14 ����> true
 * 3.1.2 ����> false
 * 12e ����> false
 * 1a3.4 ����> false
 * +-5 ����> false
 * 12e+5.4 ����>
*/
class Solution {
    //ɨ���ַ���ʱ������
    public static int i=0;
    public static void main(String[] args) {
        while (true){
            String s = new Scanner(System.in).nextLine().trim();
            System.out.println(isNumber(s));
            i = 0;
        }
    }

    public static boolean isNumber(String s) {
        //input check
        if(s==null || s.length()==0)
            return false;
        //ȥ����β�Ŀ��ַ�
        s = s.trim();
        boolean A = scanInteger(s), B=false, C=false;
        //�ж��Ƿ���B; ʹ������ʱҪȷ��������Խ��
        if(i<s.length() && s.charAt(i)=='.'){
            i++;
            B = scanUnsignedInteger(s);
        }
        //�ж��Ƿ���C
        if(i<s.length() && (s.charAt(i)=='e' || s.charAt(i)=='E')){
            i++;
            C = scanInteger(s);
            //�������e|E, ����û��C, ˵����������
            if(C==false)
                return false;
        }
        //here, ˵��C�Ǻϸ��, ֻ���ж�A��B�����
        //i����ɨ���������ַ��� && (A�ϸ���B�ϲ��ϸ񶼿���, A���ϸ���B����ϸ�)
        return i==s.length() && (A || B);

    }
    private static boolean scanInteger(String s){
        if(i<s.length() && (s.charAt(i)=='+' || s.charAt(i)=='-'))
            i++;
        return scanUnsignedInteger(s);
    }
    private static boolean scanUnsignedInteger(String s){
        //��ʼ����
        int start = i;
        while(i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9'){
            i++;
        }
        //i>start˵��ɨ�赽������;
        //i<=start˵��û��ɨ�赽����, �������˵��ҪôstartԽ��, Ҫôs.charAt(start)��������
        return i > start;
    }
}
