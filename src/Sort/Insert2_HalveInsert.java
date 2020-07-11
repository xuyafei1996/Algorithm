package Sort;

import java.util.Arrays;
/**���۰��������
 * ? ˼·��1.i�����������飬��¼a[i]Ϊtmp
 *        2.Ϊǰ���������У�����low,mind.high,��λ��
 *        3.a[low]~a[i-1]����
 * 4.�û�temp��a[low]
 * ? �������ȶ�
 *         Sn=O(1)�� �߳�����������Ԫ��
 *         Tn=O(n^2),�߱Ƚ�nlog2n�����ƶ�n����
 *
 * */
public class Insert2_HalveInsert {
    public static void main(String[] args) {
        //����һ������
        int[] arr = {24, 69, 80, 57, 13};
        System.out.println("����ǰ��" + Arrays.toString(arr));
        HalveSort(arr);
    }

    private static void HalveSort(int[] arr) {
        //��������
        if (arr==null)
            System.out.println("����Ϊ�գ�");
        //�۰����
        int i,j,low,mid,high,tmp;
        for (i = 1; i <arr.length ; i++) {
            tmp=arr[i];
            low=0;
            high = i-1;
            //��λ��
            while (low<=high){
                mid=(low+high)/2;
                if (arr[mid]>tmp)
                    high=mid-1;
                else
                    low=mid+1;
            }
            //�ƶ�,��ʱhigh<low  (high����Ϊ-1)
            for (j = i-1; j >=low; j--)
                arr[j+1]=arr[j];
            arr[++j] = tmp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
