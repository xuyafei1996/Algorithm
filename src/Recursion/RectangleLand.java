package Recursion;
/**【问题描述】
 * 划分长方形土地为正方格，求最大方格边长
 * 【思路分析】
 * 递推关系：分解为子问题，length*width-整数倍width*width，研究最后剩下的那一块长方形
 * 递归调用树：原、子问题解法相同
 * 边界条件：长是宽的整数倍，则正方形边长为width
 * */
public class RectangleLand {
    public static void main(String[] args) {
        int len = 12;
        int wid = 5;
        System.out.println(Divide(12,5));
    }

    private static int Divide(int len, int wid) {
        if (len%wid == 0)
            return wid;
        else
            return Divide(wid,len%wid);
    }
}
