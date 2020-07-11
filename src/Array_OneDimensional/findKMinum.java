package Array_OneDimensional;

import java.util.*;

/**������������
 * һά�����д�ŵĶ����������ҳ���С��k����(�ظ���������һ��)
 * ��˼·������
 *  1.������������
 *  2.����size=k��List
 *  3.��������arr  ����> tmp�����ظ�����,������һ��ѭ��
 *                ����> tmp�����ظ����� ����> tmpδ����ֱ������
 *                                   ����> tmp�������Ƚ� ����> arr[i]������ �� �������������һ��ѭ��
 *                                                    ����> arr[i]������ �� ����������û�
 *  4.tmp�е�Ԫ�ظ���<k ����> ����
 * ������������
 * null ����> ����
 * {1} k=2 ����> ����
 * {1,1} k=2 ����> ����
 * {1,1,1} k=2 ����> ����
 * {1,2} k=2 ����> 1,2
 * {1,5,3,4,2} k=3 ����> 1,2,3
 * {1,1,5,4,2} k=3 ����> 1,2,4
 * */
public class findKMinum {
    public static void main(String[] args) {
        //���ô�СΪk�Ļ�����
        System.out.println("������k��");
        int k = new Scanner(System.in).nextInt();
        ArrayList tmp = new ArrayList();

        //¼������
//        int[] arr = null;
//        int[] arr = {1,1,1};
//        int[] arr ={1,5,3,4,2};
        int[] arr ={1,1,5,4,2};

        //������������
        if (arr==null||k>arr.length){
            System.out.println("�������");
            System.exit(-1);
        }

        //����һά����
        for (int i=0;i<arr.length;i++){
            //C1.tmp�����ظ�����,������һ��ѭ��
            //C2.tmp�����ظ�����
            if (!tmp.contains(arr[i])){
                //C2-1.tmpδ����ֱ������
                if (tmp.size()<k)
                    tmp.add(arr[i]);
                //C2-2.tmp�������Ƚ�
                //����> C2-2-1.arr[i]������ �� �������������һ��ѭ��
                //����> C2-2-2.arr[i]������ �� ����������û�
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

        //�����������
        if (tmp.size()<k){
            System.out.println("�����еķ��ظ�Ԫ�ز���k��");
            System.exit(-1);
        }else{
            System.out.println(tmp);
        }

    }
}
