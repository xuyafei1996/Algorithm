package BinaryTree;

public class BinaryTreeNode {
    public int data;
    public BinaryTreeNode parent=null;
    public BinaryTreeNode left,right;
    public BinaryTreeNode(int data){
        this.data=data;
    }
    public String toString(){
        return "TreeNode [data=" + data + ", left=" + left + ", right=" + right+ "]";
    }
}
