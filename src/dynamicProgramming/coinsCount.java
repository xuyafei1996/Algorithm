package dynamicProgramming;
/**�����⡿
 * ��ֵΪ1Ԫ3Ԫ5Ԫ��Ӳ�ң���������ٵ�Ӳ�Ҵչ�11Ԫ��
 * ��������
 * �ص�����ɢ������(����)�ӽṹ
 * ����ʩ��
 * Step1.״̬����:n(��ֵ)
 * Step2.״̬ת�Ʒ��̣�f(n) = min{f(n-1)+1,f(n-3)+1,f(n-5)+1}
 *       f(n):��ʾ��1,3,5��ֵӲ�ң�����ֵn����СӲ�Ҹ���
 * Step3.����߽磺n=1,n=2,n=3,n=4,n=5
 * Step4.ѡ��ⷨ���������񷨡���񷨸Ľ���
 * */

public class coinsCount {
    public static void main(String[] args) {
        System.out.println(coins_MT(16));
        System.out.println(coins_T(16));
    }

    //������
    private static int coins_MT(int amount){
        int dp[] = new int[amount+5];
        dp[1]=1;dp[2]=2;dp[3]=1;dp[4]=2;dp[5]=1;
        if(amount>5){
            int a1 = coins_MT(amount-1)+1;
            int a2 = coins_MT(amount-3)+1;
            int a3 = coins_MT(amount-5)+1;
            dp[amount] = Math.min(Math.min(a1,a2),a3);
        }
        return dp[amount];
    }

    //����
    private static int coins_T(int amount) {
        int dp[] = new int[amount+5];
        dp[1]=1;dp[2]=2;dp[3]=1;dp[4]=2;dp[5]=1;
        if (amount>5){
            for (int i=5;i<=amount;i++)
                dp[i] = Math.min((dp[i-1]+1),Math.min((dp[i-3]+1),(dp[i-5]+1)));
        }
        return dp[amount];
    }

    //���񷨸Ľ�
    //�޷��Ľ�����Ϊ�����ǰ�ƣ������д����ԣ�f(n-3)��ԭֵ ���� ��f(n-1)����ֵ
}
