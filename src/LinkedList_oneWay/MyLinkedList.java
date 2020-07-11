package LinkedList_oneWay;

import java.util.Stack;

public class MyLinkedList {
    Node head = null;

    //����ӽڵ㡿
    // ���������ĩβ
    public void addNode(int value){
        Node newNode = new Node(value);
        //������Ϊ�գ��½ڵ㼴Ϊͷ���
        if (head==null){
            head = newNode;
        }
        //������ǿգ�������β��㣬���
        Node tmp = head;
        while (tmp.next!=null)
            tmp = tmp.next;
        tmp.next = newNode;
    }

    //��ɾ���ڵ㡿
    // M1.��ֵɾ��
    public boolean deleteNodeByValue(int value){
        if (head == null)
            return false;
        if (head.data==value){
            head = head.next;
            return true;
        }else {
            Node curNode = head;
            while (curNode.next!=null&&curNode.next.data!=value)
                curNode = curNode.next;//curNode����
            if (curNode.next.data==value){
                curNode.next = curNode.next.next;
                return true;
            }
        }
        return false;
    }
    //M2.������(1~n)ɾ��
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
            //��i��ǰ+1
            //���curNode����һ�ڵ�Ϊ��ɾ���ڵ㣬����curNode����µ�ƴ��
            i++;
            if (i == index){
                curNode.next = curNode.next.next;
                return true;
            }
            //curNode����
            curNode = curNode.next;
        }
        return false;
    }

    //����������
    //ÿ��ѡ����С�Ľڵ㣬���һ��δ����ڵ�(curNode)����
    public void sort(){
        if (head==null)
            System.out.println("������");
        Node preNode = head;
        while (preNode!=null){
            Node curNode = preNode.next;
            while (curNode!=null){
                if (curNode.data<preNode.data){
                    int swap = curNode.data;
                    curNode.data = preNode.data;
                    preNode.data = swap;
                }
                //��ǰ�ڵ�������ɨ��
                curNode = curNode.next;
            }
            //���򲿷�����һ��Ԫ��
            preNode = preNode.next;
        }
    }

    //����������
    //M1.����ı�����ṹ����ת����ָ��
    public void reverse1(){
        if (head==null)
            System.out.println("����Ϊ��");
        //��ʼ��preNode �� curNode
        Node preNode = head;
        Node curNode = head.next;
        head.next = null;//ͷ�����β���
        while (curNode!=null){
            Node nextNode = curNode.next;
            curNode.next = preNode;
            //�ڵ����
            preNode = curNode;
            curNode = nextNode;
        }
        //headָ���µ�ͷ���
        head = preNode;
    }
    //M2.����ı�����ṹ
    //˼·���������������������ȳ�ʹ��ջ
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
    //M3.����ı�����ṹ
    //˼·���ݹ��������ڵ���������������
    public void reverse3(Node curNode){
        if (curNode!=null){
            //�ݹ��������ڵ������
            if (curNode.next!= null)
                reverse3(curNode.next);
            //�������
            System.out.print(curNode.data+" ");
        }
    }

    //���������ȡ�
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

    //����ӡ����
    public void printList(Node head){
        Node tmp = head;
        while (tmp != null){
            System.out.print(tmp.data+" ");
            tmp = tmp.next;
        }
    }
}
