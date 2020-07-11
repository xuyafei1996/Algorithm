package BinaryTree;
/**【问题描述】
 * 根据前序序列、中序序列，重建二叉树
 * 【思路分析】
 * 以前序的第一数x为根，
 * 中序序列x左侧为左子树，x右侧为右子树
 * 根据前序序列找根节点，根据两序列递归左右子树
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
        //递归重建左右子树
        BinaryTreeNode root = rebuild(preorder,0,preorder.length-1,
                                      inorder,0,inorder.length-1);
        return root;
    }

    private static BinaryTreeNode rebuild(int[] preorder, int pre_start, int pre_end,
                                          int[] inorder, int in_start, int in_end) {
        if (pre_start>pre_end||in_start>in_end)
            return null;
        //新建子树根节点
        BinaryTreeNode root = new BinaryTreeNode(preorder[pre_start]);
        for (int i = in_start; i <=in_end ; i++) {
            //找到中序序列中，根的位置i
            if (root.data == inorder[i]){
                //（i - in_start）为中序排序中左子树结点的个数
                root.left = rebuild(preorder,pre_start+1,pre_start+(i - in_start),
                                    inorder,in_start,i-1);
                root.right = rebuild(preorder,pre_start+(i-in_start)+1,pre_end,
                                               inorder,i+1,in_end);
            }
        }
        return root;
    }
}
