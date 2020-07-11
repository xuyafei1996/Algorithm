package BinaryTree;
/**������������
 * ���ݺ������С��������У��ؽ�������
 * ��˼·������
 * ��ǰ���ĩβ��xΪ����
 * ��������x���Ϊ��������x�Ҳ�Ϊ������
 * ���ݺ��������Ҹ��ڵ㣬���������еݹ���������
 * */
public class RebuildBinaryTree2 {
    public static void main(String[] args) {
        int postorder[] = {7,4,2,5,8,6,3,1};
        int inorder[] = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTreeNode treeNode = rebuildBinaryTree(postorder, inorder);
        System.out.println(treeNode);
    }

    private static BinaryTreeNode rebuildBinaryTree(int[] postorder, int[] inorder) {
        if (postorder==null||inorder==null)
            return null;
        //�ݹ��ؽ���������
        BinaryTreeNode root = rebuild(postorder,0,postorder.length-1,
                                      inorder,0,inorder.length-1);
        return root;
    }

    private static BinaryTreeNode rebuild(int[] postorder, int post_start, int post_end,
                                          int[] inorder, int in_start, int in_end) {
        if (post_start>post_end||in_start>in_end)
            return null;
        //�½��������ڵ�
        BinaryTreeNode root = new BinaryTreeNode(postorder[post_end]);
        for (int i = in_start; i <=in_end ; i++) {
            //�ҵ����������У�����λ��i
            if (root.data == inorder[i]){
                //��i - in_start��Ϊ�������������������ĸ���
                root.left = rebuild(postorder,post_start,post_start+(i - in_start)-1,
                                    inorder,in_start,i-1);
                root.right = rebuild(postorder,post_start+(i-in_start),post_end-1,
                                               inorder,i+1,in_end);
            }
        }
        return root;
    }
}
