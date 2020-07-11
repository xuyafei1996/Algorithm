package Sort;

import java.util.Arrays;
/**【折半插入排序】
 * ? 思路：1.i遍历整个数组，记录a[i]为tmp
 *        2.为前面有序序列，设置low,mind.high,找位置
 *        3.a[low]~a[i-1]后移
 * 4.置换temp与a[low]
 * ? 分析：稳定
 *         Sn=O(1)， ∵常数个辅助单元；
 *         Tn=O(n^2),∵比较nlog2n级，移动n级；
 *
 * */
public class Insert2_HalveInsert {
    public static void main(String[] args) {
        //定义一个数组
        int[] arr = {24, 69, 80, 57, 13};
        System.out.println("排序前：" + Arrays.toString(arr));
        HalveSort(arr);
    }

    private static void HalveSort(int[] arr) {
        //特殊输入
        if (arr==null)
            System.out.println("数组为空！");
        //折半插入
        int i,j,low,mid,high,tmp;
        for (i = 1; i <arr.length ; i++) {
            tmp=arr[i];
            low=0;
            high = i-1;
            //定位置
            while (low<=high){
                mid=(low+high)/2;
                if (arr[mid]>tmp)
                    high=mid-1;
                else
                    low=mid+1;
            }
            //移动,此时high<low  (high可能为-1)
            for (j = i-1; j >=low; j--)
                arr[j+1]=arr[j];
            arr[++j] = tmp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
