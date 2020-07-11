package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**������������
 *  ���������У�ʵ��һ��ջ
 *  ��˼·������
 *  ��ջ���������о��գ���queue1��
 *       �����ĸ����в��գ����ĸ�
 *  ��ջ��ǰn-1��Ԫ������һ���У�ɾ��ԭ�������һ��Ԫ��
 * */
public class Queue2Stack {
    public static Queue queue1 = new LinkedList();
    public static Queue queue2 = new LinkedList();
    public static void main(String[] args) {
        while(true){
            System.out.println("______________");
            System.out.println("�������ѡ��");
            System.out.println("1.��ջ");
            System.out.println("2.��ջ");
            System.out.println("______________");
            int choice = new Scanner(System.in).nextInt();
            if (choice==1){
                System.out.println("����׼����ջ�����ݣ�");
                int num = new Scanner(System.in).nextInt();
                Push(num);
            }else if(choice == 2){
                System.out.println("Ԫ�س�ջ��");
                System.out.println(Pop());
            }else {
                System.out.println("ѡ����Ч");
            }
        }
    }

    //��ջ
    private static void Push(int num) {
        if (queue1.isEmpty()&&queue2.isEmpty())
            queue1.add(num);
        else if (queue1.isEmpty())
            queue2.add(num);
        else
            queue1.add(num);
    }
    //��ջ
    private static int Pop() {
        if (queue1.isEmpty()&&queue2.isEmpty()){
            System.out.println("ջ�գ�");
            return -1;
        }
        //��֤Ԫ��ʼ�մ�queue1���Ƶ�queue2
        Queue tmp = new LinkedList();
        if (queue1.isEmpty()){
            tmp=queue2;queue2=queue1;queue1=tmp;
        }
        int times = queue1.size()-1;
        //������i<queue1.size()-1����Ϊqueue1.size()���ڶ�̬�仯��
        for (int i=0; i<times;i++)
            queue2.add(queue1.remove());
        return (int) queue1.remove();
    }

}
