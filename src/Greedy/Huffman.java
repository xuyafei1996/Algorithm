package Greedy;

import java.util.PriorityQueue;
import java.util.Scanner;

/**【问题描述】
 * 给定一系列节点的权重，构造出一个哈夫曼树，使带权路径长度最小
 *
 * */
public class Huffman {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        //录入带权重的节点
        for (int i = 0; i < n; i++)
            queue.add(sc.nextInt());
        int sum = 0;
        while (queue.size()!=1){
            //remove():删除并返回最小值
            int tmp = queue.remove() + queue.remove();
            sum = tmp;
            queue.add(tmp);//新生成的父节点加入队列
        }
        System.out.println(sum);
    }
}
