package Sort;

import java.util.Arrays;
/**【简单选择】
 * ? 思路：1.i遍历整个数组，初始化min为i；
 *        2.j从a[i+1]遍历到队尾，寻找最小值
 *        3 .置换a[i]、a[min]
 * ? 分析：不稳定:值相同，可能与最小元素置换后，相对位置改变
 *         Sn=O(1)
 *         Tn=O(n 2)∵比较次数：(n-1)+(n-2)+…+1=n(n-1)/2次；   ——O(n^2)
 *                   移动次数：最少为0，最多不超过3(n-1)次
 * */
public class Select1_SimpleSelect {
    public static void main(String[] args) {
        //定义一个数组
        int[] arr = {24, 69, 80, 57, 13};
        System.out.println("排序前：" + Arrays.toString(arr));
        SimpleSort(arr);
    }

    private static void SimpleSort(int[] arr) {
        //特殊输入
        if (arr==null)
            System.out.println("数组为空！");
        //简单选择
        int i,j,min,tmp;
        for (i=0;i<arr.length;i++){
            min=i;
            for (j=i+1;j<arr.length;j++)
                if (arr[j]<arr[min])
                    min=j;//让min最终指向后部最小的
            //置换arr[i]和arr[min]
            tmp=arr[i];arr[i]=arr[min];arr[min]=tmp;
        }
        System.out.println("排序后:"+Arrays.toString(arr));
    }
}
