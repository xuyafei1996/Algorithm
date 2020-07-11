package Sort;

import java.util.Arrays;
/**【直接插入排序】
 * ? 原理：在有序子序列基础上，每次将下一待排元素插入前面有序子序列中。
 * ? 应用：基本有序、数据量不大的顺序表、链表
 * ? 思路：1.i遍历整个数组，记录a[i]为tmp
 *        2.j遍历前面的有序序列，找到位置，批量后移；
 *        3.插入tmp
 * ? 分析：稳定算法
 *        Sn=O(1)，∵常数个辅助单元；
 *        Tn       ∵最理想：有序，比较n-1次，不移动——O(n)
 *                  不理想：比较次数=移动次数=1+2+3+……+(n-1)=(n-1)n/2——O(n^2)
 *                  *平均情况也是O(n^2)
 * */
public class Insert1_InsertSort {
    public static void main(String[] args) {
        //定义一个数组
        int[] arr = {24, 69, 80, 57, 13};
        System.out.println("排序前：" + Arrays.toString(arr));
        InsertSort(arr);
    }

    private static void InsertSort(int[] arr) {
        //特殊输入
        if (arr==null)
            System.out.println("数组为空！");
        //插入排序
        int tmp,i,j;
        for (i=1;i<arr.length;i++){
            tmp = arr[i];
            for (j=i-1;j>=0&&arr[j]>tmp;j--)
                arr[j+1]=arr[j];
            arr[++j]=tmp;//☆j要恢复一位
        }
        System.out.println("排序后"+Arrays.toString(arr));
    }
}
