package Sort;

import java.util.Arrays;
/**【基数排序】
 * ? 思路：1.依据最大数位，计算排序轮数
 *         2.创建10个桶bucket[10][]，每桶容量arr.length
 *         3.创建计数数组count[10]，统计桶内元素
 *         4.每轮按对应数位，将所有元素入桶
 *         5.遍历桶，重排数组arr，清空统计数组
 *         6.研究高位、进入下一轮循环
 *? 分析：稳定
 *        Sn=O(n)，bucket[][]大小=10*n
 *        Tn=O(terms*(n+r)),terms趟排序、r为数字位数、每趟收集O(r)、每趟分配O(n)
 *
 * */
public class RadixSort {
    public static void main(String[] args) {
        //定义一个数组
        int[] arr = {24, 13, 69,928, 800,870,1123,1249};
        System.out.println("排序前：" + Arrays.toString(arr));
        RadixSort(arr);
    }

    private static void RadixSort(int[] arr) {
        //查询最大数位，即遍历轮数
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++)
            max = Math.max(max,arr[i]);
        int terms = 0;
        while (max>0){
            terms++;
            max/=10;
        }
        //建桶
        int[][] bucket = new int[10][arr.length];////10个桶，每位10种取值情况：0~9
        int weight = 1;//权重
        int k = 0;//用于重排序时的指针
        int count[]=new int[10];//统计桶内元素，每个桶最多装a.length个
        while (terms-->0){///进行 terms 次分配和收集;
            //分配：元素入桶
            for(int num:arr){
                int digit = (num/weight)%10;//一次对个十百千位入桶和排序
                bucket[digit][count[digit]]=num;//放入对应桶号的对应位置
                count[digit]++;
            }
            //遍历桶，重排数据
            for(int i=0;i<10;i++){
                if(count[i]!=0){//桶里有数据
                    for(int j=0;j<count[i];j++)
                        arr[k++]=bucket[i][j];
                }
                count[i]=0;
            }
            weight*=10;//研究高位
            k=0;//准备下次，升一位重排
        }
        System.out.println("排序后："+Arrays.toString(arr));
    }


}
