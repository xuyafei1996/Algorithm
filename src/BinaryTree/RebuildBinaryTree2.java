package BinaryTree;
/**【问题描述】
 * 根据后序序列、中序序列，重建二叉树
 * 【思路分析】
 * 以前序的末尾数x为根，
 * 中序序列x左侧为左子树，x右侧为右子树
 * 根据后序序列找根节点，根据两序列递归左右子树
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
        //递归重建左右子树
        BinaryTreeNode root = rebuild(postorder,0,postorder.length-1,
                                      inorder,0,inorder.length-1);
        return root;
    }

    private static BinaryTreeNode rebuild(int[] postorder, int post_start, int post_end,
                                          int[] inorder, int in_start, int in_end) {
        if (post_start>post_end||in_start>in_end)
            return null;
        //新建子树根节点
        BinaryTreeNode root = new BinaryTreeNode(postorder[post_end]);
        for (int i = in_start; i <=in_end ; i++) {
            //找到中序序列中，根的位置i
            if (root.data == inorder[i]){
                //（i - in_start）为中序排序中左子树结点的个数
                root.left = rebuild(postorder,post_start,post_start+(i - in_start)-1,
                                    inorder,in_start,i-1);
                root.right = rebuild(postorder,post_start+(i-in_start),post_end-1,
                                               inorder,i+1,in_end);
            }
        }
        return root;
    }
}
