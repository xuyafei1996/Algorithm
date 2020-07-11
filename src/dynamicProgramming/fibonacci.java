package dynamicProgramming;
/**【问题】
 * 斐波那契数列
 * 【特征】
 * 重叠、离散子结构
 * 【措施】
 * Step1.状态参数:n(第n个数)
 * Step2.状态转移方程：f(n) = f(n-1)+f(n-2)
 * Step3.问题边界：n=1,n=2
 * Step4.选择解法（记忆表、表格法、表格法改进）
 * */
public class fibonacci {

    public static void main(String[] args) {
        System.out.println(fib_MT(15));
        System.out.println(fib_T(15));
        System.out.println(fib_TI(15));
    }

    //★记忆表：自顶向下
    private static int fib_MT(int n){
        int[] dp = new int[n+2];
        dp[1]=1;dp[2]=1;
        if(n>2)
            dp[n] = fib_MT(n-1) + fib_MT(n-2);
        return dp[n];
    }

    //★表格法：自底向上
    private static int fib_T(int n){
        int[] f = new int[n+1];
        f[1] = f[2] = 1;
        if(n>2){
            for (int i = 3;i<=n;i++)
                f[i] = f[i-1] + f[i-2];
            //若求斐波那契对1007的余数，则f[i] = （f[i-1] + f[i-2]）%1007;
        }
        return f[n];
    }

    //★表格法优化：Sn=O(1)
    private static int fib_TI(int n){
        if (n ==1||n==2){
            return 1;
        }else {
            //只用中间变量保存前两次的和
            int a=1,b=1,c=0;
            for (int i=2;i<n;i++){
                c = a+b;
                a = b;
                b = c;//a,b前移
            }
            return c;
        }
    }
}
