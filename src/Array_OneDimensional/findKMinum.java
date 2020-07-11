package Array_OneDimensional;

import java.util.*;

/**【问题描述】
 * 一维数组中存放的都是整数，找出最小的k个数(重复的数算作一个)
 * 【思路分析】
 *  1.处理特殊输入
 *  2.设置size=k的List
 *  3.遍历数组arr  ——> tmp中有重复数据,进入下一轮循环
 *                ——> tmp中无重复数据 ——> tmp未满，直接置入
 *                                   ——> tmp已满，比较 ——> arr[i]比域内 ≥ 最大数，进入下一轮循环
 *                                                    ——> arr[i]比域内 ＜ 最大数，则置换
 *  4.tmp中的元素个数<k ——> 报错
 * 【测试用例】
 * null ——> 报错
 * {1} k=2 ——> 报错
 * {1,1} k=2 ——> 报错
 * {1,1,1} k=2 ——> 报错
 * {1,2} k=2 ——> 1,2
 * {1,5,3,4,2} k=3 ——> 1,2,3
 * {1,1,5,4,2} k=3 ——> 1,2,4
 * */
public class findKMinum {
    public static void main(String[] args) {
        //设置大小为k的缓冲区
        System.out.println("请输入k：");
        int k = new Scanner(System.in).nextInt();
        ArrayList tmp = new ArrayList();

        //录入数组
//        int[] arr = null;
//        int[] arr = {1,1,1};
//        int[] arr ={1,5,3,4,2};
        int[] arr ={1,1,5,4,2};

        //处理特殊输入
        if (arr==null||k>arr.length){
            System.out.println("输入错误！");
            System.exit(-1);
        }

        //遍历一维数组
        for (int i=0;i<arr.length;i++){
            //C1.tmp中有重复数据,进入下一轮循环
            //C2.tmp中无重复数据
            if (!tmp.contains(arr[i])){
                //C2-1.tmp未满，直接置入
                if (tmp.size()<k)
                    tmp.add(arr[i]);
                //C2-2.tmp已满，比较
                //——> C2-2-1.arr[i]比域内 ≥ 最大数，进入下一轮循环
                //——> C2-2-2.arr[i]比域内 ＜ 最大数，则置换
                else if(arr[i]<(int)Collections.max(tmp)){
                    int max = (int)Collections.max(tmp);
                    for (int j = 0; j < tmp.size(); j++) {
                        if (tmp.get(j).equals(max)){
                            tmp.remove(j);
                            tmp.add(arr[i]);
                            break;
                        }
                    }
                }

            }
        }

        //处理特殊情况
        if (tmp.size()<k){
            System.out.println("数组中的非重复元素不足k个");
            System.exit(-1);
        }else{
            System.out.println(tmp);
        }

    }
}
