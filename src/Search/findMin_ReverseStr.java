package Search;
/**������������
 *  ����������ת��{1,4 | 5,7,9}  ������ת����> {5,7,9 | 1,4}
 *  ����һ�������������תarr����arr����СԪ��Min
 *  ��˼·������
 *  ��ָ��p1��p2ָ��arr����ĩԪ�أ�midָ���м�Ԫ�أ�
 *  ��������>��arr[p1] <= arr[mid], Min�ں��������У���p1=mid��
 *       ��arr[p2] >= arr[mid], Min��ǰ�������У���p2=mid��
 *       ����p1ָ��ǰ�������β��p2ָ����������ͷ��return arr[p2];
 *  ��������0��null
 *  ��������1����תǰ��0��Ԫ�أ�������������鱾��
 *            if(arr[p1]<=arr[p2]) return arr[p1];
 *  ��������2��{0,1,1,1,1} ������ת����> {1 | 0,1,1,1} �� {1,1,1|0,1}
 *            arr[p1] = arr[mid] =arr[p2],��ʱֻ��˳�����
 *������������
 * ���ܲ��ԣ�{5,7,9,1,4} ��������> 1
 *          {5,7,9,1,1,4} ��������> 1
 *          {5,7,9,1,4,4,4} ��������> 1
 * �߽���ԣ�{1,4,5,7,9} ��������> 1
 *          {4}  ��������> 4
 * ������ԣ�null ��������> ����
 *          {1,0,1,1,1} ��������> 0
 * */
public class findMin_ReverseStr {
    public static void main(String[] args) {
        //¼����ת�������
//        int[] arr = new int[]{5,7,9,1,4};
//        int[] arr = new int[]{5,7,9,1,1,4};
//        int[] arr = new int[]{5,7,9,1,4,4,4};
//        int[] arr = new int[]{1,4,5,7,9};
//        int[] arr = new int[]{4};
//        int[] arr = null;
        int[] arr = new int[]{1,0,1,1,1};
        System.out.println("��Сֵ��"+findMin(arr));
    }

    private static int findMin(int[] arr) {
        //��������0
        if (arr == null){
            System.out.println("�����飡");
            return -1;
        }
        //һ�����
        int p1=0,p2=arr.length-1,mid=p1;//mid=p1���̺��������������������б���
        while (arr[p1]>=arr[p2]){//������while ((p2-p1)!=1)������Ե������б��������м�ֵ
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

    //˳�����
    private static int findSequence(int[] arr,int p1,int p2) {
        int result = arr[p2];
        for (int i = p1+1; i <= p2 ; i++)
            if (result>arr[i])
                result = arr[i];
        return result;
    }
}
