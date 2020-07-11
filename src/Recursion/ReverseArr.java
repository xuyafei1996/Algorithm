package Recursion;
/**【问题描述】
 * 数组逆序
 * 【题目特征】
 * 1.递推关系(分解成子问题)
 * 2.递归调用树：原、子问题解决思路相同
 * 3.有终止条件
 * 【思路分析】
 * 递推关系：arr[0~n]逆袭 = arr[n] + arr[0~n-1]逆序
 * 边界条件：arr[0] ——逆序——> arr[0]
 * */
public class ReverseArr {
    public static void main(String[] args) {
        char[] arr = new char[]{'a','f','g','h','c'};
        Inverse(arr,arr.length-1);
    }

    private static void Inverse(char[] arr,int end) {
        if (end>=0){
            System.out.print(arr[end]+",");
            Inverse(arr,end-1);
        }
    }
}
