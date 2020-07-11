package Sort;

import java.util.Arrays;

/**����������
 * ? ˼·��1.����Ŧ
 *        2.�ݹ飺ѡ��Ԫ������Ŧpivot��
 *                ��pivotС���Ƶ��󲿣���pivot����Ƶ��Ҳ�
 * ? �����������ڲ������У���������
 * */
public class Exchange_QuickSort {
    public static void main(String[] args) {
        //����һ������
        int[] arr = {24, 69, 80, 57, 13};
        System.out.println("����ǰ��" + Arrays.toString(arr));
        QuickSort(arr,0,arr.length-1);
        System.out.println("�����" + Arrays.toString(arr));
    }

    //�ݹ麯��
    private static void QuickSort(int[] arr, int low, int high) {
        if (low>high)
            return;
        int index = partition(arr,low,high);
        QuickSort(arr,low,index-1);//�󲿿���
        QuickSort(arr,low+1,high);//�Ҳ�����
    }

    //����Ŧ���ѱ���ŦС���Ƶ��󲿣�����Ŧ����Ƶ��Ҳ�
    private static int partition(int[] arr, int low, int high) {
        //�зֲ��ԣ�ѡ��Ԫ������Ŧ
        int pivot = arr[low];
        while (low<=high){
            while (arr[high]>=pivot)//�Ҳ��� С��pivot ��
                high--;
            arr[low] = arr[high];
            while (arr[low]<=pivot)//���� ����pivot ��
                low++;
            arr[high] = arr[low];
        }
        arr[low] = pivot;//�û�������Ŧ����ʱlow=high
        return low;
    }
}
