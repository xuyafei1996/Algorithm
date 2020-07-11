package Greedy;

public class Activity {
    public static void main(String[] args) {
        //下标从1开始,存储活动开始时间
        int s[] = {0,1,3,0,5,3,5,6,8,8,2,12};
        //下标从1开始,存储活动结束时间
        int f[] = {0,4,5,6,7,8,9,10,11,12,13,14};
        boolean flag[] = new boolean[s.length];
        Greedy(s,f,flag);
        for (int i = 1; i < flag.length; i++)
            if (flag[i])
                System.out.println(i);
    }

    private static void Greedy(int[] s, int[] f, boolean[] flag) {
        flag[1] = true;
        int j = 1;//记录最近一次加入A中的活动
        int Nums = s.length-1;//活动总数
        for (int i = 2; i < Nums; i++) {
            //i的开始时间在前一活动结束时间之后
            if(s[i]>=f[j]){
                flag[i]=true;
                j = i;
            }else {
                flag[i] = false;
            }
        }
    }
}
