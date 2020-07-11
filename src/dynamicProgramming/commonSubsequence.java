package dynamicProgramming;
/**【问题】
 *  序列X 和 序列Y 的最长公共子序列？
 * 【特征】
 * 重叠、离散、最优(最少)子结构
 * 【措施】
 * Step1.状态参数:m,n(X长度，y长度)
 * Step2.状态转移方程：dp[i,j] = dp[i-1,j-1]+1            ——(i,j>0,xi=yj),字符不同，取对角线 + 1
 *                              max{dp[i-1,j],dp[i,j-1]} ——(i,j>0,xi≠yj),字符相同，取左格和上格的最大值
 * Step3.问题边界： dp[i,0] = 0,dp[0,j] = 0;                            ——(i=0或j=0)
 * Step4.选择解法（记忆表、表格法、表格法改进）
 * 【应用】
 * 生物学，确定DNA链相似性；
 * 编辑距离，给出文件差异，根据字符串相似度，判断是否是盗版。
 * */
public class commonSubsequence {
    private static String str1 = "BDCABA";
    private static String str2 = "ABCBDAB";
    public static void main(String[] args) {
        System.out.println(MT(str1.length(),str2.length()));
        System.out.println(T(str1.length(),str2.length()));
    }

    //【M1.记忆表格】
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

    //【M2.表格法】
    private static int T(int m,int n){
        //用逻辑位序表达
        int[][] dp = new int[m+1][n+1];
        //确定边界
        //表格第0行，第0列，默认值就是0
        //描述方程（向右向下逐行填表）
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

    //【M3.表格法改进】
    //无法改进，∵不具有传递性，需要每一个格子进行比较和判断。

}
