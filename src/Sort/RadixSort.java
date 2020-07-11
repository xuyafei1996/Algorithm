package Sort;

import java.util.Arrays;
/**����������
 * ? ˼·��1.���������λ��������������
 *         2.����10��Ͱbucket[10][]��ÿͰ����arr.length
 *         3.������������count[10]��ͳ��Ͱ��Ԫ��
 *         4.ÿ�ְ���Ӧ��λ��������Ԫ����Ͱ
 *         5.����Ͱ����������arr�����ͳ������
 *         6.�о���λ��������һ��ѭ��
 *? �������ȶ�
 *        Sn=O(n)��bucket[][]��С=10*n
 *        Tn=O(terms*(n+r)),terms������rΪ����λ����ÿ���ռ�O(r)��ÿ�˷���O(n)
 *
 * */
public class RadixSort {
    public static void main(String[] args) {
        //����һ������
        int[] arr = {24, 13, 69,928, 800,870,1123,1249};
        System.out.println("����ǰ��" + Arrays.toString(arr));
        RadixSort(arr);
    }

    private static void RadixSort(int[] arr) {
        //��ѯ�����λ������������
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++)
            max = Math.max(max,arr[i]);
        int terms = 0;
        while (max>0){
            terms++;
            max/=10;
        }
        //��Ͱ
        int[][] bucket = new int[10][arr.length];////10��Ͱ��ÿλ10��ȡֵ�����0~9
        int weight = 1;//Ȩ��
        int k = 0;//����������ʱ��ָ��
        int count[]=new int[10];//ͳ��Ͱ��Ԫ�أ�ÿ��Ͱ���װa.length��
        while (terms-->0){///���� terms �η�����ռ�;
            //���䣺Ԫ����Ͱ
            for(int num:arr){
                int digit = (num/weight)%10;//һ�ζԸ�ʮ��ǧλ��Ͱ������
                bucket[digit][count[digit]]=num;//�����ӦͰ�ŵĶ�Ӧλ��
                count[digit]++;
            }
            //����Ͱ����������
            for(int i=0;i<10;i++){
                if(count[i]!=0){//Ͱ��������
                    for(int j=0;j<count[i];j++)
                        arr[k++]=bucket[i][j];
                }
                count[i]=0;
            }
            weight*=10;//�о���λ
            k=0;//׼���´Σ���һλ����
        }
        System.out.println("�����"+Arrays.toString(arr));
    }


}
