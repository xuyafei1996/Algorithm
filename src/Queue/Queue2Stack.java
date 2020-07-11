package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**【问题描述】
 *  用两个队列，实现一个栈
 *  【思路分析】
 *  入栈：两个队列均空，入queue1；
 *       否则，哪个队列不空，入哪个
 *  出栈：前n-1个元素入另一队列，删除原队列最后一个元素
 * */
public class Queue2Stack {
    public static Queue queue1 = new LinkedList();
    public static Queue queue2 = new LinkedList();
    public static void main(String[] args) {
        while(true){
            System.out.println("______________");
            System.out.println("输入你的选择");
            System.out.println("1.入栈");
            System.out.println("2.出栈");
            System.out.println("______________");
            int choice = new Scanner(System.in).nextInt();
            if (choice==1){
                System.out.println("输入准备入栈的数据：");
                int num = new Scanner(System.in).nextInt();
                Push(num);
            }else if(choice == 2){
                System.out.println("元素出栈：");
                System.out.println(Pop());
            }else {
                System.out.println("选择无效");
            }
        }
    }

    //入栈
    private static void Push(int num) {
        if (queue1.isEmpty()&&queue2.isEmpty())
            queue1.add(num);
        else if (queue1.isEmpty())
            queue2.add(num);
        else
            queue1.add(num);
    }
    //出栈
    private static int Pop() {
        if (queue1.isEmpty()&&queue2.isEmpty()){
            System.out.println("栈空！");
            return -1;
        }
        //保证元素始终从queue1复制到queue2
        Queue tmp = new LinkedList();
        if (queue1.isEmpty()){
            tmp=queue2;queue2=queue1;queue1=tmp;
        }
        int times = queue1.size()-1;
        //不能用i<queue1.size()-1，因为queue1.size()是在动态变化的
        for (int i=0; i<times;i++)
            queue2.add(queue1.remove());
        return (int) queue1.remove();
    }

}
