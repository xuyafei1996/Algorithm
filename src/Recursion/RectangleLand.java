package Recursion;
/**������������
 * ���ֳ���������Ϊ����������󷽸�߳�
 * ��˼·������
 * ���ƹ�ϵ���ֽ�Ϊ�����⣬length*width-������width*width���о����ʣ�µ���һ�鳤����
 * �ݹ��������ԭ��������ⷨ��ͬ
 * �߽����������ǿ�����������������α߳�Ϊwidth
 * */
public class RectangleLand {
    public static void main(String[] args) {
        int len = 12;
        int wid = 5;
        System.out.println(Divide(12,5));
    }

    private static int Divide(int len, int wid) {
        if (len%wid == 0)
            return wid;
        else
            return Divide(wid,len%wid);
    }
}
