package Simple;

import java.util.Scanner;

/**������������
 *  ��һ��double�����ݵ������η�
 * ��˼·������
 * ��2^32�η���������32�γ˷���
 * ���2^2���ٳ�2^2���õ�2^4
 * ���2^4���ٳ�2^4���õ�2^8
 * ���2^8���ٳ�2^8���õ�2^16
 * ���2^16���ٳ�2^16���õ�2^32��ֻ��4�γ˷�
 * ��a^n  = a^(n/2) * a^(n/2)                 ;nΪż��
 *        = a^((n-1)/2) * a^((n-1/)2) * base  ;nΪ����
 * ������������
 *  ���ܲ��ԣ�(3��4) ��������> 81
 *           (3��5) ��������> 243
 *           (3��-4) ��������> 1/81
 *  �߽���ԣ�(0,0) ��������> 1
 *  ������ԣ�(0,-1) ��������> false
 * */
public class powTest {
    public static boolean flag = true;
    public static void main(String[] args) {
        double base = new Scanner(System.in).nextDouble();
        int exp = new Scanner(System.in).nextInt();
        double result = Pow(base,exp);
        if (!flag)
            System.out.println("����������");
        else
            System.out.println(result);

    }

    private static double Pow(double base, int exp) {
        flag = true;//Ԥ����ȫ�ֱ���
        if (equal(base,0.0)&&exp<0){
            flag = false;
            return 0.0;
        }
        int exp_abs = Math.abs(exp);
        double result = PowerWithUnsignedExp(base,exp_abs);
        return (exp>0)?result:(1.0/result);
    }

    private static double PowerWithUnsignedExp(double base, int exp_abs) {
        //����߽�
        if (exp_abs==0)
            return 1;
        if (exp_abs==1)
            return base;
        //�ݹ�
        //�������������2
        double result = PowerWithUnsignedExp(base,exp_abs>>1);
        result*=result;
        if ((exp_abs & 0x1)==1)//��λ�������������
            result*=base;
        return result;
    }

    private static boolean equal(double nums1, double num2) {
        return ((nums1-num2)<0.0000001&&(nums1-num2)>-0.0000001);
    }
}
