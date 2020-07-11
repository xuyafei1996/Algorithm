package Simple;

import java.util.Scanner;

/**【问题描述】
 *  求一个double型数据的整数次方
 * 【思路分析】
 * 求2^32次方，不必做32次乘法；
 * 求得2^2后，再乘2^2，得到2^4
 * 求得2^4后，再乘2^4，得到2^8
 * 求得2^8后，再乘2^8，得到2^16
 * 求得2^16后，再乘2^16，得到2^32，只需4次乘法
 * 即a^n  = a^(n/2) * a^(n/2)                 ;n为偶数
 *        = a^((n-1)/2) * a^((n-1/)2) * base  ;n为奇数
 * 【测试用例】
 *  功能测试：(3，4) ————> 81
 *           (3，5) ————> 243
 *           (3，-4) ————> 1/81
 *  边界测试：(0,0) ————> 1
 *  负面测试：(0,-1) ————> false
 * */
public class powTest {
    public static boolean flag = true;
    public static void main(String[] args) {
        double base = new Scanner(System.in).nextDouble();
        int exp = new Scanner(System.in).nextInt();
        double result = Pow(base,exp);
        if (!flag)
            System.out.println("输入无意义");
        else
            System.out.println(result);

    }

    private static double Pow(double base, int exp) {
        flag = true;//预处理全局变量
        if (equal(base,0.0)&&exp<0){
            flag = false;
            return 0.0;
        }
        int exp_abs = Math.abs(exp);
        double result = PowerWithUnsignedExp(base,exp_abs);
        return (exp>0)?result:(1.0/result);
    }

    private static double PowerWithUnsignedExp(double base, int exp_abs) {
        //定义边界
        if (exp_abs==0)
            return 1;
        if (exp_abs==1)
            return base;
        //递归
        //用右移替代除以2
        double result = PowerWithUnsignedExp(base,exp_abs>>1);
        result*=result;
        if ((exp_abs & 0x1)==1)//用位与运输代替求余
            result*=base;
        return result;
    }

    private static boolean equal(double nums1, double num2) {
        return ((nums1-num2)<0.0000001&&(nums1-num2)>-0.0000001);
    }
}
