package Array_OneDimensional;
/**【问题描述】
 *  合并一个递增数组，一个递减数组，合并后为递增数组
 *  【思路分析】
 *  创建辅助数组arr_merge，设置两个指针i，j，从前向后扫描两个数组，将较大的数复制进arr_merge
 *  【测试用例】
 *  {1,2,3} , null ——> {1,2,3}
 *  {1,2,3} , {5,4,2} ——> {1,2,2,3,4,5}
 * */
public class MergeArr {
    public static void main(String[] args) {
        int arr1[] = new int[]{1, 2, 3};
        int arr2[] = new int[]{5, 4, 2};
        Merge(arr1,arr2);
    }

    private static void Merge(int[] arr1, int[] arr2) {
        int arr_merge[];
        if (arr1==null)
            arr_merge = arr2;
        else if (arr2==null)
            arr_merge = arr1;
        else{//两个数组都不为null
            arr_merge = new int[arr1.length + arr2.length];
            int i=0,j= arr2.length-1,p = 0;
            while (i<arr1.length && j>=0 && p<arr_merge.length){
                if (arr1[i]<=arr2[j])
                    arr_merge[p++] = arr1[i++];
                else
                    arr_merge[p++] = arr2[j--];
            }
            //复制剩余数组
            if (i==arr1.length&&j<arr2.length){
                while (j>=0)
                    arr_merge[p++] = arr2[j--];
            }
            if (j==arr2.length&&i<arr1.length){
                while (i<arr1.length)
                    arr_merge[p++] = arr1[i++];
            }
        }
        for (int i = 0; i < arr_merge.length; i++) {
            System.out.print(arr_merge[i]+" ");
        }
    }
}
