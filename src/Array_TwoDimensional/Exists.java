package Array_TwoDimensional;

import java.util.Scanner;

/**������������
 * ��ά����arr��ÿ�����ҵ�����ÿ�����µ���������һ������k���ж�arr���Ƿ����k
 * ��˼·������
 * ����ά���鿴�����󣬴Ӿ������Ͻ�Ԫ��(x)�Ƚ� ����> ��k=x��return(row,col)
 *                                          ����> ��k<x,����Ƚϣ�col-1��
 *                                          ����> ��k>x,���±Ƚ�(row+1)
 * Ҳ��ѡ�����½�Ԫ�أ�������ѡ���½Ǻ����Ͻǣ���Ϊ���ܱ�֤��ѯֻ��һ��������
 * eg.�����ϽǴ��Ԫ�أ��������ң�Ҳ��������
 * ������������
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
        System.out.println("��������Ҫ���ҵ�����");
        int k = new Scanner(System.in).nextInt();

        if (arr==null)
            System.out.println("������������");

        //ȡ���Ͻ�Ԫ��
        int row=0,col=arr[0].length-1;
        boolean flag = false;//�Ƿ��ҵ�
        while (row<=arr.length-1 && col>=0){//��ע�⣡col����д >0
            if (arr[row][col]==k){
                System.out.println("���ݴ��ڣ�λ����("+row+","+col+")");
                flag = true;
                break;
            }
            else if (k<arr[row][col])
                col-=1;
            else
                row+=1;
        }

        if (!flag)
            System.out.println("���ݲ�����");
    }
}
