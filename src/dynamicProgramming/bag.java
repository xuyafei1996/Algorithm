package dynamicProgramming;
/**�����⡿
 *  �̶���������װ��Ʒ����ֵ
 * ��������
 * �ص�����ɢ������(����)�ӽṹ(װ6����װ5���о�����һ��)
 * ����ʩ��
 * Step1.״̬����:����w,��ֵv
 * Step2.״̬ת�Ʒ��̣�dp(i,j) = dp[i-1,j]                         w[i]>j���������ţ������ϸ��ֵ
 *                             max{dp[i-1,j],dp(i-1,j-w[i])+v[i]} w[i]��j�������ţ��ȽϿ���Ҫ��Ҫ��
 *                                                                         i-1��ǰ(i-1)����Ʒ����������;j-w[i]��Ϊ��i����Ʒ�ڳ�����
 *                                                                         �����˵�temp[i-1][j-w[i]]�����Ž⣬�ټ���v[i]
 * Step3.����߽磺  ����=0
 * Step4.ѡ��ⷨ���������񷨡���񷨸Ľ���
 * */
public class bag {
    public static void main(String[] args) {
        int bagSize = 12;
        int w[] = new int[]{2,1,3,2,4,5,3,1};
        int v[] = new int[]{13,10,24,15,28,33,20,8};
        System.out.println(T(w,v,bagSize));
    }

    public static int T(int w[],int v[],int bagSize){
        int itemNums = w.length;
        //����
        int dp[][] = new int[itemNums+10][bagSize+10];
        //ȷ���߽�
        //Ĭ��Ϊ0
        //��������
        for (int i=1;i<=itemNums;i++){
            for (int j=1;j<=bagSize;j++){
                if (w[i-1]>j)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.max(dp[i-1][j],(dp[i-1][j-w[i-1]]+v[i-1]));
            }
        }
        return dp[itemNums][bagSize];
    }
}
