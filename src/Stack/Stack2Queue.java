package Stack;

import java.util.Scanner;
import java.util.Stack;

/**【问题描述】
 * 两个栈实现一个队列
 * 【思路分析】
 * 入队：
 * 插入栈stack1；
 * 元素全部弹到stack2后，新元素仍然压如stack1(∵会判断stack2不空，先弹stack2)
 * 出队：
 * 若stack2不空，弹出栈顶；
 * 若stack2为空，stack1全部弹入stack2，stack2弹出栈顶
 * */
public class Stack2Queue {
    public static Stack stack1 = new Stack();
    public static Stack stack2 = new Stack();
    public static void main(String[] args) {
        while(true){
            System.out.println("______________");
            System.out.println("输入你的选择");
            System.out.println("1.入队");
            System.out.println("2.出队");
            System.out.println("______________");
            int choice = new Scanner(System.in).nextInt();
            if (choice==1){
                System.out.println("输入准备入队的数据：");
                int num = new Scanner(System.in).nextInt();
                EnterQueue(num);
            }else if(choice == 2){
                System.out.println("元素出队：");
                System.out.println(ExitQueue());
            }else {
                System.out.println("选择无效");
            }
        }
    }

    //入队
    private static void EnterQueue(int num) {
        stack1.push(num);
    }
    //出队
    private static int ExitQueue() {
        if (!stack2.isEmpty()){
            return (int) stack2.pop();
        }else if (!stack1.isEmpty()){
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
            return (int) stack2.pop();
        }else {
            System.out.println("队中无元素！");
            return -1;
        }
    }

}
