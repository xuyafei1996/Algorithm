package Search;
/**【问题描述】
 *  定义数组旋转：{1,4 | 5,7,9}  ——旋转——> {5,7,9 | 1,4}
 *  输入一个递增数组的旋转arr，求arr中最小元素Min
 *  【思路分析】
 *  令指针p1、p2指向arr的首末元素，mid指向中间元素；
 *  ————>若arr[p1] <= arr[mid], Min在后面数组中，令p1=mid；
 *       若arr[p2] >= arr[mid], Min在前面数组中，令p2=mid；
 *       最终p1指向前面数组的尾；p2指向后面数组的头；return arr[p2];
 *  特殊输入0：null
 *  特殊输入1：旋转前面0个元素，即输入递增数组本身
 *            if(arr[p1]<=arr[p2]) return arr[p1];
 *  特殊输入2：{0,1,1,1,1} ——旋转——> {1 | 0,1,1,1} 或 {1,1,1|0,1}
 *            arr[p1] = arr[mid] =arr[p2],此时只能顺序查找
 *【测试用例】
 * 功能测试：{5,7,9,1,4} ————> 1
 *          {5,7,9,1,1,4} ————> 1
 *          {5,7,9,1,4,4,4} ————> 1
 * 边界测试：{1,4,5,7,9} ————> 1
 *          {4}  ————> 4
 * 特殊测试：null ————> 报错
 *          {1,0,1,1,1} ————> 0
 * */
public class findMin_ReverseStr {
    public static void main(String[] args) {
        //录入旋转后的数组
//        int[] arr = new int[]{5,7,9,1,4};
//        int[] arr = new int[]{5,7,9,1,1,4};
//        int[] arr = new int[]{5,7,9,1,4,4,4};
//        int[] arr = new int[]{1,4,5,7,9};
//        int[] arr = new int[]{4};
//        int[] arr = null;
        int[] arr = new int[]{1,0,1,1,1};
        System.out.println("最小值："+findMin(arr));
    }

    private static int findMin(int[] arr) {
        //特殊输入0
        if (arr == null){
            System.out.println("空数组！");
            return -1;
        }
        //一般情况
        int p1=0,p2=arr.length-1,mid=p1;//mid=p1，蕴含特殊情况：输入递增序列本身
        while (arr[p1]>=arr[p2]){//不能用while ((p2-p1)!=1)，否则对递增序列本身会输出中间值
            if (p2-p1==1){
                mid = p2;
                break;
            }
            mid = (p1+p2)/2;
            if (arr[0]==arr[arr.length-1]&&arr[arr.length-1]==arr[(arr.length-1)/2])
                return findSequence(arr,p1,p2);
            else if (arr[p1] <= arr[mid])
                p1=mid;
            else
                p2=mid;
        }
        return arr[mid];
    }

    //顺序查找
    private static int findSequence(int[] arr,int p1,int p2) {
        int result = arr[p2];
        for (int i = p1+1; i <= p2 ; i++)
            if (result>arr[i])
                result = arr[i];
        return result;
    }
}
