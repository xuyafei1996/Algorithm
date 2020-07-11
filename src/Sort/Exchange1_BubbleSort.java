package Sort;

import javafx.scene.chart.BubbleChart;

import java.util.Arrays;

/**��ð������
 *  ? �������ȶ��㷨
 *  Sn=O(1)���߳�����������Ԫ��
 *  Tn=O(n^2)�������룺���򣬱Ƚ�(n-1)+(n-2)+��+1=n(n-1)/2�Σ�   ����O(n^2)
 *            ����룺���򣬱Ƚ�n(n-1)/2�Σ�
 *                           �ƶ�3[(n-1)+(n-2)+��+1]=3n(n-1)/2�� ����O(n^2)
 *                           *3����Ϊtemp;
 * ? ˼·��
 * M1.����ð�ݣ�iɨ��0~len-1��
 *             jɨ��0~len-1-i������j�Ƚ�����Ԫ�ء�
 * M2.˫��ð��:iɨ��low��high,һ�ֱȽϽ�����high--
 *            jɨ��high��low,һ�ֱȽϽ�����low++
 * */
public class Exchange1_BubbleSort {
    public static void main(String[] args) {
        //����һ������
        int[] arr = {24, 69, 80, 57, 13};
        System.out.println("����ǰ��" + Arrays.toString(arr));
        BubbleSort_oneWay(arr);
        BubbleSort_twoWay(arr);
    }

    private static void BubbleSort_oneWay(int[] arr) {
        int tmp;
        for (int i = 0; i < arr.length-1; i++) {//ð����������
            for (int j = 0; j < arr.length-1-i;j++) {
                if (arr[j] > arr[j + 1]) {//�������
                    tmp = arr[j];arr[j] = arr[j + 1];arr[j + 1] = tmp;
                }
            }
        }
        System.out.println("�����" + Arrays.toString(arr));
    }

    private static void BubbleSort_twoWay(int[] arr) {
        int low=0,high=arr.length-1,tmp;
        while (low<=high){
            for (int i=low;i<high;i++){
                if (arr[i] > arr[i + 1]) {//�������
                    tmp = arr[i];arr[i] = arr[i + 1];arr[i + 1] = tmp;
                }
            }
            high--;
            if (low>high)
                break;
            for (int j=high;j>low;j--){
                if (arr[j]<arr[j-1]){//С��ǰ��
                    tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
            }
            low++;
        }
        System.out.println("�����" + Arrays.toString(arr));
    }
}
