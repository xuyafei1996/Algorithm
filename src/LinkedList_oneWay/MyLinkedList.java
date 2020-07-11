package LinkedList_oneWay;

import java.util.Stack;

public class MyLinkedList {
    Node head = null;

    //【添加节点】
    // 添加至链表末尾
    public void addNode(int value){
        Node newNode = new Node(value);
        //若链表为空，新节点即为头结点
        if (head==null){
            head = newNode;
        }
        //若链表非空，摸索到尾结点，添加
        Node tmp = head;
        while (tmp.next!=null)
            tmp = tmp.next;
        tmp.next = newNode;
    }

    //【删除节点】
    // M1.按值删除
    public boolean deleteNodeByValue(int value){
        if (head == null)
            return false;
        if (head.data==value){
            head = head.next;
            return true;
        }else {
            Node curNode = head;
            while (curNode.next!=null&&curNode.next.data!=value)
                curNode = curNode.next;//curNode后移
            if (curNode.next.data==value){
                curNode.next = curNode.next.next;
                return true;
            }
        }
        return false;
    }
    //M2.按索引(1~n)删除
    public boolean deleteNodeByIndex(int index){
        if (index<1||index>length())
            return false;
        if (index==1){
            head = head.next;
            return true;
        }
        Node curNode = head;
        int i = 1;
        while (curNode.next!=null){
            //让i提前+1
            //如果curNode的下一节点为待删除节点，利用curNode完成新的拼接
            i++;
            if (i == index){
                curNode.next = curNode.next.next;
                return true;
            }
            //curNode后移
            curNode = curNode.next;
        }
        return false;
    }

    //【链表排序】
    //每次选出最小的节点，与第一个未排序节点(curNode)交换
    public void sort(){
        if (head==null)
            System.out.println("空链表！");
        Node preNode = head;
        while (preNode!=null){
            Node curNode = preNode.next;
            while (curNode!=null){
                if (curNode.data<preNode.data){
                    int swap = curNode.data;
                    curNode.data = preNode.data;
                    preNode.data = swap;
                }
                //当前节点继续向后扫描
                curNode = curNode.next;
            }
            //有序部分新增一个元素
            preNode = preNode.next;
        }
    }

    //【链表逆序】
    //M1.允许改变链表结构，逆转链表指针
    public void reverse1(){
        if (head==null)
            System.out.println("链表为空");
        //初始化preNode 和 curNode
        Node preNode = head;
        Node curNode = head.next;
        head.next = null;//头结点作尾结点
        while (curNode!=null){
            Node nextNode = curNode.next;
            curNode.next = preNode;
            //节点后移
            preNode = curNode;
            curNode = nextNode;
        }
        //head指向新的头结点
        head = preNode;
    }
    //M2.不许改变链表结构
    //思路：最后遍历的先输出，后进先出使用栈
    public void reverse2(){
        Stack stack = new Stack();
        Node curNode = head;
        while (curNode!=null){
            stack.push(curNode);
            curNode = curNode.next;
        }
        while (!stack.empty()){
            Node node = (Node) stack.peek();
            System.out.print (node.data+ " ");
            stack.pop();
        }
    }
    //M3.不许改变链表结构
    //思路：递归输出后面节点的逆序，再输出自身
    public void reverse3(Node curNode){
        if (curNode!=null){
            //递归输出后面节点的逆序
            if (curNode.next!= null)
                reverse3(curNode.next);
            //输出自身
            System.out.print(curNode.data+" ");
        }
    }

    //【求链表长度】
    public int length() {
        if (head==null)
            return 0;
        int len = 0;
        Node tmp = head;
        while (tmp!=null){
            len ++;
            tmp = tmp.next;
        }
        return len;
    }

    //【打印链表】
    public void printList(Node head){
        Node tmp = head;
        while (tmp != null){
            System.out.print(tmp.data+" ");
            tmp = tmp.next;
        }
    }
}
