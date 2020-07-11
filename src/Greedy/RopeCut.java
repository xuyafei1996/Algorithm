package Greedy;
/**【问题描述】
 * 长度为N的绳子剪成M段（m,n都是整数），每段绳长为k[0],k[1],k[2]….
 * 请问如何剪，使得k[0],k[1],k[2]，……乘积最大
 * 【思路分析】
 *n<=4时，f[0]=0,f[1]=1,f[2]=1,f[3]=2,f[4]=4
 * n>=5时，把剪绳子划归为若干个子问题，每一剪就划分为两个子问题。
 *          若剪为长度为a与n-a的两段更优，即a(n-a)>n
 *          即f(n)=(a-1)n-a^2 > 0;
 *          f(n)单调递增。当n=5时，f(n)取得最小值为f(5)=>0,
 *          用求根公式解得a为2,3（取整）
 *          且另有n≥5时,3(n-3)≥2(n-2)
 * */
public class RopeCut {
    public static void main(String[] args) {
        System.out.println(cutRope(16));
    }

    private static int cutRope(int length) {
        if (length<2)
            return 0;
        if (length == 2)
            return 1;
        if (length == 3)
            return 2;
        //尽可能多剪些3
        int timeOf3 = length/3;
        //当余下绳子的为1时，∵1*3 < 2*2,所以应该突出一个3来，将4分解为2*2
        if (length-3*timeOf3==1)
            timeOf3 -= 1;
        int timesOf2 = (length-timeOf3*3)/2;
        return (int) (Math.pow(3,timeOf3) * Math.pow(2,timesOf2));
    }
}
