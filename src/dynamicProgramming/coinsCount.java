package dynamicProgramming;
/**【问题】
 * 面值为1元3元5元的硬币，如何用最少的硬币凑够11元？
 * 【特征】
 * 重叠、离散、最优(最少)子结构
 * 【措施】
 * Step1.状态参数:n(面值)
 * Step2.状态转移方程：f(n) = min{f(n-1)+1,f(n-3)+1,f(n-5)+1}
 *       f(n):表示用1,3,5面值硬币，凑面值n的最小硬币个数
 * Step3.问题边界：n=1,n=2,n=3,n=4,n=5
 * Step4.选择解法（记忆表、表格法、表格法改进）
 * */

public class coinsCount {
    public static void main(String[] args) {
        System.out.println(coins_MT(16));
        System.out.println(coins_T(16));
    }

    //★记忆表法
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

    //★表格法
    private static int coins_T(int amount) {
        int dp[] = new int[amount+5];
        dp[1]=1;dp[2]=2;dp[3]=1;dp[4]=2;dp[5]=1;
        if (amount>5){
            for (int i=5;i<=amount;i++)
                dp[i] = Math.min((dp[i-1]+1),Math.min((dp[i-3]+1),(dp[i-5]+1)));
        }
        return dp[amount];
    }

    //★表格法改进
    //无法改进，因为其变量前移，不具有传递性：f(n-3)的原值 不能 给f(n-1)的现值
}
