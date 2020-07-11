package Array_OneDimensional;
/**������������
 *  ����=n ��int���飬Ԫ�ط�Χ��1~n-1֮�䣬�ҳ���һ�ظ�����
 *  Ҫ�󣺲����޸�����
 *  ��˼·������
 *  ����1.�������飬���±�i���и��ơ���>���i����Ԫ�أ�ֱ�Ӹ���
 *                               ����>���i������ͬԪ�أ���return
 *  ����2.���Σ������鰴���ݷ�Χ��Ϊ��(1~n/2)���Ҳ�(n/2 +1~n-1)
 *              �����Ԫ�ظ���>n/2,�ظ�Ԫ������
 *              ����Ҳ�Ԫ�ظ���>n/2,�ظ�Ԫ�����Ҳ�
 * ��ʱ�ո��Ӷȡ�
 * ����1����ͷ��β����һ��,��Tn=O(n)
 *       �����ȴ�������,��Sn=O(n)
 * ����2�����ַ���CountRange()����O(logn)�Σ�ÿ�κ�ʱO(n),Tn=O(nlogn)
 *        Sn=O(1)
 * ������������
 * null ����> ����
 * {2} ����>����
 * {-1}����>����
 * {1,2}����>����
 * {1,2,2} ����> 2
 * {1,2,2,5,3,4,3} ����> 2
 * {6,1,2,5,6,4,3} ����> 6
 */
public class findRepeatNumber2 {
    public static void main(String[] args) {
//        int arr[] = {1,2};
//        int arr[] = {1,2,2};
//        int arr[] = {1,2,2,5,3,4,3};
        int arr[] = {6,1,2,5,6,4,3};
        //������������
        if (arr==null){
            System.out.println("����Ϊ��");
            System.exit(-1);
        }
        if (OutOfBoundary(arr)){
            System.out.println("���鷶Χ����");
            System.exit(-1);
        }

//        findRepeat1(arr);
        System.out.println("�ҵ��ظ�Ԫ��"+findRepeat2(arr));
    }



    //����1
    private static void findRepeat1(int[] arr) {
        int tmp[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            //���i����Ԫ�أ�ֱ�Ӹ���
            if (tmp[arr[i]]==0){
                tmp[arr[i]] = arr[i];
            }else {//���i������ͬԪ�أ���return
                System.out.println("�ҵ��ظ�Ԫ��"+arr[i]);
                System.exit(-1);
            }
        }
    }
    //����2
    private static int findRepeat2(int[] arr) {
        int start =1;
        int end = arr.length-1;
        while (start<=end){
            int mid = (start+end)/2;
            //ͳ�Ƴ�Ϊlen�����飬�󲿷�Χ�ڵ�Ԫ�ظ�����ÿ�α�����Χ����length��
            int count = CountRange(arr,start,mid);//start��mid����λ��Χ������ֵ��Χ��
            if (count>(mid-start+1))//��Ԫ�ظ���>n/2,�ظ�Ԫ������
                end = mid;
            else
                start = mid+1;

            if (end==start){
                if (count>=1)
                    return start;
                else
                    break;
            }
        }
        return -1;
    }

    //ͳ������arr�У���start��ʼ������Ϊlength�ķ�Χ���ж��١�(start,end)����
    private static int CountRange(int[] arr,int start, int end) {
        int count = 0;
        if (arr==null)
            return 0;
        for (int i = 0; i < arr.length; i++) {
            //Ԫ�� ��(start, end)
            if(arr[i]>=start&&arr[i]<=end)
                count++;
        }
        return count;
    }

    private static boolean OutOfBoundary(int[] arr) {
        boolean flag = false;
        int max = arr.length-1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]<0||arr[i]>max){
                flag = true;
                break;
            }
        }
        return flag;
    }
}
