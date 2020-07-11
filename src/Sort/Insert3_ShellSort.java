package Sort;

import java.util.Arrays;

/**【希尔排序】
 * ? 思路：1.步长d递减
 *        2.i遍历组头
 *        3.j遍历组内，记录a[j]为temp
 *        4.k移动组内，插入temp
 *        5、置换temp与被取代元素
 * ? 分析：不稳定
 *         Sn=O(1)，∵常数个辅助单元；
 *         Tn最坏=O(n 2)
 * */
public class Insert3_ShellSort {
    public static void main(String[] args) {
        //定义一个数组
        int[] arr = {24, 69, 80, 57, 13};
        System.out.println("排序前：" + Arrays.toString(arr));
        ShellSort(arr);
    }

    private static void ShellSort(int[] arr) {
        //特殊输入
        if (arr==null)
            System.out.println("数组为空！");
        //希尔排序
        int d,i,j,k,tmp;
        for (d=arr.length/2;d>0;d/=2){
            for (i=0;i<d;i++){//遍历组头
                for (j=i+d;j<arr.length;j+=d){//组内直接插入
                    tmp = arr[j];
                    for (k=j-d;k>=0&&arr[k]>tmp;k-=d)
                        arr[k+d] = arr[k];
                    arr[k+d] = tmp;
                }
            }
        }
        System.out.println("排序后"+Arrays.toString(arr));
    }
}
