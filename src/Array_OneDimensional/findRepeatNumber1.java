package Array_OneDimensional;
/**【问题描述】
 *  长度=n 的int数组，元素范围在0~n-1之间，其中有些数字是重复的，找出任一重复数字
 *  【思路分析】
 *  1.处理特殊输入
 *  2.遍历数组元素，判断位置i的元素是否==i？ ——> 相等，进入下轮循环
 *                                        ——> 不等(元素值为m)，与位置m上的元素比较 ——>元素相同，return
 *                                                                              ——>元素不同，置换位置i与m上的元素；
 *                                                                                 重复交换过程(使用while循环)
 * 【时空复杂度】
 * 虽然双层循环，但每个数字至多交换两次即可找到属于自己的位置，∴Tn=O(n)
 * 借助tmp，在数组上置换，∴Sn=O(1)
 * 【测试用例】
 * null ——> 报错
 * {2} ——>报错
 * {-1}——>报错
 * {1,3}——>报错
 * {1,2,2} ——> 2
 * {0,1,2} ——> 无重复元素
 * */
public class findRepeatNumber1 {
    public static void main(String[] args) {
//        int[] arr = null;
//        int[] arr = {2};
//        int[] arr = {-1};
//        int[] arr = {1,3};
//        int[] arr = {1,2,2};
        int[] arr = {1,0,2};
//        int[] arr = {2,3,1,0,2,5,3};
        //1.处理特殊输入
        if (arr==null){
            System.out.println("数组为null");
            System.exit(-1);
        }
        if (OutOfBoundary(arr)){
            System.out.println("数据范围错误");
            System.exit(-1);
        }

        //遍历数组元素，判断位置i的元素是否==i
        for (int i=0;i<arr.length;i++){
            //C1.相等，进入下轮循环
            //C2.不等(元素值为m)，与位置m上的元素比较
            while (arr[i]!=i){//★注意！使用while循环！
                //元素相同，return
                if (arr[i]==arr[arr[i]]){
                    System.out.println("找到一个重复元素"+arr[i]);
                    System.exit(0);
                }else {//元素不同，置换位置i与m上的元素
                    int tmp = arr[i];
                    arr[i] = arr[tmp];
                    arr[tmp] = tmp;//★注意！不要写成arr[arr[i]]= tmp，因为此时arr[i]已被篡改了!
                }
            }
        }

        //到最后也没找到重复元素，没有System.exit(0)
        System.out.println("没有重复元素^_^");
    }

    private static boolean OutOfBoundary(int[] arr) {
        boolean flag = false;
        int max = arr.length-1;
        //是否 ＜0 或 ＞n-1
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]<0||arr[i]>max){
                flag = true;
                break;
            }
        }
        return flag;
    }


}
