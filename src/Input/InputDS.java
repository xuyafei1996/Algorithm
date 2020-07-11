package Input;

import java.util.*;

public class InputDS {
    public static void main(String[] args) {
//        listTest1();
//        stackTest();
//        queueTest();
        setTest();
    }

    private static void setTest() {
        Set set = new HashSet();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(6);
        System.out.println(set.contains(6));//判断包含
        System.out.println(set.remove(5));//按值删除
        List list = new ArrayList();
        list.add(7);
        list.add(8);
        list.add(9);
        System.out.println(set.addAll(list));
        for (Object num : set)
            System.out.println(num);


    }

    private static void listTest1() {
//        List list = new LinkedList();
        List list = new ArrayList();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(9);
        System.out.println(list.contains(1));//判断包含
        System.out.println(list.indexOf(5));//获取位置
        System.out.println(list.remove(0));//按位删除
        System.out.println(list.remove(list.indexOf(7)));//按值删除
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
    }

    private static void queueTest() {
        Queue queue = new LinkedList();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.offer(4);
        while (!queue.isEmpty())
            System.out.println(queue.remove());
    }

    private static void stackTest() {
        Stack stack = new Stack();
        stack.push(0);
        stack.push(2);
        stack.push(6);
        while (!stack.isEmpty())
            System.out.println((Integer) stack.pop());
    }
}
