package Greedy;

import java.util.PriorityQueue;
import java.util.Scanner;

/**������������
 * ����һϵ�нڵ��Ȩ�أ������һ������������ʹ��Ȩ·��������С
 *
 * */
public class Huffman {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        //¼���Ȩ�صĽڵ�
        for (int i = 0; i < n; i++)
            queue.add(sc.nextInt());
        int sum = 0;
        while (queue.size()!=1){
            //remove():ɾ����������Сֵ
            int tmp = queue.remove() + queue.remove();
            sum = tmp;
            queue.add(tmp);//�����ɵĸ��ڵ�������
        }
        System.out.println(sum);
    }
}
