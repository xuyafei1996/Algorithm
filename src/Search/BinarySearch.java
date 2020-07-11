package Search;

import java.util.Scanner;

/**������������
 * ���ֲ���
 * ? Ҫ����������
 * ? ˼·��ÿ��ȡmid���ȽϺ������/��
 * */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9,12,15,16,22};
        System.out.println("����������ҵ�����");
        int num = new Scanner(System.in).nextInt();
        System.out.println(BinarySearch1(arr,num));
        System.out.println(BinarySearch2(arr,num,0,arr.length));
        System.out.println(BinarySearch3(arr,num,0,arr.length/2,arr.length));
    }

    //M1.ѭ��ʵ��
    private static int BinarySearch1(int[] arr, int num) {
        //�ж���������
        if (arr==null){
            System.out.println("����Ϊ�գ�");
            return -1;
        }
        //���ֲ���
        int low=0,high=arr.length-1,mid;
        while (low<=high){
            mid = (low+high)/2;
            if (arr[mid]==num)
                return mid+1;//�߼�����
            else if(arr[mid]>num)
                high=mid-1;//��ǰ�벿��
            else
                low=mid+1;//���벿��
        }
        return -1;
    }

    //M2�ݹ�ʵ��
    private static int BinarySearch2(int[] arr,int num,int low,int high){
        //�ж���������
        if (arr==null){
            System.out.println("����Ϊ�գ�");
            return -1;
        }
        //���ֲ���
        int mid = (low+high)/2;
        if (low>high)
            return -1;//���ҵ����Ҳû�ҵ�
        else if (arr[mid]==num)
            return mid+1;//�߼�����
        else if(arr[mid]>num)
            return BinarySearch2(arr,num,low,mid-1);//��ǰ�벿��
        else
            return BinarySearch2(arr,num,mid+1,high);//���벿��
    }

    //M3.β�ݹ飬ÿ�εݹ�Я��mid
    private static int BinarySearch3(int[] arr, int num, int low, int mid, int high) {
        //�ж���������
        if (arr==null){
            System.out.println("����Ϊ�գ�");
            return -1;
        }
        //���ֲ���
        if (low>high)
            return -1;
        else if (arr[mid]==num)
            return mid+1;//�߼�����
        else if(arr[mid]>num)
            return BinarySearch3(arr,num,low,(low+mid-1)/2,mid-1);//��ǰ�벿��
        else
            return BinarySearch3(arr,num,mid+1,(mid+1+high)/2,high);//��ǰ�벿��
    }

}
