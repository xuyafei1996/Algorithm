package Sort;

import java.util.Arrays;

/**��ϣ������
 * ? ˼·��1.����d�ݼ�
 *        2.i������ͷ
 *        3.j�������ڣ���¼a[j]Ϊtemp
 *        4.k�ƶ����ڣ�����temp
 *        5���û�temp�뱻ȡ��Ԫ��
 * ? ���������ȶ�
 *         Sn=O(1)���߳�����������Ԫ��
 *         Tn�=O(n 2)
 * */
public class Insert3_ShellSort {
    public static void main(String[] args) {
        //����һ������
        int[] arr = {24, 69, 80, 57, 13};
        System.out.println("����ǰ��" + Arrays.toString(arr));
        ShellSort(arr);
    }

    private static void ShellSort(int[] arr) {
        //��������
        if (arr==null)
            System.out.println("����Ϊ�գ�");
        //ϣ������
        int d,i,j,k,tmp;
        for (d=arr.length/2;d>0;d/=2){
            for (i=0;i<d;i++){//������ͷ
                for (j=i+d;j<arr.length;j+=d){//����ֱ�Ӳ���
                    tmp = arr[j];
                    for (k=j-d;k>=0&&arr[k]>tmp;k-=d)
                        arr[k+d] = arr[k];
                    arr[k+d] = tmp;
                }
            }
        }
        System.out.println("�����"+Arrays.toString(arr));
    }
}
