package Greedy;

public class Activity {
    public static void main(String[] args) {
        //�±��1��ʼ,�洢���ʼʱ��
        int s[] = {0,1,3,0,5,3,5,6,8,8,2,12};
        //�±��1��ʼ,�洢�����ʱ��
        int f[] = {0,4,5,6,7,8,9,10,11,12,13,14};
        boolean flag[] = new boolean[s.length];
        Greedy(s,f,flag);
        for (int i = 1; i < flag.length; i++)
            if (flag[i])
                System.out.println(i);
    }

    private static void Greedy(int[] s, int[] f, boolean[] flag) {
        flag[1] = true;
        int j = 1;//��¼���һ�μ���A�еĻ
        int Nums = s.length-1;//�����
        for (int i = 2; i < Nums; i++) {
            //i�Ŀ�ʼʱ����ǰһ�����ʱ��֮��
            if(s[i]>=f[j]){
                flag[i]=true;
                j = i;
            }else {
                flag[i] = false;
            }
        }
    }
}
