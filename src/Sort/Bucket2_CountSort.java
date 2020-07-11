package Sort;

import java.util.Arrays;

/**【计数排序】
 * ? 思路：M1. 如果数组元素无重复
 *            1.复制数组arr[]至copy[]
 *            2.对copy[],i扫描0~arr.len-1;j也扫描0~arr.len-1,计算copy[i]的位序count
 *            3.将copy[i]的值,置回arr对应位置处(count处)
 *            ————Tn=O(n^2);Sn=O(n)
 *         M2.1.借助二维数组，将arr录入第一列
 *            2.针对第一列，,i扫描0~arr.len-1;j也扫描0~arr.len-1,计算outcome[i][0]的位序outcome[i][1]
 *            3.将outcome[i][0]，置回arr对应位置处(outcome[i][1]处)
 *            ————Tn=O(n^2);Sn=O(n)
 *         M3.如果给出数组元素取值范围在1~99
 *            1.创建size=100的数组count[]
 *            2.将arr的值看做count的下标，记录arr出现的次数
 *            ————Tn=O(n^2);Sn=O(size(n))
 * */
public class Bucket2_CountSort {
    public static void main(String[] args) {
        //定义一个数组
        int[] arr = {24, 13, 69,13, 80,24,13};
        System.out.println("排序前：" + Arrays.toString(arr));
//        Countort1(arr);
        Countort2(arr);
        Countort3(arr);
    }

    private static void Countort1(int[] arr) {
        int[] copy = new int[arr.length];
        int i,j,count = 0;
        //复制数组
        for (int k = 0; k < arr.length; k++)
            copy[k] = arr[k];
        for (i = 0; i < copy.length; i++){
            for (j = 0,count=0; j < copy.length; j++){//★count=0
                if (copy[i]>copy[j])
                    count++;
            }
             //将copy[i]置回arr中的正确位置
            arr[count] = copy[i];
        }
        System.out.println("排序后"+Arrays.toString(arr));
    }

    private static void Countort2(int[] arr) {
        int[][] b = new int[arr.length][2];
        //第一列录入数据
        for (int i = 0; i < arr.length; i++)
            b[i][0] = arr[i];
        //第二列比较位序
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {//★j = i+1
                if (b[i][0]>b[j][0])
                    b[i][1]++;
                else
                    b[j][1]++;
            }
            arr[b[i][1]] = b[i][0];
        }
        System.out.println("排序后"+Arrays.toString(arr));
    }

    private static void Countort3(int[] arr) {
        int[] count = new int[100];
        for (int i = 0; i < arr.length; i++)
            count[arr[i]] ++;//累加arr[i]出现的次数
        for (int i = 0; i < count.length; i++) {
            if (count[i]!=0)
                for (int j = 0; j < count[i]; j++)
                    System.out.print(i+" ");
        }
    }
}
