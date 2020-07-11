package Sort;

import java.util.Arrays;
/**����ѡ��
 * ? ˼·��1.i�����������飬��ʼ��minΪi��
 *        2.j��a[i+1]��������β��Ѱ����Сֵ
 *        3 .�û�a[i]��a[min]
 * ? ���������ȶ�:ֵ��ͬ����������СԪ���û������λ�øı�
 *         Sn=O(1)
 *         Tn=O(n 2)�߱Ƚϴ�����(n-1)+(n-2)+��+1=n(n-1)/2�Σ�   ����O(n^2)
 *                   �ƶ�����������Ϊ0����಻����3(n-1)��
 * */
public class Select1_SimpleSelect {
    public static void main(String[] args) {
        //����һ������
        int[] arr = {24, 69, 80, 57, 13};
        System.out.println("����ǰ��" + Arrays.toString(arr));
        SimpleSort(arr);
    }

    private static void SimpleSort(int[] arr) {
        //��������
        if (arr==null)
            System.out.println("����Ϊ�գ�");
        //��ѡ��
        int i,j,min,tmp;
        for (i=0;i<arr.length;i++){
            min=i;
            for (j=i+1;j<arr.length;j++)
                if (arr[j]<arr[min])
                    min=j;//��min����ָ�����С��
            //�û�arr[i]��arr[min]
            tmp=arr[i];arr[i]=arr[min];arr[min]=tmp;
        }
        System.out.println("�����:"+Arrays.toString(arr));
    }
}
