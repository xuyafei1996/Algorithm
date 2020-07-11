package Array_OneDimensional;
/**������������
 *  ����=n ��int���飬Ԫ�ط�Χ��0~n-1֮�䣬������Щ�������ظ��ģ��ҳ���һ�ظ�����
 *  ��˼·������
 *  1.������������
 *  2.��������Ԫ�أ��ж�λ��i��Ԫ���Ƿ�==i�� ����> ��ȣ���������ѭ��
 *                                        ����> ����(Ԫ��ֵΪm)����λ��m�ϵ�Ԫ�رȽ� ����>Ԫ����ͬ��return
 *                                                                              ����>Ԫ�ز�ͬ���û�λ��i��m�ϵ�Ԫ�أ�
 *                                                                                 �ظ���������(ʹ��whileѭ��)
 * ��ʱ�ո��Ӷȡ�
 * ��Ȼ˫��ѭ������ÿ���������ཻ�����μ����ҵ������Լ���λ�ã���Tn=O(n)
 * ����tmp�����������û�����Sn=O(1)
 * ������������
 * null ����> ����
 * {2} ����>����
 * {-1}����>����
 * {1,3}����>����
 * {1,2,2} ����> 2
 * {0,1,2} ����> ���ظ�Ԫ��
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
        //1.������������
        if (arr==null){
            System.out.println("����Ϊnull");
            System.exit(-1);
        }
        if (OutOfBoundary(arr)){
            System.out.println("���ݷ�Χ����");
            System.exit(-1);
        }

        //��������Ԫ�أ��ж�λ��i��Ԫ���Ƿ�==i
        for (int i=0;i<arr.length;i++){
            //C1.��ȣ���������ѭ��
            //C2.����(Ԫ��ֵΪm)����λ��m�ϵ�Ԫ�رȽ�
            while (arr[i]!=i){//��ע�⣡ʹ��whileѭ����
                //Ԫ����ͬ��return
                if (arr[i]==arr[arr[i]]){
                    System.out.println("�ҵ�һ���ظ�Ԫ��"+arr[i]);
                    System.exit(0);
                }else {//Ԫ�ز�ͬ���û�λ��i��m�ϵ�Ԫ��
                    int tmp = arr[i];
                    arr[i] = arr[tmp];
                    arr[tmp] = tmp;//��ע�⣡��Ҫд��arr[arr[i]]= tmp����Ϊ��ʱarr[i]�ѱ��۸���!
                }
            }
        }

        //�����Ҳû�ҵ��ظ�Ԫ�أ�û��System.exit(0)
        System.out.println("û���ظ�Ԫ��^_^");
    }

    private static boolean OutOfBoundary(int[] arr) {
        boolean flag = false;
        int max = arr.length-1;
        //�Ƿ� ��0 �� ��n-1
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]<0||arr[i]>max){
                flag = true;
                break;
            }
        }
        return flag;
    }


}
