package dynamicProgramming;
/**�����⡿
 * 쳲���������
 * ��������
 * �ص�����ɢ�ӽṹ
 * ����ʩ��
 * Step1.״̬����:n(��n����)
 * Step2.״̬ת�Ʒ��̣�f(n) = f(n-1)+f(n-2)
 * Step3.����߽磺n=1,n=2
 * Step4.ѡ��ⷨ���������񷨡���񷨸Ľ���
 * */
public class fibonacci {

    public static void main(String[] args) {
        System.out.println(fib_MT(15));
        System.out.println(fib_T(15));
        System.out.println(fib_TI(15));
    }

    //�������Զ�����
    private static int fib_MT(int n){
        int[] dp = new int[n+2];
        dp[1]=1;dp[2]=1;
        if(n>2)
            dp[n] = fib_MT(n-1) + fib_MT(n-2);
        return dp[n];
    }

    //���񷨣��Ե�����
    private static int fib_T(int n){
        int[] f = new int[n+1];
        f[1] = f[2] = 1;
        if(n>2){
            for (int i = 3;i<=n;i++)
                f[i] = f[i-1] + f[i-2];
            //����쳲�������1007����������f[i] = ��f[i-1] + f[i-2]��%1007;
        }
        return f[n];
    }

    //�����Ż���Sn=O(1)
    private static int fib_TI(int n){
        if (n ==1||n==2){
            return 1;
        }else {
            //ֻ���м��������ǰ���εĺ�
            int a=1,b=1,c=0;
            for (int i=2;i<n;i++){
                c = a+b;
                a = b;
                b = c;//a,bǰ��
            }
            return c;
        }
    }
}
