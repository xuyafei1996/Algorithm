package Sort;

import java.util.Arrays;
/**��ֱ�Ӳ�������
 * ? ԭ�������������л����ϣ�ÿ�ν���һ����Ԫ�ز���ǰ�������������С�
 * ? Ӧ�ã��������������������˳�������
 * ? ˼·��1.i�����������飬��¼a[i]Ϊtmp
 *        2.j����ǰ����������У��ҵ�λ�ã��������ƣ�
 *        3.����tmp
 * ? �������ȶ��㷨
 *        Sn=O(1)���߳�����������Ԫ��
 *        Tn       �������룺���򣬱Ƚ�n-1�Σ����ƶ�����O(n)
 *                  �����룺�Ƚϴ���=�ƶ�����=1+2+3+����+(n-1)=(n-1)n/2����O(n^2)
 *                  *ƽ�����Ҳ��O(n^2)
 * */
public class Insert1_InsertSort {
    public static void main(String[] args) {
        //����һ������
        int[] arr = {24, 69, 80, 57, 13};
        System.out.println("����ǰ��" + Arrays.toString(arr));
        InsertSort(arr);
    }

    private static void InsertSort(int[] arr) {
        //��������
        if (arr==null)
            System.out.println("����Ϊ�գ�");
        //��������
        int tmp,i,j;
        for (i=1;i<arr.length;i++){
            tmp = arr[i];
            for (j=i-1;j>=0&&arr[j]>tmp;j--)
                arr[j+1]=arr[j];
            arr[++j]=tmp;//��jҪ�ָ�һλ
        }
        System.out.println("�����"+Arrays.toString(arr));
    }
}
