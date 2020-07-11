package Stack;

import java.util.Scanner;
import java.util.Stack;

/**������������
 * ����ջʵ��һ������
 * ��˼·������
 * ��ӣ�
 * ����ջstack1��
 * Ԫ��ȫ������stack2����Ԫ����Ȼѹ��stack1(�߻��ж�stack2���գ��ȵ�stack2)
 * ���ӣ�
 * ��stack2���գ�����ջ����
 * ��stack2Ϊ�գ�stack1ȫ������stack2��stack2����ջ��
 * */
public class Stack2Queue {
    public static Stack stack1 = new Stack();
    public static Stack stack2 = new Stack();
    public static void main(String[] args) {
        while(true){
            System.out.println("______________");
            System.out.println("�������ѡ��");
            System.out.println("1.���");
            System.out.println("2.����");
            System.out.println("______________");
            int choice = new Scanner(System.in).nextInt();
            if (choice==1){
                System.out.println("����׼����ӵ����ݣ�");
                int num = new Scanner(System.in).nextInt();
                EnterQueue(num);
            }else if(choice == 2){
                System.out.println("Ԫ�س��ӣ�");
                System.out.println(ExitQueue());
            }else {
                System.out.println("ѡ����Ч");
            }
        }
    }

    //���
    private static void EnterQueue(int num) {
        stack1.push(num);
    }
    //����
    private static int ExitQueue() {
        if (!stack2.isEmpty()){
            return (int) stack2.pop();
        }else if (!stack1.isEmpty()){
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
            return (int) stack2.pop();
        }else {
            System.out.println("������Ԫ�أ�");
            return -1;
        }
    }

}
