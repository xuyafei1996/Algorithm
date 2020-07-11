package Sort;

import java.util.Arrays;
/**【归并排序】
 * ? 思路：1.归并左部
 *        2.归并右部
 *        3.合并左右部：复制原数组到copy[]
 *                     i扫描low~mid；j扫描mid+1~high；小者入原数组
 *                     剩余的继续录入数组
 * ? 分析：稳定
 *         Sn=O(n)∵辅助数组copy[]长度为n；
 *         Tn=O(nlogn): ∵归并log2n趟，每趟归并的时间复杂度为O(n）(扫描n个元素)
 * */
public class MergeSort {
    public static void main(String[] args) {
        //定义一个数组
        int[] arr = {24, 69, 80, 57, 13};
        System.out.println("排序前：" + Arrays.toString(arr));
        MergerSort(arr,0,arr.length-1);
        System.out.println("排序后:"+Arrays.toString(arr));
    }

    private static void MergerSort(int[] arr,int low,int high) {
        //归并排序
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
        //复制剩余数组
        while(i<=mid)
            arr[k++] = copy[i++];
        while (j<=high)
            arr[k++] = copy[j++];
    }
}
