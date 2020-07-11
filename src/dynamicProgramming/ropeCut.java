package dynamicProgramming;
/**������������
 * ����ΪN�����Ӽ���M�Σ�m,n������������ÿ������Ϊk[0],k[1],k[2]��.
 * ������μ���ʹ��k[0],k[1],k[2]�������˻����
 * ��������
 * �ص�����ɢ�������ӽṹ
 * ����ʩ��
 * Step1.״̬����:n(����)
 * Step2.״̬ת�Ʒ��̣�f(n) = max{f(j)*f(n-j)} ,����j��[1,n/2]
 * Step3.����߽磺n=1,n=2,n=3
 * Step4.ѡ��ⷨ���������񷨡���񷨸Ľ���
 * */
public class ropeCut {
    public static void main(String[] args) {
        System.out.println(cut_MT(16));
        System.out.println(cut_T(16));
    }

    //������
    private static int cut_MT(int n){
        int dp[] = new int[n+3];
        dp[1]=1;dp[2]=2;dp[3]=3;
        if (n>3){
            int max = 0;
            //�������������⣬�ҳ�������f[i]
            //ע�⣺�˴��Ĵ������볣����ϵ��ͬ��������������������̶����˴����̶��������
            for (int i=1;i<=n/2;i++)
                max = Math.max(max,cut_MT(i)*cut_MT(n-i));
            dp[n] = max;
        }
        return dp[n];
    }

    //����
    private static int cut_T(int n){
        int[] dp = new int[n+3];
        dp[1]=1;dp[2]=2;dp[3]=3;
        if (n>3){
            //˫��ѭ��
            for(int i=4;i<=n;i++){
                int max = 0;
                //�������������⣬�ҳ�������f[i]
                for (int j=1;j<=i/2;j++)
                    max = Math.max(max,dp[i-j] * dp[j]);
                dp[i] = max;
            }
        }
        return dp[n];
    }

    //�����Ż�
    //�����޷��Ż�����Ϊ����ÿһ��j����Ҫ����ǰ�������ӽ��������ֻ�����м�ֵ

}
