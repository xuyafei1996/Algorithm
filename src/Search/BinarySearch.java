package Search;

import java.util.Scanner;

/**【问题描述】
 * 二分查找
 * ? 要求：序列有序
 * ? 思路：每次取mid，比较后更新上/界
 * */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9,12,15,16,22};
        System.out.println("输入你想查找的数：");
        int num = new Scanner(System.in).nextInt();
        System.out.println(BinarySearch1(arr,num));
        System.out.println(BinarySearch2(arr,num,0,arr.length));
        System.out.println(BinarySearch3(arr,num,0,arr.length/2,arr.length));
    }

    //M1.循环实现
    private static int BinarySearch1(int[] arr, int num) {
        //判断特殊输入
        if (arr==null){
            System.out.println("序列为空！");
            return -1;
        }
        //二分查找
        int low=0,high=arr.length-1,mid;
        while (low<=high){
            mid = (low+high)/2;
            if (arr[mid]==num)
                return mid+1;//逻辑序列
            else if(arr[mid]>num)
                high=mid-1;//查前半部分
            else
                low=mid+1;//查后半部分
        }
        return -1;
    }

    //M2递归实现
    private static int BinarySearch2(int[] arr,int num,int low,int high){
        //判断特殊输入
        if (arr==null){
            System.out.println("序列为空！");
            return -1;
        }
        //二分查找
        int mid = (low+high)/2;
        if (low>high)
            return -1;//查找到最后，也没找到
        else if (arr[mid]==num)
            return mid+1;//逻辑序列
        else if(arr[mid]>num)
            return BinarySearch2(arr,num,low,mid-1);//查前半部分
        else
            return BinarySearch2(arr,num,mid+1,high);//查后半部分
    }

    //M3.尾递归，每次递归携带mid
    private static int BinarySearch3(int[] arr, int num, int low, int mid, int high) {
        //判断特殊输入
        if (arr==null){
            System.out.println("序列为空！");
            return -1;
        }
        //二分查找
        if (low>high)
            return -1;
        else if (arr[mid]==num)
            return mid+1;//逻辑序列
        else if(arr[mid]>num)
            return BinarySearch3(arr,num,low,(low+mid-1)/2,mid-1);//查前半部分
        else
            return BinarySearch3(arr,num,mid+1,(mid+1+high)/2,high);//查前半部分
    }

}
