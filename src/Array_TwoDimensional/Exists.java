package Array_TwoDimensional;

import java.util.Scanner;

/**【问题描述】
 * 二维数组arr，每行往右递增，每列往下递增；输入一个整数k，判断arr中是否存在k
 * 【思路分析】
 * 将二维数组看作矩阵，从矩阵右上角元素(x)比较 ——> 若k=x，return(row,col)
 *                                          ——> 若k<x,向左比较（col-1）
 *                                          ——> 若k>x,向下比较(row+1)
 * 也可选择左下角元素，但不能选右下角和左上角，因为不能保证查询只往一个方向走
 * eg.比左上角大的元素，可能在右，也可能在下
 * 【测试用例】
 * null
 * {{1,2,3}}
 * {{1},{2},{3}}
 * {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}}
 * */
public class Exists {
    public static void main(String[] args) {
        int arr[][]={{1,2,3}};
//        int arr[][]={{1},{2},{3}};
//        int arr[][]={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println("请输入你要查找的数：");
        int k = new Scanner(System.in).nextInt();

        if (arr==null)
            System.out.println("输入数据有误");

        //取右上角元素
        int row=0,col=arr[0].length-1;
        boolean flag = false;//是否找到
        while (row<=arr.length-1 && col>=0){//★注意！col不能写 >0
            if (arr[row][col]==k){
                System.out.println("数据存在，位置是("+row+","+col+")");
                flag = true;
                break;
            }
            else if (k<arr[row][col])
                col-=1;
            else
                row+=1;
        }

        if (!flag)
            System.out.println("数据不存在");
    }
}
