package Sort;

import java.util.Arrays;
/**���鲢����
 * ? ˼·��1.�鲢��
 *        2.�鲢�Ҳ�
 *        3.�ϲ����Ҳ�������ԭ���鵽copy[]
 *                     iɨ��low~mid��jɨ��mid+1~high��С����ԭ����
 *                     ʣ��ļ���¼������
 * ? �������ȶ�
 *         Sn=O(n)�߸�������copy[]����Ϊn��
 *         Tn=O(nlogn): �߹鲢log2n�ˣ�ÿ�˹鲢��ʱ�临�Ӷ�ΪO(n��(ɨ��n��Ԫ��)
 * */
public class MergeSort {
    public static void main(String[] args) {
        //����һ������
        int[] arr = {24, 69, 80, 57, 13};
        System.out.println("����ǰ��" + Arrays.toString(arr));
        MergerSort(arr,0,arr.length-1);
        System.out.println("�����:"+Arrays.toString(arr));
    }

    private static void MergerSort(int[] arr,int low,int high) {
        //�鲢����
        if (low<high){
            int mid = (low+high)/2;
            MergerSort(arr,low,mid);
            MergerSort(arr,mid+1,high);
            Merge(arr,low,mid,high);
        }
    }

    private static void Merge(int[] arr, int low, int mid,int high) {
        int[] copy = new int[arr.length];
        for (int i = low; i <=high ; i++)
            copy[i] = arr[i];
        int i,j,k;
        for (i=low,j=mid+1,k=i;i<=mid&&j<=high;k++){
            if (copy[i]<=copy[j])
                arr[k] = copy[i++];
            else
                arr[k] = copy[j++];
        }
        //����ʣ������
        while(i<=mid)
            arr[k++] = copy[i++];
        while (j<=high)
            arr[k++] = copy[j++];
    }
}
