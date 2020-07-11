package Sort;

import java.util.Arrays;

/**����������
 * ? ˼·��M1. �������Ԫ�����ظ�
 *            1.��������arr[]��copy[]
 *            2.��copy[],iɨ��0~arr.len-1;jҲɨ��0~arr.len-1,����copy[i]��λ��count
 *            3.��copy[i]��ֵ,�û�arr��Ӧλ�ô�(count��)
 *            ��������Tn=O(n^2);Sn=O(n)
 *         M2.1.������ά���飬��arr¼���һ��
 *            2.��Ե�һ�У�,iɨ��0~arr.len-1;jҲɨ��0~arr.len-1,����outcome[i][0]��λ��outcome[i][1]
 *            3.��outcome[i][0]���û�arr��Ӧλ�ô�(outcome[i][1]��)
 *            ��������Tn=O(n^2);Sn=O(n)
 *         M3.�����������Ԫ��ȡֵ��Χ��1~99
 *            1.����size=100������count[]
 *            2.��arr��ֵ����count���±꣬��¼arr���ֵĴ���
 *            ��������Tn=O(n^2);Sn=O(size(n))
 * */
public class Bucket2_CountSort {
    public static void main(String[] args) {
        //����һ������
        int[] arr = {24, 13, 69,13, 80,24,13};
        System.out.println("����ǰ��" + Arrays.toString(arr));
//        Countort1(arr);
        Countort2(arr);
        Countort3(arr);
    }

    private static void Countort1(int[] arr) {
        int[] copy = new int[arr.length];
        int i,j,count = 0;
        //��������
        for (int k = 0; k < arr.length; k++)
            copy[k] = arr[k];
        for (i = 0; i < copy.length; i++){
            for (j = 0,count=0; j < copy.length; j++){//��count=0
                if (copy[i]>copy[j])
                    count++;
            }
             //��copy[i]�û�arr�е���ȷλ��
            arr[count] = copy[i];
        }
        System.out.println("�����"+Arrays.toString(arr));
    }

    private static void Countort2(int[] arr) {
        int[][] b = new int[arr.length][2];
        //��һ��¼������
        for (int i = 0; i < arr.length; i++)
            b[i][0] = arr[i];
        //�ڶ��бȽ�λ��
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {//��j = i+1
                if (b[i][0]>b[j][0])
                    b[i][1]++;
                else
                    b[j][1]++;
            }
            arr[b[i][1]] = b[i][0];
        }
        System.out.println("�����"+Arrays.toString(arr));
    }

    private static void Countort3(int[] arr) {
        int[] count = new int[100];
        for (int i = 0; i < arr.length; i++)
            count[arr[i]] ++;//�ۼ�arr[i]���ֵĴ���
        for (int i = 0; i < count.length; i++) {
            if (count[i]!=0)
                for (int j = 0; j < count[i]; j++)
                    System.out.print(i+" ");
        }
    }
}
