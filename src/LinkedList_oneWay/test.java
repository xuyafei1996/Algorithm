package LinkedList_oneWay;

public class test {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.head = new Node(1);
        myLinkedList.addNode(2);
        myLinkedList.addNode(6);
        myLinkedList.addNode(4);
//        myLinkedList.deleteNodeByValue(1);
        myLinkedList.deleteNodeByIndex(2);
//        myLinkedList.sort();
//        myLinkedList.reverse1();
//        myLinkedList.reverse2();
        myLinkedList.reverse3(myLinkedList.head);
//        System.out.println("链表长度为"+myLinkedList.length());
//        myLinkedList.printList(myLinkedList.head);
    }
}
