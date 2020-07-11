package BinaryTree;
/**������������
 * ����ǰ�����С��������У��ؽ�������
 * ��˼·������
 * ��ǰ��ĵ�һ��xΪ����
 * ��������x���Ϊ��������x�Ҳ�Ϊ������
 * ����ǰ�������Ҹ��ڵ㣬���������еݹ���������
 * */
public class RebuildBinaryTree1 {
    public static void main(String[] args) {
        int preorder[] = {1, 2, 4, 7, 3, 5, 6, 8};
        int inorder[] = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTreeNode treeNode = rebuildBinaryTree(preorder, inorder);
        System.out.println(treeNode);
    }

    private static BinaryTreeNode rebuildBinaryTree(int[] preorder, int[] inorder) {
        if (preorder==null||inorder==null)
            return null;
        //�ݹ��ؽ���������
        BinaryTreeNode root = rebuild(preorder,0,preorder.length-1,
                                      inorder,0,inorder.length-1);
        return root;
    }

    private static BinaryTreeNode rebuild(int[] preorder, int pre_start, int pre_end,
                                          int[] inorder, int in_start, int in_end) {
        if (pre_start>pre_end||in_start>in_end)
            return null;
        //�½��������ڵ�
        BinaryTreeNode root = new BinaryTreeNode(preorder[pre_start]);
        for (int i = in_start; i <=in_end ; i++) {
            //�ҵ����������У�����λ��i
            if (root.data == inorder[i]){
                //��i - in_start��Ϊ�������������������ĸ���
                root.left = rebuild(preorder,pre_start+1,pre_start+(i - in_start),
                                    inorder,in_start,i-1);
                root.right = rebuild(preorder,pre_start+(i-in_start)+1,pre_end,
                                               inorder,i+1,in_end);
            }
        }
        return root;
    }
}
