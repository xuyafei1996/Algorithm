package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**��Ͱ����
 * ? Ҫ�󣺿��������ֵ��Сֵ���ϴ�����(�Աȼ�������)��
 *         Ҫ�����ݷֲ����ȣ���������һ��Ͱ��
 * ? ˼·�� ������ arr ����Ϊ n ����С��ͬ�����䣨Ͱ����ÿ������������������ϲ� ��
 *        1.����Ͱ�� = (max-min)/arr.len
 *        2.��ÿ��Ͱ����һ��ArrayList
 *        3.����ÿ��Ԫ�ض�ӦͰ��(arr[i]-min)/arr.len,����Ͱ
 *        4.Ͱ��Ԫ������
 * */
public class Bucket1_BucketSort {
    public static void main(String[] args) {
        //����һ������
        int[] arr = {24, 13, 69,928, 800,870,1123,1249};
        System.out.println("����ǰ��" + Arrays.toString(arr));
        BucketSort(arr);
    }

    private static void BucketSort(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i],max);
            min = Math.min(arr[i],min);
        }
        //����Ͱ��
        int bNum = (max-min)/arr.length + 1;
        //��ͨ
        ArrayList<ArrayList<Integer>> bucket = new ArrayList<>(bNum);
        for (int i = 0; i < bNum; i++)
            bucket.add(new ArrayList<Integer>());
        //Ԫ����Ͱ
        for (int i = 0; i < arr.length; i++) {
            int index = (arr[i]-min)/arr.length;
            bucket.get(index).add(arr[i]);
        }
        //Ͱ������
        for (int i = 0; i < bNum; i++){
            Collections.sort(bucket.get(i));
            if (!bucket.get(i).isEmpty())
                System.out.println(bucket.get(i).toString());
        }
    }
}
