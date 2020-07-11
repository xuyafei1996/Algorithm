package Greedy;
/**������������
 * ����ΪN�����Ӽ���M�Σ�m,n������������ÿ������Ϊk[0],k[1],k[2]��.
 * ������μ���ʹ��k[0],k[1],k[2]�������˻����
 * ��˼·������
 *n<=4ʱ��f[0]=0,f[1]=1,f[2]=1,f[3]=2,f[4]=4
 * n>=5ʱ���Ѽ����ӻ���Ϊ���ɸ������⣬ÿһ���ͻ���Ϊ���������⡣
 *          ����Ϊ����Ϊa��n-a�����θ��ţ���a(n-a)>n
 *          ��f(n)=(a-1)n-a^2 > 0;
 *          f(n)������������n=5ʱ��f(n)ȡ����СֵΪf(5)=>0,
 *          �������ʽ���aΪ2,3��ȡ����
 *          ������n��5ʱ,3(n-3)��2(n-2)
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
        //�����ܶ��Щ3
        int timeOf3 = length/3;
        //���������ӵ�Ϊ1ʱ����1*3 < 2*2,����Ӧ��ͻ��һ��3������4�ֽ�Ϊ2*2
        if (length-3*timeOf3==1)
            timeOf3 -= 1;
        int timesOf2 = (length-timeOf3*3)/2;
        return (int) (Math.pow(3,timeOf3) * Math.pow(2,timesOf2));
    }
}
