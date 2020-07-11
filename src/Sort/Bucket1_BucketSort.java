package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**【桶排序】
 * ? 要求：可用于最大值最小值相差较大的情况(对比计数排序)，
 *         要求数据分布均匀，以免落在一个桶内
 * ? 思路： 把数组 arr 划分为 n 个大小相同子区间（桶），每个子区间各自排序，最后合并 。
 *        1.计算桶数 = (max-min)/arr.len
 *        2.对每个桶建立一个ArrayList
 *        3.计算每个元素对应桶号(arr[i]-min)/arr.len,并入桶
 *        4.桶内元素排序
 * */
public class Bucket1_BucketSort {
    public static void main(String[] args) {
        //定义一个数组
        int[] arr = {24, 13, 69,928, 800,870,1123,1249};
        System.out.println("排序前：" + Arrays.toString(arr));
        BucketSort(arr);
    }

    private static void BucketSort(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i],max);
            min = Math.min(arr[i],min);
        }
        //计算桶数
        int bNum = (max-min)/arr.length + 1;
        //建通
        ArrayList<ArrayList<Integer>> bucket = new ArrayList<>(bNum);
        for (int i = 0; i < bNum; i++)
            bucket.add(new ArrayList<Integer>());
        //元素入桶
        for (int i = 0; i < arr.length; i++) {
            int index = (arr[i]-min)/arr.length;
            bucket.get(index).add(arr[i]);
        }
        //桶内排序
        for (int i = 0; i < bNum; i++){
            Collections.sort(bucket.get(i));
            if (!bucket.get(i).isEmpty())
                System.out.println(bucket.get(i).toString());
        }
    }
}
