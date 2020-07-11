package dynamicProgramming;
/**�����⡿
 *  ����X �� ����Y ������������У�
 * ��������
 * �ص�����ɢ������(����)�ӽṹ
 * ����ʩ��
 * Step1.״̬����:m,n(X���ȣ�y����)
 * Step2.״̬ת�Ʒ��̣�dp[i,j] = dp[i-1,j-1]+1            ����(i,j>0,xi=yj),�ַ���ͬ��ȡ�Խ��� + 1
 *                              max{dp[i-1,j],dp[i,j-1]} ����(i,j>0,xi��yj),�ַ���ͬ��ȡ�����ϸ�����ֵ
 * Step3.����߽磺 dp[i,0] = 0,dp[0,j] = 0;                            ����(i=0��j=0)
 * Step4.ѡ��ⷨ���������񷨡���񷨸Ľ���
 * ��Ӧ�á�
 * ����ѧ��ȷ��DNA�������ԣ�
 * �༭���룬�����ļ����죬�����ַ������ƶȣ��ж��Ƿ��ǵ��档
 * */
public class commonSubsequence {
    private static String str1 = "BDCABA";
    private static String str2 = "ABCBDAB";
    public static void main(String[] args) {
        System.out.println(MT(str1.length(),str2.length()));
        System.out.println(T(str1.length(),str2.length()));
    }

    //��M1.������
    private static int MT(int m,int n){
        int dp[][] = new int[m+1][n+1];
        if (m==0||n==0)
            dp[m][n] = 0;
        else if (str1.charAt(m-1)==str2.charAt(n-1))
            dp[m][n] = MT(m-1,n-1)+1;
        else
            dp[m][n] = Math.max(MT(m,n-1),MT(m-1,n));
        return dp[m][n];
    }

    //��M2.��񷨡�
    private static int T(int m,int n){
        //���߼�λ����
        int[][] dp = new int[m+1][n+1];
        //ȷ���߽�
        //����0�У���0�У�Ĭ��ֵ����0
        //�������̣����������������
        for (int i=1;i<=m;i++){
            for (int j=1;j<=n;j++){
                if (str1.charAt(i-1) == str2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j] ,dp[i][j-1]);
            }
        }
      return dp[m][n];
    }

    //��M3.��񷨸Ľ���
    //�޷��Ľ����߲����д����ԣ���Ҫÿһ�����ӽ��бȽϺ��жϡ�

}
