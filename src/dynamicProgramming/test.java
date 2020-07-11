package dynamicProgramming;

public class test {
    public static void main(String[] args) {
        System.out.println(T(16));
    }

    private static int cut_T(int n){
        int[] f = new int[n+3];
        f[1]=1;f[2]=2;f[3]=3;
        if (n>3){
            //双层循环
            for(int i=4;i<=n;i++){
                int max = 0;
                //遍历所有子问题，找出了最大的f[i]
                for (int j=1;j<=i/2;j++){
                    max = Math.max(max,f[i-j] * f[j]);
                }
                f[i] = max;
            }
        }
        return f[n];
    }
    private static int T(int n) {
        int dp[] = new int[n+3];
        dp[1]=1;dp[2]=2;dp[3]=3;
        if (n>3){
            for (int i=4;i<=n;i++){
                int max = 0;
                for (int j=1;j<=i/2;j++){
                    max = Math.max(max,dp[j]*dp[i-j]);
                }
                dp[i] = max;
            }
        }
        return dp[n];
    }


}
