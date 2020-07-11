package Sort;

import javafx.scene.chart.BubbleChart;

import java.util.Arrays;

/**【冒泡排序】
 *  ? 分析：稳定算法
 *  Sn=O(1)，∵常数个辅助单元；
 *  Tn=O(n^2)∵最理想：有序，比较(n-1)+(n-2)+…+1=n(n-1)/2次；   ——O(n^2)
 *            最不理想：逆序，比较n(n-1)/2次，
 *                           移动3[(n-1)+(n-2)+…+1]=3n(n-1)/2次 ——O(n^2)
 *                           *3是因为temp;
 * ? 思路：
 * M1.单向冒泡：i扫描0~len-1；
 *             j扫描0~len-1-i，依据j比较相邻元素。
 * M2.双向冒泡:i扫描low→high,一轮比较结束，high--
 *            j扫描high→low,一轮比较结束，low++
 * */
public class Exchange1_BubbleSort {
    public static void main(String[] args) {
        //定义一个数组
        int[] arr = {24, 69, 80, 57, 13};
        System.out.println("排序前：" + Arrays.toString(arr));
        BubbleSort_oneWay(arr);
        BubbleSort_twoWay(arr);
    }

    private static void BubbleSort_oneWay(int[] arr) {
        int tmp;
        for (int i = 0; i < arr.length-1; i++) {//冒泡排序轮数
            for (int j = 0; j < arr.length-1-i;j++) {
                if (arr[j] > arr[j + 1]) {//大数后沉
                    tmp = arr[j];arr[j] = arr[j + 1];arr[j + 1] = tmp;
                }
            }
        }
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    private static void BubbleSort_twoWay(int[] arr) {
        int low=0,high=arr.length-1,tmp;
        while (low<=high){
            for (int i=low;i<high;i++){
                if (arr[i] > arr[i + 1]) {//大数后沉
                    tmp = arr[i];arr[i] = arr[i + 1];arr[i + 1] = tmp;
                }
            }
            high--;
            if (low>high)
                break;
            for (int j=high;j>low;j--){
                if (arr[j]<arr[j-1]){//小数前浮
                    tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
            }
            low++;
        }
        System.out.println("排序后：" + Arrays.toString(arr));
    }
}
