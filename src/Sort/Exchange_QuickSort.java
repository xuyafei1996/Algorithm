package Sort;

import java.util.Arrays;

/**【快速排序】
 * ? 思路：1.找枢纽
 *        2.递归：选首元素做枢纽pivot；
 *                比pivot小的移到左部，比pivot大的移到右部
 * ? 分析：所有内部排序中，性能最优
 * */
public class Exchange_QuickSort {
    public static void main(String[] args) {
        //定义一个数组
        int[] arr = {24, 69, 80, 57, 13};
        System.out.println("排序前：" + Arrays.toString(arr));
        QuickSort(arr,0,arr.length-1);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    //递归函数
    private static void QuickSort(int[] arr, int low, int high) {
        if (low>high)
            return;
        int index = partition(arr,low,high);
        QuickSort(arr,low,index-1);//左部快排
        QuickSort(arr,low+1,high);//右部快排
    }

    //找枢纽，把比枢纽小的移到左部，比枢纽大的移到右部
    private static int partition(int[] arr, int low, int high) {
        //切分策略：选首元素作枢纽
        int pivot = arr[low];
        while (low<=high){
            while (arr[high]>=pivot)//右部找 小于pivot 的
                high--;
            arr[low] = arr[high];
            while (arr[low]<=pivot)//左部找 大于pivot 的
                low++;
            arr[high] = arr[low];
        }
        arr[low] = pivot;//置换最终枢纽，此时low=high
        return low;
    }
}
