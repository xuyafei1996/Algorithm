package Sort;

import java.util.Arrays;
/**��������
 * ? ˼·��1.����Build�� �Ӻ���ǰ���������и��ڵ㣻
 *        2.����Adjust:(1)��¼���ڵ㣬�������
 *                     (2)�������Ķ��ӣ�
 *                     (3)����ӽ��<=���ڵ㣬������һ�㣻
 *                     (4)�ӽ��>=���ڵ㣬�ӽ���϶������µ���
 *        3.����Sort�� (1)�������ϣ��û��Ѷ���
 * *                   (2)��ʣ���i-1��Ԫ�� ����ɶ�
 * ? ���������ȶ�
 *         Sn=O(1)
 *         Tn=O(nlog2n)�߽���O(n)��N���ڵ㣬�߶�H=logN��
 *                               ���һ���ÿ�����ڵ�����µ�1�Σ������ڶ���ĸ��ڵ�����µ�2�Σ����������Ҫ�µ�H�Σ�
 *                               �����һ�㸸�ڵ���2^(H-1)��,�����ڶ��㸸�ڵ���2^(H-2),����ֻ��2^0=1����
 *                               �����ܹ���ʱ�临�Ӷ�Ϊs = 1 * 2^(H-1) + 2 * 2^(H-2) + ... + (H-1) * 2^1 + H * 2^0
 *                               ��H�����s= 2N - 2 - log2(N)�����Ƶ�ʱ�临�ӶȾ���O(N)��
 *                    �ߵ��������µ���n-1�Σ�ÿ�ε����ĸ��Ӷ�ΪO(H)=O(log2n)����������O(nlogn)�����O(n2)
 * */
public class Select2_HeapSort {
    public static void main(String[] args) {
            //����һ������
            int[] arr = {24, 69, 80, 57, 13};
            System.out.println("����ǰ��" + Arrays.toString(arr));
            HeapSort(arr);
    }

    private static void HeapSort(int[] arr) {
        int i,tmp;
        //����
        BuildHeap(arr);
        //�û��ѵס��Ѷ�������
        for (i = arr.length-1; i >=0 ; i--) {
            tmp=arr[i];arr[i]=arr[0];arr[0]=tmp;
            //�Ѹ����µ�����i-1�Ƕѵ�
            //��С���Ѿ����������
            Adjust(arr,0,i-1);
        }
        System.out.println("�����"+Arrays.toString(arr));
    }

    private static void BuildHeap(int[] arr){
        //�Ժ���ǰɨ���Ҷ�ڵ�
        for (int i = arr.length/2-1; i >=0 ; i--)
            //�Ըýڵ���ĩβ�ڵ㣬������
            Adjust(arr,i,arr.length-1);
    }

    private static void Adjust(int[] arr, int i, int len) {
        int tmp=arr[i],j;
        for (j = 2*i; j < len; j*=2) {
            //��������ӣ�����Ҷ��ӱ�����Ӵ��������Ҷ��ӣ��������������
            if (arr[j]<arr[j+1])
                j++;
            //����ӽ��<=���ڵ㣬������һ�㣻
            if (arr[j]<=tmp)
                break;
            else {
                arr[i] = arr[j];//�Ѵ�����滻����
                i=j;//i�·ţ����Ÿ÷�֧���µ���
            }
        }
        arr[i] = tmp;//��ԭ���ĸ��ŵ�i��ȷλ����
    }
}
