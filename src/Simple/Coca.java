package Simple;

import java.util.*;

/**������������
 * ĳ�̵�涨����������ˮƿ���Ի�һƿ��ˮ�� С��������ʮ������ˮƿ���������Ի�����ƿ��ˮ�ȣ�
 * ������������
 * ����¼�룬��0Ϊ��β
 * */
public class Coca {
    public static void main(String[] args) {
        List list = new LinkedList();
        Scanner sc = new Scanner(System.in);
        while (true) {//ǧ�����while (sc.hasNext())
            int num=sc.nextInt();
            if(num==0)
                break;
            else
                list.add(num);
        }

        for (int i = 0; i < list.size(); i++) {
            int times = 0;
            int n = (int) list.get(i);
            while (n>2){
                int full = n/3;
                int empty_left = n%3;
                times+=full;
                n = full+empty_left;
            }
            if (n==2)//��ʣ������ƿʱ�����ϰ��һƿ�ٶһ�
                times++;
            System.out.println(times);
        }

    }
}
