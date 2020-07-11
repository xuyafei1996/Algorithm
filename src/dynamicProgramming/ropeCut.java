package dynamicProgramming;
/**【问题描述】
 * 长度为N的绳子剪成M段（m,n都是整数），每段绳长为k[0],k[1],k[2]….
 * 请问如何剪，使得k[0],k[1],k[2]，……乘积最大
 * 【特征】
 * 重叠、离散、最优子结构
 * 【措施】
 * Step1.状态参数:n(绳长)
 * Step2.状态转移方程：f(n) = max{f(j)*f(n-j)} ,其中j∈[1,n/2]
 * Step3.问题边界：n=1,n=2,n=3
 * Step4.选择解法（记忆表、表格法、表格法改进）
 * */
public class ropeCut {
    public static void main(String[] args) {
        System.out.println(cut_MT(16));
        System.out.println(cut_T(16));
    }

    //★记忆表法
    private static int cut_MT(int n){
        int dp[] = new int[n+3];
        dp[1]=1;dp[2]=2;dp[3]=3;
        if (n>3){
            int max = 0;
            //遍历所有子问题，找出了最大的f[i]
            //注意：此处的此问题与常见体系不同，常见题型子问题个数固定，此处不固定，需遍历
            for (int i=1;i<=n/2;i++)
                max = Math.max(max,cut_MT(i)*cut_MT(n-i));
            dp[n] = max;
        }
        return dp[n];
    }

    //★表格法
    private static int cut_T(int n){
        int[] dp = new int[n+3];
        dp[1]=1;dp[2]=2;dp[3]=3;
        if (n>3){
            //双层循环
            for(int i=4;i<=n;i++){
                int max = 0;
                //遍历所有子问题，找出了最大的f[i]
                for (int j=1;j<=i/2;j++)
                    max = Math.max(max,dp[i-j] * dp[j]);
                dp[i] = max;
            }
        }
        return dp[n];
    }

    //★表格法优化
    //本题无法优化，以为对于每一个j，都要遍历前面所有子结果；不能只保存中间值

}
