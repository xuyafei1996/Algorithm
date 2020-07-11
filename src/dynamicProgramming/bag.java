package dynamicProgramming;
/**【问题】
 *  固定容量，求装物品最大价值
 * 【特征】
 * 重叠、离散、最优(最少)子结构(装6个与装5个研究过程一样)
 * 【措施】
 * Step1.状态参数:重量w,价值v
 * Step2.状态转移方程：dp(i,j) = dp[i-1,j]                         w[i]>j——不够放，等于上格的值
 *                             max{dp[i-1,j],dp(i-1,j-w[i])+v[i]} w[i]≤j——够放，比较看看要不要放
 *                                                                         i-1是前(i-1)个物品的最优重量;j-w[i]是为第i个物品腾出容量
 *                                                                         即回退到temp[i-1][j-w[i]]的最优解，再加上v[i]
 * Step3.问题边界：  容量=0
 * Step4.选择解法（记忆表、表格法、表格法改进）
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
        //建表
        int dp[][] = new int[itemNums+10][bagSize+10];
        //确定边界
        //默认为0
        //描述方程
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
