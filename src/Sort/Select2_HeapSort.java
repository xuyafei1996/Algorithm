package Sort;

import java.util.Arrays;
/**【堆排序】
 * ? 思路：1.建堆Build： 从后往前，调整所有父节点；
 *        2.调整Adjust:(1)记录父节点，遍历后代
 *                     (2)锁定最大的儿子；
 *                     (3)最大子结点<=父节点，遍历下一层；
 *                     (4)子结点>=父节点，子结点上顶，重新调整
 *        3.排序Sort： (1)从下往上，置换堆顶；
 * *                   (2)把剩余的i-1个元素 整理成堆
 * ? 分析：不稳定
 *         Sn=O(1)
 *         Tn=O(nlog2n)∵建堆O(n)：N个节点，高度H=logN，
 *                               最后一层的每个父节点最多下调1次，倒数第二层的父节点最多下调2次，顶点最多需要下调H次，
 *                               而最后一层父节点有2^(H-1)个,倒数第二层父节点有2^(H-2),顶点只有2^0=1个，
 *                               所以总共的时间复杂度为s = 1 * 2^(H-1) + 2 * 2^(H-2) + ... + (H-1) * 2^1 + H * 2^0
 *                               将H代入后s= 2N - 2 - log2(N)，近似的时间复杂度就是O(N)。
 *                    ∵调整：向下调整n-1次，每次调整的复杂度为O(H)=O(log2n)；最好情况是O(nlogn)，最坏是O(n2)
 * */
public class Select2_HeapSort {
    public static void main(String[] args) {
            //定义一个数组
            int[] arr = {24, 69, 80, 57, 13};
            System.out.println("排序前：" + Arrays.toString(arr));
            HeapSort(arr);
    }

    private static void HeapSort(int[] arr) {
        int i,tmp;
        //建堆
        BuildHeap(arr);
        //置换堆底、堆顶并调整
        for (i = arr.length-1; i >=0 ; i--) {
            tmp=arr[i];arr[i]=arr[0];arr[0]=tmp;
            //把根向下调整，i-1是堆底
            //最小的已经落在最后面
            Adjust(arr,0,i-1);
        }
        System.out.println("排序后"+Arrays.toString(arr));
    }

    private static void BuildHeap(int[] arr){
        //自后向前扫描非叶节点
        for (int i = arr.length/2-1; i >=0 ; i--)
            //自该节点至末尾节点，调整堆
            Adjust(arr,i,arr.length-1);
    }

    private static void Adjust(int[] arr, int i, int len) {
        int tmp=arr[i],j;
        for (j = 2*i; j < len; j*=2) {
            //锁定大儿子，如果右儿子比左儿子大，则锁定右儿子，否则锁定左儿子
            if (arr[j]<arr[j+1])
                j++;
            //最大子结点<=父节点，遍历下一层；
            if (arr[j]<=tmp)
                break;
            else {
                arr[i] = arr[j];//把大儿子替换父亲
                i=j;//i下放，沿着该分支往下调整
            }
        }
        arr[i] = tmp;//把原来的根放到i正确位置上
    }
}
