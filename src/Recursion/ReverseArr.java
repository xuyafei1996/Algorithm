package Recursion;
/**������������
 * ��������
 * ����Ŀ������
 * 1.���ƹ�ϵ(�ֽ��������)
 * 2.�ݹ��������ԭ����������˼·��ͬ
 * 3.����ֹ����
 * ��˼·������
 * ���ƹ�ϵ��arr[0~n]��Ϯ = arr[n] + arr[0~n-1]����
 * �߽�������arr[0] �������򡪡�> arr[0]
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
