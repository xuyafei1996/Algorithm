package Array_OneDimensional;
/**【问题描述】
 *  长度=n 的int数组，元素范围在1~n-1之间，找出任一重复数字
 *  要求：不能修改数组
 *  【思路分析】
 *  方法1.辅助数组，按下标i进行复制——>如果i处无元素，直接复制
 *                               ——>如果i处有相同元素，则return
 *  方法2.分治：将数组按数据范围分为左部(1~n/2)和右部(n/2 +1~n-1)
 *              如果左部元素个数>n/2,重复元素在左部
 *              如果右部元素个数>n/2,重复元素在右部
 * 【时空复杂度】
 * 方法1：从头到尾遍历一次,∴Tn=O(n)
 *       创建等大辅助数组,∴Sn=O(n)
 * 方法2：二分法，CountRange()调用O(logn)次，每次耗时O(n),Tn=O(nlogn)
 *        Sn=O(1)
 * 【测试用例】
 * null ——> 报错
 * {2} ——>报错
 * {-1}——>报错
 * {1,2}——>报错
 * {1,2,2} ——> 2
 * {1,2,2,5,3,4,3} ——> 2
 * {6,1,2,5,6,4,3} ——> 6
 */
public class findRepeatNumber2 {
    public static void main(String[] args) {
//        int arr[] = {1,2};
//        int arr[] = {1,2,2};
//        int arr[] = {1,2,2,5,3,4,3};
        int arr[] = {6,1,2,5,6,4,3};
        //处理特殊输入
        if (arr==null){
            System.out.println("数组为空");
            System.exit(-1);
        }
        if (OutOfBoundary(arr)){
            System.out.println("数组范围错误！");
            System.exit(-1);
        }

//        findRepeat1(arr);
        System.out.println("找到重复元素"+findRepeat2(arr));
    }



    //方法1
    private static void findRepeat1(int[] arr) {
        int tmp[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            //如果i处无元素，直接复制
            if (tmp[arr[i]]==0){
                tmp[arr[i]] = arr[i];
            }else {//如果i处有相同元素，则return
                System.out.println("找到重复元素"+arr[i]);
                System.exit(-1);
            }
        }
    }
    //方法2
    private static int findRepeat2(int[] arr) {
        int start =1;
        int end = arr.length-1;
        while (start<=end){
            int mid = (start+end)/2;
            //统计长为len的数组，左部范围内的元素个数（每次遍历范围都是length）
            int count = CountRange(arr,start,mid);//start、mid不是位序范围，是数值范围！
            if (count>(mid-start+1))//左部元素个数>n/2,重复元素在左部
                end = mid;
            else
                start = mid+1;

            if (end==start){
                if (count>=1)
                    return start;
                else
                    break;
            }
        }
        return -1;
    }

    //统计数组arr中，自start开始，长度为length的范围中有多少∈(start,end)的数
    private static int CountRange(int[] arr,int start, int end) {
        int count = 0;
        if (arr==null)
            return 0;
        for (int i = 0; i < arr.length; i++) {
            //元素 ∈(start, end)
            if(arr[i]>=start&&arr[i]<=end)
                count++;
        }
        return count;
    }

    private static boolean OutOfBoundary(int[] arr) {
        boolean flag = false;
        int max = arr.length-1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]<0||arr[i]>max){
                flag = true;
                break;
            }
        }
        return flag;
    }
}
